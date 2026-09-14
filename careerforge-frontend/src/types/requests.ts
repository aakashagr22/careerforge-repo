import { Role } from './auth';

export interface LoginRequest {
  email: string;
  password: string;
}

export interface RegisterRequest {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
}

export interface UpdateUserRoleRequest {
  role: Role;
}

export type OtpType = 'EMAIL_VERIFICATION' | 'PASSWORD_RESET';

export interface VerifyOtpRequest {
  email: string;
  otp: string;
  type: OtpType;
}

export interface ResendOtpRequest {
  email: string;
  type: OtpType;
}

export interface ForgotPasswordRequest {
  email: string;
}

export interface ResetPasswordRequest {
  email: string;
  otp: string;
  newPassword: string;
}
