import React from 'react';
import { ChatRoom, PrivateConversation } from '../types/chat';
import { Hash, Info, Menu, GraduationCap, ShieldCheck } from 'lucide-react';
import { OnlineBadge } from './OnlineBadge';

interface ChatHeaderProps {
  room?: ChatRoom | null;
  conversation?: PrivateConversation | null;
  onToggleInfoPanel: () => void;
  onOpenMobileDrawer: () => void;
  connected?: boolean;
}

export const ChatHeader: React.FC<ChatHeaderProps> = ({
  room,
  conversation,
  onToggleInfoPanel,
  onOpenMobileDrawer,
  connected = true,
}) => {
  const getHeaderIcon = () => {
    if (conversation) {
      return (
        <div className="relative">
          <div className="h-9 w-9 rounded-xl bg-brand-600 text-white font-bold text-sm flex items-center justify-center">
            {conversation.otherUserFirstName.charAt(0)}
          </div>
          <div className="absolute -bottom-0.5 -right-0.5">
            <OnlineBadge online={true} size="sm" />
          </div>
        </div>
      );
    }

    if (room) {
      switch (room.roomType) {
        case 'YEAR_CHAT':
          return <GraduationCap className="h-5 w-5 text-amber-500 shrink-0" />;
        case 'SENIOR_CHAT':
          return <ShieldCheck className="h-5 w-5 text-indigo-500 shrink-0" />;
        case 'GENERAL_CHAT':
        default:
          return <Hash className="h-5 w-5 text-brand-600 shrink-0" />;
      }
    }

    return null;
  };

  const title = conversation
    ? `${conversation.otherUserFirstName} ${conversation.otherUserLastName}`
    : room
    ? room.name
    : 'Select a chat';

  const subtitle = conversation
    ? conversation.otherUserEmail
    : room
    ? room.description || `${room.memberCount || 0} members`
    : '';

  return (
    <header className="h-16 px-4 md:px-6 border-b border-slate-200/80 dark:border-dark-border bg-white dark:bg-dark-card flex items-center justify-between shrink-0">
      <div className="flex items-center gap-3 min-w-0">
        <button
          onClick={onOpenMobileDrawer}
          className="md:hidden p-2 text-slate-500 hover:text-slate-900 dark:hover:text-slate-200"
        >
          <Menu className="h-5 w-5" />
        </button>

        {getHeaderIcon()}

        <div className="min-w-0">
          <div className="flex items-center gap-2">
            <h2 className="font-heading font-bold text-base md:text-lg text-slate-900 dark:text-white truncate">
              {title}
            </h2>
            {connected && (
              <span className="h-2 w-2 rounded-full bg-emerald-500" title="Connected to chat broker" />
            )}
          </div>
          {subtitle && (
            <p className="text-xs text-slate-500 dark:text-slate-400 truncate">{subtitle}</p>
          )}
        </div>
      </div>

      <div className="flex items-center gap-2">
        <button
          onClick={onToggleInfoPanel}
          className="p-2 rounded-xl border border-slate-200/80 dark:border-dark-border text-slate-500 dark:text-slate-400 hover:bg-slate-100 dark:hover:bg-zinc-800/50 transition-colors"
          title="Toggle Details Panel"
        >
          <Info className="h-4 w-4" />
        </button>
      </div>
    </header>
  );
};
