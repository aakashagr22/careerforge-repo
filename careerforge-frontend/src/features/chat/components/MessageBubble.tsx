import React, { useState } from 'react';
import { motion } from 'framer-motion';
import { ChatMessage } from '../types/chat';
import { Edit3, Trash2, Check, X, ShieldAlert } from 'lucide-react';

interface MessageBubbleProps {
  message: ChatMessage;
  isOwn: boolean;
  isAdmin: boolean;
  onEdit?: (messageId: string, newText: string) => void;
  onDelete?: (messageId: string) => void;
  onAdminDelete?: (messageId: string) => void;
}

export const MessageBubble: React.FC<MessageBubbleProps> = ({
  message,
  isOwn,
  isAdmin,
  onEdit,
  onDelete,
  onAdminDelete,
}) => {
  const [isEditing, setIsEditing] = useState(false);
  const [editText, setEditText] = useState(message.message);

  const formattedTime = new Date(message.createdAt).toLocaleTimeString([], {
    hour: '2-digit',
    minute: '2-digit',
  });

  const handleSaveEdit = () => {
    if (!editText.trim()) return;
    if (onEdit) {
      onEdit(message.id, editText.trim());
    }
    setIsEditing(false);
  };

  const handleCancelEdit = () => {
    setEditText(message.message);
    setIsEditing(false);
  };

  const getInitials = (firstName: string, lastName: string) => {
    return `${firstName?.charAt(0) || ''}${lastName?.charAt(0) || ''}`.toUpperCase() || 'U';
  };

  if (message.messageType === 'SYSTEM') {
    return (
      <div className="flex justify-center my-3">
        <span className="px-3 py-1 rounded-full text-xs font-medium bg-slate-200/60 dark:bg-zinc-800 text-slate-500 dark:text-slate-400">
          {message.message}
        </span>
      </div>
    );
  }

  return (
    <motion.div
      initial={{ opacity: 0, y: 8 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.15 }}
      className={`group flex items-start gap-3 my-3 ${isOwn ? 'flex-row-reverse' : ''}`}
    >
      {/* Sender Avatar */}
      <div
        className={`h-9 w-9 rounded-xl flex items-center justify-center text-xs font-bold shrink-0 shadow-sm ${
          isOwn
            ? 'bg-brand-600 text-white'
            : 'bg-slate-200 dark:bg-zinc-800 text-slate-700 dark:text-slate-300'
        }`}
      >
        {getInitials(message.senderFirstName, message.senderLastName)}
      </div>

      {/* Message Content */}
      <div className={`flex flex-col max-w-[75%] md:max-w-[65%] ${isOwn ? 'items-end' : 'items-start'}`}>
        {/* Header (Name & Time) */}
        <div className={`flex items-center gap-2 mb-1 text-xs ${isOwn ? 'flex-row-reverse' : ''}`}>
          <span className="font-semibold text-slate-700 dark:text-slate-300">
            {isOwn ? 'You' : `${message.senderFirstName} ${message.senderLastName}`}
          </span>
          <span className="text-[10px] text-slate-400 dark:text-slate-500">{formattedTime}</span>
        </div>

        {/* Bubble */}
        <div className="relative group/bubble">
          {message.deleted ? (
            <div className="px-4 py-2.5 rounded-2xl italic text-xs border border-dashed border-slate-300 dark:border-zinc-700 text-slate-400 dark:text-slate-500">
              This message was deleted
            </div>
          ) : isEditing ? (
            <div className="flex items-center gap-2 p-2 bg-white dark:bg-dark-card border border-brand-500 rounded-2xl shadow-md">
              <input
                type="text"
                value={editText}
                onChange={(e) => setEditText(e.target.value)}
                onKeyDown={(e) => {
                  if (e.key === 'Enter') handleSaveEdit();
                  if (e.key === 'Escape') handleCancelEdit();
                }}
                className="flex-1 bg-transparent px-2 py-1 text-sm outline-none text-slate-900 dark:text-white"
                autoFocus
              />
              <button
                onClick={handleSaveEdit}
                className="p-1.5 rounded-lg bg-brand-600 text-white hover:bg-brand-700 transition-colors"
                title="Save edit"
              >
                <Check className="h-3.5 w-3.5" />
              </button>
              <button
                onClick={handleCancelEdit}
                className="p-1.5 rounded-lg text-slate-400 hover:text-slate-600 dark:hover:text-slate-200 transition-colors"
                title="Cancel"
              >
                <X className="h-3.5 w-3.5" />
              </button>
            </div>
          ) : (
            <div
              className={`px-4 py-2.5 rounded-2xl text-sm leading-relaxed whitespace-pre-wrap break-words shadow-sm ${
                isOwn
                  ? 'bg-brand-600 text-white rounded-tr-xs'
                  : 'bg-white dark:bg-dark-card text-slate-800 dark:text-slate-100 border border-slate-200/80 dark:border-dark-border rounded-tl-xs'
              }`}
            >
              {message.message}
              {message.edited && (
                <span
                  className={`text-[10px] ml-2 italic opacity-75 ${
                    isOwn ? 'text-brand-100' : 'text-slate-400 dark:text-slate-500'
                  }`}
                >
                  (edited)
                </span>
              )}
            </div>
          )}

          {/* Action buttons on hover */}
          {!message.deleted && !isEditing && (
            <div
              className={`absolute top-1/2 -translate-y-1/2 hidden group-hover/bubble:flex items-center gap-1 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-lg shadow-md px-1.5 py-1 z-10 ${
                isOwn ? 'right-full mr-2' : 'left-full ml-2'
              }`}
            >
              {isOwn && onEdit && (
                <button
                  onClick={() => setIsEditing(true)}
                  className="p-1 rounded text-slate-400 hover:text-brand-600 dark:hover:text-brand-400 transition-colors"
                  title="Edit message"
                >
                  <Edit3 className="h-3.5 w-3.5" />
                </button>
              )}
              {isOwn && onDelete && (
                <button
                  onClick={() => onDelete(message.id)}
                  className="p-1 rounded text-slate-400 hover:text-red-600 transition-colors"
                  title="Delete message"
                >
                  <Trash2 className="h-3.5 w-3.5" />
                </button>
              )}
              {isAdmin && onAdminDelete && !isOwn && (
                <button
                  onClick={() => onAdminDelete(message.id)}
                  className="p-1 rounded text-slate-400 hover:text-rose-600 transition-colors"
                  title="Admin delete message"
                >
                  <ShieldAlert className="h-3.5 w-3.5" />
                </button>
              )}
            </div>
          )}
        </div>
      </div>
    </motion.div>
  );
};
