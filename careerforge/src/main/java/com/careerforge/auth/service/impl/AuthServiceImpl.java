package com.careerforge.auth.service.impl;

import com.careerforge.auth.dto.JwtAuthResponse;
import com.careerforge.auth.dto.LoginRequest;
import com.careerforge.auth.dto.RegisterRequest;
import com.careerforge.auth.service.AuthService;
import com.careerforge.exception.BadRequestException;
import com.careerforge.security.JwtTokenProvider;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.dto.UserDto;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.mapper.UserMapper;
import com.careerforge.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final UserMapper userMapper;
    private final org.springframework.context.ApplicationEventPublisher eventPublisher;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                            UserRepository userRepository,
                            StudentProfileRepository studentProfileRepository,
                            PasswordEncoder passwordEncoder,
                            JwtTokenProvider tokenProvider,
                            UserMapper userMapper,
                            org.springframework.context.ApplicationEventPublisher eventPublisher) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.userMapper = userMapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public UserDto register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists: " + request.getEmail());
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT)
                .active(true)
                .build();

        User savedUser = userRepository.save(user);

        // Initialize a blank student profile for newly registered students
        StudentProfile profile = StudentProfile.builder()
                .user(savedUser)
                .streak(0)
                .build();
        StudentProfile savedProfile = studentProfileRepository.save(profile);
        
        eventPublisher.publishEvent(new com.careerforge.notification.event.NotificationEvent(
                this,
                savedProfile,
                "Welcome to CareerForge, " + savedUser.getFirstName() + "! Complete your profile details to generate your personalized placement roadmap."
        ));

        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public JwtAuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        String refreshJwt = tokenProvider.generateRefreshToken(authentication);

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("User record missing after authentication"));

        return JwtAuthResponse.builder()
                .accessToken(jwt)
                .refreshToken(refreshJwt)
                .user(userMapper.toDto(user))
                .build();
    }
}
