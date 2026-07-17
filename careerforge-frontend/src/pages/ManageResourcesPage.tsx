import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { adminService } from '../services/adminService';
import { resourceService } from '../services/resourceService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { Badge } from '../components/Badge';
import { Library, Plus, Trash2, Loader2, Play, FileText, BookOpen, Code } from 'lucide-react';

const resourceSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().min(1, 'Description is required').max(250),
  url: zod.string().min(1, 'URL is required').url('Must be a valid URL'),
  category: zod.string().min(1, 'Category is required'),
  type: zod.enum(['VIDEO', 'ARTICLE', 'BOOK', 'DOCUMENTATION']),
  difficulty: zod.enum(['EASY', 'MEDIUM', 'HARD']),
  durationMinutes: zod.number().min(1, 'Est duration must be positive'),
});

type ResourceFormValues = zod.infer<typeof resourceSchema>;

export const ManageResourcesPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [page, setPage] = useState(0);
  const size = 5;

  // Fetch paginated resources
  const { data: resourcePage, isLoading: loadingList } = useQuery({
    queryKey: ['adminResources', page],
    queryFn: () => resourceService.getResources({
      page,
      size,
    }),
  });

  const { register, handleSubmit, reset, formState: { errors } } = useForm<ResourceFormValues>({
    resolver: zodResolver(resourceSchema),
    defaultValues: {
      title: '',
      description: '',
      url: '',
      category: 'DSA',
      type: 'VIDEO',
      difficulty: 'EASY',
      durationMinutes: 15,
    }
  });

  // Create mutation
  const createMutation = useMutation({
    mutationFn: adminService.createResource,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminResources'] });
      queryClient.invalidateQueries({ queryKey: ['adminStats'] });
      reset();
      toast.success('Resource created successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to create resource.');
    }
  });

  // Delete mutation
  const deleteMutation = useMutation({
    mutationFn: adminService.deleteResource,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminResources'] });
      queryClient.invalidateQueries({ queryKey: ['adminStats'] });
      toast.success('Resource deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete resource.');
    }
  });

  const onSubmit = (values: ResourceFormValues) => {
    createMutation.mutate(values);
  };

  const handleDelete = (id: string) => {
    if (window.confirm('Are you sure you want to delete this resource?')) {
      deleteMutation.mutate(id);
    }
  };

  const getFormatIcon = (format: string) => {
    switch (format) {
      case 'VIDEO': return <Play className="h-4 w-4 text-red-500" />;
      case 'ARTICLE': return <FileText className="h-4 w-4 text-indigo-500" />;
      case 'BOOK': return <BookOpen className="h-4 w-4 text-amber-500" />;
      case 'DOCUMENTATION': return <Code className="h-4 w-4 text-emerald-500" />;
      default: return <Library className="h-4 w-4 text-slate-500" />;
    }
  };

  const resources = resourcePage?.content || [];

  return (
    <div className="space-y-8 max-w-5xl mx-auto">
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <Library className="h-7 w-7 text-rose-650" /> Manage Study Materials
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Publish external learning items or clean up outdated guides.
        </p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
        
        {/* Create Resource Card Form */}
        <Card className="lg:col-span-1 h-fit">
          <CardHeader>
            <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
              <Plus className="h-4.5 w-4.5 text-brand-600" /> Create Resource
            </CardTitle>
          </CardHeader>
          <CardContent className="p-5">
            <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
              <Input
                label="Resource Title"
                placeholder="e.g., Intro to Graphs"
                error={errors.title?.message}
                {...register('title')}
              />
              
              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                  Description
                </label>
                <textarea
                  placeholder="Summarize content..."
                  {...register('description')}
                  className={`w-full px-4 py-2 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 resize-none h-16 ${
                    errors.description ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
                  }`}
                />
                {errors.description && (
                  <p className="text-xs text-red-500">{errors.description.message}</p>
                )}
              </div>

              <Input
                label="Redirect URL"
                placeholder="e.g., https://youtube.com/..."
                error={errors.url?.message}
                {...register('url')}
              />

              <div className="grid grid-cols-2 gap-4">
                <Input
                  label="Category Tag"
                  placeholder="e.g., DSA, Dev"
                  error={errors.category?.message}
                  {...register('category')}
                />
                <Input
                  label="Est. Duration (Min)"
                  type="number"
                  error={errors.durationMinutes?.message}
                  {...register('durationMinutes', { valueAsNumber: true })}
                />
              </div>

              <div className="grid grid-cols-2 gap-4">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Format
                  </label>
                  <select
                    {...register('type')}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
                  >
                    <option value="VIDEO">Video</option>
                    <option value="ARTICLE">Article</option>
                    <option value="BOOK">Book</option>
                    <option value="DOCUMENTATION">Documentation</option>
                  </select>
                </div>

                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Difficulty
                  </label>
                  <select
                    {...register('difficulty')}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
                  >
                    <option value="EASY">Easy</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HARD">Hard</option>
                  </select>
                </div>
              </div>

              <button
                type="submit"
                disabled={createMutation.isPending}
                className="w-full inline-flex items-center justify-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-semibold text-sm transition-colors disabled:opacity-75"
              >
                {createMutation.isPending ? (
                  <Loader2 className="h-4 w-4 animate-spin" />
                ) : (
                  'Publish Resource'
                )}
              </button>
            </form>
          </CardContent>
        </Card>

        {/* Existing Resources List */}
        <div className="lg:col-span-2 space-y-4">
          <Card>
            <CardHeader>
              <CardTitle className="text-sm font-bold uppercase tracking-wider">
                Existing Materials Directory
              </CardTitle>
            </CardHeader>
            <CardContent className="p-0">
              {loadingList ? (
                <div className="flex items-center justify-center py-20 gap-2 text-slate-500 text-sm">
                  <Loader2 className="h-5 w-5 animate-spin" /> Loading directories...
                </div>
              ) : resources.length === 0 ? (
                <div className="text-center py-20 text-slate-500 text-sm">
                  No resources published. Build your first curriculum item on the left panel!
                </div>
              ) : (
                <div className="divide-y divide-slate-100 dark:divide-zinc-800/60">
                  {resources.map((res) => (
                    <div key={res.id} className="p-4 flex justify-between items-center gap-4 hover:bg-slate-50/20 dark:hover:bg-zinc-800/10 transition-colors">
                      <div className="min-w-0 space-y-1">
                        <div className="flex items-center gap-2 flex-wrap">
                          {getFormatIcon(res.type)}
                          <span className="font-semibold text-sm text-slate-800 dark:text-slate-200 truncate">
                            {res.title}
                          </span>
                          <Badge variant="slate">{res.category}</Badge>
                          <Badge variant={res.difficulty === 'EASY' ? 'success' : res.difficulty === 'MEDIUM' ? 'warning' : 'error'} className="text-[8px] tracking-wider py-0 leading-none">
                            {res.difficulty}
                          </Badge>
                        </div>
                        <p className="text-xs text-slate-400 line-clamp-1 leading-normal">
                          {res.description}
                        </p>
                      </div>

                      <button
                        onClick={() => handleDelete(res.id)}
                        className="text-red-500 hover:text-red-700 p-2 hover:bg-red-50 dark:hover:bg-red-950/20 rounded-xl transition-colors shrink-0"
                      >
                        <Trash2 className="h-4.5 w-4.5" />
                      </button>
                    </div>
                  ))}
                </div>
              )}
            </CardContent>
            {resourcePage && resourcePage.totalPages > 1 && (
              <div className="flex items-center justify-between p-4 border-t border-slate-100 dark:border-zinc-800 text-xs font-semibold text-slate-500">
                <span>Page {page + 1} of {resourcePage.totalPages}</span>
                <div className="flex gap-2">
                  <button
                    onClick={() => setPage(p => Math.max(0, p - 1))}
                    disabled={page === 0}
                    className="px-2.5 py-1 border border-slate-200 dark:border-zinc-800 rounded hover:bg-slate-50 dark:hover:bg-zinc-800/50 disabled:opacity-50"
                  >
                    Prev
                  </button>
                  <button
                    onClick={() => setPage(p => Math.min(resourcePage.totalPages - 1, p + 1))}
                    disabled={page >= resourcePage.totalPages - 1}
                    className="px-2.5 py-1 border border-slate-200 dark:border-zinc-800 rounded hover:bg-slate-50 dark:hover:bg-zinc-800/50 disabled:opacity-50"
                  >
                    Next
                  </button>
                </div>
              </div>
            )}
          </Card>
        </div>

      </div>
    </div>
  );
};
export default ManageResourcesPage;
