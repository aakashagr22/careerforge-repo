import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { blogService } from '../services/blogService';
import { useAuthStore } from '../store/authStore';
import { MarkdownPreview } from '../components/MarkdownPreview';
import { Card, CardContent } from '../components/Card';
import toast from 'react-hot-toast';
import {
  ArrowLeft, Calendar, User, CheckCircle2, AlertTriangle, MessageSquare, Loader2, Save
} from 'lucide-react';

export const BlogDetailPage: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const queryClient = useQueryClient();
  const { user } = useAuthStore();
  const isAdmin = user?.role === 'ADMIN';

  const [rejectionFeedback, setRejectionFeedback] = useState('');
  const [isRejectionBoxOpen, setIsRejectionBoxOpen] = useState(false);

  // 1. Fetch Blog Detail
  const { data: blog, isLoading, error } = useQuery({
    queryKey: ['blogDetail', id],
    queryFn: () => blogService.getBlogById(id!),
    enabled: !!id,
    staleTime: 5 * 60 * 1000,
  });

  // 2. Approve mutation
  const approveMutation = useMutation({
    mutationFn: blogService.approveBlog,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['blogDetail', id] });
      queryClient.invalidateQueries({ queryKey: ['pendingBlogs'] });
      queryClient.invalidateQueries({ queryKey: ['publishedBlogs'] });
      toast.success('Blog approved and published successfully!');
      navigate('/admin/blogs');
    },
    onError: (err: any) => {
      toast.error(err.response?.data?.message || 'Failed to approve blog.');
    }
  });

  // 3. Reject mutation
  const rejectMutation = useMutation({
    mutationFn: ({ blogId, reason }: { blogId: string; reason: string }) => 
      blogService.rejectBlog(blogId, { rejectionReason: reason }),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['blogDetail', id] });
      queryClient.invalidateQueries({ queryKey: ['pendingBlogs'] });
      setIsRejectionBoxOpen(false);
      setRejectionFeedback('');
      toast.success('Blog rejected and feedback sent.');
      navigate('/admin/blogs');
    },
    onError: (err: any) => {
      toast.error(err.response?.data?.message || 'Failed to reject blog.');
    }
  });

  const handleApprove = () => {
    if (window.confirm('Are you sure you want to approve and publish this blog?')) {
      approveMutation.mutate(id!);
    }
  };

  const handleRejectSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!rejectionFeedback.trim()) return;
    rejectMutation.mutate({ blogId: id!, reason: rejectionFeedback.trim() });
  };

  const handleBack = () => {
    navigate(-1); // Go back in history
  };

  if (isLoading) {
    return (
      <div className="flex flex-col items-center justify-center py-32 gap-3 text-slate-505 font-semibold text-xs">
        <Loader2 className="h-5 w-5 animate-spin text-brand-650" /> Loading article content...
      </div>
    );
  }

  if (error || !blog) {
    return (
      <div className="text-center py-20 max-w-md mx-auto space-y-4">
        <AlertTriangle className="h-10 w-10 text-red-500 mx-auto" />
        <h3 className="text-sm font-bold text-slate-850 dark:text-white">Blog Not Found</h3>
        <p className="text-xs text-slate-500">The article you are trying to view does not exist or has been removed.</p>
        <button onClick={handleBack} className="inline-flex items-center gap-1.5 text-xs text-brand-650 font-bold hover:underline">
          <ArrowLeft className="h-4 w-4" /> Go Back
        </button>
      </div>
    );
  }

  const formattedDate = new Date(blog.createdAt).toLocaleDateString('en-US', {
    month: 'long',
    day: 'numeric',
    year: 'numeric',
  });

  const isPendingReview = blog.status === 'PENDING_REVIEW';
  const isPublished = blog.status === 'PUBLISHED';

  return (
    <div className="space-y-6 max-w-3xl mx-auto pb-20">
      
      {/* Back navigation */}
      <button
        onClick={handleBack}
        className="inline-flex items-center gap-1.5 text-xs font-bold text-slate-500 hover:text-slate-700 dark:hover:text-slate-350 transition-colors"
      >
        <ArrowLeft className="h-4 w-4" /> Back
      </button>

      {/* Main Content Layout */}
      <Card className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border p-8 rounded-3xl">
        <CardContent className="p-0 space-y-6">
          
          {/* Article Header Details */}
          <div className="space-y-3 border-b border-slate-200/50 dark:border-dark-border/40 pb-5">
            <h1 className="text-2xl sm:text-3xl font-black text-slate-900 dark:text-white leading-tight">
              {blog.title}
            </h1>
            
            <div className="flex flex-wrap items-center gap-5 text-xs font-semibold text-slate-400 dark:text-slate-500">
              <div className="flex items-center gap-1.5">
                <User className="h-4 w-4" />
                <span>By {blog.authorName}</span>
              </div>
              <div className="flex items-center gap-1.5">
                <Calendar className="h-4 w-4" />
                <span>Published on {formattedDate}</span>
              </div>
              {blog.status === 'REJECTED' && (
                <div className="bg-red-50 dark:bg-red-955/10 text-red-650 dark:text-red-400 px-2 py-0.5 rounded border border-red-200/30 dark:border-red-950/20 uppercase text-[9px] tracking-wider font-bold">
                  Rejected
                </div>
              )}
            </div>
          </div>

          {/* Student's Rejection Comments Alert Box */}
          {blog.status === 'REJECTED' && blog.rejectionReason && (
            <div className="bg-red-50 dark:bg-red-950/20 text-red-650 dark:text-red-400 p-4 border border-red-200/50 dark:border-red-955/35 rounded-2xl space-y-1">
              <h4 className="text-xs font-bold flex items-center gap-1.5">
                <AlertTriangle className="h-4 w-4" /> Moderator Feedback / Rejection Comments:
              </h4>
              <p className="text-xs leading-relaxed font-semibold italic">
                "{blog.rejectionReason}"
              </p>
            </div>
          )}

          {/* Render article body */}
          <div className="prose prose-slate dark:prose-invert max-w-none">
            <MarkdownPreview content={blog.content} />
          </div>

          {/* Moderator Approval Panel at bottom (visible to admin for pending or published reviews) */}
          {isAdmin && (isPendingReview || isPublished) && (
            <div className="border-t border-slate-200/50 dark:border-dark-border/40 pt-6 mt-6 space-y-4">
              <div className="flex items-center gap-2">
                <MessageSquare className="h-4.5 w-4.5 text-rose-600" />
                <h3 className="text-xs font-bold text-slate-800 dark:text-white uppercase tracking-wider">
                  Moderator Controls
                </h3>
              </div>

              {isRejectionBoxOpen ? (
                <form onSubmit={handleRejectSubmit} className="bg-red-50 dark:bg-red-950/10 border border-red-200/30 dark:border-red-950/20 p-4.5 rounded-xl space-y-3">
                  <label className="block text-xs font-bold text-red-650 dark:text-red-400 uppercase tracking-wide">
                    Reason for Rejection
                  </label>
                  <textarea
                    required
                    value={rejectionFeedback}
                    onChange={(e) => setRejectionFeedback(e.target.value)}
                    placeholder="Provide revision instructions to the author..."
                    className="w-full px-3 py-2 rounded-xl border border-red-200 dark:border-red-900/40 bg-white dark:bg-zinc-800 text-xs font-semibold text-slate-800 dark:text-slate-200 focus:outline-none h-24 resize-none"
                  />
                  <div className="flex justify-end gap-2">
                    <button
                      type="button"
                      onClick={() => setIsRejectionBoxOpen(false)}
                      className="px-3 py-1.5 border border-red-200 dark:border-red-900/50 text-red-650 dark:text-red-400 text-xs font-semibold rounded-lg hover:bg-red-50/50 dark:hover:bg-red-950/20"
                    >
                      Cancel Rejection
                    </button>
                    <button
                      type="submit"
                      disabled={rejectMutation.isPending}
                      className="px-3 py-1.5 bg-red-600 hover:bg-red-750 text-white text-xs font-bold rounded-lg transition-colors disabled:opacity-70 inline-flex items-center gap-1"
                    >
                      {rejectMutation.isPending ? (
                        <Loader2 className="h-3 w-3 animate-spin" />
                      ) : null}
                      Submit Rejection
                    </button>
                  </div>
                </form>
              ) : (
                <div className="flex justify-end gap-3 pt-2">
                  <button
                    type="button"
                    onClick={() => setIsRejectionBoxOpen(true)}
                    className="inline-flex items-center gap-1.5 bg-red-50 dark:bg-red-955/20 text-red-650 dark:text-red-400 px-4.5 py-2.5 rounded-xl text-xs font-bold transition-colors hover:bg-red-100 dark:hover:bg-red-950/40"
                  >
                    <AlertTriangle className="h-3.5 w-3.5" /> Reject with Comments
                  </button>
                  {isPendingReview && (
                    <button
                      type="button"
                      disabled={approveMutation.isPending}
                      onClick={handleApprove}
                      className="inline-flex items-center gap-1.5 bg-emerald-600 hover:bg-emerald-700 text-white px-4.5 py-2.5 rounded-xl text-xs font-bold transition-colors shadow-sm disabled:opacity-70"
                    >
                      {approveMutation.isPending ? (
                        <Loader2 className="h-3.5 w-3.5 animate-spin" />
                      ) : (
                        <CheckCircle2 className="h-3.5 w-3.5" />
                      )}
                      Approve & Publish
                    </button>
                  )}
                </div>
              )}
            </div>
          )}

        </CardContent>
      </Card>

    </div>
  );
};

export default BlogDetailPage;
