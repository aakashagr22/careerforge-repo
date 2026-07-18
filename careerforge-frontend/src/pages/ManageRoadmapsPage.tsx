import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { adminService } from '../services/adminService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { Compass, Plus, Trash2, Loader2, Settings } from 'lucide-react';

const roadmapSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().max(250).optional().or(zod.literal('')),
  targetRoles: zod.array(zod.enum(['SDE', 'FULL_STACK', 'WEB_DEVELOPER', 'AI_ML', 'DEVOPS'])).min(1, 'Select at least one role'),
  semester: zod.number().min(1, 'Semester must be 1-8').max(8),
  monthsRemaining: zod.number().min(1, 'Months remaining must be at least 1'),
});

const sectionSchema = zod.object({
  roadmapId: zod.string().min(1, 'Please select a parent roadmap'),
  parentId: zod.string().optional(),
  title: zod.string().min(1, 'Section title is required').max(100),
  position: zod.number().min(0, 'Position must be positive'),
});

type RoadmapFormValues = zod.infer<typeof roadmapSchema>;
type SectionFormValues = zod.infer<typeof sectionSchema>;

export const ManageRoadmapsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [selectedRoadmapId, setSelectedRoadmapId] = useState<string>('');

  // Fetch all roadmaps (paginated query, set 0 page size 100 for admin fetch)
  const { data: roadmapPage } = useQuery({
    queryKey: ['adminRoadmaps'],
    queryFn: () => adminService.getAllRoadmaps(0, 100),
  });

  // Fetch sections of the selected roadmap
  const { data: sections = [], isLoading: loadingSections } = useQuery({
    queryKey: ['adminRoadmapSections', selectedRoadmapId],
    queryFn: () => adminService.getRoadmapSectionsTree(selectedRoadmapId),
    enabled: !!selectedRoadmapId,
  });

  // React Hook Forms
  const roadmapForm = useForm<RoadmapFormValues>({
    resolver: zodResolver(roadmapSchema) as any,
    defaultValues: { title: '', description: '', targetRoles: [], semester: 5, monthsRemaining: 6 }
  });

  const sectionForm = useForm<SectionFormValues>({
    resolver: zodResolver(sectionSchema),
    defaultValues: { roadmapId: '', parentId: '', title: '', position: 0 }
  });

  // Sync selectedRoadmapId with sectionForm's roadmapId to keep both dropdowns synchronized
  React.useEffect(() => {
    sectionForm.setValue('roadmapId', selectedRoadmapId, { shouldValidate: true });
  }, [selectedRoadmapId, sectionForm]);


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

  // Create Section Mutation
  const createSectionMutation = useMutation({
    mutationFn: adminService.createRoadmapSection,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      sectionForm.reset({
        roadmapId: selectedRoadmapId,
        parentId: '',
        title: '',
        position: flattenSections(sections).length,
      });
      toast.success('Roadmap section added!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to add roadmap section.');
    }
  });

  // Delete Section Mutation
  const deleteSectionMutation = useMutation({
    mutationFn: adminService.deleteRoadmapSection,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Section deleted successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to delete section.');
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

  const onSectionSubmit = (values: SectionFormValues) => {
    const payload = {
      roadmapId: values.roadmapId,
      parentId: values.parentId || null,
      title: values.title,
      position: values.position,
    };
    createSectionMutation.mutate(payload);
  };

  const handleDeleteRoadmap = (id: string) => {
    if (window.confirm('Delete this roadmap and all nested sections inside it?')) {
      deleteRoadmapMutation.mutate(id);
    }
  };

  const handleDeleteSection = (id: string) => {
    if (window.confirm('Delete this roadmap section?')) {
      deleteSectionMutation.mutate(id);
    }
  };

  function flattenSections(nodes: any[]): any[] {
    const list: any[] = [];
    const recurse = (arr: any[]) => {
      for (const n of arr) {
        list.push(n);
        if (n.children && n.children.length > 0) {
          recurse(n.children);
        }
      }
    };
    recurse(nodes);
    return list;
  }

  const roadmaps = roadmapPage?.content || [];
  const flatSectionsList = flattenSections(sections);

  return (
    <div className="space-y-8 max-w-5xl mx-auto">
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <Compass className="h-7 w-7 text-rose-650" /> Configure Curriculum Roadmaps
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Define semester-wise milestones, target paths, or hierarchical learning sections.
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

          {/* Create Section Form */}
          <Card>
            <CardHeader>
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <Plus className="h-4.5 w-4.5 text-brand-650" /> Add Roadmap Section
              </CardTitle>
            </CardHeader>
            <CardContent className="p-5">
              <form onSubmit={sectionForm.handleSubmit(onSectionSubmit)} className="space-y-4">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Select Target Roadmap
                  </label>
                  <select
                    {...sectionForm.register('roadmapId', {
                      onChange: (e) => {
                        setSelectedRoadmapId(e.target.value);
                      }
                    })}
                    value={sectionForm.watch('roadmapId')}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none text-slate-750 dark:text-slate-350"
                  >
                    <option value="">-- Choose Target Roadmap --</option>
                    {roadmaps.map((r: any) => (
                      <option key={r.id} value={r.id}>{r.title} (Sem {r.semester})</option>
                    ))}
                  </select>
                  {sectionForm.formState.errors.roadmapId && (
                    <p className="text-xs text-red-500">{sectionForm.formState.errors.roadmapId.message}</p>
                  )}
                </div>

                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Select Parent Section (Optional)
                  </label>
                  <select
                    {...sectionForm.register('parentId')}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none text-slate-750 dark:text-slate-350"
                  >
                    <option value="">-- Root Section (No Parent) --</option>
                    {flatSectionsList.map((sec: any) => (
                      <option key={sec.id} value={sec.id}>{sec.title}</option>
                    ))}
                  </select>
                </div>

                <Input
                  label="Section Title"
                  placeholder="e.g., Data Structures Foundations"
                  error={sectionForm.formState.errors.title?.message}
                  {...sectionForm.register('title')}
                />


                <Input
                  label="Position Sequence"
                  type="number"
                  error={sectionForm.formState.errors.position?.message}
                  {...sectionForm.register('position', { valueAsNumber: true })}
                />

                <button
                  type="submit"
                  disabled={createSectionMutation.isPending}
                  className="w-full inline-flex items-center justify-center gap-2 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-semibold text-xs transition-colors"
                >
                  Publish Section
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
                <Settings className="h-4.5 w-4.5 text-brand-650" /> Sections & Tracks Preview
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
                  <label className="block text-xs font-semibold text-slate-500 uppercase tracking-wide">
                    Choose a roadmap to view sections:
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
                  loadingSections ? (
                    <div className="flex items-center justify-center py-10 gap-2 text-slate-500 text-xs font-semibold">
                      <Loader2 className="h-4 w-4 animate-spin text-brand-600" /> Loading sections...
                    </div>
                  ) : flatSectionsList.length === 0 ? (
                    <div className="text-center py-10 text-slate-500 text-sm">
                      No learning sections added to this roadmap track. Publish your first section on the bottom-left form!
                    </div>
                  ) : (
                    <div className="divide-y divide-slate-100 dark:divide-zinc-800/60 mt-4 border border-slate-200/50 dark:border-zinc-800/65 rounded-xl overflow-hidden bg-slate-50/10 dark:bg-zinc-800/5">
                      {flatSectionsList.map((p: any) => {
                        return (
                          <div key={p.id} className="p-4 flex justify-between items-center gap-4 hover:bg-slate-50/20 dark:hover:bg-zinc-800/10 transition-colors">
                            <div className="min-w-0 space-y-1">
                              <div className="flex items-center gap-2 flex-wrap">
                                <span className="text-xs font-bold text-slate-400">Position #{p.position}</span>
                                <span className="font-semibold text-sm text-slate-800 dark:text-slate-200 truncate">
                                  {p.title}
                                </span>
                              </div>

                            </div>

                            <button
                              onClick={() => handleDeleteSection(p.id)}
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
                    Select a roadmap from the dropdown selector to preview or manage its section milestones.
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
