package com.careerforge.config;

import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminSeeder.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        String adminEmail = "admin@careerforge.com";
        var existingAdminOpt = userRepository.findByEmail(adminEmail);

        if (existingAdminOpt.isPresent()) {
            User existingAdmin = existingAdminOpt.get();
            existingAdmin.setRole(Role.ADMIN);
            existingAdmin.setPassword(passwordEncoder.encode("Admin@123"));
            existingAdmin.setActive(true);
            existingAdmin.setEmailVerified(true);
            userRepository.save(existingAdmin);
            log.info("Default administrator account verified & updated: {}", adminEmail);
        } else {
            User admin = User.builder()
                    .firstName("System")
                    .lastName("Admin")
                    .email(adminEmail)
                    .password(passwordEncoder.encode("Admin@123"))
                    .role(Role.ADMIN)
                    .active(true)
                    .emailVerified(true)
                    .build();
            userRepository.save(admin);
            log.info("Default super administrator created: {}", adminEmail);
        }
    }
}
