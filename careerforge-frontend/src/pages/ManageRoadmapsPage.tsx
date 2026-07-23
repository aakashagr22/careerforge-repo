import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm, Controller } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { adminService } from '../services/adminService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { Select } from '../components/Select';
import { 
  Compass, Plus, Trash2, Loader2, Settings, 
  X, Save
} from 'lucide-react';



const roadmapSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().max(250).optional().or(zod.literal('')),
  targetRoles: zod.array(zod.enum(['SDE', 'FULL_STACK', 'AI_ML', 'DATA_SCIENTIST'])).min(1, 'Select at least one role'),
  semester: zod.number().min(1, 'Semester must be 1-8').max(8),
  monthsRemaining: zod.number().min(1, 'Months remaining must be at least 1'),
});

const sectionSchema = zod.object({
  roadmapId: zod.string().min(1, 'Please select a parent roadmap'),
  parentId: zod.string().optional(),
  title: zod.string().min(1, 'Section title is required').max(100),
  position: zod.number().min(0, 'Position must be positive'),
});

const questionFormSchema = zod.object({
  title: zod.string().min(1, 'Title is required').max(100),
  description: zod.string().max(250).optional().or(zod.literal('')),
  difficulty: zod.enum(['BEGINNER', 'EASY', 'MEDIUM', 'HARD', 'ADVANCED']),
  solveUrl: zod.string().url('Must be a valid URL').min(1, 'Solve link is required'),
  videoUrl: zod.string().url('Must be a valid URL').optional().or(zod.literal('')),
  articleUrl: zod.string().url('Must be a valid URL').optional().or(zod.literal('')),
  practiceUrl: zod.string().url('Must be a valid URL').optional().or(zod.literal('')),
});

type RoadmapFormValues = zod.infer<typeof roadmapSchema>;
type SectionFormValues = zod.infer<typeof sectionSchema>;
type QuestionFormValues = zod.infer<typeof questionFormSchema>;

