import { apiClient } from '../config/api';
import { StudyResource, ResourceFilters } from '../types/resources';

export const resourceService = {
  async getResources(filters: ResourceFilters): Promise<{
    content: StudyResource[];
    totalElements: number;
    totalPages: number;
    size: number;
    number: number;
  }> {
    const response = await apiClient.get('/api/student/resources', {
      params: {
        query: filters.query || undefined,
        folderId: filters.folderId || undefined,
        type: filters.type === 'ALL' ? undefined : (filters.type || undefined),
        page: filters.page,
        size: filters.size,
      }
    });
    return response.data.data;
  },

  async getResourceById(id: string): Promise<StudyResource> {
    const response = await apiClient.get(`/api/student/resources/${id}`);
    return response.data.data;
  },
};
