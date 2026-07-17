import { apiClient } from '../config/api';
import { StudentProfile } from '../types/auth';

export const studentService = {
  async getMyProfile(): Promise<StudentProfile> {
    const response = await apiClient.get('/students/me');
    return response.data.data;
  },

  async updateMyProfile(data: any): Promise<StudentProfile> {
    const response = await apiClient.put('/students/me', data);
    return response.data.data;
  },
};
