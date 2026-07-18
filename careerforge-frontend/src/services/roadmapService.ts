import { apiClient } from '../config/api';
import { PersonalizedRoadmapResponse } from '../types/roadmap';

export const roadmapService = {
  async getPersonalizedRoadmap(): Promise<PersonalizedRoadmapResponse> {
    const response = await apiClient.get('/api/student/roadmap');
    const data = response.data.data;
    
    return {
      id: data.roadmap.id,
      targetRole: data.roadmap.targetRoles ? data.roadmap.targetRoles.join(', ') : '',
      preferredLanguage: '', // Language is now independent of roadmap templates
      semester: data.roadmap.semester,
      title: data.roadmap.title,
      description: data.roadmap.description,
      phases: (data.phases || []).map((p: any) => ({
        id: p.id,
        phaseName: p.title,
        description: p.description,
        durationMonths: (p.endMonth - p.startMonth + 1) || 1,
        orderIndex: p.priority,
      })),
      communicationTrackEnabled: false,
    };
  },
};
