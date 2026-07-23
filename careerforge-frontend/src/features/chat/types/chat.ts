export type RoomType = 'YEAR_CHAT' | 'GENERAL_CHAT' | 'SENIOR_CHAT' | 'PRIVATE_CHAT';

export type MessageType = 'TEXT' | 'IMAGE' | 'FILE' | 'SYSTEM';

export interface ChatRoom {
  id: string;
  name: string;
  description: string | null;
  roomType: RoomType;
  yearGroup: number | null;
  active: boolean;
  memberCount: number;
  createdAt: string;
  updatedAt: string;
}

export interface ChatMessage {
  id: string;
  chatRoomId: string | null;
  conversationId: string | null;
  senderId: string;
  senderFirstName: string;
  senderLastName: string;
  senderEmail: string;
  message: string;
  messageType: MessageType;
  edited: boolean;
  editedAt: string | null;
  deleted: boolean;
  createdAt: string;
}

export interface PrivateConversation {
  id: string;
  otherUserId: string;
  otherUserFirstName: string;
  otherUserLastName: string;
  otherUserEmail: string;
  createdAt: string;
}

export interface RoomMember {
  id: string;
  userId: string;
  firstName: string;
  lastName: string;
  email: string;
  joinedAt: string;
}

export interface RoomStatistics {
  roomId: string;
  roomName: string;
  roomType: RoomType;
  totalMembers: number;
  totalMessages: number;
  activeParticipants: number;
}

export interface UserSearchResponse {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
}

// Request DTOs
export interface CreateRoomRequest {
  name: string;
  description?: string;
  roomType: RoomType;
  yearGroup?: number;
}

export interface UpdateRoomRequest {
  name: string;
  description?: string;
}

export interface SendMessageRequest {
  chatRoomId?: string;
  conversationId?: string;
  message: string;
  messageType?: MessageType;
}

export interface EditMessageRequest {
  message: string;
}

export interface CreateConversationRequest {
  targetUserId: string;
}

export interface MuteUserRequest {
  reason?: string;
  expiresAt?: string;
}

// API Generic Response wrapper
export interface ApiResponse<T> {
  success: boolean;
  message: string;
  data: T;
  timestamp: string;
}

// Paginated Response wrapper
export interface PageResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
  last: boolean;
  first: boolean;
  empty: boolean;
}
