package com.careerforge.auth.service;

import com.careerforge.auth.dto.*;
import com.careerforge.user.dto.UserDto;

public interface AuthService {
    UserDto register(RegisterRequest request);
    JwtAuthResponse login(LoginRequest request);
    JwtAuthResponse verifyOtp(VerifyOtpRequest request);
    void resendOtp(ResendOtpRequest request);
    void forgotPassword(ForgotPasswordRequest request);
    void resetPassword(ResetPasswordRequest request);
}
