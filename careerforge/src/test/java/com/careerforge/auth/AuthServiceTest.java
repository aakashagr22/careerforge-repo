package com.careerforge.auth;

import com.careerforge.auth.dto.JwtAuthResponse;
import com.careerforge.auth.dto.LoginRequest;
import com.careerforge.auth.dto.RegisterRequest;
import com.careerforge.auth.service.impl.AuthServiceImpl;
import com.careerforge.exception.BadRequestException;
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
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider tokenProvider;

    @Mock
    private UserMapper userMapper;

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
                .role(Role.STUDENT)
                .build();

        user = User.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("encodedPassword")
                .role(Role.STUDENT)
                .active(true)
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
    void register_ShouldSaveUserAndProfile_WhenEmailIsUnique() {
        when(userRepository.existsByEmail(registerRequest.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toDto(user)).thenReturn(userDto);

        UserDto result = authService.register(registerRequest);

        assertNotNull(result);
        assertEquals(registerRequest.getEmail(), result.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
        verify(studentProfileRepository, times(1)).save(any(StudentProfile.class));
    }

    @Test
    void register_ShouldThrowException_WhenEmailAlreadyExists() {
        when(userRepository.existsByEmail(registerRequest.getEmail())).thenReturn(true);

        assertThrows(BadRequestException.class, () -> authService.register(registerRequest));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void login_ShouldReturnJwtResponse_WhenCredentialsAreValid() {
        LoginRequest loginRequest = new LoginRequest("john.doe@example.com", "password123");
        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(tokenProvider.generateToken(authentication)).thenReturn("accessToken");
        when(tokenProvider.generateRefreshToken(authentication)).thenReturn("refreshToken");
        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.of(user));
        when(userMapper.toDto(user)).thenReturn(userDto);

        JwtAuthResponse response = authService.login(loginRequest);

        assertNotNull(response);
        assertEquals("accessToken", response.getAccessToken());
        assertEquals("refreshToken", response.getRefreshToken());
        assertEquals(userDto, response.getUser());
    }
}
