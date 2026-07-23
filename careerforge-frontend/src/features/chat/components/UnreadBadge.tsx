import React from 'react';

interface UnreadBadgeProps {
  count: number;
}

export const UnreadBadge: React.FC<UnreadBadgeProps> = ({ count }) => {
  if (count <= 0) return null;

  return (
    <span className="h-5 min-w-[20px] px-1.5 rounded-full bg-brand-600 text-white text-[11px] font-bold flex items-center justify-center shadow-sm">
      {count > 99 ? '99+' : count}
    </span>
  );
};
