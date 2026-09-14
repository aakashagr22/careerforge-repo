package com.careerforge.auth.service;

import com.careerforge.auth.dto.*;
import com.careerforge.user.dto.UserDto;

public interface AuthService {
    UserDto register(RegisterRequest request);
    JwtAuthResponse login(LoginRequest request);
    JwtAuthResponse verifyOtp(VerifyOtpRequest request);
    String resendOtp(ResendOtpRequest request);
    String forgotPassword(ForgotPasswordRequest request);
    void resetPassword(ResetPasswordRequest request);
}
