import React from 'react';
import { PrivateConversation } from '../types/chat';
import { OnlineBadge } from './OnlineBadge';
import { MessageSquarePlus } from 'lucide-react';

interface ConversationListProps {
  conversations: PrivateConversation[];
  selectedConversationId: string | null;
  onSelectConversation: (id: string) => void;
  onOpenSearch: () => void;
}

export const ConversationList: React.FC<ConversationListProps> = ({
  conversations,
  selectedConversationId,
  onSelectConversation,
  onOpenSearch,
}) => {
  const getInitials = (firstName: string, lastName: string) => {
    return `${firstName?.charAt(0) || ''}${lastName?.charAt(0) || ''}`.toUpperCase() || 'U';
  };

  return (
    <div className="space-y-4 px-3 py-2">
      {/* Header with New Chat Action */}
      <div className="flex items-center justify-between px-3">
        <h4 className="text-xs font-semibold uppercase tracking-wider text-slate-400 dark:text-slate-500">
          Direct Messages
        </h4>
        <button
          onClick={onOpenSearch}
          className="p-1 rounded-lg text-slate-400 hover:text-brand-600 dark:hover:text-brand-400 transition-colors"
          title="New direct message"
        >
          <MessageSquarePlus className="h-4 w-4" />
        </button>
      </div>

      {conversations.length === 0 ? (
        <div className="px-3 py-6 text-center text-xs text-slate-400 dark:text-slate-500 space-y-2">
          <p>No direct messages yet.</p>
          <button
            onClick={onOpenSearch}
            className="text-brand-600 dark:text-brand-400 hover:underline font-semibold"
          >
            Find students to chat
          </button>
        </div>
      ) : (
        <div className="space-y-1">
          {conversations.map((conv) => {
            const isSelected = selectedConversationId === conv.id;
            return (
              <button
                key={conv.id}
                onClick={() => onSelectConversation(conv.id)}
                className={`w-full flex items-center gap-3 px-3 py-2.5 rounded-xl text-left transition-all ${
                  isSelected
                    ? 'bg-brand-50 dark:bg-brand-900/25 text-brand-700 dark:text-brand-300 font-semibold'
                    : 'text-slate-600 dark:text-slate-400 hover:bg-slate-100 dark:hover:bg-zinc-800/50 hover:text-slate-900 dark:hover:text-slate-200 font-medium'
                }`}
              >
                <div className="relative">
                  <div className="h-8 w-8 rounded-xl bg-brand-100 dark:bg-brand-900/40 text-brand-600 dark:text-brand-300 flex items-center justify-center text-xs font-bold shrink-0">
                    {getInitials(conv.otherUserFirstName, conv.otherUserLastName)}
                  </div>
                  <div className="absolute -bottom-0.5 -right-0.5">
                    <OnlineBadge online={true} size="sm" />
                  </div>
                </div>

                <div className="flex-1 min-w-0">
                  <div className="text-sm truncate">
                    {conv.otherUserFirstName} {conv.otherUserLastName}
                  </div>
                  <div className="text-[11px] text-slate-400 dark:text-slate-500 truncate">
                    {conv.otherUserEmail}
                  </div>
                </div>
              </button>
            );
          })}
        </div>
      )}
    </div>
  );
};
