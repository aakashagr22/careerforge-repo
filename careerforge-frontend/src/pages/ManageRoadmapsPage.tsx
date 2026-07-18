import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { adminService } from '../services/adminService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { Badge } from '../components/Badge';
import { Compass, Plus, Trash2, Loader2, Settings } from 'lucide-react';

const roadmapSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().min(1, 'Description is required').max(250),
  targetRoles: zod.array(zod.enum(['SDE', 'FULL_STACK', 'WEB_DEVELOPER', 'AI_ML', 'DEVOPS'])).min(1, 'Select at least one role'),
  semester: zod.number().min(1, 'Semester must be 1-8').max(8),
  monthsRemaining: zod.number().min(1, 'Months remaining must be at least 1'),
});

const phaseSchema = zod.object({
  roadmapId: zod.string().min(1, 'Please select a parent roadmap'),
  phaseName: zod.string().min(1, 'Phase name is required').max(100),
  description: zod.string().min(1, 'Description is required').max(300),
  durationMonths: zod.number().min(1, 'Duration must be positive'),
  orderIndex: zod.number().min(1, 'Order index must be positive'),
});

type RoadmapFormValues = zod.infer<typeof roadmapSchema>;
type PhaseFormValues = zod.infer<typeof phaseSchema>;

export const ManageRoadmapsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [selectedRoadmapId, setSelectedRoadmapId] = useState<string>('');

  // Fetch all roadmaps (paginated query, set 0 page size 100 for admin fetch)
  const { data: roadmapPage } = useQuery({
    queryKey: ['adminRoadmaps'],
    queryFn: () => adminService.getAllRoadmaps(0, 100),
  });

  // Fetch phases of the selected roadmap
  const { data: phases = [], isLoading: loadingPhases } = useQuery({
    queryKey: ['adminRoadmapPhases', selectedRoadmapId],
    queryFn: () => adminService.getRoadmapPhases(selectedRoadmapId),
    enabled: !!selectedRoadmapId,
  });

  // React Hook Forms
  const roadmapForm = useForm<RoadmapFormValues>({
    resolver: zodResolver(roadmapSchema) as any,
    defaultValues: { title: '', description: '', targetRoles: [], semester: 5, monthsRemaining: 6 }
  });

  const phaseForm = useForm<PhaseFormValues>({
    resolver: zodResolver(phaseSchema),
    defaultValues: { roadmapId: '', phaseName: '', description: '', durationMonths: 2, orderIndex: 1 }
  });

  // Create Roadmap Mutation
  const createRoadmapMutation = useMutation({
    mutationFn: adminService.createRoadmap,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmaps'] });
      queryClient.invalidateQueries({ queryKey: ['adminStats'] });
      roadmapForm.reset();
      toast.success('Curriculum roadmap generated!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to create roadmap.');
    }
  });

  // Delete Roadmap Mutation
  const deleteRoadmapMutation = useMutation({
    mutationFn: adminService.deleteRoadmap,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmaps'] });
      queryClient.invalidateQueries({ queryKey: ['adminStats'] });
      setSelectedRoadmapId('');
      toast.success('Roadmap track deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete roadmap.');
    }
  });

  // Create Phase Mutation
  const createPhaseMutation = useMutation({
    mutationFn: adminService.createRoadmapPhase,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapPhases', selectedRoadmapId] });
      phaseForm.reset({
        roadmapId: selectedRoadmapId,
        phaseName: '',
        description: '',
        durationMonths: 2,
        orderIndex: phases.length + 2,
      });
      toast.success('Learning phase added!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to add learning phase.');
    }
  });

  // Delete Phase Mutation
  const deletePhaseMutation = useMutation({
    mutationFn: adminService.deleteRoadmapPhase,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapPhases', selectedRoadmapId] });
      toast.success('Phase deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete phase.');
    }
  });

  const onRoadmapSubmit = (values: RoadmapFormValues) => {
    const payload = {
      title: values.title,
      description: values.description,
      semester: values.semester,
      monthsRemaining: values.monthsRemaining,
      targetRoles: values.targetRoles,
    };
    createRoadmapMutation.mutate(payload);
  };

  const onPhaseSubmit = (values: PhaseFormValues) => {
    const sortedPhases = [...phases].sort((a, b) => a.orderIndex - b.orderIndex);
    
    let startMonth = 1;
    for (const p of sortedPhases) {
      if (p.orderIndex < values.orderIndex) {
        startMonth += p.durationMonths;
      }
    }
    const endMonth = startMonth + values.durationMonths - 1;

    const payload = {
      roadmapId: values.roadmapId,
      title: values.phaseName,
      description: values.description,
      startMonth,
      endMonth,
      priority: values.orderIndex,
    };
    createPhaseMutation.mutate(payload);
  };

  const handleDeleteRoadmap = (id: string) => {
    if (window.confirm('Delete this roadmap and all monthly phases inside it?')) {
      deleteRoadmapMutation.mutate(id);
    }
  };

  const handleDeletePhase = (id: string) => {
    if (window.confirm('Delete this learning phase milestone?')) {
      deletePhaseMutation.mutate(id);
    }
  };

  const roadmaps = roadmapPage?.content || [];

  return (
    <div className="space-y-8 max-w-5xl mx-auto">
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <Compass className="h-7 w-7 text-rose-650" /> Configure Curriculum Roadmaps
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Define semester-wise milestones, languages, target paths, or soft-skill phases.
        </p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
        
        <div className="space-y-6 lg:col-span-1">
          {/* Create Roadmap form */}
          <Card>
            <CardHeader>
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <Plus className="h-4.5 w-4.5 text-brand-650" /> New Roadmap Track
              </CardTitle>
            </CardHeader>
            <CardContent className="p-5">
              <form onSubmit={roadmapForm.handleSubmit(onRoadmapSubmit)} className="space-y-4">
                <Input
                  label="Roadmap Title"
                  placeholder="e.g., C++ Web Development Prep"
                  error={roadmapForm.formState.errors.title?.message}
                  {...roadmapForm.register('title')}
                />
                
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Description
                  </label>
                  <textarea
                    placeholder="Summarize target curriculum..."
                    {...roadmapForm.register('description')}
                    className="w-full px-4 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none h-16 resize-none"
                  />
                </div>

                <div className="space-y-2">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Target Roles
                  </label>
                  <div className="grid grid-cols-2 gap-2 border border-slate-100 dark:border-dark-border p-3 rounded-xl bg-slate-50/30 dark:bg-zinc-800/10">
                    {[
                      { value: 'SDE', label: 'SDE' },
                      { value: 'FULL_STACK', label: 'Full Stack' },
                      { value: 'WEB_DEVELOPER', label: 'Web Dev' },
                      { value: 'AI_ML', label: 'AI / ML' },
                      { value: 'DEVOPS', label: 'DevOps' }
                    ].map((role) => (
                      <label key={role.value} className="flex items-center gap-2 text-xs font-medium text-slate-600 dark:text-slate-455 cursor-pointer select-none">
                        <input
                          type="checkbox"
                          value={role.value}
                          className="h-3.5 w-3.5 rounded border-slate-300 dark:border-dark-border text-brand-600"
                          {...roadmapForm.register('targetRoles')}
                        />
                        {role.label}
                      </label>
                    ))}
                  </div>
                  {roadmapForm.formState.errors.targetRoles && (
                    <p className="text-xs text-red-500">{roadmapForm.formState.errors.targetRoles.message}</p>
                  )}
                </div>

                <div className="grid grid-cols-2 gap-4 items-center">
                  <Input
                    label="Target Semester"
                    type="number"
                    error={roadmapForm.formState.errors.semester?.message}
                    {...roadmapForm.register('semester', { valueAsNumber: true })}
                  />

                  <Input
                    label="Prep Duration (Months)"
                    type="number"
                    error={roadmapForm.formState.errors.monthsRemaining?.message}
                    {...roadmapForm.register('monthsRemaining', { valueAsNumber: true })}
                  />
                </div>

                <button
                  type="submit"
                  disabled={createRoadmapMutation.isPending}
                  className="w-full inline-flex items-center justify-center gap-2 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-semibold text-xs transition-colors"
                >
                  Publish Roadmap
                </button>
              </form>
            </CardContent>
          </Card>

          {/* Create Phase Form */}
          <Card>
            <CardHeader>
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <Plus className="h-4.5 w-4.5 text-brand-650" /> Add Roadmap Phase
              </CardTitle>
            </CardHeader>
            <CardContent className="p-5">
              <form onSubmit={phaseForm.handleSubmit(onPhaseSubmit)} className="space-y-4">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Select Target Roadmap
                  </label>
                  <select
                    {...phaseForm.register('roadmapId', {
                      onChange: (e) => {
                        setSelectedRoadmapId(e.target.value);
                        phaseForm.setValue('roadmapId', e.target.value);
                      }
                    })}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none text-slate-750 dark:text-slate-350"
                  >
                    <option value="">-- Choose Target Roadmap --</option>
                    {roadmaps.map((r: any) => (
                      <option key={r.id} value={r.id}>{r.title} (Sem {r.semester})</option>
                    ))}
                  </select>
                  {phaseForm.formState.errors.roadmapId && (
                    <p className="text-xs text-red-500">{phaseForm.formState.errors.roadmapId.message}</p>
                  )}
                </div>

                <Input
                  label="Phase Name"
                  placeholder="e.g., Data Structures Foundations"
                  error={phaseForm.formState.errors.phaseName?.message}
                  {...phaseForm.register('phaseName')}
                />

                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Description
                  </label>
                  <textarea
                    placeholder="List bullet points / topics..."
                    {...phaseForm.register('description')}
                    className="w-full px-4 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none h-16 resize-none"
                  />
                </div>

                <div className="grid grid-cols-2 gap-4">
                  <Input
                    label="Est. Duration (Months)"
                    type="number"
                    error={phaseForm.formState.errors.durationMonths?.message}
                    {...phaseForm.register('durationMonths', { valueAsNumber: true })}
                  />

                  <Input
                    label="Phase Order Sequence"
                    type="number"
                    error={phaseForm.formState.errors.orderIndex?.message}
                    {...phaseForm.register('orderIndex', { valueAsNumber: true })}
                  />
                </div>

                <button
                  type="submit"
                  disabled={createPhaseMutation.isPending}
                  className="w-full inline-flex items-center justify-center gap-2 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-semibold text-xs transition-colors"
                >
                  Publish Phase
                </button>
              </form>
            </CardContent>
          </Card>
        </div>

        {/* Roadmap Preview lists */}
        <div className="lg:col-span-2 space-y-6">
          <Card>
            <CardHeader className="flex flex-row justify-between items-center px-6 py-4">
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <Settings className="h-4.5 w-4.5 text-brand-650" /> Milestones & Tracks Preview
              </CardTitle>
              {selectedRoadmapId && (
                <button
                  onClick={() => handleDeleteRoadmap(selectedRoadmapId)}
                  className="text-xs font-semibold text-red-500 hover:underline flex items-center gap-1"
                >
                  <Trash2 className="h-3.5 w-3.5" /> Delete Selected Roadmap
                </button>
              )}
            </CardHeader>
            <CardContent className="p-6">
              
              <div className="space-y-4">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-505 uppercase tracking-wide">
                    Choose a roadmap to view phases:
                  </label>
                  <select
                    value={selectedRoadmapId}
                    onChange={(e) => setSelectedRoadmapId(e.target.value)}
                    className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-bg text-sm focus:outline-none text-slate-700 dark:text-slate-350"
                  >
                    <option value="">-- Choose Roadmap Track from Directory --</option>
                    {roadmaps.map((r: any) => (
                      <option key={r.id} value={r.id}>{r.title} (Sem {r.semester} - {r.targetRoles?.join(', ')})</option>
                    ))}
                  </select>
                </div>

                {selectedRoadmapId ? (
                  loadingPhases ? (
                    <div className="flex items-center justify-center py-10 gap-2 text-slate-500 text-xs font-semibold">
                      <Loader2 className="h-4 w-4 animate-spin text-brand-600" /> Loading milestones...
                    </div>
                  ) : phases.length === 0 ? (
                    <div className="text-center py-10 text-slate-500 text-sm">
                      No learning phases added to this roadmap track. Publish your first phase on the bottom-left form!
                    </div>
                  ) : (
                    <div className="divide-y divide-slate-100 dark:divide-zinc-800/60 mt-4 border border-slate-200/50 dark:border-zinc-800/65 rounded-xl overflow-hidden bg-slate-50/10 dark:bg-zinc-800/5">
                      {phases.map((p: any) => {
                        const isComms = p.phaseName.toLowerCase().includes('soft') || p.phaseName.toLowerCase().includes('communication');
                        return (
                          <div key={p.id} className="p-4 flex justify-between items-center gap-4 hover:bg-slate-50/20 dark:hover:bg-zinc-800/10 transition-colors">
                            <div className="min-w-0 space-y-1">
                              <div className="flex items-center gap-2 flex-wrap">
                                <span className="text-xs font-bold text-slate-400">Phase #{p.orderIndex}</span>
                                <span className="font-semibold text-sm text-slate-800 dark:text-slate-200 truncate">
                                  {p.phaseName}
                                </span>
                                <Badge variant={isComms ? 'success' : 'brand'} className="text-[8px] tracking-wider py-0 leading-none">
                                  {p.durationMonths} {p.durationMonths === 1 ? 'Month' : 'Months'}
                                </Badge>
                              </div>
                              <p className="text-xs text-slate-450 line-clamp-1 leading-normal">
                                {p.description}
                              </p>
                            </div>

                            <button
                              onClick={() => handleDeletePhase(p.id)}
                              className="text-red-500 hover:text-red-700 p-2 hover:bg-red-50 dark:hover:bg-red-950/20 rounded-xl transition-colors shrink-0"
                            >
                              <Trash2 className="h-4.5 w-4.5" />
                            </button>
                          </div>
                        );
                      })}
                    </div>
                  )
                ) : (
                  <div className="text-center py-12 text-slate-400 text-sm">
                    Select a roadmap from the dropdown selector to preview or manage its phase milestones.
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
export default ManageRoadmapsPage;
