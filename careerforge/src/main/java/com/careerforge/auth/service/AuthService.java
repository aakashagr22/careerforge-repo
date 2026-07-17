package com.careerforge.auth.service;

import com.careerforge.auth.dto.JwtAuthResponse;
import com.careerforge.auth.dto.LoginRequest;
import com.careerforge.auth.dto.RegisterRequest;
import com.careerforge.user.dto.UserDto;

public interface AuthService {
    UserDto register(RegisterRequest request);
    JwtAuthResponse login(LoginRequest request);
}
