import { apiClient } from '../config/api';
import { Announcement, CreateAnnouncementRequest } from '../types/announcement';

export const announcementService = {
  // Shared (student + admin)
  async getAnnouncements(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/announcements', {
      params: { page, size },
    });
    return response.data.data;
  },

  // Admin only
  async createAnnouncement(data: CreateAnnouncementRequest): Promise<Announcement> {
    const response = await apiClient.post('/api/admin/announcements', data);
    return response.data.data;
  },

  async deleteAnnouncement(id: string): Promise<void> {
    await apiClient.delete(`/api/admin/announcements/${id}`);
  },
};