export const ManageRoadmapsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [selectedRoadmapId, setSelectedRoadmapId] = useState<string>('');
  const [assigningToSectionId, setAssigningToSectionId] = useState<string | null>(null);
  const [savingQuestion, setSavingQuestion] = useState(false);

  // Fetch all roadmaps
  const { data: roadmapPage } = useQuery({
    queryKey: ['adminRoadmaps'],
    queryFn: () => adminService.getAllRoadmaps(0, 100),
  });

  // Fetch sections tree of the selected roadmap
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

  const questionForm = useForm<QuestionFormValues>({
    resolver: zodResolver(questionFormSchema),
    defaultValues: { title: '', description: '', difficulty: 'EASY', solveUrl: '', videoUrl: '', articleUrl: '', practiceUrl: '' }
  });

  // Sync selectedRoadmapId with sectionForm's roadmapId
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

  // Seed Sample DSA Mutation
  const seedDsaMutation = useMutation({
    mutationFn: adminService.seedRoadmapDsa,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Sample DSA hierarchical roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed sample DSA data.');
    }
  });

  const handleSeedSampleDsa = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedDsaMutation.mutate(id);
    }
  };

  // Seed Spring Boot Mutation
  const seedSpringBootMutation = useMutation({
    mutationFn: adminService.seedRoadmapSpringBoot,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Spring Boot Prep roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed Spring Boot Prep data.');
    }
  });

  const handleSeedSpringBoot = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedSpringBootMutation.mutate(id);
    }
  };

  // Seed MERN Stack Mutation
  const seedMernMutation = useMutation({
    mutationFn: adminService.seedRoadmapMern,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('MERN Stack roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed MERN Stack data.');
    }
  });

  const handleSeedMern = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedMernMutation.mutate(id);
    }
  };

  // Seed FastAPI Mutation
  const seedFastApiMutation = useMutation({
    mutationFn: adminService.seedRoadmapFastApi,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Python FastAPI roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed Python FastAPI data.');
    }
  });

  const handleSeedFastApi = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedFastApiMutation.mutate(id);
    }
  };

  // Seed Frontend Mutation
  const seedFrontendMutation = useMutation({
    mutationFn: adminService.seedRoadmapFrontend,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Frontend (React) roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed Frontend React data.');
    }
  });

  const handleSeedFrontend = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedFrontendMutation.mutate(id);
    }
  };

  // Seed AI/ML Mutation
  const seedAiMlMutation = useMutation({
    mutationFn: adminService.seedRoadmapAiMl,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('AI/ML Prep roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed AI/ML data.');
    }
  });

  const handleSeedAiMl = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedAiMlMutation.mutate(id);
    }
  };

  // Seed Data Scientist Mutation
  const seedDataScientistMutation = useMutation({
    mutationFn: adminService.seedRoadmapDataScientist,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Data Scientist roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed Data Scientist data.');
    }
  });

  const handleSeedDataScientist = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedDataScientistMutation.mutate(id);
    }
  };

  // Seed Java Mutation
  const seedJavaMutation = useMutation({
    mutationFn: adminService.seedRoadmapJava,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Java Master Sheet roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed Java Master data.');
    }
  });

  const handleSeedJava = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedJavaMutation.mutate(id);
    }
  };

  // Seed Python Mutation
  const seedPythonMutation = useMutation({
    mutationFn: adminService.seedRoadmapPython,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Python Master Sheet roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed Python Master data.');
    }
  });

  const handleSeedPython = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedPythonMutation.mutate(id);
    }
  };

  // Seed C++ Mutation
  const seedCppMutation = useMutation({
    mutationFn: adminService.seedRoadmapCpp,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('C++ Master Sheet roadmap seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed C++ Master data.');
    }
  });

  const handleSeedCpp = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedCppMutation.mutate(id);
    }
  };

  // Seed TLE CP-31 Sheet Mutation
  const seedCpSheetMutation = useMutation({
    mutationFn: adminService.seedRoadmapCpSheet,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('TLE Eliminators CP-31 Sheet seeded successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to seed TLE CP-31 Sheet data.');
    }
  });

  const handleSeedCpSheet = (id: string) => {
    if (window.confirm('WARNING: Seeding will clear all existing sections on this roadmap track. Proceed?')) {
      seedCpSheetMutation.mutate(id);
    }
  };



  // Create Section Mutation
  const createSectionMutation = useMutation({
    mutationFn: adminService.createRoadmapSection,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      sectionForm.reset({
        roadmapId: selectedRoadmapId,
        parentId: '',
        title: '',
        position: flatSectionsList.length,
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

  // Unassign Question Mutation
  const removeQuestionMutation = useMutation({
    mutationFn: adminService.removeQuestionFromSection,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
      toast.success('Question unassigned successfully.');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to unassign question.');
    }
  });

  const onRoadmapSubmit = (values: RoadmapFormValues) => {
    createRoadmapMutation.mutate(values);
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
    if (window.confirm('Delete this roadmap section and all problems attached to it?')) {
      deleteSectionMutation.mutate(id);
    }
  };

  const handleRemoveQuestion = (sectionQuestionId: string) => {
    if (window.confirm('Are you sure you want to remove this problem from the section?')) {
      removeQuestionMutation.mutate(sectionQuestionId);
    }
  };

  const onQuestionSubmit = async (values: QuestionFormValues) => {
    if (!assigningToSectionId) return;

    setSavingQuestion(true);
    try {
      // 1. Create canonical question
      const question = await adminService.createQuestion({
        title: values.title,
        description: values.description,
        difficulty: values.difficulty,
      });

      // 2. Add Links
      if (values.solveUrl) {
        await adminService.createQuestionLink(question.id, {
          linkType: 'SOLVE',
          label: 'Solve',
          url: values.solveUrl,
          position: 0,
        });
      }
      if (values.videoUrl) {
        await adminService.createQuestionLink(question.id, {
          linkType: 'VIDEO',
          label: 'Video Solution',
          url: values.videoUrl,
          position: 1,
        });
      }
      if (values.articleUrl) {
        await adminService.createQuestionLink(question.id, {
          linkType: 'ARTICLE',
          label: 'Article Tutorial',
          url: values.articleUrl,
          position: 2,
        });
      }
      if (values.practiceUrl) {
        await adminService.createQuestionLink(question.id, {
          linkType: 'PRACTICE',
          label: 'Practice Link',
          url: values.practiceUrl,
          position: 3,
        });
      }

      // 3. Assign Question to Section
      await adminService.assignQuestionToSection(assigningToSectionId, {
        questionId: question.id,
        position: 0,
      });

      toast.success('Problem added and assigned successfully!');
      setAssigningToSectionId(null);
      questionForm.reset();
      queryClient.invalidateQueries({ queryKey: ['adminRoadmapSections', selectedRoadmapId] });
    } catch (err: any) {
      toast.error(err.response?.data?.message || 'Failed to build question hierarchy.');
    } finally {
      setSavingQuestion(false);
    }
  };

  function flattenSections(nodes: any[]): any[] {
    const list: any[] = [];
    const recurse = (arr: any[], depth = 0) => {
      for (const n of arr) {
        list.push({ ...n, depth });
        if (n.children && n.children.length > 0) {
          recurse(n.children, depth + 1);
        }
      }
    };
    recurse(nodes);
    return list;
  }

  const roadmaps = roadmapPage?.content || [];
  const flatSectionsList = flattenSections(sections);

  return (
    <div className="space-y-8 max-w-5xl mx-auto pb-12">
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <Compass className="h-7 w-7 text-rose-650" /> Configure Curriculum Roadmaps
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Define semester-wise milestones, target paths, hierarchical learning sections, and attach preparation sheets.
        </p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
        
        {/* Left Forms column */}
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
                      { value: 'AI_ML', label: 'AI / ML' },
                      { value: 'DATA_SCIENTIST', label: 'Data Scientist' }
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
                  {createRoadmapMutation.isPending && <Loader2 className="h-4 w-4 animate-spin" />}
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
                <Controller
                  control={sectionForm.control}
                  name="roadmapId"
                  render={({ field }) => (
                    <Select
                      label="Select Target Roadmap"
                      options={roadmaps.map((r: any) => ({ value: r.id, label: `${r.title} (Sem ${r.semester})` }))}
                      value={field.value || ''}
                      onChange={(val) => {
                        field.onChange(val);
                        setSelectedRoadmapId(val);
                      }}
                      placeholder="-- Choose Target Roadmap --"
                      className="w-full text-left"
                    />
                  )}
                />
                {sectionForm.formState.errors.roadmapId && (
                  <p className="text-xs text-red-500 mt-1">{sectionForm.formState.errors.roadmapId.message}</p>
                )}

                <Controller
                  control={sectionForm.control}
                  name="parentId"
                  render={({ field }) => (
                    <Select
                      label="Select Parent Section (Optional)"
                      options={flatSectionsList.map((sec: any) => ({
                        value: sec.id,
                        label: `${'- '.repeat(sec.depth)}${sec.title}`
                      }))}
                      value={field.value || ''}
                      onChange={field.onChange}
                      placeholder="-- Root Section (No Parent) --"
                      className="w-full text-left"
                    />
                  )}
                />

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
                  {createSectionMutation.isPending && <Loader2 className="h-4 w-4 animate-spin" />}
                  Publish Section
                </button>
              </form>
            </CardContent>
          </Card>
        </div>

        {/* Roadmap Preview list & Hierarchical Preview */}
        <div className="lg:col-span-2 space-y-6">
          <Card>
            <CardHeader className="flex flex-row justify-between items-center px-6 py-4 flex-wrap gap-3">
              <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
                <Settings className="h-4.5 w-4.5 text-brand-650" /> Sections & Tracks Preview
              </CardTitle>
              {selectedRoadmapId && (
                <div className="flex items-center gap-3 flex-wrap">
                  <div className="flex items-center gap-2">
                    <select
                      id="template-seed-select"
                      className="px-3 py-1.5 rounded-xl border border-slate-300 dark:border-zinc-700 bg-white dark:bg-zinc-900 text-slate-800 dark:text-slate-200 text-xs font-semibold focus:outline-none focus:ring-2 focus:ring-brand-500"
                      defaultValue=""
                      onChange={(e) => {
                        const val = e.target.value;
                        if (!val) return;
                        if (val === 'dsa') handleSeedSampleDsa(selectedRoadmapId);
                        if (val === 'cpsheet') handleSeedCpSheet(selectedRoadmapId);
                        if (val === 'java') handleSeedJava(selectedRoadmapId);
                        if (val === 'python') handleSeedPython(selectedRoadmapId);
                        if (val === 'cpp') handleSeedCpp(selectedRoadmapId);
                        if (val === 'springboot') handleSeedSpringBoot(selectedRoadmapId);
                        if (val === 'fastapi') handleSeedFastApi(selectedRoadmapId);
                        if (val === 'mern') handleSeedMern(selectedRoadmapId);
                        if (val === 'frontend') handleSeedFrontend(selectedRoadmapId);
                        if (val === 'aiml') handleSeedAiMl(selectedRoadmapId);
                        if (val === 'datascientist') handleSeedDataScientist(selectedRoadmapId);
                        e.target.value = '';
                      }}
                    >
                      <option value="" disabled>✨ Seed Roadmap Template...</option>
                      <option value="cpsheet">🏆 Seed TLE Eliminators CP-31 Sheet</option>
                      <option value="dsa">⚡ Seed DSA A2Z Sheet (Striver)</option>
                      <option value="cpp">⚡ Seed C++ Master Sheet (Love Babbar/Striver)</option>
                      <option value="python">⚡ Seed Python Master Sheet (CampusX/Krish Naik)</option>
                      <option value="java">⚡ Seed Java Master Sheet (Baeldung/Telusko)</option>
                      <option value="springboot">⚡ Seed Spring Boot Prep Sheet</option>
                      <option value="fastapi">⚡ Seed Python FastAPI Sheet</option>
                      <option value="mern">⚡ Seed MERN Stack Roadmap</option>
                      <option value="frontend">⚡ Seed Frontend (React) Roadmap</option>
                      <option value="aiml">⚡ Seed AI/ML Prep Roadmap</option>
                      <option value="datascientist">⚡ Seed Data Scientist Roadmap</option>

                    </select>
                  </div>

                  <button
                    onClick={() => handleDeleteRoadmap(selectedRoadmapId)}
                    className="text-xs font-semibold text-red-500 hover:text-red-700 hover:underline flex items-center gap-1"
                  >
                    <Trash2 className="h-3.5 w-3.5" /> Delete Roadmap
                  </button>
                </div>
              )}

            </CardHeader>
            <CardContent className="p-6">
              
              <div className="space-y-4">
                  <Select
                    label="Choose a roadmap to view sections:"
                    options={roadmaps.map((r: any) => ({
                      value: r.id,
                      label: `${r.title} (Sem ${r.semester} - ${r.targetRoles?.join(', ')})`
                    }))}
                    value={selectedRoadmapId}
                    onChange={(val) => setSelectedRoadmapId(val)}
                    placeholder="-- Choose Roadmap Track from Directory --"
                    className="w-full text-left"
                  />

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
                          <div key={p.id} className="p-4 hover:bg-slate-50/20 dark:hover:bg-zinc-800/10 transition-colors">
                            <div className="flex justify-between items-center gap-4">
                              <div className="min-w-0 flex items-center gap-2">
                                <span className="text-[10px] font-bold text-slate-400">Pos #{p.position}</span>
                                <span 
                                  style={{ paddingLeft: `${p.depth * 16}px` }}
                                  className="font-semibold text-sm text-slate-800 dark:text-slate-200 flex items-center gap-1.5"
                                >
                                  {p.depth > 0 && <span className="text-slate-400">↳</span>}
                                  {p.title}
                                </span>
                              </div>

                              <div className="flex items-center gap-3 shrink-0">
                                <button
                                  onClick={() => setAssigningToSectionId(p.id)}
                                  className="text-xs font-bold text-brand-600 hover:text-brand-700 hover:underline flex items-center gap-1"
                                >
                                  <Plus className="h-3 w-3" /> Add Problem
                                </button>
                                <button
                                  onClick={() => handleDeleteSection(p.id)}
                                  className="text-red-500 hover:text-red-700 p-1 rounded transition-colors"
                                  title="Delete Section"
                                >
                                  <Trash2 className="h-4.5 w-4.5" />
                                </button>
                              </div>
                            </div>

                            {/* Render Attached Questions List */}
                            {p.questions && p.questions.length > 0 && (
                              <div className="mt-2.5 space-y-1.5 pl-6 md:pl-8">
                                <span className="text-[9px] font-bold text-slate-400 uppercase tracking-wider block">Assigned Problems:</span>
                                {p.questions.map((q: any) => (
                                  <div key={q.sectionQuestionId} className="flex items-center justify-between bg-slate-100/40 dark:bg-zinc-800/20 px-3 py-2 rounded-xl border border-slate-200/20">
                                    <div className="flex items-center gap-2 text-xs">
                                      <span className="font-semibold text-slate-700 dark:text-slate-300">{q.title}</span>
                                      <span className={`text-[9px] font-bold px-1.5 py-0.5 rounded uppercase ${
                                        q.difficulty === 'BEGINNER' || q.difficulty === 'EASY'
                                          ? 'bg-emerald-50 text-emerald-600 dark:bg-emerald-950/20'
                                          : q.difficulty === 'MEDIUM'
                                          ? 'bg-amber-50 text-amber-600 dark:bg-amber-950/20'
                                          : 'bg-red-50 text-red-600 dark:bg-red-950/20'
                                      }`}>
                                        {q.difficulty}
                                      </span>
                                    </div>
                                    <button
                                      onClick={() => handleRemoveQuestion(q.sectionQuestionId)}
                                      className="text-[10px] font-bold text-red-500 hover:underline"
                                    >
                                      Remove
                                    </button>
                                  </div>
                                ))}
                              </div>
                            )}
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

      {/* Add Question to Section Modal Overlay */}
      {assigningToSectionId && (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/60 backdrop-blur-sm p-4">
          <Card className="w-full max-w-lg shadow-2xl">
            <CardHeader className="flex flex-row justify-between items-center">
              <div>
                <CardTitle className="text-sm font-bold uppercase tracking-wider">
                  Add Coding Problem to Section
                </CardTitle>
                <p className="text-[10px] text-slate-500 mt-0.5">
                  Creates a canonical question and attaches study links to populate the learning checklist.
                </p>
              </div>
              <button
                onClick={() => setAssigningToSectionId(null)}
                className="text-slate-400 hover:text-slate-650 transition-colors"
              >
                <X className="h-5 w-5" />
              </button>
            </CardHeader>
            <CardContent className="p-6">
              <form onSubmit={questionForm.handleSubmit(onQuestionSubmit)} className="space-y-4">
                <Input
                  label="Problem Title"
                  placeholder="e.g. Find Prime Factors of N"
                  error={questionForm.formState.errors.title?.message}
                  {...questionForm.register('title')}
                />

                <Input
                  label="Description / Instructions"
                  placeholder="e.g. Optimize algorithm to run in O(sqrt(N)) time complexity."
                  error={questionForm.formState.errors.description?.message}
                  {...questionForm.register('description')}
                />

                <Controller
                  control={questionForm.control}
                  name="difficulty"
                  render={({ field }) => (
                    <Select
                      label="Difficulty Level"
                      options={[
                        { value: 'BEGINNER', label: 'Beginner' },
                        { value: 'EASY', label: 'Easy' },
                        { value: 'MEDIUM', label: 'Medium' },
                        { value: 'HARD', label: 'Hard' },
                        { value: 'ADVANCED', label: 'Advanced' }
                      ]}
                      value={field.value}
                      onChange={field.onChange}
                      className="w-full text-left"
                    />
                  )}
                />

                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  <Input
                    label="Solve Link URL (LeetCode/GFG)"
                    placeholder="https://leetcode.com/problems/..."
                    error={questionForm.formState.errors.solveUrl?.message}
                    {...questionForm.register('solveUrl')}
                  />
                  <Input
                    label="Video Solution URL"
                    placeholder="https://youtube.com/watch?v=..."
                    error={questionForm.formState.errors.videoUrl?.message}
                    {...questionForm.register('videoUrl')}
                  />
                </div>

                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  <Input
                    label="Article Tutorial URL"
                    placeholder="https://takeuforward.org/..."
                    error={questionForm.formState.errors.articleUrl?.message}
                    {...questionForm.register('articleUrl')}
                  />
                  <Input
                    label="Practice/Sandbox URL"
                    placeholder="https://ide.geeksforgeeks.org/..."
                    error={questionForm.formState.errors.practiceUrl?.message}
                    {...questionForm.register('practiceUrl')}
                  />
                </div>

                <div className="flex justify-end gap-3 pt-2">
                  <button
                    type="button"
                    onClick={() => setAssigningToSectionId(null)}
                    className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl text-xs font-semibold hover:bg-slate-50 dark:hover:bg-zinc-800/40 text-slate-700 dark:text-slate-350"
                  >
                    Cancel
                  </button>
                  <button
                    type="submit"
                    disabled={savingQuestion}
                    className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-5 py-2 rounded-xl text-xs font-bold disabled:opacity-75"
                  >
                    {savingQuestion ? (
                      <Loader2 className="h-3.5 w-3.5 animate-spin" />
                    ) : (
                      <Save className="h-3.5 w-3.5" />
                    )}
                    Save and Assign
                  </button>
                </div>
              </form>
            </CardContent>
          </Card>
        </div>
      )}
    </div>
  );
};
export default ManageRoadmapsPage;
