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

  async updateResource(id: string, data: any): Promise<any> {
    const response = await apiClient.put(`/api/admin/resources/${id}`, data);
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

  // Canonical Questions CRUD
  async createQuestion(data: { title: string; description?: string; difficulty: string }): Promise<any> {
    const response = await apiClient.post('/api/admin/questions', data);
    return response.data.data;
  },

  async deleteQuestion(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/questions/${id}`);
    return response.data;
  },

  // Question Links CRUD
  async createQuestionLink(questionId: string, data: { linkType: string; label?: string; url: string; position: number }): Promise<any> {
    const response = await apiClient.post(`/api/admin/questions/${questionId}/links`, data);
    return response.data.data;
  },

  // Section Question Placement CRUD
  async assignQuestionToSection(sectionId: string, data: { questionId: string; position: number }): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/sections/${sectionId}/question-items`, data);
    return response.data.data;
  },

  async removeQuestionFromSection(sectionQuestionId: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/roadmaps/sections/question-items/${sectionQuestionId}`);
    return response.data;
  },

  async seedRoadmapDsa(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-dsa`);
    return response.data;
  },

  async seedRoadmapSpringBoot(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-springboot`);
    return response.data;
  },

  async seedRoadmapMern(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-mern`);
    return response.data;
  },

  async seedRoadmapFastApi(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-fastapi`);
    return response.data;
  },

  async seedRoadmapFrontend(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-frontend`);
    return response.data;
  },

  async seedRoadmapAiMl(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-aiml`);
    return response.data;
  },

  async seedRoadmapDataScientist(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-datascientist`);
    return response.data;
  },

  async seedRoadmapJava(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-java`);
    return response.data;
  },

  async seedRoadmapPython(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-python`);
    return response.data;
  },

  async seedRoadmapCpp(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-cpp`);
    return response.data;
  },

  async seedRoadmapCpSheet(roadmapId: string): Promise<any> {
    const response = await apiClient.post(`/api/admin/roadmaps/${roadmapId}/seed-cpsheet`);
    return response.data;
  },
};

export default adminService;

