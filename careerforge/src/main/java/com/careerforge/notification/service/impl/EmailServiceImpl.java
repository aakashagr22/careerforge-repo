package com.careerforge.notification.service.impl;

import com.careerforge.auth.entity.OtpType;
import com.careerforge.notification.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    private static final URI RESEND_EMAILS_URI = URI.create("https://api.resend.com/emails");

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${app.email.resend-api-key:}")
    private String resendApiKey;

    @Value("${app.email.from:}")
    private String fromEmail;

    public EmailServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    @Override
    @Async
    public void sendOtpEmail(String toEmail, String otpCode, OtpType type) {
        String subject = type == OtpType.EMAIL_VERIFICATION
                ? "CareerForge — Verify Your Email Address"
                : "CareerForge — Password Reset OTP";

        String title = type == OtpType.EMAIL_VERIFICATION
                ? "Verify Your Email"
                : "Reset Your Password";

        String description = type == OtpType.EMAIL_VERIFICATION
                ? "Thank you for creating an account on CareerForge. Use the verification code below to activate your account and start your placement preparation."
                : "We received a request to reset your CareerForge password. Enter the one-time code below to choose a new password.";

        log.info("Dispatching {} OTP email to {}", type, toEmail);

        if (resendApiKey == null || resendApiKey.isBlank() || fromEmail == null || fromEmail.isBlank()) {
            log.error("Resend is not configured. Set RESEND_API_KEY and EMAIL_FROM before requesting OTP emails.");
            return;
        }

        try {
            String htmlContent = buildOtpHtmlTemplate(title, description, otpCode);
            String body = objectMapper.writeValueAsString(Map.of(
                    "from", fromEmail.trim(),
                    "to", List.of(toEmail),
                    "subject", subject,
                    "html", htmlContent
            ));
            HttpRequest request = HttpRequest.newBuilder(RESEND_EMAILS_URI)
                    .timeout(Duration.ofSeconds(15))
                    .header("Authorization", "Bearer " + resendApiKey.trim())
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "CareerForge/1.0")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                log.error("Resend rejected OTP email to {} with HTTP {}: {}", toEmail, response.statusCode(), response.body());
                return;
            }
            log.info("OTP email accepted by Resend for {}", toEmail);
        } catch (Exception e) {
            log.error("Failed to dispatch OTP email to Resend for {}", toEmail, e);
        }
    }

    private String buildOtpHtmlTemplate(String title, String description, String otpCode) {
        return """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="utf-8">
              <style>
                body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #0f172a; color: #f8fafc; margin: 0; padding: 24px; }
                .card { max-width: 520px; margin: 0 auto; background: #1e293b; border: 1px solid #334155; border-radius: 16px; padding: 36px; box-shadow: 0 10px 25px rgba(0,0,0,0.5); }
                .logo { font-size: 24px; font-weight: 800; color: #818cf8; text-align: center; margin-bottom: 24px; }
                .title { font-size: 20px; font-weight: 700; color: #ffffff; text-align: center; margin-bottom: 12px; }
                .desc { font-size: 14px; color: #94a3b8; line-height: 1.6; text-align: center; margin-bottom: 28px; }
                .otp-box { background: #0f172a; border: 2px dashed #6366f1; border-radius: 12px; padding: 18px; text-align: center; margin: 0 auto 24px; width: fit-content; }
                .otp-code { font-family: 'Courier New', Courier, monospace; font-size: 36px; font-weight: 800; letter-spacing: 8px; color: #38bdf8; margin: 0; }
                .meta { font-size: 12px; color: #64748b; text-align: center; margin-top: 24px; border-top: 1px solid #334155; pt: 16px; }
              </style>
            </head>
            <body>
              <div class="card">
                <div class="logo">⚡ CareerForge</div>
                <div class="title">%s</div>
                <div class="desc">%s</div>
                <div class="otp-box">
                  <div class="otp-code">%s</div>
                </div>
                <div class="desc" style="font-size: 13px; color: #fbbf24;">This code is valid for 10 minutes. Do not share it with anyone.</div>
                <div class="meta">If you did not request this email, you can safely ignore it.</div>
              </div>
            </body>
            </html>
            """.formatted(title, description, otpCode);
    }
}
