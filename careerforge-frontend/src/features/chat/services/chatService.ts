import { apiClient } from '../../../config/api';
import {
  ApiResponse,
  ChatMessage,
  EditMessageRequest,
  PageResponse,
  SendMessageRequest,
} from '../types/chat';

export const chatService = {
  // Student: Get room messages (paginated)
  getRoomMessages: async (roomId: string, page = 0, size = 50): Promise<PageResponse<ChatMessage>> => {
    const response = await apiClient.get<ApiResponse<PageResponse<ChatMessage>>>(
      `/api/student/chat/rooms/${roomId}/messages`,
      { params: { page, size } }
    );
    return response.data.data;
  },

  // Student: Get conversation messages (paginated)
  getConversationMessages: async (conversationId: string, page = 0, size = 50): Promise<PageResponse<ChatMessage>> => {
    const response = await apiClient.get<ApiResponse<PageResponse<ChatMessage>>>(
      `/api/student/chat/conversations/${conversationId}/messages`,
      { params: { page, size } }
    );
    return response.data.data;
  },

  // Student: Send message (REST fallback)
  sendMessage: async (data: SendMessageRequest): Promise<ChatMessage> => {
    const response = await apiClient.post<ApiResponse<ChatMessage>>('/api/student/chat/messages', data);
    return response.data.data;
  },

  // Student: Edit own message
  editMessage: async (messageId: string, data: EditMessageRequest): Promise<ChatMessage> => {
    const response = await apiClient.put<ApiResponse<ChatMessage>>(
      `/api/student/chat/messages/${messageId}`,
      data
    );
    return response.data.data;
  },

  // Student: Soft-delete own message
  deleteMessage: async (messageId: string): Promise<void> => {
    await apiClient.delete<ApiResponse<void>>(`/api/student/chat/messages/${messageId}`);
  },

  // Admin: Hard-delete any message
  adminDeleteMessage: async (messageId: string): Promise<void> => {
    await apiClient.delete<ApiResponse<void>>(`/api/admin/chat/messages/${messageId}`);
  },
};
