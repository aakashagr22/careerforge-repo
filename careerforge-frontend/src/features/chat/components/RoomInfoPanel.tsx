import React from 'react';
import { ChatRoom, PrivateConversation } from '../types/chat';
import { X, Users, Calendar, Info, Shield } from 'lucide-react';
import { useQuery } from '@tanstack/react-query';
import { roomService } from '../services/roomService';

interface RoomInfoPanelProps {
  room?: ChatRoom | null;
  conversation?: PrivateConversation | null;
  onClose: () => void;
  isAdmin?: boolean;
}

export const RoomInfoPanel: React.FC<RoomInfoPanelProps> = ({
  room,
  conversation,
  onClose,
  isAdmin = false,
}) => {
  // Query room statistics if admin or room selected
  const { data: stats } = useQuery({
    queryKey: ['roomStats', room?.id],
    queryFn: () => roomService.getRoomStatistics(room!.id),
    enabled: !!room && isAdmin,
  });

  if (!room && !conversation) return null;

  return (
    <div className="w-72 border-l border-slate-200/80 dark:border-dark-border bg-white dark:bg-dark-card flex flex-col h-full shrink-0">
      {/* Header */}
      <div className="h-16 px-6 border-b border-slate-200/80 dark:border-dark-border flex items-center justify-between">
        <h3 className="font-heading font-semibold text-slate-900 dark:text-white flex items-center gap-2">
          <Info className="h-4 w-4 text-brand-600" /> Details
        </h3>
        <button
          onClick={onClose}
          className="text-slate-400 hover:text-slate-600 dark:hover:text-slate-200 transition-colors"
        >
          <X className="h-4 w-4" />
        </button>
      </div>

      {/* Content */}
      <div className="flex-1 p-6 space-y-6 overflow-y-auto">
        {room && (
          <>
            <div>
              <h4 className="font-heading font-bold text-lg text-slate-900 dark:text-white">
                {room.name}
              </h4>
              <p className="text-xs text-slate-500 dark:text-slate-400 mt-1 leading-relaxed">
                {room.description || 'No description provided for this room.'}
              </p>
            </div>

            <div className="space-y-3 pt-3 border-t border-slate-200/80 dark:border-dark-border">
              <div className="flex items-center justify-between text-xs text-slate-600 dark:text-slate-400">
                <span className="flex items-center gap-2">
                  <Shield className="h-4 w-4 text-slate-400" /> Room Type
                </span>
                <span className="font-semibold px-2 py-0.5 rounded bg-brand-50 dark:bg-brand-900/30 text-brand-600 dark:text-brand-400 uppercase text-[10px]">
                  {room.roomType.replace('_', ' ')}
                </span>
              </div>

              <div className="flex items-center justify-between text-xs text-slate-600 dark:text-slate-400">
                <span className="flex items-center gap-2">
                  <Users className="h-4 w-4 text-slate-400" /> Members
                </span>
                <span className="font-semibold text-slate-800 dark:text-slate-200">
                  {room.memberCount || 0}
                </span>
              </div>

              <div className="flex items-center justify-between text-xs text-slate-600 dark:text-slate-400">
                <span className="flex items-center gap-2">
                  <Calendar className="h-4 w-4 text-slate-400" /> Created
                </span>
                <span className="font-medium text-slate-800 dark:text-slate-200">
                  {new Date(room.createdAt).toLocaleDateString()}
                </span>
              </div>
            </div>

            {/* Admin Stats Section */}
            {isAdmin && stats && (
              <div className="pt-4 border-t border-slate-200/80 dark:border-dark-border space-y-3">
                <h5 className="text-xs font-bold uppercase tracking-wider text-rose-600 dark:text-rose-400">
                  Admin Room Statistics
                </h5>
                <div className="grid grid-cols-2 gap-2 text-center">
                  <div className="p-2.5 rounded-xl bg-slate-50 dark:bg-zinc-800/50 border">
                    <div className="text-lg font-bold text-slate-900 dark:text-white">
                      {stats.totalMessages}
                    </div>
                    <div className="text-[10px] text-slate-400">Total Messages</div>
                  </div>
                  <div className="p-2.5 rounded-xl bg-slate-50 dark:bg-zinc-800/50 border">
                    <div className="text-lg font-bold text-slate-900 dark:text-white">
                      {stats.activeParticipants}
                    </div>
                    <div className="text-[10px] text-slate-400">Active Senders</div>
                  </div>
                </div>
              </div>
            )}
          </>
        )}

        {conversation && (
          <div className="space-y-4">
            <div className="h-16 w-16 rounded-2xl bg-brand-600 text-white flex items-center justify-center text-xl font-bold mx-auto shadow-md">
              {conversation.otherUserFirstName.charAt(0)}
            </div>
            <div className="text-center">
              <h4 className="font-heading font-bold text-lg text-slate-900 dark:text-white">
                {conversation.otherUserFirstName} {conversation.otherUserLastName}
              </h4>
              <p className="text-xs text-slate-400 mt-0.5">{conversation.otherUserEmail}</p>
            </div>

            <div className="pt-4 border-t border-slate-200/80 dark:border-dark-border space-y-2 text-xs">
              <div className="flex items-center justify-between">
                <span className="text-slate-400">Chat Started</span>
                <span className="font-medium text-slate-700 dark:text-slate-300">
                  {new Date(conversation.createdAt).toLocaleDateString()}
                </span>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};
