import { apiClient } from '../config/api';
import type { CommunityAnswer, CommunityQuestion, CommunityQuestionPage, CreateQuestionRequest } from '../types/community';

export const communityService = {
  async getQuestions(page = 0, size = 10): Promise<CommunityQuestionPage> {
    const response = await apiClient.get('/api/student/questions', { params: { page, size } });
    return response.data.data;
  },
  async getQuestion(id: string): Promise<CommunityQuestion> {
    const response = await apiClient.get(`/api/student/questions/${id}`);
    return response.data.data;
  },
  async createQuestion(data: CreateQuestionRequest): Promise<CommunityQuestion> {
    const response = await apiClient.post('/api/student/questions', data);
    return response.data.data;
  },
  async createAnswer(questionId: string, content: string): Promise<CommunityAnswer> {
    const response = await apiClient.post(`/api/student/questions/${questionId}/answers`, { content });
    return response.data.data;
  },
};
