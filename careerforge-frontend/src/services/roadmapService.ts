import { apiClient } from '../config/api';
import { PersonalizedRoadmapResponse } from '../types/roadmap';

export const roadmapService = {
  async getPersonalizedRoadmap(roadmapId?: string): Promise<PersonalizedRoadmapResponse> {
    const response = await apiClient.get('/api/student/roadmap', {
      params: roadmapId ? { roadmapId } : undefined,
    });
    return response.data.data;
  },

  async updateQuestionProgress(
    sectionQuestionId: string,
    progress: { completed?: boolean; revisionMarked?: boolean; note?: string }
  ): Promise<any> {
    const response = await apiClient.put(
      `/api/student/roadmap/question-items/${sectionQuestionId}/progress`,
      progress
    );
    return response.data.data;
  }
};
