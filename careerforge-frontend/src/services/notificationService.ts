import { apiClient } from '../config/api';
import { NotificationItem } from '../types/notifications';

export const notificationService = {
  async getNotifications(): Promise<NotificationItem[]> {
    const response = await apiClient.get('/api/student/notifications');
    return response.data.data;
  },

  async markAsRead(id: string): Promise<void> {
    const response = await apiClient.put(`/api/student/notifications/${id}/read`);
    return response.data;
  },
};
