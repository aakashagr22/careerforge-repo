import { apiClient } from '../config/api';
import { Blog, CreateBlogRequest, UpdateBlogRequest, RejectBlogRequest } from '../types/blog';

// We will return the data property directly from the backend's ResponseEntity wrapper
export const blogService = {
  // Student Endpoints
  async createStudentBlog(data: CreateBlogRequest): Promise<Blog> {
    const response = await apiClient.post('/api/student/blogs', data);
    return response.data.data;
  },

  async updateStudentBlog(id: string, data: UpdateBlogRequest): Promise<Blog> {
    const response = await apiClient.put(`/api/student/blogs/${id}`, data);
    return response.data.data;
  },

  async getMyBlogs(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/student/blogs/my', {
      params: { page, size }
    });
    return response.data.data;
  },

  async getPublishedBlogs(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/student/blogs', {
      params: { page, size }
    });
    return response.data.data;
  },

  async getBlogById(id: string): Promise<Blog> {
    const response = await apiClient.get(`/api/student/blogs/${id}`);
    return response.data.data;
  },

  // Admin Endpoints
  async createAdminBlog(data: CreateBlogRequest): Promise<Blog> {
    const response = await apiClient.post('/api/admin/blogs', data);
    return response.data.data;
  },

  async getPendingBlogs(page: number, size: number): Promise<any> {
    const response = await apiClient.get('/api/admin/blogs/pending', {
      params: { page, size }
    });
    return response.data.data;
  },

  async approveBlog(id: string): Promise<Blog> {
    const response = await apiClient.post(`/api/admin/blogs/${id}/approve`);
    return response.data.data;
  },

  async rejectBlog(id: string, data: RejectBlogRequest): Promise<Blog> {
    const response = await apiClient.post(`/api/admin/blogs/${id}/reject`, data);
    return response.data.data;
  }
};
