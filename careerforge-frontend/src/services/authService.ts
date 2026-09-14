import { apiClient } from '../config/api';
import { JwtAuthResponse, User } from '../types/auth';
import { LoginRequest, RegisterRequest } from '../types/requests';

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
};
