import React, { useState } from 'react';
import { X, VolumeX } from 'lucide-react';
import { motion, AnimatePresence } from 'framer-motion';

interface MuteUserModalProps {
  isOpen: boolean;
  onClose: () => void;
  onMute: (reason: string) => void;
  studentName?: string;
  roomName?: string;
}

export const MuteUserModal: React.FC<MuteUserModalProps> = ({
  isOpen,
  onClose,
  onMute,
  studentName = 'Student',
  roomName = 'Room',
}) => {
  const [reason, setReason] = useState('');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onMute(reason.trim());
    setReason('');
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
              <VolumeX className="h-5 w-5 text-red-600" /> Mute User in Room
            </h3>
            <button onClick={onClose} className="text-slate-400 hover:text-slate-600">
              <X className="h-5 w-5" />
            </button>
          </div>

          <p className="text-xs text-slate-500 dark:text-slate-400">
            Muting <strong className="text-slate-800 dark:text-slate-200">{studentName}</strong> in{' '}
            <strong className="text-slate-800 dark:text-slate-200">{roomName}</strong> will prevent them from sending messages in this room.
          </p>

          <form onSubmit={handleSubmit} className="space-y-4">
            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-500 mb-1">
                Reason for Muting
              </label>
              <textarea
                rows={3}
                value={reason}
                onChange={(e) => setReason(e.target.value)}
                placeholder="Inappropriate behavior, spamming..."
                className="w-full px-3 py-2 rounded-xl bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border text-sm outline-none resize-none focus:ring-2 focus:ring-red-500/20"
              />
            </div>

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
                className="px-4 py-2 rounded-xl bg-red-600 hover:bg-red-700 text-white text-sm font-semibold transition-all flex items-center gap-1.5"
              >
                <VolumeX className="h-4 w-4" /> Mute Student
              </button>
            </div>
          </form>
        </motion.div>
      </div>
    </AnimatePresence>
  );
};
