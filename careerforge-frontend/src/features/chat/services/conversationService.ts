import { apiClient } from '../../../config/api';
import {
  ApiResponse,
  CreateConversationRequest,
  PrivateConversation,
  UserSearchResponse,
} from '../types/chat';

export const conversationService = {
  // Student: Get all private conversations
  getConversations: async (): Promise<PrivateConversation[]> => {
    const response = await apiClient.get<ApiResponse<PrivateConversation[]>>('/api/student/chat/conversations');
    return response.data.data;
  },

  // Student: Start / get private conversation
  createConversation: async (data: CreateConversationRequest): Promise<PrivateConversation> => {
    const response = await apiClient.post<ApiResponse<PrivateConversation>>(
      '/api/student/chat/conversations',
      data
    );
    return response.data.data;
  },

  // Student: Search users to initiate chat
  searchUsers: async (query: string): Promise<UserSearchResponse[]> => {
    const response = await apiClient.get<ApiResponse<UserSearchResponse[]>>(
      '/api/student/chat/users/search',
      { params: { query } }
    );
    return response.data.data;
  },
};
