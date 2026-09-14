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
import java.util.List;

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
        var existingUserOpt = userRepository.findByEmail(request.getEmail());
        User savedUser;

        if (existingUserOpt.isPresent()) {
            User existing = existingUserOpt.get();
            if (existing.isEmailVerified()) {
                throw new BadRequestException("Email already registered: " + request.getEmail());
            }
            // If user previously signed up but did not verify email, update password and details
            existing.setFirstName(request.getFirstName());
            existing.setLastName(request.getLastName());
            existing.setPassword(passwordEncoder.encode(request.getPassword()));
            savedUser = userRepository.save(existing);
        } else {
            User user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.STUDENT)
                    .active(true)
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
                    "Welcome to CareerForge, " + savedUser.getFirstName() + "! Verify your email to start your placement journey."
            ));
        }

        // Generate and dispatch 6-digit verification OTP
        String otpCode = createAndSaveOtp(savedUser.getEmail(), OtpType.EMAIL_VERIFICATION);
        emailService.sendOtpEmail(savedUser.getEmail(), otpCode, OtpType.EMAIL_VERIFICATION);

        return userMapper.toDto(savedUser);
    }

    @Override
    public JwtAuthResponse verifyOtp(VerifyOtpRequest request) {
        Otp otp = otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(
                request.getEmail(),
                request.getType()
        ).orElseThrow(() -> new BadRequestException("No active verification code found for this email."));

        if (otp.isExpired()) {
            throw new BadRequestException("Verification code has expired. Please request a new one.");
        }

        if (!otp.getOtpCode().equals(request.getOtp().trim())) {
            throw new BadRequestException("Incorrect verification code. Please check your email and try again.");
        }

        otp.setVerified(true);
        otpRepository.save(otp);

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + request.getEmail()));

        if (request.getType() == OtpType.EMAIL_VERIFICATION) {
            user.setEmailVerified(true);
            user.setActive(true);
            userRepository.save(user);
        }

        // Create authentication to generate access & refresh tokens
        Authentication auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                null,
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
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
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Account not found with email: " + request.getEmail()));

        if (request.getType() == OtpType.EMAIL_VERIFICATION && user.isEmailVerified()) {
            throw new BadRequestException("Email is already verified. Please sign in.");
        }

        // Rate limit: check if an OTP was created less than 60 seconds ago
        var latestOtpOpt = otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(
                request.getEmail(),
                request.getType()
        );

        if (latestOtpOpt.isPresent()) {
            LocalDateTime lastCreatedAt = latestOtpOpt.get().getCreatedAt();
            if (lastCreatedAt != null && lastCreatedAt.isAfter(LocalDateTime.now().minusSeconds(60))) {
                throw new BadRequestException("Please wait at least 60 seconds before requesting a new code.");
            }
        }

        String otpCode = createAndSaveOtp(request.getEmail(), request.getType());
        emailService.sendOtpEmail(request.getEmail(), otpCode, request.getType());
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {
        var userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            log.info("Password reset requested for non-existent email: {}", request.getEmail());
            return; // Return silently to prevent user enumeration
        }

        String otpCode = createAndSaveOtp(request.getEmail(), OtpType.PASSWORD_RESET);
        emailService.sendOtpEmail(request.getEmail(), otpCode, OtpType.PASSWORD_RESET);
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {
        Otp otp = otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(
                request.getEmail(),
                OtpType.PASSWORD_RESET
        ).orElseThrow(() -> new BadRequestException("No active password reset request found. Please request a new code."));

        if (otp.isExpired()) {
            throw new BadRequestException("Password reset code has expired. Please request a new one.");
        }

        if (!otp.getOtpCode().equals(request.getOtp().trim())) {
            throw new BadRequestException("Incorrect password reset code.");
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + request.getEmail()));

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        otp.setVerified(true);
        otpRepository.save(otp);
        log.info("Password successfully reset for user: {}", user.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public JwtAuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid email or password"));

        if (!user.isEmailVerified()) {
            throw new BadRequestException("Please verify your email address with the 6-digit OTP sent to your inbox before logging in.");
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
        String otpCode = String.format("%06d", secureRandom.nextInt(1000000));
        Otp otp = Otp.builder()
                .email(email)
                .otpCode(otpCode)
                .otpType(type)
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .verified(false)
                .build();
        otpRepository.save(otp);
        return otpCode;
    }
}
