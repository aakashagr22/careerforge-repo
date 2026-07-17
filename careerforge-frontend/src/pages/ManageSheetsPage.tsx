import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { adminService } from '../services/adminService';
import { sheetService } from '../services/sheetService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { Badge } from '../components/Badge';
import { Layers, Plus, Trash2, Loader2, LayoutGrid } from 'lucide-react';

const sheetSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().min(1, 'Description is required').max(200),
  category: zod.enum(['DSA', 'WEB_DEVELOPER', 'SYSTEM_DESIGN', 'MACHINE_LEARNING']),
});

const topicSchema = zod.object({
  sheetId: zod.string().min(1, 'Please select a parent sheet'),
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().min(1, 'Description is required').max(200),
  difficulty: zod.enum(['EASY', 'MEDIUM', 'HARD']),
  orderIndex: zod.number().min(1, 'Order index must be positive'),
});

type SheetFormValues = zod.infer<typeof sheetSchema>;
type TopicFormValues = zod.infer<typeof topicSchema>;

export const ManageSheetsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [selectedSheetId, setSelectedSheetId] = useState<string>('');

  // Fetch all sheets
  const { data: sheets = [] } = useQuery({
    queryKey: ['adminSheets'],
    queryFn: sheetService.getPracticeSheets,
  });

  // Fetch topics for selected sheet
  const { data: topics = [], isLoading: loadingTopics } = useQuery({
    queryKey: ['adminSheetTopics', selectedSheetId],
    queryFn: () => sheetService.getSheetTopics(selectedSheetId),
    enabled: !!selectedSheetId,
  });

  // React Hook Forms
  const sheetForm = useForm<SheetFormValues>({
    resolver: zodResolver(sheetSchema),
    defaultValues: { title: '', description: '', category: 'DSA' }
  });

  const topicForm = useForm<TopicFormValues>({
    resolver: zodResolver(topicSchema),
    defaultValues: { sheetId: '', title: '', description: '', difficulty: 'EASY', orderIndex: 1 }
  });

  // Create Sheet Mutation
  const createSheetMutation = useMutation({
    mutationFn: adminService.createSheet,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminSheets'] });
      queryClient.invalidateQueries({ queryKey: ['adminStats'] });
      sheetForm.reset();
      toast.success('Practice sheet created!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to create sheet.');
    }
  });

  // Delete Sheet Mutation
  const deleteSheetMutation = useMutation({
    mutationFn: adminService.deleteSheet,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminSheets'] });
      queryClient.invalidateQueries({ queryKey: ['adminStats'] });
      setSelectedSheetId('');
      toast.success('Sheet deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete sheet.');
    }
  });

  // Create Topic Mutation
  const createTopicMutation = useMutation({
    mutationFn: adminService.createSheetTopic,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminSheetTopics', selectedSheetId] });
      queryClient.invalidateQueries({ queryKey: ['studentDashboard'] });
      topicForm.reset({
        sheetId: selectedSheetId,
        title: '',
        description: '',
        difficulty: 'EASY',
        orderIndex: topics.length + 2,
      });
      toast.success('Sheet topic added!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to add topic.');
    }
  });

  // Delete Topic Mutation
  const deleteTopicMutation = useMutation({
    mutationFn: adminService.deleteSheetTopic,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminSheetTopics', selectedSheetId] });
      queryClient.invalidateQueries({ queryKey: ['studentDashboard'] });
      toast.success('Topic deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete topic.');
    }
  });

  const onSheetSubmit = (values: SheetFormValues) => {
    createSheetMutation.mutate(values);
  };

  const onTopicSubmit = (values: TopicFormValues) => {
    createTopicMutation.mutate(values);
  };

  const handleDeleteSheet = (id: string) => {
    if (window.confirm('Delete this sheet and all topics within it?')) {
      deleteSheetMutation.mutate(id);
    }
  };

  const handleDeleteTopic = (id: string) => {
    if (window.confirm('Delete this topic?')) {
      deleteTopicMutation.mutate(id);
    }
  };

  return (
    <div className="space-y-8 max-w-5xl mx-auto">
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <Layers className="h-7 w-7 text-rose-650" /> Manage Practice Checklists
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Configure DSA or Web Development practice sheets and add challenge topics.
        </p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
        
        <div className="space-y-6 lg:col-span-1">
          {/* Create Sheet Form */}
          <Card>
            <CardHeader>
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <Plus className="h-4.5 w-4.5 text-brand-650" /> New Practice Sheet
              </CardTitle>
            </CardHeader>
            <CardContent className="p-5">
              <form onSubmit={sheetForm.handleSubmit(onSheetSubmit)} className="space-y-4">
                <Input
                  label="Sheet Title"
                  placeholder="e.g., Array & Strings Part 1"
                  error={sheetForm.formState.errors.title?.message}
                  {...sheetForm.register('title')}
                />
                
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Description
                  </label>
                  <textarea
                    placeholder="e.g., Basic algorithms..."
                    {...sheetForm.register('description')}
                    className="w-full px-4 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none h-16 resize-none"
                  />
                </div>

                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Category Type
                  </label>
                  <select
                    {...sheetForm.register('category')}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none text-slate-750 dark:text-slate-350"
                  >
                    <option value="DSA">Data Structures & Algorithms</option>
                    <option value="WEB_DEVELOPER">Web Development</option>
                    <option value="SYSTEM_DESIGN">System Design</option>
                    <option value="MACHINE_LEARNING">Machine Learning</option>
                  </select>
                </div>

                <button
                  type="submit"
                  disabled={createSheetMutation.isPending}
                  className="w-full inline-flex items-center justify-center gap-2 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-semibold text-xs transition-colors"
                >
                  Create Sheet
                </button>
              </form>
            </CardContent>
          </Card>

          {/* Add Sheet Topic Form */}
          <Card>
            <CardHeader>
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <Plus className="h-4.5 w-4.5 text-brand-650" /> Add Topic Challenge
              </CardTitle>
            </CardHeader>
            <CardContent className="p-5">
              <form onSubmit={topicForm.handleSubmit(onTopicSubmit)} className="space-y-4">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Select Sheet
                  </label>
                  <select
                    {...topicForm.register('sheetId', {
                      onChange: (e) => {
                        setSelectedSheetId(e.target.value);
                        topicForm.setValue('sheetId', e.target.value);
                      }
                    })}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none text-slate-750 dark:text-slate-350"
                  >
                    <option value="">-- Choose Target Sheet --</option>
                    {sheets.map(s => (
                      <option key={s.id} value={s.id}>{s.title}</option>
                    ))}
                  </select>
                  {topicForm.formState.errors.sheetId && (
                    <p className="text-xs text-red-500">{topicForm.formState.errors.sheetId.message}</p>
                  )}
                </div>

                <Input
                  label="Topic Name"
                  placeholder="e.g., Two Pointer Traversal"
                  error={topicForm.formState.errors.title?.message}
                  {...topicForm.register('title')}
                />

                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Task description
                  </label>
                  <textarea
                    placeholder="Define challenge details..."
                    {...topicForm.register('description')}
                    className="w-full px-4 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none h-16 resize-none"
                  />
                </div>

                <div className="grid grid-cols-2 gap-4">
                  <div className="space-y-1.5">
                    <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                      Difficulty
                    </label>
                    <select
                      {...topicForm.register('difficulty')}
                      className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none text-slate-750 dark:text-slate-350"
                    >
                      <option value="EASY">Easy</option>
                      <option value="MEDIUM">Medium</option>
                      <option value="HARD">Hard</option>
                    </select>
                  </div>

                  <Input
                    label="Sequence Order"
                    type="number"
                    error={topicForm.formState.errors.orderIndex?.message}
                    {...topicForm.register('orderIndex', { valueAsNumber: true })}
                  />
                </div>

                <button
                  type="submit"
                  disabled={createTopicMutation.isPending}
                  className="w-full inline-flex items-center justify-center gap-2 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-semibold text-xs transition-colors"
                >
                  Publish Topic
                </button>
              </form>
            </CardContent>
          </Card>
        </div>

        {/* Directory details preview */}
        <div className="lg:col-span-2 space-y-6">
          
          {/* Select a sheet to view topics */}
          <Card>
            <CardHeader className="flex flex-row justify-between items-center px-6 py-4">
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <LayoutGrid className="h-4.5 w-4.5 text-brand-650" /> Topics & Checklists Preview
              </CardTitle>
              {selectedSheetId && (
                <button
                  onClick={() => handleDeleteSheet(selectedSheetId)}
                  className="text-xs font-semibold text-red-500 hover:underline flex items-center gap-1"
                >
                  <Trash2 className="h-3.5 w-3.5" /> Delete Selected Sheet
                </button>
              )}
            </CardHeader>
            <CardContent className="p-6">
              
              <div className="space-y-4">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-500 uppercase tracking-wide">
                    Choose a sheet to view list:
                  </label>
                  <select
                    value={selectedSheetId}
                    onChange={(e) => setSelectedSheetId(e.target.value)}
                    className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-bg text-sm focus:outline-none text-slate-700 dark:text-slate-350"
                  >
                    <option value="">-- Choose Sheet from Directory --</option>
                    {sheets.map(s => (
                      <option key={s.id} value={s.id}>{s.title} ({s.category})</option>
                    ))}
                  </select>
                </div>

                {selectedSheetId ? (
                  loadingTopics ? (
                    <div className="flex items-center justify-center py-10 gap-2 text-slate-500 text-xs font-semibold">
                      <Loader2 className="h-4 w-4 animate-spin text-brand-600" /> Loading topic checklist...
                    </div>
                  ) : topics.length === 0 ? (
                    <div className="text-center py-10 text-slate-500 text-sm">
                      No topics added to this sheet. Build your first topic on the bottom-left form!
                    </div>
                  ) : (
                    <div className="divide-y divide-slate-100 dark:divide-zinc-800/60 mt-4 border border-slate-200/50 dark:border-zinc-800/65 rounded-xl overflow-hidden bg-slate-50/10 dark:bg-zinc-800/5">
                      {topics.map((t) => (
                        <div key={t.id} className="p-4 flex justify-between items-center gap-4 hover:bg-slate-50/20 dark:hover:bg-zinc-800/10 transition-colors">
                          <div className="min-w-0 space-y-1">
                            <div className="flex items-center gap-2 flex-wrap">
                              <span className="text-xs font-bold text-slate-400">#{t.orderIndex}</span>
                              <span className="font-semibold text-sm text-slate-800 dark:text-slate-200 truncate">
                                {t.title}
                              </span>
                              <Badge variant={t.difficulty === 'EASY' ? 'success' : t.difficulty === 'MEDIUM' ? 'warning' : 'error'} className="text-[8px] tracking-wider py-0 leading-none">
                                {t.difficulty}
                              </Badge>
                            </div>
                            <p className="text-xs text-slate-400 line-clamp-1">
                              {t.description}
                            </p>
                          </div>

                          <button
                            onClick={() => handleDeleteTopic(t.id)}
                            className="text-red-500 hover:text-red-700 p-2 hover:bg-red-50 dark:hover:bg-red-950/20 rounded-xl transition-colors shrink-0"
                          >
                            <Trash2 className="h-4.5 w-4.5" />
                          </button>
                        </div>
                      ))}
                    </div>
                  )
                ) : (
                  <div className="text-center py-12 text-slate-400 text-sm">
                    Select a practice sheet from the dropdown selector to preview or manage its topic checks.
                  </div>
                )}
              </div>

            </CardContent>
          </Card>
        </div>

      </div>
    </div>
  );
};
export default ManageSheetsPage;
