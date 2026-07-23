import React, { useEffect, useRef } from 'react';
import { ChatMessage } from '../types/chat';
import { MessageBubble } from './MessageBubble';
import { EmptyChat } from './EmptyChat';
import { ChatSkeleton } from './ChatSkeleton';
import { TypingIndicator } from './TypingIndicator';

interface MessageListProps {
  messages: ChatMessage[];
  currentUserId: string;
  isAdmin: boolean;
  isLoading?: boolean;
  onEditMessage?: (messageId: string, newText: string) => void;
  onDeleteMessage?: (messageId: string) => void;
  onAdminDeleteMessage?: (messageId: string) => void;
}

export const MessageList: React.FC<MessageListProps> = ({
  messages,
  currentUserId,
  isAdmin,
  isLoading = false,
  onEditMessage,
  onDeleteMessage,
  onAdminDeleteMessage,
}) => {
  const bottomRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [messages]);

  if (isLoading) {
    return <ChatSkeleton />;
  }

  if (messages.length === 0) {
    return <EmptyChat type="no-messages" />;
  }

  return (
    <div className="flex-1 overflow-y-auto p-4 md:p-6 space-y-1">
      {/* Reverse rendering if backend returns desc, ensure chronological display */}
      {messages.map((message) => (
        <MessageBubble
          key={message.id}
          message={message}
          isOwn={message.senderId === currentUserId}
          isAdmin={isAdmin}
          onEdit={onEditMessage}
          onDelete={onDeleteMessage}
          onAdminDelete={onAdminDeleteMessage}
        />
      ))}
      <TypingIndicator />
      <div ref={bottomRef} />
    </div>
  );
};
