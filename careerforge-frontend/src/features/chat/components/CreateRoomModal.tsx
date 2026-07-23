import React, { useState } from 'react';
import { X, Plus, Hash } from 'lucide-react';
import { RoomType } from '../types/chat';
import { motion, AnimatePresence } from 'framer-motion';

interface CreateRoomModalProps {
  isOpen: boolean;
  onClose: () => void;
  onCreate: (name: string, description: string, roomType: RoomType, yearGroup?: number) => void;
  loading?: boolean;
}

export const CreateRoomModal: React.FC<CreateRoomModalProps> = ({
  isOpen,
  onClose,
  onCreate,
  loading = false,
}) => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [roomType, setRoomType] = useState<RoomType>('GENERAL_CHAT');
  const [yearGroup, setYearGroup] = useState<number>(1);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!name.trim()) return;
    onCreate(
      name.trim(),
      description.trim(),
      roomType,
      roomType === 'YEAR_CHAT' ? yearGroup : undefined
    );
    setName('');
    setDescription('');
    setRoomType('GENERAL_CHAT');
    setYearGroup(1);
    onClose();
  };

  if (!isOpen) return null;

  return (
    <AnimatePresence>
      <div className="fixed inset-0 z-50 flex items-center justify-center p-4">
        <motion.div
          initial={{ opacity: 0 }}
          animate={{ opacity: 0.5 }}
          exit={{ opacity: 0 }}
          onClick={onClose}
          className="fixed inset-0 bg-black"
        />

        <motion.div
          initial={{ opacity: 0, scale: 0.95 }}
          animate={{ opacity: 1, scale: 1 }}
          exit={{ opacity: 0, scale: 0.95 }}
          className="relative w-full max-w-md bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl shadow-2xl p-6 z-10 space-y-4"
        >
          <div className="flex items-center justify-between border-b border-slate-200/80 dark:border-dark-border pb-3">
            <h3 className="font-heading font-bold text-lg text-slate-900 dark:text-white flex items-center gap-2">
              <Hash className="h-5 w-5 text-rose-600" /> Create New Chat Room
            </h3>
            <button onClick={onClose} className="text-slate-400 hover:text-slate-600">
              <X className="h-5 w-5" />
            </button>
          </div>

          <form onSubmit={handleSubmit} className="space-y-4">
            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-500 mb-1">
                Room Name
              </label>
              <input
                type="text"
                required
                value={name}
                onChange={(e) => setName(e.target.value)}
                placeholder="e.g. Competitive Programming Discussion"
                className="w-full px-3 py-2 rounded-xl bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border text-sm outline-none focus:ring-2 focus:ring-rose-500/20"
              />
            </div>

            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-500 mb-1">
                Description
              </label>
              <textarea
                rows={2}
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Brief summary of room topic..."
                className="w-full px-3 py-2 rounded-xl bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border text-sm outline-none resize-none focus:ring-2 focus:ring-rose-500/20"
              />
            </div>

            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-500 mb-1">
                Room Category Type
              </label>
              <select
                value={roomType}
                onChange={(e) => setRoomType(e.target.value as RoomType)}
                className="w-full px-3 py-2 rounded-xl bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border text-sm outline-none focus:ring-2 focus:ring-rose-500/20"
              >
                <option value="GENERAL_CHAT">General Chat</option>
                <option value="YEAR_CHAT">Year Chat</option>
                <option value="SENIOR_CHAT">Senior Room</option>
              </select>
            </div>

            {/* Year Group Selector — only visible when YEAR_CHAT is selected */}
            {roomType === 'YEAR_CHAT' && (
              <div>
                <label className="block text-xs font-bold uppercase tracking-wider text-slate-500 mb-1">
                  Year Group <span className="text-rose-500">*</span>
                </label>
                <select
                  value={yearGroup}
                  onChange={(e) => setYearGroup(Number(e.target.value))}
                  className="w-full px-3 py-2 rounded-xl bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border text-sm outline-none focus:ring-2 focus:ring-rose-500/20"
                >
                  <option value={1}>1st Year (Semester 1–2)</option>
                  <option value={2}>2nd Year (Semester 3–4)</option>
                  <option value={3}>3rd Year (Semester 5–6)</option>
                  <option value={4}>4th Year (Semester 7–8)</option>
                </select>
                <p className="mt-1 text-xs text-slate-400">
                  Only students in this year group will be able to access this room.
                </p>
              </div>
            )}

            <div className="flex items-center justify-end gap-3 pt-3 border-t border-slate-200/80 dark:border-dark-border">
              <button
                type="button"
                onClick={onClose}
                className="px-4 py-2 rounded-xl text-sm font-medium text-slate-500 hover:bg-slate-100 dark:hover:bg-zinc-800"
              >
                Cancel
              </button>
              <button
                type="submit"
                disabled={loading || !name.trim()}
                className="px-4 py-2 rounded-xl bg-rose-600 hover:bg-rose-700 text-white text-sm font-semibold disabled:opacity-40 transition-all flex items-center gap-1.5"
              >
                <Plus className="h-4 w-4" /> Create Room
              </button>
            </div>
          </form>
        </motion.div>
      </div>
    </AnimatePresence>
  );
};
