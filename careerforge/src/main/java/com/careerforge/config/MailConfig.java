package com.careerforge.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    private static final Logger log = LoggerFactory.getLogger(MailConfig.class);

    @Value("${spring.mail.host:}")
    private String host;

    @Value("${spring.mail.port:587}")
    private int port;

    @Value("${spring.mail.username:}")
    private String username;

    @Value("${spring.mail.password:}")
    private String password;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        if (host != null && !host.isBlank()) {
            String sanitizedHost = host.trim();
            String sanitizedUsername = username != null ? username.trim() : "";
            // Automatically strip spaces from Google App Passwords (e.g. 'ddtf hubp qgem iiwe' -> 'ddtfhubpqgemiiwe')
            String sanitizedPassword = password != null ? password.replaceAll("\\s+", "").trim() : "";

            mailSender.setHost(sanitizedHost);
            mailSender.setPort(port);
            mailSender.setUsername(sanitizedUsername);
            mailSender.setPassword(sanitizedPassword);

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.ssl.trust", "*");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3");
            props.put("mail.smtp.connectiontimeout", "4000");
            props.put("mail.smtp.timeout", "4000");
            props.put("mail.smtp.writetimeout", "4000");

            log.info("📧 JavaMailSender configured successfully for host [{}] on port [{}] with username [{}]",
                    sanitizedHost, port, sanitizedUsername);
        } else {
            log.info("📧 JavaMailSender host is blank. SMTP email dispatch will be bypassed.");
        }
        return mailSender;
    }
}
