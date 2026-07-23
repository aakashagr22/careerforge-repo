import React from 'react';

interface OnlineBadgeProps {
  online?: boolean;
  size?: 'sm' | 'md';
}

export const OnlineBadge: React.FC<OnlineBadgeProps> = ({ online = true, size = 'sm' }) => {
  const sizeClasses = size === 'sm' ? 'h-2.5 w-2.5 ring-2' : 'h-3 w-3 ring-2';

  return (
    <span
      className={`inline-block rounded-full ring-white dark:ring-dark-card ${sizeClasses} ${
        online ? 'bg-emerald-500' : 'bg-slate-300 dark:bg-zinc-600'
      }`}
      title={online ? 'Online' : 'Offline'}
    />
  );
};
