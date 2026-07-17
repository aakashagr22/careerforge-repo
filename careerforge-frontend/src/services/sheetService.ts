import { apiClient } from '../config/api';
import { PracticeSheet, Topic } from '../types/sheets';

export const sheetService = {
  async getPracticeSheets(): Promise<PracticeSheet[]> {
    const response = await apiClient.get('/api/student/sheets', {
      params: { page: 0, size: 100 } // Fetch all sheets
    });
    // Spring Boot Page structure has a "content" array
    return response.data.data.content;
  },

  async getSheetTopics(sheetId: string): Promise<Topic[]> {
    const response = await apiClient.get(`/api/student/sheets/${sheetId}/topics`);
    return response.data.data;
  },

  async getCompletedTopicIds(): Promise<string[]> {
    const response = await apiClient.get('/api/student/sheets/completions');
    return response.data.data;
  },

  async toggleTopicCompletion(topicId: string, completed: boolean): Promise<any> {
    const response = await apiClient.post(`/api/student/sheets/topics/${topicId}/complete`, null, {
      params: { completed }
    });
    return response.data.data;
  },
};
