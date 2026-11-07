package com.careerforge.auth.service.impl;

import com.careerforge.auth.dto.*;
import com.careerforge.auth.entity.Otp;
import com.careerforge.auth.entity.OtpType;
import com.careerforge.auth.repository.OtpRepository;
import com.careerforge.auth.service.AuthService;
import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.notification.service.EmailService;
import com.careerforge.security.JwtTokenProvider;
import com.careerforge.security.UserPrincipal;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.dto.UserDto;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.mapper.UserMapper;
import com.careerforge.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Locale;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final OtpRepository otpRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final UserMapper userMapper;
    private final org.springframework.context.ApplicationEventPublisher eventPublisher;
    private final SecureRandom secureRandom = new SecureRandom();

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                            UserRepository userRepository,
                            StudentProfileRepository studentProfileRepository,
                            OtpRepository otpRepository,
                            EmailService emailService,
                            PasswordEncoder passwordEncoder,
                            JwtTokenProvider tokenProvider,
                            UserMapper userMapper,
                            org.springframework.context.ApplicationEventPublisher eventPublisher) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.otpRepository = otpRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.userMapper = userMapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public UserDto register(RegisterRequest request) {
        String email = normalizeEmail(request.getEmail());
        var existingUserOpt = userRepository.findByEmail(email);
        User savedUser;

        if (existingUserOpt.isPresent()) {
            User existing = existingUserOpt.get();
            if (existing.isEmailVerified()) {
                throw new BadRequestException("Email already registered: " + email);
            }
            // A pending account may restart registration; it remains locked until OTP verification.
            existing.setFirstName(request.getFirstName());
            existing.setLastName(request.getLastName());
            existing.setPassword(passwordEncoder.encode(request.getPassword()));
            existing.setActive(false);
            existing.setEmailVerified(false);
            savedUser = userRepository.save(existing);
        } else {
            User user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(email)
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.STUDENT)
                    .active(false)
                    .emailVerified(false)
                    .build();

            savedUser = userRepository.save(user);

            // Initialize a blank student profile
            StudentProfile profile = StudentProfile.builder()
                    .user(savedUser)
                    .streak(0)
                    .build();
            StudentProfile savedProfile = studentProfileRepository.save(profile);

            eventPublisher.publishEvent(new com.careerforge.notification.event.NotificationEvent(
                    this,
                    savedProfile,
                    "Welcome to CareerForge, " + savedUser.getFirstName() + "! Verify your email to activate your account."
            ));
        }

        // Generate and dispatch 6-digit verification OTP
        String otpCode = createAndSaveOtp(savedUser.getEmail(), OtpType.EMAIL_VERIFICATION);
        dispatchOtpEmail(savedUser.getEmail(), otpCode, OtpType.EMAIL_VERIFICATION);

        return userMapper.toDto(savedUser);
    }

    @Override
    public JwtAuthResponse verifyOtp(VerifyOtpRequest request) {
        String email = normalizeEmail(request.getEmail());
        var otpOpt = otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(
                email,
                request.getType()
        );
        Otp otp = otpOpt.orElseThrow(() -> new BadRequestException("No active verification code found for this email."));
        if (otp.isExpired()) {
            throw new BadRequestException("Verification code has expired. Please request a new one.");
        }
        if (!passwordEncoder.matches(request.getOtp(), otp.getOtpCode())) {
            throw new BadRequestException("Incorrect verification code. Please check your email and try again.");
        }
        otp.setVerified(true);
        otpRepository.save(otp);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + email));

        if (request.getType() == OtpType.EMAIL_VERIFICATION) {
            user.setEmailVerified(true);
            user.setActive(true);
            userRepository.save(user);
        }

        // Create authentication to generate access & refresh tokens
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userPrincipal,
                null,
                userPrincipal.getAuthorities()
        );

        String jwt = tokenProvider.generateToken(auth);
        String refreshJwt = tokenProvider.generateRefreshToken(auth);

        return JwtAuthResponse.builder()
                .accessToken(jwt)
                .refreshToken(refreshJwt)
                .user(userMapper.toDto(user))
                .build();
    }

    @Override
    public void resendOtp(ResendOtpRequest request) {
        String email = normalizeEmail(request.getEmail());
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Account not found with email: " + email));

        if (request.getType() == OtpType.EMAIL_VERIFICATION && user.isEmailVerified()) {
            throw new BadRequestException("Email is already verified. Please sign in.");
        }

        // Rate limit: check if an OTP was created less than 60 seconds ago
        var latestOtpOpt = otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(
                email,
                request.getType()
        );

        if (latestOtpOpt.isPresent()) {
            LocalDateTime lastCreatedAt = latestOtpOpt.get().getCreatedAt();
            if (lastCreatedAt != null && lastCreatedAt.isAfter(LocalDateTime.now().minusSeconds(60))) {
                throw new BadRequestException("Please wait at least 60 seconds before requesting a new code.");
            }
        }

        String otpCode = createAndSaveOtp(email, request.getType());
        dispatchOtpEmail(email, otpCode, request.getType());
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {
        String email = normalizeEmail(request.getEmail());
        var userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            log.info("Password reset requested for non-existent email: {}", email);
            return; // Prevent user enumeration
        }

        String otpCode = createAndSaveOtp(email, OtpType.PASSWORD_RESET);
        dispatchOtpEmail(email, otpCode, OtpType.PASSWORD_RESET);
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {
        String email = normalizeEmail(request.getEmail());
        var otpOpt = otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(
                email,
                OtpType.PASSWORD_RESET
        );
        Otp otp = otpOpt.orElseThrow(() -> new BadRequestException("No active password reset request found. Please request a new code."));
        if (otp.isExpired()) {
            throw new BadRequestException("Password reset code has expired. Please request a new code.");
        }
        if (!passwordEncoder.matches(request.getOtp(), otp.getOtpCode())) {
            throw new BadRequestException("Incorrect password reset code.");
        }
        otp.setVerified(true);
        otpRepository.save(otp);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + email));

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        log.info("Password successfully reset for user: {}", user.getEmail());
    }

    @Override
    @Transactional
    public JwtAuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid email or password"));

        if (!user.isEmailVerified()) {
            throw new BadRequestException("Please verify your email before signing in.");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        String refreshJwt = tokenProvider.generateRefreshToken(authentication);

        return JwtAuthResponse.builder()
                .accessToken(jwt)
                .refreshToken(refreshJwt)
                .user(userMapper.toDto(user))
                .build();
    }

    private String createAndSaveOtp(String email, OtpType type) {
        otpRepository.deleteAllByEmailAndOtpType(email, type);
        String otpCode = String.format("%06d", secureRandom.nextInt(1_000_000));
        Otp otp = Otp.builder()
                .email(email)
                .otpCode(passwordEncoder.encode(otpCode))
                .otpType(type)
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .verified(false)
                .build();
        otpRepository.save(otp);
        return otpCode;
    }

    private String normalizeEmail(String email) {
        return email.trim().toLowerCase(Locale.ROOT);
    }

    /**
     * Resilient helper to dispatch OTP emails with safe exception handling.
     * Prevents mail server connection exceptions (e.g., cloud egress firewalls)
     * from breaking user registration or password reset transactions.
     */
    private void dispatchOtpEmail(String email, String otpCode, OtpType type) {
        try {
            emailService.sendOtpEmail(email, otpCode, type);
        } catch (Exception e) {
            log.warn("OTP email dispatch failed for {} [type: {}]: {}", email, type, e.getMessage());
        }
    }
}
