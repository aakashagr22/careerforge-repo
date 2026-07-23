import React from 'react';

export const ChatSkeleton: React.FC = () => {
  return (
    <div className="flex-1 flex flex-col h-full bg-slate-50/50 dark:bg-dark-bg/50 animate-pulse">
      {/* Header skeleton */}
      <div className="h-16 px-6 border-b border-slate-200/80 dark:border-dark-border flex items-center justify-between bg-white dark:bg-dark-card">
        <div className="flex items-center gap-3">
          <div className="h-10 w-10 rounded-xl bg-slate-200 dark:bg-zinc-800" />
          <div className="space-y-1.5">
            <div className="h-4 w-32 bg-slate-200 dark:bg-zinc-800 rounded" />
            <div className="h-3 w-48 bg-slate-200 dark:bg-zinc-800 rounded" />
          </div>
        </div>
        <div className="h-8 w-8 rounded-lg bg-slate-200 dark:bg-zinc-800" />
      </div>

      {/* Messages skeleton */}
      <div className="flex-1 p-6 space-y-6 overflow-hidden">
        {[...Array(5)].map((_, i) => (
          <div
            key={i}
            className={`flex items-start gap-3 ${i % 2 === 1 ? 'flex-row-reverse' : ''}`}
          >
            <div className="h-9 w-9 rounded-xl bg-slate-200 dark:bg-zinc-800 shrink-0" />
            <div className={`space-y-2 max-w-sm ${i % 2 === 1 ? 'items-end' : ''}`}>
              <div className="h-3 w-24 bg-slate-200 dark:bg-zinc-800 rounded" />
              <div className="h-12 w-64 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
            </div>
          </div>
        ))}
      </div>

      {/* Input skeleton */}
      <div className="p-4 border-t border-slate-200/80 dark:border-dark-border bg-white dark:bg-dark-card">
        <div className="h-12 w-full rounded-2xl bg-slate-200 dark:bg-zinc-800" />
      </div>
    </div>
  );
};
