import React from 'react';
import { motion } from 'framer-motion';

interface TypingIndicatorProps {
  names?: string[];
}

export const TypingIndicator: React.FC<TypingIndicatorProps> = ({ names = [] }) => {
  if (names.length === 0) return null;

  const text =
    names.length === 1
      ? `${names[0]} is typing...`
      : names.length === 2
      ? `${names[0]} and ${names[1]} are typing...`
      : `${names[0]} and ${names.length - 1} others are typing...`;

  return (
    <div className="flex items-center gap-2 px-6 py-1 text-xs text-slate-400 dark:text-slate-500 italic">
      <div className="flex items-center gap-1">
        {[0, 1, 2].map((i) => (
          <motion.span
            key={i}
            animate={{ opacity: [0.3, 1, 0.3] }}
            transition={{ repeat: Infinity, duration: 1, delay: i * 0.2 }}
            className="h-1.5 w-1.5 rounded-full bg-slate-400 dark:bg-slate-500"
          />
        ))}
      </div>
      <span>{text}</span>
    </div>
  );
};
