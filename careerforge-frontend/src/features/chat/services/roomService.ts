import { apiClient } from '../../../config/api';
import {
  ApiResponse,
  ChatRoom,
  CreateRoomRequest,
  MuteUserRequest,
  RoomStatistics,
  UpdateRoomRequest,
} from '../types/chat';

export const roomService = {
  // Student: Get accessible chat rooms
  getAccessibleRooms: async (): Promise<ChatRoom[]> => {
    const response = await apiClient.get<ApiResponse<ChatRoom[]>>('/api/student/chat/rooms');
    return response.data.data;
  },

  // Admin: Create room
  createRoom: async (data: CreateRoomRequest): Promise<ChatRoom> => {
    const response = await apiClient.post<ApiResponse<ChatRoom>>('/api/admin/chat/rooms', data);
    return response.data.data;
  },

  // Admin: Update room
  updateRoom: async (roomId: string, data: UpdateRoomRequest): Promise<ChatRoom> => {
    const response = await apiClient.put<ApiResponse<ChatRoom>>(`/api/admin/chat/rooms/${roomId}`, data);
    return response.data.data;
  },

  // Admin: Soft delete room
  deleteRoom: async (roomId: string): Promise<void> => {
    await apiClient.delete<ApiResponse<void>>(`/api/admin/chat/rooms/${roomId}`);
  },

  // Admin: Mute user
  muteUser: async (roomId: string, userId: string, data: MuteUserRequest): Promise<void> => {
    await apiClient.post<ApiResponse<void>>(`/api/admin/chat/rooms/${roomId}/mute/${userId}`, data);
  },

  // Admin: Unmute user
  unmuteUser: async (roomId: string, userId: string): Promise<void> => {
    await apiClient.delete<ApiResponse<void>>(`/api/admin/chat/rooms/${roomId}/mute/${userId}`);
  },

  // Admin: Get room statistics
  getRoomStatistics: async (roomId: string): Promise<RoomStatistics> => {
    const response = await apiClient.get<ApiResponse<RoomStatistics>>(`/api/admin/chat/rooms/${roomId}/statistics`);
    return response.data.data;
  },
};
