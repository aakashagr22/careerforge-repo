import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { studentService } from '../services/studentService';
import { blogService } from '../services/blogService';
import { BlogCard } from '../components/BlogCard';
import { MarkdownPreview } from '../components/MarkdownPreview';
import { Card, CardContent } from '../components/Card';
import { Input } from '../components/Input';
import {
  BookOpen, Plus, X, ArrowLeft, ArrowRight, Eye, Send, AlertTriangle, FileText, CheckCircle2, Loader2
} from 'lucide-react';
import { Blog } from '../types/blog';

const blogFormSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  content: zod.string().min(1, 'Content body is required'),
  submitForReview: zod.boolean(),
});

type BlogFormValues = zod.infer<typeof blogFormSchema>;

export const StudentBlogsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const navigate = useNavigate();
  const [activeTab, setActiveTab] = useState<'feed' | 'my-blogs'>('feed');
  const [page, setPage] = useState(0);
  const [isComposerOpen, setIsComposerOpen] = useState(false);
  const [editingBlog, setEditingBlog] = useState<Blog | null>(null);
  const size = 9;

  // 1. Fetch Student Profile to check year eligibility
  const { data: profile } = useQuery({
    queryKey: ['studentProfile'],
    queryFn: studentService.getMyProfile,
  });

  const semester = profile?.semester;
  const isEligible = semester !== undefined && semester >= 3 && semester <= 8;

  // 2. Fetch Published Blogs
  const { data: publishedPage, isLoading: loadingFeed } = useQuery({
    queryKey: ['publishedBlogs', page],
    queryFn: () => blogService.getPublishedBlogs(page, size),
    enabled: activeTab === 'feed',
    staleTime: 5 * 60 * 1000,
  });

  // 3. Fetch My Blogs
  const { data: myBlogsPage, isLoading: loadingMyBlogs } = useQuery({
    queryKey: ['myBlogs', page],
    queryFn: () => blogService.getMyBlogs(page, size),
    enabled: activeTab === 'my-blogs',
    staleTime: 5 * 60 * 1000,
  });

  // 4. Form setup
  const { register, handleSubmit, reset, setValue, formState: { errors } } = useForm<BlogFormValues>({
    resolver: zodResolver(blogFormSchema),
    defaultValues: {
      title: '',
      content: '',
      submitForReview: false,
    }
  });

  // 5. Create Mutation
  const createBlogMutation = useMutation({
    mutationFn: blogService.createStudentBlog,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['publishedBlogs'] });
      queryClient.invalidateQueries({ queryKey: ['myBlogs'] });
      setIsComposerOpen(false);
      reset();
      toast.success('Blog saved successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to create blog.');
    }
  });

  // 6. Update Mutation
  const updateBlogMutation = useMutation({
    mutationFn: ({ id, data }: { id: string; data: BlogFormValues }) => 
      blogService.updateStudentBlog(id, data),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['publishedBlogs'] });
      queryClient.invalidateQueries({ queryKey: ['myBlogs'] });
      setIsComposerOpen(false);
      setEditingBlog(null);
      reset();
      toast.success('Blog updated successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to update blog.');
    }
  });

  const onSubmit = (values: BlogFormValues) => {
    if (editingBlog) {
      updateBlogMutation.mutate({ id: editingBlog.id, data: values });
    } else {
      createBlogMutation.mutate(values);
    }
  };

  const handleEditClick = (blog: Blog) => {
    setEditingBlog(blog);
    setValue('title', blog.title);
    setValue('content', blog.content);
    setValue('submitForReview', blog.status === 'REJECTED'); // Default to submit review if resubmitting
    setIsComposerOpen(true);
  };

  const handleTabChange = (tab: 'feed' | 'my-blogs') => {
    setActiveTab(tab);
    setPage(0);
  };

  const currentBlogs = activeTab === 'feed' ? (publishedPage?.content || []) : (myBlogsPage?.content || []);
  const totalPages = activeTab === 'feed' ? (publishedPage?.totalPages || 0) : (myBlogsPage?.totalPages || 0);
  const isLoading = activeTab === 'feed' ? loadingFeed : loadingMyBlogs;

  return (
    <div className="space-y-8 max-w-6xl mx-auto pb-16">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4 border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <div className="space-y-2">
          <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2.5">
            <BookOpen className="h-7 w-7 text-brand-650" /> Placement Blogs
          </h1>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Read preparation tips, interview retrospectives, or compose blogs to guide your peers.
          </p>
        </div>

        {/* Tab Selection */}
        <div className="flex items-center gap-2 bg-slate-100 dark:bg-zinc-800/40 p-1.5 rounded-xl border border-slate-200/40 dark:border-dark-border/10 shrink-0">
          <button
            onClick={() => handleTabChange('feed')}
            className={`px-4 py-2 text-xs font-bold rounded-lg transition-all ${
              activeTab === 'feed'
                ? 'bg-white dark:bg-dark-card text-brand-650 dark:text-white shadow-sm border border-slate-200/20'
                : 'text-slate-500 hover:text-slate-700 dark:hover:text-slate-350'
            }`}
          >
            Public Feed
          </button>
          <button
            onClick={() => handleTabChange('my-blogs')}
            className={`px-4 py-2 text-xs font-bold rounded-lg transition-all ${
              activeTab === 'my-blogs'
                ? 'bg-white dark:bg-dark-card text-brand-650 dark:text-white shadow-sm border border-slate-200/20'
                : 'text-slate-500 hover:text-slate-700 dark:hover:text-slate-350'
            }`}
          >
            My Desk
          </button>
        </div>
      </div>

      {/* ==================== MAIN ACTION ROW ==================== */}
      {activeTab === 'my-blogs' && (
        <div className="flex justify-between items-center bg-slate-50/50 dark:bg-zinc-800/10 border border-slate-200/50 dark:border-dark-border/40 p-5 rounded-2xl">
          <div className="space-y-1">
            <h3 className="text-xs font-extrabold text-slate-800 dark:text-white uppercase tracking-wide">
              Composer Desk
            </h3>
            <p className="text-[10px] text-slate-400 dark:text-slate-500">
              Only students in 2nd–4th year (semesters 3–8) can submit posts for approval.
            </p>
          </div>
          <button
            disabled={!isEligible}
            onClick={() => { setEditingBlog(null); reset(); setIsComposerOpen(true); }}
            className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-bold text-xs transition-colors shadow-sm disabled:opacity-50 disabled:cursor-not-allowed"
          >
            <Plus className="h-4.5 w-4.5" /> Compose Blog
          </button>
        </div>
      )}

      {/* Check eligibility warning */}
      {activeTab === 'my-blogs' && !isEligible && (
        <div className="flex gap-3 bg-amber-50 dark:bg-amber-950/20 text-amber-600 dark:text-amber-450 border border-amber-200/30 dark:border-amber-950/40 p-4.5 rounded-2xl items-start">
          <AlertTriangle className="h-5 w-5 shrink-0 mt-0.5" />
          <div className="text-xs space-y-1">
            <h4 className="font-extrabold">Eligibility Restriction Active</h4>
            <p className="leading-relaxed">
              Blogging permissions are restricted to students in their 2nd, 3rd, or 4th year (semesters 3 to 8). 
              Currently, your profile semester is set to: <strong>{semester || 'Not set'}</strong>. You can update your semester details in settings.
            </p>
          </div>
        </div>
      )}

      {/* ==================== BLOGS LISTING ==================== */}
      {isLoading ? (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 animate-pulse">
          {[...Array(6)].map((_, i) => (
            <div key={i} className="h-52 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          ))}
        </div>
      ) : currentBlogs.length === 0 ? (
        <div className="text-center py-24 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-3xl max-w-md mx-auto space-y-3">
          <FileText className="h-10 w-10 text-slate-350 mx-auto" />
          <h3 className="text-sm font-bold text-slate-800 dark:text-white">No Blogs Found</h3>
          <p className="text-xs text-slate-500 leading-relaxed">
            {activeTab === 'feed'
              ? 'No placements guides have been published yet. Be the first to share your journey!'
              : 'You have not written any blog submissions yet. Select Compose Blog to get started.'}
          </p>
        </div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {currentBlogs.map((blog: Blog) => (
            <BlogCard
              key={blog.id}
              blog={blog}
              isOwner={activeTab === 'my-blogs'}
              onRead={(b) => navigate(`/student/blogs/${b.id}`)}
              onEdit={handleEditClick}
            />
          ))}
        </div>
      )}

      {/* ==================== PAGINATION BOTTOM ==================== */}
      {totalPages > 1 && (
        <div className="flex items-center justify-between text-sm font-bold text-slate-450 pt-6 border-t border-slate-200/50 dark:border-dark-border/40">
          <span>Page {page + 1} of {totalPages}</span>
          <div className="flex gap-2">
            <button
              onClick={() => setPage(p => Math.max(0, p - 1))}
              disabled={page === 0}
              className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors"
            >
              Prev
            </button>
            <button
              onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))}
              disabled={page >= totalPages - 1}
              className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors"
            >
              Next
            </button>
          </div>
        </div>
      )}

      {/* ==================== COMPOSER MODAL (CREATE / EDIT) ==================== */}
      {isComposerOpen && (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/60 backdrop-blur-sm p-4">
          <Card className="w-full max-w-2xl shadow-2xl">
            <form onSubmit={handleSubmit(onSubmit)} className="p-6 space-y-4">
              <div className="flex justify-between items-center">
                <h3 className="text-sm font-bold text-slate-900 dark:text-white">
                  {editingBlog ? 'Edit Blog submission' : 'Compose Blog submission'}
                </h3>
                <button
                  type="button"
                  onClick={() => setIsComposerOpen(false)}
                  className="text-slate-400 hover:text-slate-600"
                >
                  <X className="h-5 w-5" />
                </button>
              </div>

              {/* Display Rejection Feedback Alert if applicable */}
              {editingBlog && editingBlog.status === 'REJECTED' && (
                <div className="bg-red-50 dark:bg-red-950/20 text-red-650 dark:text-red-400 p-4 border border-red-200/50 dark:border-red-950/30 rounded-xl space-y-1">
                  <h4 className="text-xs font-bold flex items-center gap-1.5">
                    <AlertTriangle className="h-4 w-4" /> Moderator Review Comments:
                  </h4>
                  <p className="text-xs leading-relaxed font-semibold italic">
                    "{editingBlog.rejectionReason}"
                  </p>
                </div>
              )}

              <Input
                label="Article Title"
                placeholder="e.g. My Amazon SWE Interview Retrospective"
                error={errors.title?.message}
                {...register('title')}
              />

              <div className="space-y-1.5">
                <div className="flex justify-between items-end">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Article Body (Markdown Supported)
                  </label>
                  <span className="text-[10px] text-slate-400 dark:text-slate-500 font-bold uppercase tracking-wider">
                    Use *italic* and **bold**
                  </span>
                </div>
                <textarea
                  placeholder="Draft your thoughts here..."
                  {...register('content')}
                  className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800 text-xs font-semibold text-slate-800 dark:text-slate-200 transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 h-56 resize-none ${
                    errors.content ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
                  }`}
                />
                {errors.content && (
                  <p className="text-xs text-red-500">{errors.content.message}</p>
                )}
              </div>

              {/* Submit for review checkbox */}
              <div className="flex items-center gap-2 pt-2 border-t border-slate-200/40 dark:border-dark-border/40">
                <input
                  type="checkbox"
                  id="submitForReview"
                  {...register('submitForReview')}
                  className="h-4 w-4 rounded border-slate-350 text-brand-650 focus:ring-brand-500/30 cursor-pointer"
                />
                <label
                  htmlFor="submitForReview"
                  className="text-xs font-bold text-slate-650 dark:text-slate-350 cursor-pointer select-none"
                >
                  Submit directly for Moderator review (Unchecking saves as draft)
                </label>
              </div>

              <div className="flex justify-end gap-3 pt-2">
                <button
                  type="button"
                  onClick={() => setIsComposerOpen(false)}
                  className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl text-xs font-semibold hover:bg-slate-50 dark:hover:bg-zinc-800/40 text-slate-700 dark:text-slate-300 dark:hover:text-white"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  disabled={createBlogMutation.isPending || updateBlogMutation.isPending}
                  className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2 rounded-xl text-xs font-semibold disabled:opacity-75"
                >
                  {createBlogMutation.isPending || updateBlogMutation.isPending ? (
                    <Loader2 className="h-3.5 w-3.5 animate-spin" />
                  ) : (
                    <Send className="h-3.5 w-3.5" />
                  )}
                  Save Blog
                </button>
              </div>
            </form>
          </Card>
        </div>
        )}

    </div>
  );
};

export default StudentBlogsPage;
