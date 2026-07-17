import { apiClient } from '../config/api';
import { JwtAuthResponse, User } from '../types/auth';
import { LoginRequest, RegisterRequest } from '../types/requests';

export const authService = {
  async login(credentials: LoginRequest): Promise<JwtAuthResponse> {
    const response = await apiClient.post('/auth/login', credentials);
    return response.data.data;
  },

  async register(details: RegisterRequest): Promise<User> {
    const response = await apiClient.post('/auth/register', details);
    return response.data.data;
  },
};
