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

/**
 * Enterprise Authentication Service
 * 
 * Provides unified authentication, JWT session management, and resilient OTP verification.
 * 
 * Architectural Highlights:
 * - Multi-Factor Verification Engine: Communicates with Spring Boot backend via RESTful endpoints.
 * - Uses the backend's email-delivered, time-limited OTP flow for account verification.
 */
export const authService = {
  /**
   * Authenticate user credentials and retrieve access + refresh JWT tokens.
   */
  async login(credentials: LoginRequest): Promise<JwtAuthResponse> {
    const response = await apiClient.post('/auth/login', credentials);
    const data = response.data?.data || response.data;
    if (!data || typeof data !== 'object' || !data.accessToken) {
      throw new Error('Invalid authentication response from backend server.');
    }
    return data;
  },

  /**
   * Register a new user account.
   * The account remains pending until the email OTP is verified.
   */
  async register(details: RegisterRequest): Promise<User> {
    const response = await apiClient.post('/auth/register', details);
    return response.data?.data || response.data;
  },

  /**
   * Verify 6-digit OTP code to activate email verification or authorize sensitive operations.
   * A successful verification returns the authenticated session tokens.
   */
  async verifyOtp(payload: VerifyOtpRequest): Promise<JwtAuthResponse> {
    const response = await apiClient.post('/auth/verify-otp', payload);
    const data = response.data?.data || response.data;
    if (!data || typeof data !== 'object' || !data.accessToken) {
      throw new Error('Invalid authentication response from backend server.');
    }
    return data;
  },

  /**
   * Dispatch a fresh 6-digit verification code.
   */
  async resendOtp(payload: ResendOtpRequest): Promise<void> {
    await apiClient.post('/auth/resend-otp', payload);
  },

  /**
   * Request password reset OTP dispatch for the specified account email.
   */
  async forgotPassword(payload: ForgotPasswordRequest): Promise<void> {
    await apiClient.post('/auth/forgot-password', payload);
  },

  /**
   * Complete password reset using verified 6-digit OTP code and new password.
   */
  async resetPassword(payload: ResetPasswordRequest): Promise<void> {
    await apiClient.post('/auth/reset-password', payload);
  },
};
