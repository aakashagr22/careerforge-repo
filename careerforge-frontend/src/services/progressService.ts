import { apiClient } from '../config/api';
import { DashboardData } from '../types/progress';

export const progressService = {
  async getDashboardData(): Promise<DashboardData> {
    const response = await apiClient.get('/api/student/dashboard');
    return response.data.data;
  },
};
