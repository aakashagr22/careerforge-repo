import { apiClient } from '../config/api';
import { FolderDirectory, ResourceFolder } from '../types/resources';

export const resourceFolderService = {
  async getDirectory(isAdmin: boolean, folderId: string | null, page: number, size: number, type?: string): Promise<FolderDirectory> {
    const rolePath = isAdmin ? 'admin' : 'student';
    const folderPath = folderId ? folderId : 'root';
    const response = await apiClient.get(`/api/${rolePath}/resource-folders/${folderPath}`, {
      params: { page, size, type: type === 'ALL' ? undefined : type }
    });
    return response.data.data;
  },

  async createFolder(data: { name: string; parentId?: string }): Promise<ResourceFolder> {
    const response = await apiClient.post('/api/admin/resource-folders', data);
    return response.data.data;
  },

  async updateFolder(id: string, data: { name: string; parentId?: string }): Promise<ResourceFolder> {
    const response = await apiClient.put(`/api/admin/resource-folders/${id}`, data);
    return response.data.data;
  },

  async deleteFolder(id: string): Promise<any> {
    const response = await apiClient.delete(`/api/admin/resource-folders/${id}`);
    return response.data;
  }
};
