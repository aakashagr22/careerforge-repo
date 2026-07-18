import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { motion } from 'framer-motion';
import { studentService } from '../services/studentService';
import { roadmapService } from '../services/roadmapService';
import { Card, CardContent } from '../components/Card';
import { Input } from '../components/Input';
import { Badge } from '../components/Badge';
import { 
  Milestone, Calendar, Award, Star, Compass, 
  MessageSquare, Loader2
} from 'lucide-react';

const profileSetupSchema = zod.object({
  semester: zod.number().min(1, 'Semester must be between 1 and 8').max(8),
  branch: zod.string().min(1, 'Branch is required'),
  enrollmentNo: zod.string().min(1, 'Enrollment number is required'),
  preferredLanguage: zod.enum(['JAVA', 'CPP', 'PYTHON']),
  targetRole: zod.enum(['SDE', 'FULL_STACK', 'WEB_DEVELOPER', 'AI_ML', 'DEVOPS']),
});

type ProfileSetupValues = zod.infer<typeof profileSetupSchema>;

export const RoadmapPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [editingProfile, setEditingProfile] = useState(false);

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

  const onSubmit = (values: ProfileSetupValues) => {
    updateProfileMutation.mutate({
      ...values,
      firstName: profile?.firstName || '',
      lastName: profile?.lastName || '',
      section: profile?.section || '',
    });
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

  const flatSections = flattenSections(roadmapData?.sections || []);

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

              <Input label="Engineering Branch" placeholder="e.g. Computer Science" error={errors.branch?.message} {...register('branch')} />
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

  const hasRoadmap = !!roadmapData?.roadmap;

  if (!hasRoadmap || roadmapError) {
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

  const roadmap = roadmapData.roadmap;

  return (
    <div className="space-y-10 max-w-4xl mx-auto">
      
      {/* ==================== ROADMAP HEADER CARD ==================== */}
      <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl p-6 md:p-8 flex flex-col md:flex-row justify-between items-start md:items-center gap-6 relative overflow-hidden shadow-sm">
        <div className="space-y-3 relative z-10">
          <div className="flex items-center gap-2">
            <Badge variant="brand">{roadmap.targetRoles?.join(', ')}</Badge>
            <Badge variant="slate">{profile?.preferredLanguage}</Badge>
            <Badge variant="slate">Semester {roadmap.semester}</Badge>
          </div>
          <h1 className="text-2xl md:text-3xl font-extrabold font-heading text-slate-900 dark:text-white tracking-tight">
            {roadmap.title}
          </h1>
          <p className="text-sm text-slate-500 dark:text-slate-400 max-w-2xl leading-relaxed">
            {roadmap.description}
          </p>
          <div className="flex items-center gap-4 text-xs font-semibold text-slate-400 pt-1">
            <span className="flex items-center gap-1.5">
              <Calendar className="h-4 w-4 text-brand-500" /> Est: {roadmap.monthsRemaining} Months
            </span>
            <span className="flex items-center gap-1.5">
              <Award className="h-4 w-4 text-brand-500" /> {flatSections.length} Sections
            </span>
          </div>
        </div>
        <button
          onClick={() => setEditingProfile(true)}
          className="px-4 py-2.5 rounded-xl text-sm font-semibold border border-slate-200 dark:border-dark-border hover:bg-slate-50 dark:hover:bg-zinc-800/40 shrink-0 relative z-10"
        >
          Change Target Settings
        </button>
      </div>

      {/* ==================== CHRONOLOGICAL TIMELINE ==================== */}
      <div className="relative pl-6 md:pl-8 space-y-12">
        {/* Central Vertical Connector Line */}
        <div className="absolute left-[30px] md:left-[38px] top-4 bottom-4 w-0.5 bg-slate-200 dark:bg-dark-border pointer-events-none" />

        {flatSections.map((sec, idx) => {
          const isSoftSkills = sec.title.toLowerCase().includes('soft') || sec.title.toLowerCase().includes('communication');

          return (
            <motion.div
              key={sec.id}
              initial={{ opacity: 0, x: -20 }}
              whileInView={{ opacity: 1, x: 0 }}
              viewport={{ once: true }}
              transition={{ duration: 0.4, delay: idx * 0.1 }}
              className="relative group"
            >
              {/* Chronological Milestone Point */}
              <div className="absolute left-[-38px] md:left-[-48px] top-1.5 h-7 w-7 md:h-9 md:w-9 rounded-full bg-slate-50 dark:bg-dark-bg border-4 border-slate-200 dark:border-dark-border flex items-center justify-center text-slate-400 group-hover:border-brand-500 transition-colors z-10 shrink-0">
                {isSoftSkills ? (
                  <MessageSquare className="h-3 w-3 md:h-4 md:w-4 text-brand-500" />
                ) : (
                  <Star className="h-3 w-3 md:h-4 md:w-4 text-brand-500" />
                )}
              </div>

              {/* Section card details */}
              <Card hoverEffect>
                <CardContent className="p-6 md:p-8 space-y-4">
                  <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-3 border-b border-slate-200/50 dark:border-dark-border/40 pb-3">
                    <div>
                      <span className="text-[10px] font-bold text-brand-600 dark:text-brand-400 uppercase tracking-wider block">
                        SECTION {sec.position + 1}
                      </span>
                      <h3 className="text-lg font-bold font-heading text-slate-900 dark:text-white mt-0.5">
                        {sec.title}
                      </h3>
                    </div>
                  </div>


                </CardContent>
              </Card>
            </motion.div>
          );
        })}
      </div>

    </div>
  );
};
export default RoadmapPage;
