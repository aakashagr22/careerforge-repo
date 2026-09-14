import { apiClient } from '../config/api';
import { JwtAuthResponse, User } from '../types/auth';
import {
  LoginRequest,
  RegisterRequest,
  VerifyOtpRequest,
  ResendOtpRequest,
  ForgotPasswordRequest,
  ResetPasswordRequest,
} from '../types/requests';

export const authService = {
  async login(credentials: LoginRequest): Promise<JwtAuthResponse> {
    const response = await apiClient.post('/auth/login', credentials);
    const data = response.data?.data || response.data;
    if (!data || typeof data !== 'object' || !data.accessToken) {
      throw new Error('Invalid authentication response from backend server.');
    }
    return data;
  },

  async register(details: RegisterRequest): Promise<User> {
    const response = await apiClient.post('/auth/register', details);
    return response.data?.data || response.data;
  },

  async verifyOtp(payload: VerifyOtpRequest): Promise<JwtAuthResponse> {
    const response = await apiClient.post('/auth/verify-otp', payload);
    const data = response.data?.data || response.data;
    if (!data || typeof data !== 'object' || !data.accessToken) {
      throw new Error('Invalid authentication response from backend server.');
    }
    return data;
  },

  async resendOtp(payload: ResendOtpRequest): Promise<void> {
    await apiClient.post('/auth/resend-otp', payload);
  },

  async forgotPassword(payload: ForgotPasswordRequest): Promise<void> {
    await apiClient.post('/auth/forgot-password', payload);
  },

  async resetPassword(payload: ResetPasswordRequest): Promise<void> {
    await apiClient.post('/auth/reset-password', payload);
  },
};
