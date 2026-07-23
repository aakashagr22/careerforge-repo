import React from 'react';
import { ChatRoom, PrivateConversation } from '../types/chat';
import { RoomList } from './RoomList';
import { ConversationList } from './ConversationList';
import { Hash, MessageSquare, Search } from 'lucide-react';
import { ChatTab } from '../store/useChatStore';

interface ChatSidebarProps {
  activeTab: ChatTab;
  onTabChange: (tab: ChatTab) => void;
  rooms: ChatRoom[];
  conversations: PrivateConversation[];
  selectedRoomId: string | null;
  selectedConversationId: string | null;
  onSelectRoom: (roomId: string) => void;
  onSelectConversation: (id: string) => void;
  onOpenSearch: () => void;
  searchQuery: string;
  onSearchChange: (q: string) => void;
}

export const ChatSidebar: React.FC<ChatSidebarProps> = ({
  activeTab,
  onTabChange,
  rooms,
  conversations,
  selectedRoomId,
  selectedConversationId,
  onSelectRoom,
  onSelectConversation,
  onOpenSearch,
  searchQuery,
  onSearchChange,
}) => {
  const filteredRooms = rooms.filter((r) =>
    r.name.toLowerCase().includes(searchQuery.toLowerCase())
  );

  const filteredConversations = conversations.filter((c) =>
    `${c.otherUserFirstName} ${c.otherUserLastName} ${c.otherUserEmail}`
      .toLowerCase()
      .includes(searchQuery.toLowerCase())
  );

  return (
    <div className="w-64 md:w-72 border-r border-slate-200/80 dark:border-dark-border bg-white dark:bg-dark-card flex flex-col h-full shrink-0">
      {/* Search Bar */}
      <div className="p-3 border-b border-slate-200/80 dark:border-dark-border">
        <div className="flex items-center gap-2 px-3 py-2 bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border rounded-xl">
          <Search className="h-4 w-4 text-slate-400 shrink-0" />
          <input
            type="text"
            value={searchQuery}
            onChange={(e) => onSearchChange(e.target.value)}
            placeholder="Search rooms or chats..."
            className="flex-1 bg-transparent text-xs outline-none text-slate-900 dark:text-white placeholder:text-slate-400"
          />
        </div>
      </div>

      {/* Tabs */}
      <div className="flex items-center p-1.5 border-b border-slate-200/80 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800/20 text-xs font-semibold">
        <button
          onClick={() => onTabChange('rooms')}
          className={`flex-1 flex items-center justify-center gap-1.5 py-2 rounded-lg transition-all ${
            activeTab === 'rooms'
              ? 'bg-white dark:bg-dark-card text-brand-600 dark:text-brand-400 shadow-sm'
              : 'text-slate-500 dark:text-slate-400 hover:text-slate-900 dark:hover:text-slate-200'
          }`}
        >
          <Hash className="h-3.5 w-3.5" /> Rooms
        </button>
        <button
          onClick={() => onTabChange('direct')}
          className={`flex-1 flex items-center justify-center gap-1.5 py-2 rounded-lg transition-all ${
            activeTab === 'direct'
              ? 'bg-white dark:bg-dark-card text-brand-600 dark:text-brand-400 shadow-sm'
              : 'text-slate-500 dark:text-slate-400 hover:text-slate-900 dark:hover:text-slate-200'
          }`}
        >
          <MessageSquare className="h-3.5 w-3.5" /> Direct Messages
        </button>
      </div>

      {/* Lists */}
      <div className="flex-1 overflow-y-auto">
        {activeTab === 'rooms' ? (
          <RoomList
            rooms={filteredRooms}
            selectedRoomId={selectedRoomId}
            onSelectRoom={onSelectRoom}
          />
        ) : (
          <ConversationList
            conversations={filteredConversations}
            selectedConversationId={selectedConversationId}
            onSelectConversation={onSelectConversation}
            onOpenSearch={onOpenSearch}
          />
        )}
      </div>
    </div>
  );
};
