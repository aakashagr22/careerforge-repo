import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { studentService } from '../services/studentService';
import { roadmapService } from '../services/roadmapService';
import { Card, CardContent } from '../components/Card';
import { Input } from '../components/Input';
import { Badge } from '../components/Badge';
import { 
  Milestone, Calendar, Award, Star, 
  Loader2, ChevronDown, ChevronRight, PlayCircle, 
  BookOpen, HelpCircle, FileCode2, ExternalLink, StickyNote, Save, X
} from 'lucide-react';
import { RoadmapSection, RoadmapSectionQuestion, PersonalizedRoadmapResponse } from '../types/roadmap';

const profileSetupSchema = zod.object({
  semester: zod.number().min(1, 'Semester must be between 1 and 8').max(8),
  branch: zod.string().min(1, 'Branch is required'),
  enrollmentNo: zod.string().min(1, 'Enrollment number is required'),
  preferredLanguage: zod.enum(['JAVA', 'CPP', 'PYTHON']),
  targetRole: zod.enum(['SDE', 'FULL_STACK', 'WEB_DEVELOPER', 'AI_ML', 'DEVOPS']),
});

type ProfileSetupValues = zod.infer<typeof profileSetupSchema>;

interface RoadmapSectionNodeProps {
  section: RoadmapSection;
  depth: number;
  onEditNote: (id: string, title: string, currentNote: string) => void;
  onToggleComplete: (id: string, currentVal: boolean) => void;
  onToggleRevision: (id: string, currentVal: boolean) => void;
}

