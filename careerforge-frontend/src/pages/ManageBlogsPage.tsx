import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { blogService } from '../services/blogService';
import { Card, CardContent } from '../components/Card';
import { Input } from '../components/Input';
import {
  BookOpen, Plus, X, ArrowLeft, ArrowRight, Eye, Send, CheckCircle2, AlertTriangle, MessageSquare, Loader2
} from 'lucide-react';
import { Blog } from '../types/blog';

const adminBlogSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  content: zod.string().min(1, 'Content body is required'),
});

type AdminBlogValues = zod.infer<typeof adminBlogSchema>;

export const ManageBlogsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const navigate = useNavigate();
  const [activeTab, setActiveTab] = useState<'pending' | 'published'>('pending');
  const [page, setPage] = useState(0);
  const [isAdminComposerOpen, setIsAdminComposerOpen] = useState(false);
  const size = 10;

  // 1. Fetch pending or published blogs
  const { data: blogsPage, isLoading: loadingBlogs } = useQuery({
    queryKey: ['adminBlogs', activeTab, page],
    queryFn: () => activeTab === 'pending' 
      ? blogService.getPendingBlogs(page, size)
      : blogService.getPublishedBlogs(page, size),
    staleTime: 5 * 60 * 1000,
  });

  // 2. Admin composer form setup
  const { register, handleSubmit, reset, formState: { errors } } = useForm<AdminBlogValues>({
    resolver: zodResolver(adminBlogSchema),
    defaultValues: {
      title: '',
      content: '',
    }
  });

  // 3. Admin creation mutation (auto-publishes)
  const createAdminBlogMutation = useMutation({
    mutationFn: blogService.createAdminBlog,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminBlogs'] });
      setIsAdminComposerOpen(false);
      reset();
      toast.success('Admin article published successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to publish blog.');
    }
  });

  const onAdminComposeSubmit = (values: AdminBlogValues) => {
    createAdminBlogMutation.mutate({
      title: values.title,
      content: values.content,
      submitForReview: false, // Bypassed
    });
  };

  const blogs = blogsPage?.content || [];
  const totalPages = blogsPage?.totalPages || 0;

  return (
    <div className="space-y-8 max-w-6xl mx-auto pb-16">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4 border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <div className="space-y-2">
          <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2">
            <BookOpen className="h-7 w-7 text-rose-650" /> Manage Articles
          </h1>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Publish official announcements or moderate student draft review submissions.
          </p>
        </div>

        <div className="flex flex-wrap items-center gap-3">
          {/* Tab Selection */}
          <div className="flex items-center gap-2 bg-slate-100 dark:bg-zinc-800/40 p-1.5 rounded-xl border border-slate-200/40 dark:border-dark-border/10 shrink-0">
            <button
              onClick={() => { setActiveTab('pending'); setPage(0); }}
              className={`px-4 py-2 text-xs font-bold rounded-lg transition-all ${
                activeTab === 'pending'
                  ? 'bg-white dark:bg-dark-card text-brand-650 dark:text-white shadow-sm border border-slate-200/20'
                  : 'text-slate-500 hover:text-slate-700 dark:hover:text-slate-350'
              }`}
            >
              Pending Approval
            </button>
            <button
              onClick={() => { setActiveTab('published'); setPage(0); }}
              className={`px-4 py-2 text-xs font-bold rounded-lg transition-all ${
                activeTab === 'published'
                  ? 'bg-white dark:bg-dark-card text-brand-650 dark:text-white shadow-sm border border-slate-200/20'
                  : 'text-slate-500 hover:text-slate-700 dark:hover:text-slate-350'
              }`}
            >
              Published Articles
            </button>
          </div>

          {/* Action button */}
          <button
            onClick={() => { reset(); setIsAdminComposerOpen(true); }}
            className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-bold text-xs transition-colors shadow-sm"
          >
            <Plus className="h-4.5 w-4.5" /> Write Admin Article
          </button>
        </div>
      </div>

      {/* ==================== MAIN MODERATION QUEUE ==================== */}
      <Card className="border border-slate-200/80 dark:border-dark-border">
        <CardContent className="p-0">
          {loadingBlogs ? (
            <div className="flex items-center justify-center py-24 gap-3 text-slate-500 font-semibold text-xs">
              <Loader2 className="h-5 w-5 animate-spin text-rose-650" /> {activeTab === 'pending' ? 'Loading submissions queue...' : 'Loading published articles...'}
            </div>
          ) : blogs.length === 0 ? (
            <div className="text-center py-20 text-slate-500 text-xs">
              {activeTab === 'pending' ? 'Moderation queue is empty. No articles awaiting approval!' : 'No published articles found.'}
            </div>
          ) : (
            <div className="overflow-x-auto">
              <table className="w-full text-left border-collapse text-xs">
                <thead>
                  <tr className="border-b border-slate-100 dark:border-zinc-800 text-slate-400 dark:text-slate-500 font-bold uppercase tracking-wider bg-slate-50/50 dark:bg-zinc-800/10">
                    <th className="p-4">Title</th>
                    <th className="p-4">Author</th>
                    <th className="p-4">{activeTab === 'pending' ? 'Submitted Date' : 'Published Date'}</th>
                    <th className="p-4 text-right">Actions</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-slate-100 dark:divide-zinc-800/60">
                  {blogs.map((blog: Blog) => (
                    <tr key={blog.id} className="hover:bg-slate-50/20 dark:hover:bg-zinc-800/10 transition-colors">
                      <td className="p-4 font-semibold text-slate-800 dark:text-slate-200 max-w-[300px] truncate">
                        {blog.title}
                      </td>
                      <td className="p-4 text-slate-600 dark:text-slate-400 font-medium">
                        {blog.authorName}
                      </td>
                      <td className="p-4 text-slate-550 dark:text-slate-500 font-medium">
                        {new Date(blog.createdAt).toLocaleDateString()}
                      </td>
                      <td className="p-4 text-right">
                        <button
                          onClick={() => navigate(`/admin/blogs/${blog.id}`)}
                          className="inline-flex items-center gap-1 bg-slate-100 hover:bg-slate-200 dark:bg-zinc-800 dark:hover:bg-zinc-700 text-slate-700 dark:text-slate-200 px-3 py-1.5 rounded-lg font-semibold transition-colors"
                        >
                          Review & Action <Eye className="h-3.5 w-3.5" />
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </CardContent>

        {/* Pagination */}
        {totalPages > 1 && (
          <div className="flex items-center justify-between p-4 border-t border-slate-200/50 dark:border-dark-border/40 text-sm font-bold text-slate-450">
            <span>Page {page + 1} of {totalPages}</span>
            <div className="flex gap-2">
              <button
                onClick={() => setPage(p => Math.max(0, p - 1))}
                disabled={page === 0}
                className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors animate-all"
              >
                Prev
              </button>
              <button
                onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))}
                disabled={page >= totalPages - 1}
                className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors animate-all"
              >
                Next
              </button>
            </div>
          </div>
        )}
      </Card>

      {/* ==================== ADMIN WRITE ARTICLE MODAL ==================== */}
      {isAdminComposerOpen && (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/60 backdrop-blur-sm p-4">
          <Card className="w-full max-w-2xl shadow-2xl">
            <form onSubmit={handleSubmit(onAdminComposeSubmit)} className="p-6 space-y-4">
              <div className="flex justify-between items-center">
                <h3 className="text-sm font-bold text-slate-900 dark:text-white">
                  Write Admin Article (Auto-Publish)
                </h3>
                <button
                  type="button"
                  onClick={() => setIsAdminComposerOpen(false)}
                  className="text-slate-400 hover:text-slate-600"
                >
                  <X className="h-5 w-5" />
                </button>
              </div>

              <Input
                label="Article Title"
                placeholder="e.g. System Announcement: Placement Registration Commenced"
                error={errors.title?.message}
                {...register('title')}
              />

              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                  Article Body (Markdown Supported)
                </label>
                <textarea
                  placeholder="Draft official announcements or editorial guides..."
                  {...register('content')}
                  className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800 text-xs font-semibold text-slate-850 dark:text-slate-200 transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 h-56 resize-none"
                />
                {errors.content && (
                  <p className="text-xs text-red-500">{errors.content.message}</p>
                )}
              </div>

              <div className="flex justify-end gap-3 pt-2">
                <button
                  type="button"
                  onClick={() => setIsAdminComposerOpen(false)}
                  className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl text-xs font-semibold hover:bg-slate-50 dark:hover:bg-zinc-800/40 text-slate-700 dark:text-slate-300 dark:hover:text-white"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  disabled={createAdminBlogMutation.isPending}
                  className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2 rounded-xl text-xs font-semibold disabled:opacity-75"
                >
                  {createAdminBlogMutation.isPending ? (
                    <Loader2 className="h-3.5 w-3.5 animate-spin" />
                  ) : (
                    <Send className="h-3.5 w-3.5" />
                  )}
                  Publish Immediately
                </button>
              </div>
            </form>
          </Card>
        </div>
      )}



    </div>
  );
};

export default ManageBlogsPage;
