import { apiClient } from '../config/api';
import { Suggestion, CreateSuggestionRequest, ReplySuggestionRequest } from '../types/suggestion';

export const suggestionService = {
  // Student API calls
  async submitSuggestion(data: CreateSuggestionRequest): Promise<Suggestion> {
    const response = await apiClient.post('/api/student/suggestions', data);
    return response.data.data;
  },

  async getMySuggestions(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/student/suggestions', {
      params: { page, size }
    });
    return response.data.data;
  },

  // Admin API calls
  async getAdminSuggestions(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/admin/suggestions', {
      params: { page, size }
    });
    return response.data.data;
  },

  async replyToSuggestion(id: string, data: ReplySuggestionRequest): Promise<Suggestion> {
    const response = await apiClient.post(`/api/admin/suggestions/${id}/reply`, data);
    return response.data.data;
  }
};
