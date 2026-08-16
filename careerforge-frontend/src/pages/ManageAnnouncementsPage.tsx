import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import toast from 'react-hot-toast';
import { announcementService } from '../services/announcementService';
import { Announcement, AnnouncementPriority } from '../types/announcement';
import {
  Megaphone, AlertTriangle, Calendar, User, Loader2, BellOff,
  Plus, Trash2, X, ArrowLeft, ArrowRight, Send
} from 'lucide-react';

export const ManageAnnouncementsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [page, setPage] = useState(0);
  const size = 10;

  // Create form state
  const [showForm, setShowForm] = useState(false);
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [priority, setPriority] = useState<AnnouncementPriority>('NORMAL');

  // Delete confirm state
  const [confirmDeleteId, setConfirmDeleteId] = useState<string | null>(null);

  // Fetch announcements
  const { data: announcementsPage, isLoading } = useQuery({
    queryKey: ['adminAnnouncements', page],
    queryFn: () => announcementService.getAnnouncements(page, size),
    staleTime: 30 * 1000,
  });

  const announcements: Announcement[] = announcementsPage?.content || [];
  const totalPages: number = announcementsPage?.totalPages || 0;

  // Create mutation
  const createMutation = useMutation({
    mutationFn: announcementService.createAnnouncement,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminAnnouncements'] });
      queryClient.invalidateQueries({ queryKey: ['announcements'] });
      toast.success('Announcement published successfully!');
      resetForm();
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to publish announcement.');
    },
  });

  // Delete mutation
  const deleteMutation = useMutation({
    mutationFn: announcementService.deleteAnnouncement,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminAnnouncements'] });
      queryClient.invalidateQueries({ queryKey: ['announcements'] });
      toast.success('Announcement deleted.');
      setConfirmDeleteId(null);
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete announcement.');
    },
  });

  const resetForm = () => {
    setTitle('');
    setContent('');
    setPriority('NORMAL');
    setShowForm(false);
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!title.trim() || !content.trim()) return;
    createMutation.mutate({ title: title.trim(), content: content.trim(), priority });
  };

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
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4 border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <div className="space-y-1">
          <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2.5">
            <Megaphone className="h-7 w-7 text-rose-600" />
            Manage Announcements
          </h1>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Publish and manage platform-wide announcements visible to all students.
          </p>
        </div>

        <button
          onClick={() => setShowForm(v => !v)}
          className="inline-flex items-center gap-2 bg-rose-600 hover:bg-rose-700 text-white px-4 py-2.5 rounded-xl text-sm font-bold transition-colors shadow-sm shrink-0"
        >
          {showForm ? <X className="h-4 w-4" /> : <Plus className="h-4 w-4" />}
          {showForm ? 'Cancel' : 'New Announcement'}
        </button>
      </div>

      {/* ==================== CREATE FORM ==================== */}
      {showForm && (
        <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl p-6 space-y-5 shadow-sm">
          <h2 className="text-sm font-bold text-slate-800 dark:text-white uppercase tracking-wider">
            Compose Announcement
          </h2>
          <form onSubmit={handleSubmit} className="space-y-4">
            {/* Title */}
            <div className="space-y-1.5">
              <label className="text-xs font-bold text-slate-600 dark:text-slate-400 uppercase tracking-wider">
                Title *
              </label>
              <input
                required
                maxLength={200}
                value={title}
                onChange={e => setTitle(e.target.value)}
                placeholder="e.g. Campus Recruitment Drive – August 2026"
                className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50 dark:bg-zinc-800/50 text-sm font-semibold text-slate-800 dark:text-slate-100 focus:outline-none focus:ring-2 focus:ring-rose-500/30 transition"
              />
            </div>

            {/* Content */}
            <div className="space-y-1.5">
              <label className="text-xs font-bold text-slate-600 dark:text-slate-400 uppercase tracking-wider">
                Content *
              </label>
              <textarea
                required
                value={content}
                onChange={e => setContent(e.target.value)}
                rows={5}
                placeholder="Write the full announcement message here..."
                className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50 dark:bg-zinc-800/50 text-sm text-slate-800 dark:text-slate-100 focus:outline-none focus:ring-2 focus:ring-rose-500/30 transition resize-none leading-relaxed"
              />
            </div>

            {/* Priority */}
            <div className="space-y-1.5">
              <label className="text-xs font-bold text-slate-600 dark:text-slate-400 uppercase tracking-wider">
                Priority
              </label>
              <div className="flex items-center gap-3">
                {(['NORMAL', 'URGENT'] as AnnouncementPriority[]).map(p => (
                  <button
                    key={p}
                    type="button"
                    onClick={() => setPriority(p)}
                    className={`px-4 py-2 rounded-xl text-xs font-bold border transition-all ${
                      priority === p
                        ? p === 'URGENT'
                          ? 'bg-rose-600 text-white border-rose-600'
                          : 'bg-brand-600 text-white border-brand-600'
                        : 'bg-white dark:bg-zinc-800 text-slate-500 dark:text-slate-400 border-slate-200 dark:border-dark-border hover:border-slate-300'
                    }`}
                  >
                    {p === 'URGENT' && <AlertTriangle className="h-3 w-3 inline mr-1" />}
                    {p}
                  </button>
                ))}
              </div>
            </div>

            {/* Submit */}
            <div className="flex justify-end pt-1">
              <button
                type="submit"
                disabled={createMutation.isPending}
                className="inline-flex items-center gap-2 bg-rose-600 hover:bg-rose-700 disabled:opacity-75 text-white px-5 py-2.5 rounded-xl text-sm font-bold transition-colors"
              >
                {createMutation.isPending ? (
                  <Loader2 className="h-4 w-4 animate-spin" />
                ) : (
                  <Send className="h-4 w-4" />
                )}
                Publish Announcement
              </button>
            </div>
          </form>
        </div>
      )}

      {/* ==================== ANNOUNCEMENT LIST ==================== */}
      {isLoading ? (
        <div className="flex items-center justify-center py-24 gap-3 text-slate-500 font-semibold text-xs">
          <Loader2 className="h-5 w-5 animate-spin text-rose-600" />
          Loading announcements...
        </div>
      ) : announcements.length === 0 ? (
        <div className="text-center py-24 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl space-y-3">
          <BellOff className="h-9 w-9 text-slate-300 mx-auto" />
          <h4 className="text-sm font-bold text-slate-700 dark:text-white">No Announcements Yet</h4>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Click "New Announcement" to publish your first notice.
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
                  : 'border-slate-200/80 dark:border-dark-border'
              }`}
            >
              {/* Priority badge + delete */}
              <div className="absolute top-4 right-4 flex items-center gap-2">
                {a.priority === 'URGENT' && (
                  <span className="inline-flex items-center gap-1 px-2.5 py-1 rounded-full bg-rose-100 dark:bg-rose-950/30 text-rose-600 dark:text-rose-400 text-[10px] font-bold uppercase tracking-wider">
                    <AlertTriangle className="h-3 w-3" />
                    Urgent
                  </span>
                )}
                {confirmDeleteId === a.id ? (
                  <div className="flex items-center gap-1">
                    <button
                      onClick={() => deleteMutation.mutate(a.id)}
                      disabled={deleteMutation.isPending}
                      className="px-2.5 py-1 bg-rose-600 text-white text-[10px] font-bold rounded-lg hover:bg-rose-700 transition-colors"
                    >
                      {deleteMutation.isPending ? '...' : 'Confirm'}
                    </button>
                    <button
                      onClick={() => setConfirmDeleteId(null)}
                      className="px-2.5 py-1 border border-slate-200 dark:border-dark-border text-slate-600 dark:text-slate-400 text-[10px] font-bold rounded-lg hover:bg-slate-50 dark:hover:bg-zinc-800 transition-colors"
                    >
                      Cancel
                    </button>
                  </div>
                ) : (
                  <button
                    onClick={() => setConfirmDeleteId(a.id)}
                    className="h-7 w-7 flex items-center justify-center rounded-lg text-slate-400 hover:text-rose-600 hover:bg-rose-50 dark:hover:bg-rose-950/20 transition-colors"
                    title="Delete announcement"
                  >
                    <Trash2 className="h-4 w-4" />
                  </button>
                )}
              </div>

              {/* Title */}
              <h2 className={`text-base font-bold pr-28 ${a.priority === 'URGENT' ? 'text-rose-700 dark:text-rose-300' : 'text-slate-800 dark:text-white'}`}>
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

export default ManageAnnouncementsPage;
