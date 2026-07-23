import React from 'react';
import { ChatRoom } from '../types/chat';
import { Hash, Users, GraduationCap, ShieldCheck } from 'lucide-react';
import { UnreadBadge } from './UnreadBadge';

interface RoomCardProps {
  room: ChatRoom;
  isSelected: boolean;
  unreadCount?: number;
  onClick: () => void;
}

export const RoomCard: React.FC<RoomCardProps> = ({
  room,
  isSelected,
  unreadCount = 0,
  onClick,
}) => {
  const getRoomIcon = () => {
    switch (room.roomType) {
      case 'YEAR_CHAT':
        return <GraduationCap className="h-4 w-4 text-amber-500 shrink-0" />;
      case 'SENIOR_CHAT':
        return <ShieldCheck className="h-4 w-4 text-indigo-500 shrink-0" />;
      case 'GENERAL_CHAT':
      default:
        return <Hash className="h-4 w-4 text-brand-500 shrink-0" />;
    }
  };

  return (
    <button
      onClick={onClick}
      className={`w-full flex items-center justify-between px-3 py-2.5 rounded-xl text-left transition-all group ${
        isSelected
          ? 'bg-brand-50 dark:bg-brand-900/25 text-brand-700 dark:text-brand-300 font-semibold'
          : 'text-slate-600 dark:text-slate-400 hover:bg-slate-100 dark:hover:bg-zinc-800/50 hover:text-slate-900 dark:hover:text-slate-200 font-medium'
      }`}
    >
      <div className="flex items-center gap-2.5 min-w-0">
        {getRoomIcon()}
        <span className="text-sm truncate">{room.name}</span>
      </div>

      <div className="flex items-center gap-2 shrink-0">
        {room.memberCount > 0 && (
          <span className="flex items-center gap-1 text-[11px] opacity-60">
            <Users className="h-3 w-3" />
            {room.memberCount}
          </span>
        )}
        <UnreadBadge count={unreadCount} />
      </div>
    </button>
  );
};
