import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import { roomService } from '../services/roomService';
import { chatService } from '../services/chatService';
import { ChatRoom, ChatMessage, RoomType } from '../types/chat';
import { CreateRoomModal } from './CreateRoomModal';
import { Plus, Trash2, ShieldAlert, Users, Hash, Eye, MessageSquare, X } from 'lucide-react';
import { motion, AnimatePresence } from 'framer-motion';
import toast from 'react-hot-toast';

export const AdminChatConsole: React.FC = () => {
  const queryClient = useQueryClient();
  const navigate = useNavigate();
  const [isCreateModalOpen, setIsCreateModalOpen] = useState(false);
  const [inspectRoom, setInspectRoom] = useState<ChatRoom | null>(null);

  // Fetch all rooms
  const { data: rooms = [], isLoading } = useQuery({
    queryKey: ['adminRooms'],
    queryFn: roomService.getAccessibleRooms,
  });

  // Fetch inspect room messages
  const { data: inspectMessagesPage, isLoading: loadingInspect } = useQuery({
    queryKey: ['adminRoomMessages', inspectRoom?.id],
    queryFn: () => chatService.getRoomMessages(inspectRoom!.id),
    enabled: !!inspectRoom,
  });

  // Create room mutation
  const createRoomMutation = useMutation({
    mutationFn: (data: { name: string; description: string; roomType: RoomType }) =>
      roomService.createRoom(data),
    onSuccess: () => {
      toast.success('Chat room created successfully');
      queryClient.invalidateQueries({ queryKey: ['adminRooms'] });
    },
    onError: (err: any) => {
      toast.error(err.response?.data?.message || 'Failed to create room');
    },
  });

  // Delete room mutation
  const deleteRoomMutation = useMutation({
    mutationFn: roomService.deleteRoom,
    onSuccess: () => {
      toast.success('Chat room deactivated successfully');
      queryClient.invalidateQueries({ queryKey: ['adminRooms'] });
    },
    onError: (err: any) => {
      toast.error(err.response?.data?.message || 'Failed to delete room');
    },
  });

  // Admin delete message mutation
  const adminDeleteMessageMutation = useMutation({
    mutationFn: chatService.adminDeleteMessage,
    onSuccess: () => {
      toast.success('Message deleted by Admin');
      queryClient.invalidateQueries({ queryKey: ['adminRoomMessages', inspectRoom?.id] });
    },
    onError: (err: any) => {
      toast.error(err.response?.data?.message || 'Failed to delete message');
    },
  });

  const handleCreateRoom = (name: string, description: string, roomType: RoomType, yearGroup?: number) => {
    createRoomMutation.mutate({ name, description, roomType, yearGroup });
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex flex-col md:flex-row md:items-center justify-between gap-4 bg-white dark:bg-dark-card p-6 rounded-2xl border border-slate-200/80 dark:border-dark-border shadow-sm">
        <div>
          <h2 className="font-heading font-bold text-2xl text-slate-900 dark:text-white flex items-center gap-2">
            <ShieldAlert className="h-6 w-6 text-rose-600" /> Chat Room Administration
          </h2>
          <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
            Manage public discussion rooms, inspect year chat message feeds, and perform administrative moderation.
          </p>
        </div>

        <button
          onClick={() => setIsCreateModalOpen(true)}
          className="px-4 py-2.5 rounded-xl bg-rose-600 hover:bg-rose-700 text-white font-medium text-sm transition-all shadow-md shadow-rose-600/20 flex items-center gap-2 shrink-0"
        >
          <Plus className="h-4 w-4" /> Create Chat Room
        </button>
      </div>

      {/* Rooms Table */}
      <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl overflow-hidden shadow-sm">
        <div className="p-4 border-b border-slate-200/80 dark:border-dark-border flex items-center justify-between">
          <h3 className="font-heading font-bold text-base text-slate-900 dark:text-white flex items-center gap-2">
            <Hash className="h-4 w-4 text-rose-600" /> Active Public & Year Rooms ({rooms.length})
          </h3>
        </div>

        {isLoading ? (
          <div className="p-8 text-center text-sm text-slate-400">Loading chat rooms...</div>
        ) : rooms.length === 0 ? (
          <div className="p-8 text-center text-sm text-slate-400">No rooms found.</div>
        ) : (
          <div className="overflow-x-auto">
            <table className="w-full text-left text-sm">
              <thead className="bg-slate-50 dark:bg-zinc-800/40 text-xs font-bold uppercase tracking-wider text-slate-400 border-b border-slate-200/80 dark:border-dark-border">
                <tr>
                  <th className="px-6 py-3.5">Room Name</th>
                  <th className="px-6 py-3.5">Category</th>
                  <th className="px-6 py-3.5">Members</th>
                  <th className="px-6 py-3.5">Created Date</th>
                  <th className="px-6 py-3.5 text-right">Actions</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-slate-200/80 dark:divide-dark-border">
                {rooms.map((room) => (
                  <tr key={room.id} className="hover:bg-slate-50/50 dark:hover:bg-zinc-800/20 transition-colors">
                    <td className="px-6 py-4">
                      <div className="font-semibold text-slate-900 dark:text-white">{room.name}</div>
                      <div className="text-xs text-slate-400 max-w-xs truncate">{room.description}</div>
                    </td>
                    <td className="px-6 py-4">
                      <div className="flex items-center gap-2">
                        <span className="px-2.5 py-1 rounded-full text-[11px] font-bold uppercase bg-brand-50 dark:bg-brand-900/20 text-brand-600 dark:text-brand-400">
                          {room.roomType.replace('_', ' ')}
                        </span>
                        {room.roomType === 'YEAR_CHAT' && room.yearGroup && (
                          <span className="px-2 py-0.5 rounded-full text-[10px] font-bold bg-amber-100 dark:bg-amber-900/30 text-amber-700 dark:text-amber-400">
                            Year {room.yearGroup}
                          </span>
                        )}
                      </div>
                    </td>
                    <td className="px-6 py-4 font-medium text-slate-700 dark:text-slate-300">
                      <span className="flex items-center gap-1.5">
                        <Users className="h-4 w-4 text-slate-400" />
                        {room.memberCount || 0}
                      </span>
                    </td>
                    <td className="px-6 py-4 text-slate-500 text-xs">
                      {new Date(room.createdAt).toLocaleDateString()}
                    </td>
                    <td className="px-6 py-4 text-right space-x-1">
                      <button
                        onClick={() => setInspectRoom(room)}
                        className="p-2 rounded-xl text-slate-400 hover:text-brand-600 hover:bg-brand-50 dark:hover:bg-brand-950/20 transition-colors"
                        title="Inspect room messages"
                      >
                        <Eye className="h-4 w-4" />
                      </button>
                      <button
                        onClick={() => navigate(`/student/chat/${room.id}`)}
                        className="p-2 rounded-xl text-slate-400 hover:text-indigo-600 hover:bg-indigo-50 dark:hover:bg-indigo-950/20 transition-colors"
                        title="Open room in live view"
                      >
                        <MessageSquare className="h-4 w-4" />
                      </button>
                      <button
                        onClick={() => {
                          if (confirm(`Are you sure you want to deactivate room "${room.name}"?`)) {
                            deleteRoomMutation.mutate(room.id);
                          }
                        }}
                        className="p-2 rounded-xl text-slate-400 hover:text-red-600 hover:bg-red-50 dark:hover:bg-red-950/20 transition-colors"
                        title="Deactivate room"
                      >
                        <Trash2 className="h-4 w-4" />
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>

      <CreateRoomModal
        isOpen={isCreateModalOpen}
        onClose={() => setIsCreateModalOpen(false)}
        onCreate={handleCreateRoom}
        loading={createRoomMutation.isPending}
      />

      {/* Admin Room Messages Inspection Modal */}
      <AnimatePresence>
        {inspectRoom && (
          <div className="fixed inset-0 z-50 flex items-center justify-center p-4">
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 0.5 }}
              exit={{ opacity: 0 }}
              onClick={() => setInspectRoom(null)}
              className="fixed inset-0 bg-black"
            />

            <motion.div
              initial={{ opacity: 0, scale: 0.95 }}
              animate={{ opacity: 1, scale: 1 }}
              exit={{ opacity: 0, scale: 0.95 }}
              className="relative w-full max-w-2xl bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl shadow-2xl overflow-hidden z-10 flex flex-col max-h-[80vh]"
            >
              {/* Header */}
              <div className="flex items-center justify-between p-4 border-b border-slate-200/80 dark:border-dark-border bg-slate-50 dark:bg-zinc-800/40">
                <div>
                  <h3 className="font-heading font-bold text-base text-slate-900 dark:text-white flex items-center gap-2">
                    <ShieldAlert className="h-4 w-4 text-rose-600" /> Moderating: {inspectRoom.name}
                  </h3>
                  <p className="text-xs text-slate-400">{inspectRoom.roomType.replace('_', ' ')}</p>
                </div>
                <button
                  onClick={() => setInspectRoom(null)}
                  className="text-slate-400 hover:text-slate-600 dark:hover:text-slate-200"
                >
                  <X className="h-5 w-5" />
                </button>
              </div>

              {/* Messages Body */}
              <div className="flex-1 overflow-y-auto p-4 space-y-3">
                {loadingInspect ? (
                  <div className="p-8 text-center text-sm text-slate-400">Loading room feed...</div>
                ) : (inspectMessagesPage?.content || []).length === 0 ? (
                  <div className="p-8 text-center text-sm text-slate-400">No messages in this room yet.</div>
                ) : (
                  inspectMessagesPage?.content.map((msg: ChatMessage) => (
                    <div
                      key={msg.id}
                      className="p-3 rounded-xl bg-slate-50 dark:bg-zinc-800/40 border border-slate-200/80 dark:border-dark-border flex items-start justify-between gap-3"
                    >
                      <div>
                        <div className="flex items-center gap-2 text-xs">
                          <span className="font-bold text-slate-800 dark:text-slate-200">
                            {msg.senderFirstName} {msg.senderLastName}
                          </span>
                          <span className="text-slate-400">({msg.senderEmail})</span>
                          <span className="text-[10px] text-slate-400">
                            {new Date(msg.createdAt).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}
                          </span>
                        </div>
                        <p className="text-sm text-slate-700 dark:text-slate-300 mt-1 leading-relaxed">
                          {msg.message}
                        </p>
                      </div>

                      <button
                        onClick={() => {
                          if (confirm('Delete this message permanently?')) {
                            adminDeleteMessageMutation.mutate(msg.id);
                          }
                        }}
                        className="p-1.5 rounded-lg text-slate-400 hover:text-rose-600 hover:bg-rose-50 dark:hover:bg-rose-950/20 transition-colors"
                        title="Hard delete message"
                      >
                        <Trash2 className="h-4 w-4" />
                      </button>
                    </div>
                  ))
                )}
              </div>
            </motion.div>
          </div>
        )}
      </AnimatePresence>
    </div>
  );
};
