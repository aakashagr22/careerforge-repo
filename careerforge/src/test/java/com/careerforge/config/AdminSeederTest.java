package com.careerforge.config;

import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminSeederTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AdminSeeder adminSeeder;

    @Test
    void run_ShouldCreateAdmin_WhenNotPresent() {
        when(userRepository.findByEmail("admin@careerforge.com")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("Admin@123")).thenReturn("encodedPassword");

        adminSeeder.run();

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void run_ShouldUpdateExistingAdmin_WhenPresent() {
        User existing = User.builder()
                .email("admin@careerforge.com")
                .role(Role.STUDENT)
                .build();
        when(userRepository.findByEmail("admin@careerforge.com")).thenReturn(Optional.of(existing));
        when(passwordEncoder.encode("Admin@123")).thenReturn("encodedPassword");

        adminSeeder.run();

        verify(userRepository, times(1)).save(existing);
    }
}
