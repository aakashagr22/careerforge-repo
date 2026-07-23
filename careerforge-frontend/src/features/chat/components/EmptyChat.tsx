import React from 'react';
import { MessageSquarePlus, Sparkles } from 'lucide-react';
import { motion } from 'framer-motion';

interface EmptyChatProps {
  type?: 'no-selection' | 'no-messages' | 'no-search';
  onStartSearch?: () => void;
}

export const EmptyChat: React.FC<EmptyChatProps> = ({
  type = 'no-selection',
  onStartSearch,
}) => {
  if (type === 'no-messages') {
    return (
      <div className="flex-1 flex flex-col items-center justify-center p-8 text-center bg-slate-50/50 dark:bg-dark-bg/30">
        <motion.div
          initial={{ scale: 0.8, opacity: 0 }}
          animate={{ scale: 1, opacity: 1 }}
          className="h-16 w-16 rounded-2xl bg-brand-50 dark:bg-brand-900/20 text-brand-600 dark:text-brand-400 flex items-center justify-center mb-4"
        >
          <Sparkles className="h-8 w-8" />
        </motion.div>
        <h3 className="font-heading font-bold text-lg text-slate-800 dark:text-slate-200 mb-1">
          No Messages Yet
        </h3>
        <p className="text-sm text-slate-500 dark:text-slate-400 max-w-sm">
          Be the first one to start the conversation! Send a message below to get started.
        </p>
      </div>
    );
  }

  if (type === 'no-search') {
    return (
      <div className="p-8 text-center text-slate-500 dark:text-slate-400 text-sm">
        No students or conversations match your search.
      </div>
    );
  }

  return (
    <div className="flex-1 flex flex-col items-center justify-center p-8 text-center bg-slate-50/50 dark:bg-dark-bg/30">
      <motion.div
        initial={{ scale: 0.8, opacity: 0 }}
        animate={{ scale: 1, opacity: 1 }}
        className="h-20 w-20 rounded-3xl bg-gradient-to-tr from-brand-600 to-indigo-600 text-white flex items-center justify-center shadow-xl shadow-brand-500/20 mb-6"
      >
        <MessageSquarePlus className="h-10 w-10" />
      </motion.div>
      <h2 className="font-heading font-bold text-2xl text-slate-900 dark:text-white mb-2">
        Welcome to CareerForge Chat
      </h2>
      <p className="text-sm text-slate-500 dark:text-slate-400 max-w-md mb-6 leading-relaxed">
        Select a year chat room, general discussion room, or start a direct message with a fellow student to collaborate and ask doubts.
      </p>
      {onStartSearch && (
        <button
          onClick={onStartSearch}
          className="px-5 py-2.5 rounded-xl bg-brand-600 hover:bg-brand-700 text-white font-medium text-sm transition-all shadow-md shadow-brand-600/20 flex items-center gap-2"
        >
          <MessageSquarePlus className="h-4 w-4" />
          Start a Conversation
        </button>
      )}
    </div>
  );
};
