import { apiClient } from '../config/api';

export const adminService = {
  // Stats
  async getDashboardStats(): Promise<any> {
    const response = await apiClient.get('/api/admin/dashboard/stats');
    return response.data.data;
  },

  // Student CRUD
  async getAllStudents(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/admin/students', {
      params: { page, size }
    });
    return response.data.data;
  },

  async deleteStudent(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/students/${id}`);
    return response.data;
  },

  // Resources CRUD
  async createResource(data: any): Promise<any> {
    const response = await apiClient.post('/api/admin/resources', data);
    return response.data.data;
  },

  async deleteResource(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/resources/${id}`);
    return response.data;
  },

  // Sheets CRUD
  async createSheet(data: any): Promise<any> {
    const response = await apiClient.post('/api/admin/sheets', data);
    return response.data.data;
  },

  async deleteSheet(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/sheets/${id}`);
    return response.data;
  },

  // Topics CRUD
  async createSheetTopic(data: any): Promise<any> {
    const response = await apiClient.post('/api/admin/sheets/topics', data);
    return response.data.data;
  },

  async deleteSheetTopic(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/sheets/topics/${id}`);
    return response.data;
  },

  // Roadmaps CRUD
  async createRoadmap(data: any): Promise<any> {
    const response = await apiClient.post('/api/admin/roadmaps', data);
    return response.data.data;
  },

  async deleteRoadmap(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/roadmaps/${id}`);
    return response.data;
  },

  async getAllRoadmaps(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/admin/roadmaps', {
      params: { page, size }
    });
    return response.data.data;
  },

  async getRoadmapSectionsTree(roadmapId: string): Promise<any> {
    const response = await apiClient.get(`/api/admin/roadmaps/${roadmapId}/tree`);
    return response.data.data;
  },

  // Roadmap Sections CRUD
  async createRoadmapSection(data: any): Promise<any> {
    const response = await apiClient.post('/api/admin/roadmaps/sections', data);
    return response.data.data;
  },

  async deleteRoadmapSection(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/roadmaps/sections/${id}`);
    return response.data;
  },
};
export default adminService;
