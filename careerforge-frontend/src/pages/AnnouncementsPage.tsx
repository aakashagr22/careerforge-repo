import React, { useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import { announcementService } from '../services/announcementService';
import { Announcement } from '../types/announcement';
import { Megaphone, AlertTriangle, Calendar, User, ArrowLeft, ArrowRight, Loader2, BellOff } from 'lucide-react';

export const AnnouncementsPage: React.FC = () => {
  const [page, setPage] = useState(0);
  const size = 10;

  const { data: announcementsPage, isLoading } = useQuery({
    queryKey: ['announcements', page],
    queryFn: () => announcementService.getAnnouncements(page, size),
    staleTime: 60 * 1000,
  });

  const announcements: Announcement[] = announcementsPage?.content || [];
  const totalPages: number = announcementsPage?.totalPages || 0;

  const formatDate = (dateStr: string) =>
    new Date(dateStr).toLocaleDateString(undefined, {
      year: 'numeric',
      month: 'short',
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit',
    });

  return (
    <div className="space-y-8 max-w-3xl mx-auto pb-16">

      {/* ==================== PAGE HEADER ==================== */}
      <div className="flex flex-col gap-2 border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2.5">
          <Megaphone className="h-7 w-7 text-brand-600" />
          Announcements
        </h1>
        <p className="text-xs text-slate-500 dark:text-slate-400">
          Stay updated with the latest news and important notices from the administration.
        </p>
      </div>

      {/* ==================== ANNOUNCEMENT LIST ==================== */}
      {isLoading ? (
        <div className="flex items-center justify-center py-24 gap-3 text-slate-500 font-semibold text-xs">
          <Loader2 className="h-5 w-5 animate-spin text-brand-600" />
          Loading announcements...
        </div>
      ) : announcements.length === 0 ? (
        <div className="text-center py-24 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl space-y-3">
          <BellOff className="h-9 w-9 text-slate-300 mx-auto" />
          <h4 className="text-sm font-bold text-slate-700 dark:text-white">No Announcements Yet</h4>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Check back later for important updates from the admin.
          </p>
        </div>
      ) : (
        <div className="space-y-4">
          {announcements.map((a) => (
            <div
              key={a.id}
              className={`relative bg-white dark:bg-dark-card rounded-2xl border p-5 transition-all duration-200 ${
                a.priority === 'URGENT'
                  ? 'border-rose-300 dark:border-rose-800/60 shadow-sm shadow-rose-100 dark:shadow-rose-950/20'
                  : 'border-slate-200/80 dark:border-dark-border hover:border-brand-200 dark:hover:border-brand-900/40'
              }`}
            >
              {/* Urgent badge */}
              {a.priority === 'URGENT' && (
                <span className="absolute top-4 right-4 inline-flex items-center gap-1 px-2.5 py-1 rounded-full bg-rose-100 dark:bg-rose-950/30 text-rose-600 dark:text-rose-400 text-[10px] font-bold uppercase tracking-wider">
                  <AlertTriangle className="h-3 w-3" />
                  Urgent
                </span>
              )}

              {/* Title */}
              <h2 className={`text-base font-bold pr-20 ${a.priority === 'URGENT' ? 'text-rose-700 dark:text-rose-300' : 'text-slate-800 dark:text-white'}`}>
                {a.title}
              </h2>

              {/* Content */}
              <p className="text-sm text-slate-600 dark:text-slate-300 leading-relaxed mt-2 whitespace-pre-wrap">
                {a.content}
              </p>

              {/* Footer meta */}
              <div className="flex items-center gap-4 mt-4 text-[10px] font-semibold text-slate-400 dark:text-slate-500 uppercase tracking-wider">
                {a.createdByName && (
                  <span className="flex items-center gap-1">
                    <User className="h-3 w-3" /> {a.createdByName}
                  </span>
                )}
                <span className="flex items-center gap-1">
                  <Calendar className="h-3 w-3" /> {formatDate(a.createdAt)}
                </span>
              </div>
            </div>
          ))}
        </div>
      )}

      {/* ==================== PAGINATION ==================== */}
      {totalPages > 1 && (
        <div className="flex items-center justify-between text-sm font-bold text-slate-450 pt-4 border-t border-slate-200/50 dark:border-dark-border/40">
          <span>Page {page + 1} of {totalPages}</span>
          <div className="flex gap-2">
            <button
              onClick={() => setPage(p => Math.max(0, p - 1))}
              disabled={page === 0}
              className="flex items-center gap-1.5 px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors text-sm"
            >
              <ArrowLeft className="h-4 w-4" /> Prev
            </button>
            <button
              onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))}
              disabled={page >= totalPages - 1}
              className="flex items-center gap-1.5 px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors text-sm"
            >
              Next <ArrowRight className="h-4 w-4" />
            </button>
          </div>
        </div>
      )}

    </div>
  );
};

export default AnnouncementsPage;
