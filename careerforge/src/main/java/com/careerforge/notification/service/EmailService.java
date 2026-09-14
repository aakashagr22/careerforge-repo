package com.careerforge.notification.service;

import com.careerforge.auth.entity.OtpType;

public interface EmailService {

    void sendOtpEmail(String toEmail, String otpCode, OtpType type);
}
