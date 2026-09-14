package com.careerforge.auth;

import com.careerforge.auth.dto.*;
import com.careerforge.auth.entity.Otp;
import com.careerforge.auth.entity.OtpType;
import com.careerforge.auth.repository.OtpRepository;
import com.careerforge.auth.service.impl.AuthServiceImpl;
import com.careerforge.exception.BadRequestException;
import com.careerforge.notification.service.EmailService;
import com.careerforge.security.JwtTokenProvider;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.dto.UserDto;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.mapper.UserMapper;
import com.careerforge.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private OtpRepository otpRepository;

    @Mock
    private EmailService emailService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider tokenProvider;

    @Mock
    private UserMapper userMapper;

    @Mock
    private org.springframework.context.ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private AuthServiceImpl authService;

    private RegisterRequest registerRequest;
    private User user;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        registerRequest = RegisterRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("password123")
                .build();

        user = User.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("encodedPassword")
                .role(Role.STUDENT)
                .active(true)
                .emailVerified(true)
                .build();

        userDto = UserDto.builder()
                .id(user.getId())
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .role(Role.STUDENT)
                .active(true)
                .build();
    }

    @Test
    void register_ShouldSaveUserAndSendOtp_WhenEmailIsUnique() {
        when(userRepository.findByEmail(registerRequest.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toDto(user)).thenReturn(userDto);

        UserDto result = authService.register(registerRequest);

        assertNotNull(result);
        assertEquals(registerRequest.getEmail(), result.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
        verify(studentProfileRepository, times(1)).save(any(StudentProfile.class));
        verify(otpRepository, times(1)).save(any(Otp.class));
        verify(emailService, times(1)).sendOtpEmail(eq(registerRequest.getEmail()), anyString(), eq(OtpType.EMAIL_VERIFICATION));
    }

    @Test
    void register_ShouldThrowException_WhenEmailAlreadyVerified() {
        when(userRepository.findByEmail(registerRequest.getEmail())).thenReturn(Optional.of(user));

        assertThrows(BadRequestException.class, () -> authService.register(registerRequest));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void verifyOtp_ShouldVerifyAndReturnJwt_WhenOtpIsValid() {
        VerifyOtpRequest request = new VerifyOtpRequest("john.doe@example.com", "123456", OtpType.EMAIL_VERIFICATION);
        Otp otp = Otp.builder()
                .email(request.getEmail())
                .otpCode("123456")
                .otpType(OtpType.EMAIL_VERIFICATION)
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .verified(false)
                .build();

        when(otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(request.getEmail(), OtpType.EMAIL_VERIFICATION))
                .thenReturn(Optional.of(otp));
        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(user));
        when(tokenProvider.generateToken(any(Authentication.class))).thenReturn("accessToken");
        when(tokenProvider.generateRefreshToken(any(Authentication.class))).thenReturn("refreshToken");
        when(userMapper.toDto(user)).thenReturn(userDto);

        JwtAuthResponse response = authService.verifyOtp(request);

        assertNotNull(response);
        assertEquals("accessToken", response.getAccessToken());
        assertTrue(otp.isVerified());
        verify(otpRepository, times(1)).save(otp);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void verifyOtp_ShouldThrowException_WhenOtpExpired() {
        VerifyOtpRequest request = new VerifyOtpRequest("john.doe@example.com", "123456", OtpType.EMAIL_VERIFICATION);
        Otp otp = Otp.builder()
                .email(request.getEmail())
                .otpCode("123456")
                .otpType(OtpType.EMAIL_VERIFICATION)
                .expiresAt(LocalDateTime.now().minusMinutes(1))
                .verified(false)
                .build();

        when(otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(request.getEmail(), OtpType.EMAIL_VERIFICATION))
                .thenReturn(Optional.of(otp));

        assertThrows(BadRequestException.class, () -> authService.verifyOtp(request));
    }

    @Test
    void forgotPassword_ShouldGenerateOtpAndSendEmail_WhenUserExists() {
        ForgotPasswordRequest request = new ForgotPasswordRequest("john.doe@example.com");
        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(user));

        authService.forgotPassword(request);

        verify(otpRepository, times(1)).save(any(Otp.class));
        verify(emailService, times(1)).sendOtpEmail(eq(request.getEmail()), anyString(), eq(OtpType.PASSWORD_RESET));
    }

    @Test
    void resetPassword_ShouldUpdatePassword_WhenOtpIsValid() {
        ResetPasswordRequest request = new ResetPasswordRequest("john.doe@example.com", "654321", "newSecurePassword123");
        Otp otp = Otp.builder()
                .email(request.getEmail())
                .otpCode("654321")
                .otpType(OtpType.PASSWORD_RESET)
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .verified(false)
                .build();

        when(otpRepository.findTopByEmailAndOtpTypeAndVerifiedFalseOrderByCreatedAtDesc(request.getEmail(), OtpType.PASSWORD_RESET))
                .thenReturn(Optional.of(otp));
        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.encode(request.getNewPassword())).thenReturn("newEncodedPassword");

        authService.resetPassword(request);

        assertEquals("newEncodedPassword", user.getPassword());
        assertTrue(otp.isVerified());
        verify(userRepository, times(1)).save(user);
        verify(otpRepository, times(1)).save(otp);
    }

    @Test
    void login_ShouldReturnJwtResponse_WhenCredentialsAreValid() {
        LoginRequest loginRequest = new LoginRequest("john.doe@example.com", "password123");
        Authentication authentication = mock(Authentication.class);

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.of(user));
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(tokenProvider.generateToken(authentication)).thenReturn("accessToken");
        when(tokenProvider.generateRefreshToken(authentication)).thenReturn("refreshToken");
        when(userMapper.toDto(user)).thenReturn(userDto);

        JwtAuthResponse response = authService.login(loginRequest);

        assertNotNull(response);
        assertEquals("accessToken", response.getAccessToken());
        assertEquals("refreshToken", response.getRefreshToken());
        assertEquals(userDto, response.getUser());
    }
}