const RoadmapSectionNode: React.FC<RoadmapSectionNodeProps> = ({
  section,
  depth,
  onEditNote,
  onToggleComplete,
  onToggleRevision,
}) => {
  const [isExpanded, setIsExpanded] = useState(false);
  const hasChildren = section.children && section.children.length > 0;
  const hasQuestions = section.questions && section.questions.length > 0;
  const isEmpty = !hasChildren && !hasQuestions;

  const getQuestionsCount = (node: RoadmapSection): { total: number; completed: number } => {
    let total = node.questions?.length || 0;
    let completed = node.questions?.filter(q => q.completed).length || 0;
    if (node.children) {
      for (const child of node.children) {
        const sub = getQuestionsCount(child);
        total += sub.total;
        completed += sub.completed;
      }
    }
    return { total, completed };
  };

  const count = getQuestionsCount(section);

  const headingClass = depth === 0 
    ? "text-sm md:text-base font-extrabold text-slate-800 dark:text-slate-100"
    : depth === 1
    ? "text-xs md:text-sm font-bold text-slate-700 dark:text-slate-300"
    : "text-xs font-semibold text-slate-600 dark:text-slate-400";

  return (
    <div className="w-full">
      <div
        onClick={() => !isEmpty && setIsExpanded(!isExpanded)}
        style={{ paddingLeft: `${16 + depth * 24}px` }}
        className={`flex items-center justify-between p-4 cursor-pointer select-none transition-all hover:bg-slate-50/50 dark:hover:bg-zinc-800/10 ${
          isExpanded ? 'bg-slate-50/30 dark:bg-zinc-900/5' : ''
        }`}
      >
        <div className="flex items-center gap-3">
          <div className="text-slate-450 shrink-0">
            {isEmpty ? (
              <HelpCircle className="h-4 w-4 text-slate-300" />
            ) : isExpanded ? (
              <ChevronDown className="h-4.5 w-4.5 text-slate-500" />
            ) : (
              <ChevronRight className="h-4.5 w-4.5 text-slate-500" />
            )}
          </div>
          <div>
            <h4 className={headingClass}>
              {section.title}
            </h4>
          </div>
        </div>

        {count.total > 0 && (
          <div className="flex items-center gap-3 text-xs shrink-0 ml-4">
            <span className="font-semibold text-slate-500">
              {count.completed} / {count.total} Solved
            </span>
            <div className="w-16 md:w-24 bg-slate-100 dark:bg-zinc-800 rounded-full h-1.5 overflow-hidden">
              <div
                className="bg-brand-600 h-1.5 rounded-full transition-all duration-300"
                style={{ width: `${(count.completed / count.total) * 100}%` }}
              />
            </div>
          </div>
        )}
      </div>

      {isExpanded && (
        <div className="w-full bg-slate-50/5 dark:bg-zinc-900/5 divide-y divide-slate-100 dark:divide-dark-border/20 border-t border-slate-200/50 dark:border-dark-border/40">
          {hasChildren && (
            <div className="divide-y divide-slate-100 dark:divide-dark-border/20">
              {section.children.map(child => (
                <RoadmapSectionNode
                  key={child.id}
                  section={child}
                  depth={depth + 1}
                  onEditNote={onEditNote}
                  onToggleComplete={onToggleComplete}
                  onToggleRevision={onToggleRevision}
                />
              ))}
            </div>
          )}

          {hasQuestions && (
            <div 
              style={{ paddingLeft: `${24 + depth * 24}px` }}
              className="p-4 overflow-x-auto"
            >
              <table className="w-full text-left border-collapse text-xs border border-slate-200/60 dark:border-dark-border/40 rounded-xl bg-white dark:bg-dark-card overflow-hidden">
                <thead>
                  <tr className="border-b border-slate-200/50 dark:border-dark-border/30 text-[10px] font-bold text-slate-550 uppercase tracking-wider bg-slate-100/50 dark:bg-zinc-800/20">
                    <th className="p-3.5 w-12 text-center">Status</th>
                    <th className="p-3.5 min-w-[200px]">Problem</th>
                    <th className="p-3.5 w-20 text-center">Solve</th>
                    <th className="p-3.5 w-16 text-center">Video</th>
                    <th className="p-3.5 w-16 text-center">Article</th>
                    <th className="p-3.5 w-16 text-center">Practice</th>
                    <th className="p-3.5 w-16 text-center">Note</th>
                    <th className="p-3.5 w-16 text-center">Revision</th>
                    <th className="p-3.5 w-20 text-center">Difficulty</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-slate-200/40 dark:divide-dark-border/20">
                  {section.questions.map((q) => {
                    const solveLink = q.links?.find(l => l.linkType === 'SOLVE');
                    const videoLink = q.links?.find(l => l.linkType === 'VIDEO');
                    const articleLink = q.links?.find(l => l.linkType === 'ARTICLE');
                    const practiceLink = q.links?.find(l => l.linkType === 'PRACTICE');

                    return (
                      <tr
                        key={q.sectionQuestionId}
                        className={`hover:bg-slate-50/40 dark:hover:bg-zinc-800/10 transition-colors ${
                          q.completed ? 'bg-emerald-500/5 dark:bg-emerald-950/5' : ''
                        }`}
                      >
                        <td className="p-3 text-center">
                          <input
                            type="checkbox"
                            checked={q.completed || false}
                            onChange={() => onToggleComplete(q.sectionQuestionId, q.completed || false)}
                            className="h-4 w-4 rounded border-slate-300 dark:border-zinc-700 text-brand-650 cursor-pointer focus:ring-brand-500"
                          />
                        </td>

                        <td className="p-3 font-semibold text-slate-800 dark:text-slate-200">
                          <div>
                            <span>{q.title}</span>
                            {q.description && (
                              <span className="block text-[10px] font-normal text-slate-450 mt-0.5 leading-relaxed">
                                {q.description}
                              </span>
                            )}
                          </div>
                        </td>

                        <td className="p-3 text-center">
                          {solveLink ? (
                            <a
                              href={solveLink.url}
                              target="_blank"
                              rel="noopener noreferrer"
                              className="inline-flex items-center gap-1 font-bold text-brand-600 dark:text-brand-400 hover:underline"
                            >
                              Solve <ExternalLink className="h-3 w-3" />
                            </a>
                          ) : (
                            <span className="text-slate-400">-</span>
                          )}
                        </td>

                        <td className="p-3 text-center">
                          {videoLink ? (
                            <a
                              href={videoLink.url}
                              target="_blank"
                              rel="noopener noreferrer"
                              className="text-red-500 hover:text-red-600 transition-colors inline-block"
                              title={videoLink.label || 'Watch Video'}
                            >
                              <PlayCircle className="h-5 w-5" />
                            </a>
                          ) : (
                            <span className="text-slate-400">-</span>
                          )}
                        </td>

                        <td className="p-3 text-center">
                          {articleLink ? (
                            <a
                              href={articleLink.url}
                              target="_blank"
                              rel="noopener noreferrer"
                              className="text-blue-500 hover:text-blue-600 transition-colors inline-block"
                              title={articleLink.label || 'Read Article'}
                            >
                              <BookOpen className="h-5 w-5" />
                            </a>
                          ) : (
                            <span className="text-slate-400">-</span>
                          )}
                        </td>

                        <td className="p-3 text-center">
                          {practiceLink ? (
                            <a
                              href={practiceLink.url}
                              target="_blank"
                              rel="noopener noreferrer"
                              className="text-emerald-500 hover:text-emerald-600 transition-colors inline-block"
                              title={practiceLink.label || 'Practice'}
                            >
                              <FileCode2 className="h-5 w-5" />
                            </a>
                          ) : (
                            <span className="text-slate-400">-</span>
                          )}
                        </td>

                        <td className="p-3 text-center">
                          <button
                            onClick={() => onEditNote(q.sectionQuestionId, q.title, q.note || '')}
                            className={`transition-colors relative ${
                              q.note
                                ? 'text-brand-650 hover:text-brand-700'
                                : 'text-slate-350 hover:text-slate-500'
                            }`}
                            title={q.note ? `Note: ${q.note}` : 'Add Note'}
                          >
                            <StickyNote className="h-5 w-5" />
                            {q.note && (
                              <span className="absolute -top-1 -right-1 h-2 w-2 rounded-full bg-brand-500" />
                            )}
                          </button>
                        </td>

                        <td className="p-3 text-center">
                          <button
                            onClick={() => onToggleRevision(q.sectionQuestionId, q.revisionMarked || false)}
                            className="transition-colors focus:outline-none"
                          >
                            <Star
                              className={`h-4.5 w-4.5 ${
                                q.revisionMarked
                                  ? 'fill-amber-400 text-amber-400'
                                  : 'text-slate-350 hover:text-amber-400'
                              }`}
                            />
                          </button>
                        </td>

                        <td className="p-3 text-center">
                          <span
                            className={`px-2 py-0.5 rounded text-[10px] font-extrabold ${
                              q.difficulty === 'BEGINNER' || q.difficulty === 'EASY'
                                ? 'bg-emerald-500/10 text-emerald-600 dark:bg-emerald-950/20 dark:text-emerald-400'
                                : q.difficulty === 'MEDIUM'
                                ? 'bg-amber-500/10 text-amber-600 dark:bg-amber-950/20 dark:text-amber-400'
                                : 'bg-red-500/10 text-red-600 dark:bg-red-950/20 dark:text-red-400'
                            }`}
                          >
                            {q.difficulty}
                          </span>
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
            </div>
          )}
        </div>
      )}
    </div>
  );
};

export const RoadmapPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [editingProfile, setEditingProfile] = useState(false);
  const [editingQuestionNote, setEditingQuestionNote] = useState<{ id: string; title: string; note: string } | null>(null);
  const [noteValue, setNoteValue] = useState('');

  const pendingUpdatesRef = React.useRef<Record<string, {
    timer: any;
    completed?: boolean;
    revisionMarked?: boolean;
    initialSnapshot: any;
  }>>({});

  React.useEffect(() => {
    return () => {
      Object.values(pendingUpdatesRef.current).forEach(pending => {
        window.clearTimeout(pending.timer);
      });
    };
  }, []);

  // Fetch Student Profile
  const { data: profile, isLoading: loadingProfile } = useQuery({
    queryKey: ['studentProfile'],
    queryFn: studentService.getMyProfile,
  });

  // Fetch Roadmap (only if profile is configured)
  const isProfileConfigured = !!(profile?.semester && profile?.preferredLanguage && profile?.targetRole);

  const { data: roadmapData, isLoading: loadingRoadmap, error: roadmapError } = useQuery({
    queryKey: ['studentRoadmap'],
    queryFn: roadmapService.getPersonalizedRoadmap,
    enabled: isProfileConfigured && !editingProfile,
  });

  const { register, handleSubmit, formState: { errors } } = useForm<ProfileSetupValues>({
    resolver: zodResolver(profileSetupSchema),
    values: profile ? {
      semester: profile.semester || 1,
      branch: profile.branch || '',
      enrollmentNo: profile.enrollmentNo || '',
      preferredLanguage: profile.preferredLanguage || 'JAVA',
      targetRole: profile.targetRole || 'SDE',
    } : undefined
  });

  // Mutation to update profile details
  const updateProfileMutation = useMutation({
    mutationFn: studentService.updateMyProfile,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['studentProfile'] });
      queryClient.invalidateQueries({ queryKey: ['studentRoadmap'] });
      setEditingProfile(false);
      toast.success('Preferences configured successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to update preferences.');
    }
  });

  // Helper: deep-clone sections and update a specific question's fields
  const updateQuestionInSections = (
    sections: RoadmapSection[],
    sectionQuestionId: string,
    updates: Partial<RoadmapSectionQuestion>
  ): RoadmapSection[] => {
    return sections.map(section => ({
      ...section,
      questions: section.questions?.map(q =>
        q.sectionQuestionId === sectionQuestionId ? { ...q, ...updates } : q
      ) || [],
      children: section.children
        ? updateQuestionInSections(section.children, sectionQuestionId, updates)
        : [],
    }));
  };

  // Helper: find a question in the hierarchical section tree
  const findQuestionInSections = (sections: RoadmapSection[], sectionQuestionId: string): RoadmapSectionQuestion | null => {
    for (const section of sections) {
      const found = section.questions?.find(q => q.sectionQuestionId === sectionQuestionId);
      if (found) return found;
      if (section.children) {
        const subFound = findQuestionInSections(section.children, sectionQuestionId);
        if (subFound) return subFound;
      }
    }
    return null;
  };

  // Mutation for checkbox/revision toggles — optimistic, no toasts
  const toggleProgressMutation = useMutation({
    mutationFn: ({ id, completed, revisionMarked }: { id: string; completed?: boolean; revisionMarked?: boolean; initialSnapshot?: any }) =>
      roadmapService.updateQuestionProgress(id, { completed, revisionMarked }),
    onMutate: async ({ initialSnapshot }) => {
      // Cancel any outgoing refetches so they don't overwrite our optimistic update
      await queryClient.cancelQueries({ queryKey: ['studentRoadmap'] });
      return { previousData: initialSnapshot };
    },
    onError: (_err, _vars, context: any) => {
      // Roll back to the snapshot before this batch of toggles on error
      if (context?.previousData) {
        queryClient.setQueryData(['studentRoadmap'], context.previousData);
      }
      toast.error('Failed to sync progress with the server.');
    },
    onSettled: () => {
      // Re-sync with server in background (silent)
      queryClient.invalidateQueries({ queryKey: ['studentRoadmap'] });
    },
  });

  // Mutation for saving notes — keeps toast since it's an explicit user action with a modal
  const saveNoteMutation = useMutation({
    mutationFn: ({ id, note }: { id: string; note: string }) =>
      roadmapService.updateQuestionProgress(id, { note }),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['studentRoadmap'] });
      setEditingQuestionNote(null);
    },
    onError: (err: any) => {
      toast.error(err.response?.data?.message || 'Failed to save note.');
    }
  });

  const onSubmit = (values: ProfileSetupValues) => {
    updateProfileMutation.mutate({
      ...values,
      firstName: profile?.firstName || '',
      lastName: profile?.lastName || '',
      section: profile?.section || '',
    });
  };

  const handleToggleComplete = (id: string, currentVal: boolean) => {
    const newVal = !currentVal;

    // 1. Instantly update UI cache
    queryClient.setQueryData<PersonalizedRoadmapResponse>(['studentRoadmap'], (old) => {
      if (!old) return old;
      return {
        ...old,
        sections: updateQuestionInSections(old.sections, id, { completed: newVal })
      };
    });

    // 2. Debounce backend API request
    const prevPending = pendingUpdatesRef.current[id];
    if (prevPending) {
      window.clearTimeout(prevPending.timer);
    }

    const initialSnapshot = prevPending ? prevPending.initialSnapshot : queryClient.getQueryData<PersonalizedRoadmapResponse>(['studentRoadmap']);
    const initialQuestion = findQuestionInSections(initialSnapshot?.sections || [], id);

    const mergedCompleted = newVal;
    const mergedRevision = prevPending && prevPending.revisionMarked !== undefined
      ? prevPending.revisionMarked
      : initialQuestion?.revisionMarked;

    const timer = window.setTimeout(() => {
      toggleProgressMutation.mutate({ id, completed: mergedCompleted, revisionMarked: mergedRevision, initialSnapshot });
      delete pendingUpdatesRef.current[id];
    }, 500);

    pendingUpdatesRef.current[id] = {
      timer,
      completed: mergedCompleted,
      revisionMarked: mergedRevision,
      initialSnapshot
    };
  };

  const handleToggleRevision = (id: string, currentVal: boolean) => {
    const newVal = !currentVal;

    // 1. Instantly update UI cache
    queryClient.setQueryData<PersonalizedRoadmapResponse>(['studentRoadmap'], (old) => {
      if (!old) return old;
      return {
        ...old,
        sections: updateQuestionInSections(old.sections, id, { revisionMarked: newVal })
      };
    });

    // 2. Debounce backend API request
    const prevPending = pendingUpdatesRef.current[id];
    if (prevPending) {
      window.clearTimeout(prevPending.timer);
    }

    const initialSnapshot = prevPending ? prevPending.initialSnapshot : queryClient.getQueryData<PersonalizedRoadmapResponse>(['studentRoadmap']);
    const initialQuestion = findQuestionInSections(initialSnapshot?.sections || [], id);

    const mergedCompleted = prevPending && prevPending.completed !== undefined
      ? prevPending.completed
      : initialQuestion?.completed;
    const mergedRevision = newVal;

    const timer = window.setTimeout(() => {
      toggleProgressMutation.mutate({ id, completed: mergedCompleted, revisionMarked: mergedRevision, initialSnapshot });
      delete pendingUpdatesRef.current[id];
    }, 500);

    pendingUpdatesRef.current[id] = {
      timer,
      completed: mergedCompleted,
      revisionMarked: mergedRevision,
      initialSnapshot
    };
  };

  const handleEditNoteClick = (id: string, title: string, currentNote: string) => {
    setEditingQuestionNote({ id, title, note: currentNote });
    setNoteValue(currentNote);
  };

  const handleSaveNote = () => {
    if (editingQuestionNote) {
      saveNoteMutation.mutate({ id: editingQuestionNote.id, note: noteValue });
    }
  };

  const getProgressStats = (sections: RoadmapSection[]) => {
    let total = 0;
    let completed = 0;
    let easyTotal = 0;
    let easyCompleted = 0;
    let mediumTotal = 0;
    let mediumCompleted = 0;
    let hardTotal = 0;
    let hardCompleted = 0;

    const recurse = (nodes: RoadmapSection[]) => {
      for (const n of nodes) {
        if (n.questions && n.questions.length > 0) {
          for (const q of n.questions) {
            total++;
            if (q.completed) completed++;

            const diff = q.difficulty || 'EASY';
            if (diff === 'BEGINNER' || diff === 'EASY') {
              easyTotal++;
              if (q.completed) easyCompleted++;
            } else if (diff === 'MEDIUM') {
              mediumTotal++;
              if (q.completed) mediumCompleted++;
            } else if (diff === 'HARD' || diff === 'ADVANCED') {
              hardTotal++;
              if (q.completed) hardCompleted++;
            }
          }
        }
        if (n.children && n.children.length > 0) {
          recurse(n.children);
        }
      }
    };

    recurse(sections);

    const percent = total > 0 ? Math.round((completed / total) * 100) : 0;
    return {
      total,
      completed,
      easyTotal,
      easyCompleted,
      mediumTotal,
      mediumCompleted,
      hardTotal,
      hardCompleted,
      percent,
    };
  };

  if (loadingProfile || (isProfileConfigured && loadingRoadmap)) {
    return (
      <div className="flex flex-col items-center justify-center py-32 gap-3 text-slate-500 font-semibold text-xs">
        <Loader2 className="h-5 w-5 animate-spin text-brand-650" /> Syncing with placement tracker...
      </div>
    );
  }

  if (!isProfileConfigured || editingProfile) {
    return (
      <div className="max-w-md mx-auto space-y-6">
        <div>
          <h1 className="text-2xl font-extrabold font-heading text-slate-800 dark:text-white">
            Setup Learning Path
          </h1>
          <p className="text-xs text-slate-500 mt-1">
            Choose your target roles and semester to align your curriculum benchmarks.
          </p>
        </div>

        <Card>
          <CardContent className="p-6">
            <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
              <div className="grid grid-cols-2 gap-4">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-500 uppercase tracking-wide">Target Semester</label>
                  <select
                    {...register('semester', { valueAsNumber: true })}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none"
                  >
                    {[1, 2, 3, 4, 5, 6, 7, 8].map(s => (
                      <option key={s} value={s}>Semester {s}</option>
                    ))}
                  </select>
                </div>

                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-500 uppercase tracking-wide">Preferred Lang</label>
                  <select
                    {...register('preferredLanguage')}
                    className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none"
                  >
                    <option value="JAVA">Java</option>
                    <option value="CPP">C++</option>
                    <option value="PYTHON">Python</option>
                  </select>
                </div>
              </div>

              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-500 uppercase tracking-wide">Target Domain Path</label>
                <select
                  {...register('targetRole')}
                  className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none"
                >
                  <option value="SDE">Software Development Engineer (SDE)</option>
                  <option value="FULL_STACK">Full Stack Developer</option>
                  <option value="WEB_DEVELOPER">Frontend / Web Specialist</option>
                  <option value="AI_ML">Artificial Intelligence / Machine Learning</option>
                  <option value="DEVOPS">DevOps & Cloud Infrastructure</option>
                </select>
              </div>

              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-500 uppercase tracking-wide">Engineering Branch</label>
                <select
                  {...register('branch')}
                  className="w-full px-3 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-xs focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
                >
                  <option value="Computer Science (CSE)">Computer Science (CSE)</option>
                  <option value="Information Technology (IT)">Information Technology (IT)</option>
                  <option value="Electronics and Communication Engineering (ECE)">Electronics and Communication Engineering (ECE)</option>
                  <option value="Electrical Engineering (EE)">Electrical Engineering (EE)</option>
                </select>
                {errors.branch && (
                  <p className="text-xs text-red-500 mt-1">{errors.branch.message}</p>
                )}
              </div>
              <Input label="Enrollment Number" placeholder="e.g. 0101CS201025" error={errors.enrollmentNo?.message} {...register('enrollmentNo')} />

              <button
                type="submit"
                disabled={updateProfileMutation.isPending}
                className="w-full inline-flex items-center justify-center gap-2 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2.5 rounded-xl font-bold text-xs transition-colors mt-2"
              >
                Save Preferences
              </button>
            </form>
          </CardContent>
        </Card>
      </div>
    );
  }

  const roadmap = roadmapData?.roadmap;
  const sections = roadmapData?.sections || [];
  const stats = getProgressStats(sections);

  if (!roadmap || roadmapError) {
    return (
      <div className="flex flex-col items-center justify-center py-20 text-center space-y-4">
        <div className="h-14 w-14 bg-amber-100 dark:bg-amber-950/20 text-amber-600 rounded-full flex items-center justify-center">
          <Milestone className="h-7 w-7" />
        </div>
        <h2 className="text-xl font-bold font-heading">No matching roadmap configured</h2>
        <p className="text-sm text-slate-500 max-w-md">
          There are currently no curriculum roadmaps matches configured for **{profile?.targetRole}** in **Semester {profile?.semester}** using **{profile?.preferredLanguage}**.
        </p>
        <div className="flex gap-4">
          <button
            onClick={() => setEditingProfile(true)}
            className="bg-brand-600 hover:bg-brand-700 text-white px-5 py-2.5 rounded-xl text-sm font-semibold transition-colors"
          >
            Adjust Preferences
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="space-y-8 max-w-4xl mx-auto pb-16">
      
      {/* ==================== ROADMAP HEADER CARD ==================== */}
      <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl p-6 md:p-8 flex flex-col md:flex-row justify-between items-start md:items-center gap-6 relative overflow-hidden shadow-sm">
        <div className="space-y-3 relative z-10">
          <div className="flex items-center gap-2">
            <Badge variant="slate">{profile?.preferredLanguage}</Badge>
            <Badge variant="slate">Semester {roadmap.semester}</Badge>
          </div>
          <h1 className="text-2xl md:text-3xl font-extrabold font-heading text-slate-900 dark:text-white tracking-tight">
            {roadmap.title}
          </h1>
          {roadmap.description && (
            <p className="text-sm text-slate-500 dark:text-slate-400 max-w-2xl leading-relaxed">
              {roadmap.description}
            </p>
          )}
          <div className="flex items-center gap-4 text-xs font-semibold text-slate-400 pt-1">
            <span className="flex items-center gap-1.5">
              <Calendar className="h-4 w-4 text-brand-500" /> Est: {roadmap.monthsRemaining} Months
            </span>
            <span className="flex items-center gap-1.5">
              <Award className="h-4 w-4 text-brand-500" /> {stats.total} Problems
            </span>
          </div>
        </div>
        <button
          onClick={() => setEditingProfile(true)}
          className="px-4 py-2.5 rounded-xl text-sm font-semibold border border-slate-200 dark:border-dark-border hover:bg-slate-50 dark:hover:bg-zinc-800/40 shrink-0 relative z-10 text-slate-750 dark:text-slate-200"
        >
          Change Target Settings
        </button>
      </div>

      {/* ==================== PROGRESS METRICS DASHBOARD ==================== */}
      <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl p-6 shadow-sm flex flex-col md:flex-row items-center gap-8">
        <div className="relative h-28 w-28 shrink-0 flex items-center justify-center bg-slate-50 dark:bg-zinc-800/10 rounded-full border border-slate-100 dark:border-zinc-800/20">
          <svg className="absolute w-full h-full transform -rotate-90" viewBox="0 0 100 100">
            <circle
              className="text-slate-100 dark:text-zinc-800/40"
              strokeWidth="8"
              stroke="currentColor"
              fill="transparent"
              r="40"
              cx="50"
              cy="50"
            />
            <circle
              className="text-brand-600 transition-all duration-500"
              strokeWidth="8"
              strokeDasharray={251.2}
              strokeDashoffset={251.2 - (251.2 * stats.percent) / 100}
              strokeLinecap="round"
              stroke="currentColor"
              fill="transparent"
              r="40"
              cx="50"
              cy="50"
            />
          </svg>
          <div className="text-center">
            <span className="text-2xl font-black text-slate-800 dark:text-white block leading-none">
              {stats.percent}%
            </span>
            <span className="text-[9px] font-bold text-slate-400 block mt-1 uppercase tracking-wider">
              Solved
            </span>
          </div>
        </div>

        <div className="flex-1 w-full space-y-4">
          <div>
            <span className="text-xs font-bold text-slate-450 block uppercase tracking-wider">Overall Progress Breakdown</span>
            <h3 className="text-lg font-black text-slate-800 dark:text-white mt-1">
              {stats.completed} / {stats.total} Problems Completed
            </h3>
          </div>

          <div className="grid grid-cols-3 gap-4 text-center">
            <div className="p-3 bg-emerald-500/5 border border-emerald-500/10 rounded-xl">
              <span className="block text-[10px] font-bold text-emerald-500 uppercase tracking-wider">Easy</span>
              <span className="block text-sm font-extrabold text-slate-700 dark:text-slate-350 mt-1">
                {stats.easyCompleted} / {stats.easyTotal}
              </span>
            </div>
            <div className="p-3 bg-amber-500/5 border border-amber-500/10 rounded-xl">
              <span className="block text-[10px] font-bold text-amber-500 uppercase tracking-wider">Medium</span>
              <span className="block text-sm font-extrabold text-slate-700 dark:text-slate-350 mt-1">
                {stats.mediumCompleted} / {stats.mediumTotal}
              </span>
            </div>
            <div className="p-3 bg-red-500/5 border border-red-500/10 rounded-xl">
              <span className="block text-[10px] font-bold text-red-500 uppercase tracking-wider">Hard</span>
              <span className="block text-sm font-extrabold text-slate-700 dark:text-slate-350 mt-1">
                {stats.hardCompleted} / {stats.hardTotal}
              </span>
            </div>
          </div>
        </div>
      </div>

      {/* ==================== HIERARCHICAL SECTIONS TREE ==================== */}
      <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl overflow-hidden divide-y divide-slate-200/60 dark:divide-dark-border/60 shadow-sm">
        {sections.map((sec) => (
          <RoadmapSectionNode
            key={sec.id}
            section={sec}
            depth={0}
            onEditNote={handleEditNoteClick}
            onToggleComplete={handleToggleComplete}
            onToggleRevision={handleToggleRevision}
          />
        ))}
      </div>

      {/* ==================== EDIT NOTE MODAL DIALOG ==================== */}
      {editingQuestionNote && (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/60 backdrop-blur-sm p-4">
          <Card className="w-full max-w-md shadow-2xl">
            <div className="p-6 space-y-4">
              <div className="flex justify-between items-start">
                <div>
                  <span className="text-[10px] font-bold text-slate-450 uppercase tracking-wide">Question Note</span>
                  <h3 className="text-sm font-bold text-slate-900 dark:text-white mt-0.5">
                    {editingQuestionNote.title}
                  </h3>
                </div>
                <button
                  onClick={() => setEditingQuestionNote(null)}
                  className="text-slate-400 hover:text-slate-600 transition-colors"
                >
                  <X className="h-5 w-5" />
                </button>
              </div>

              <textarea
                value={noteValue}
                onChange={(e) => setNoteValue(e.target.value)}
                placeholder="Write your study notes, solutions, or thoughts about this question..."
                className="w-full h-32 p-3 text-xs bg-slate-50 dark:bg-zinc-800/20 border border-slate-200 dark:border-dark-border rounded-xl focus:outline-none resize-none text-slate-750 dark:text-slate-250"
              />

              <div className="flex justify-end gap-3 pt-2">
                <button
                  onClick={() => setEditingQuestionNote(null)}
                  className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl text-xs font-semibold hover:bg-slate-50 dark:hover:bg-zinc-800/40 text-slate-700 dark:text-slate-350"
                >
                  Cancel
                </button>
                <button
                  onClick={handleSaveNote}
                  disabled={saveNoteMutation.isPending}
                  className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2 rounded-xl text-xs font-semibold disabled:opacity-75"
                >
                  <Save className="h-3.5 w-3.5" /> Save Note
                </button>
              </div>
            </div>
          </Card>
        </div>
      )}

    </div>
  );
};
export default RoadmapPage;
