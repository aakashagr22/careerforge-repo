import React, { useEffect, useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useParams, useNavigate } from 'react-router-dom';
import { useAuthStore } from '../../../store/authStore';
import { useChatStore } from '../store/useChatStore';
import { roomService } from '../services/roomService';
import { chatService } from '../services/chatService';
import { conversationService } from '../services/conversationService';
import { useChatSocket } from '../hooks/useChatSocket';
import { ChatMessage } from '../types/chat';

import { ChatLayout } from '../components/ChatLayout';
import { ChatSidebar } from '../components/ChatSidebar';
import { ChatHeader } from '../components/ChatHeader';
import { MessageList } from '../components/MessageList';
import { MessageInput } from '../components/MessageInput';
import { RoomInfoPanel } from '../components/RoomInfoPanel';
import { StudentSearchModal } from '../components/StudentSearchModal';
import { EmptyChat } from '../components/EmptyChat';
import { ChatSkeleton } from '../components/ChatSkeleton';
import toast from 'react-hot-toast';

export const StudentChatPage: React.FC = () => {
  const { roomId: urlRoomId, conversationId: urlConvId } = useParams();
  const navigate = useNavigate();
  const queryClient = useQueryClient();
  const { user } = useAuthStore();

  const {
    activeTab,
    selectedRoomId,
    selectedConversationId,
    setActiveTab,
    selectRoom,
    selectConversation,
    toggleInfoPanel,
    setMobileDrawerOpen,
    searchModalOpen,
    setSearchModalOpen,
    searchQuery,
    setSearchQuery,
  } = useChatStore();

  const [realtimeMessages, setRealtimeMessages] = useState<ChatMessage[]>([]);

  // Sync URL params to store
  useEffect(() => {
    if (urlRoomId) {
      selectRoom(urlRoomId);
    } else if (urlConvId) {
      selectConversation(urlConvId);
    }
  }, [urlRoomId, urlConvId]);

  // Fetch accessible rooms
  const { data: rooms = [] } = useQuery({
    queryKey: ['chatRooms'],
    queryFn: roomService.getAccessibleRooms,
  });

  // Fetch conversations
  const { data: conversations = [] } = useQuery({
    queryKey: ['privateConversations'],
    queryFn: conversationService.getConversations,
  });

  // Auto-select first room if nothing selected
  useEffect(() => {
    if (!selectedRoomId && !selectedConversationId && rooms.length > 0 && !urlRoomId && !urlConvId) {
      selectRoom(rooms[0].id);
    }
  }, [rooms, selectedRoomId, selectedConversationId, urlRoomId, urlConvId]);

  // Fetch room messages
  const { data: roomMessagesPage, isLoading: loadingRoomMsgs } = useQuery({
    queryKey: ['roomMessages', selectedRoomId],
    queryFn: () => chatService.getRoomMessages(selectedRoomId!),
    enabled: !!selectedRoomId,
  });

  // Fetch conversation messages
  const { data: convMessagesPage, isLoading: loadingConvMsgs } = useQuery({
    queryKey: ['convMessages', selectedConversationId],
    queryFn: () => chatService.getConversationMessages(selectedConversationId!),
    enabled: !!selectedConversationId,
  });

  // STOMP WebSocket Hook
  const { connected, sendMessage: sendStompMessage } = useChatSocket({
    roomId: selectedRoomId,
    conversationId: selectedConversationId,
    onMessageReceived: (newMsg) => {
      setRealtimeMessages((prev) => [...prev, newMsg]);
    },
  });

  // Reset realtime messages on room/conversation change
  useEffect(() => {
    setRealtimeMessages([]);
  }, [selectedRoomId, selectedConversationId]);

  // Merge static history & real-time streamed messages
  const baseHistory = selectedRoomId
    ? (roomMessagesPage?.content || []).slice().reverse()
    : selectedConversationId
    ? (convMessagesPage?.content || []).slice().reverse()
    : [];

  const allMessages = [...baseHistory, ...realtimeMessages];

  // Send message handler (prefers STOMP WebSocket, falls back to REST API)
  const handleSendMessage = async (text: string) => {
    if (!text.trim()) return;

    if (connected) {
      try {
        sendStompMessage({
          chatRoomId: selectedRoomId || undefined,
          conversationId: selectedConversationId || undefined,
          message: text,
        });
        return;
      } catch (err) {
        console.warn('STOMP send failed, using REST fallback:', err);
      }
    }

    // REST fallback
    try {
      const sentMsg = await chatService.sendMessage({
        chatRoomId: selectedRoomId || undefined,
        conversationId: selectedConversationId || undefined,
        message: text,
      });
      setRealtimeMessages((prev) => [...prev, sentMsg]);
    } catch (err: any) {
      toast.error(err.response?.data?.message || 'Failed to send message');
    }
  };

  // Edit message mutation
  const editMutation = useMutation({
    mutationFn: ({ id, text }: { id: string; text: string }) =>
      chatService.editMessage(id, { message: text }),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['roomMessages', selectedRoomId] });
      queryClient.invalidateQueries({ queryKey: ['convMessages', selectedConversationId] });
    },
  });

  // Delete message mutation
  const deleteMutation = useMutation({
    mutationFn: chatService.deleteMessage,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['roomMessages', selectedRoomId] });
      queryClient.invalidateQueries({ queryKey: ['convMessages', selectedConversationId] });
    },
  });

  // Create conversation handler from student search
  const handleSelectUserForChat = async (targetUserId: string) => {
    try {
      const conv = await conversationService.createConversation({ targetUserId });
      queryClient.invalidateQueries({ queryKey: ['privateConversations'] });
      selectConversation(conv.id);
      navigate(`/student/chat/direct/${conv.id}`);
    } catch (err: any) {
      toast.error(err.response?.data?.message || 'Failed to start conversation');
    }
  };

  const currentRoom = rooms.find((r) => r.id === selectedRoomId);
  const currentConversation = conversations.find((c) => c.id === selectedConversationId);

  const sidebarContent = (
    <ChatSidebar
      activeTab={activeTab}
      onTabChange={setActiveTab}
      rooms={rooms}
      conversations={conversations}
      selectedRoomId={selectedRoomId}
      selectedConversationId={selectedConversationId}
      onSelectRoom={(id) => {
        selectRoom(id);
        navigate(`/student/chat/${id}`);
      }}
      onSelectConversation={(id) => {
        selectConversation(id);
        navigate(`/student/chat/direct/${id}`);
      }}
      onOpenSearch={() => setSearchModalOpen(true)}
      searchQuery={searchQuery}
      onSearchChange={setSearchQuery}
    />
  );

  return (
    <>
      <ChatLayout
        sidebar={sidebarContent}
        mobileDrawer={sidebarContent}
        header={
          <ChatHeader
            room={currentRoom}
            conversation={currentConversation}
            onToggleInfoPanel={toggleInfoPanel}
            onOpenMobileDrawer={() => setMobileDrawerOpen(true)}
            connected={connected}
          />
        }
        messages={
          !selectedRoomId && !selectedConversationId ? (
            <EmptyChat onStartSearch={() => setSearchModalOpen(true)} />
          ) : loadingRoomMsgs || loadingConvMsgs ? (
            <ChatSkeleton />
          ) : (
            <MessageList
              messages={allMessages}
              currentUserId={user?.id || ''}
              isAdmin={user?.role === 'ADMIN'}
              onEditMessage={(id, text) => editMutation.mutate({ id, text })}
              onDeleteMessage={(id) => deleteMutation.mutate(id)}
            />
          )
        }
        input={
          selectedRoomId || selectedConversationId ? (
            <MessageInput onSendMessage={handleSendMessage} />
          ) : null
        }
        infoPanel={
          <RoomInfoPanel
            room={currentRoom}
            conversation={currentConversation}
            onClose={toggleInfoPanel}
            isAdmin={user?.role === 'ADMIN'}
          />
        }
      />

      <StudentSearchModal
        isOpen={searchModalOpen}
        onClose={() => setSearchModalOpen(false)}
        onSelectUser={handleSelectUserForChat}
      />
    </>
  );
};
