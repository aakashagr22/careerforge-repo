import { apiClient } from '../config/api';
import { PersonalizedRoadmapResponse } from '../types/roadmap';

export const roadmapService = {
  async getPersonalizedRoadmap(): Promise<PersonalizedRoadmapResponse> {
    const response = await apiClient.get('/api/student/roadmap');
    return response.data.data;
  },
};
