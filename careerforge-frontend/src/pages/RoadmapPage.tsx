import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { motion } from 'framer-motion';
import { studentService } from '../services/studentService';
import { roadmapService } from '../services/roadmapService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { Badge } from '../components/Badge';
import { 
  Milestone, Calendar, Award, Star, Compass, 
  MessageSquare, Loader2
} from 'lucide-react';

const profileSetupSchema = zod.object({
  semester: zod.number().min(1, 'Semester must be between 1 and 8').max(8),
  branch: zod.string().min(1, 'Branch is required'),
  college: zod.string().min(1, 'College is required'),
  enrollmentNo: zod.string().min(1, 'Enrollment number is required'),
  preferredLanguage: zod.enum(['JAVA', 'CPP', 'PYTHON']),
  targetRole: zod.enum(['SDE', 'FULL_STACK', 'WEB_DEVELOPER', 'AI_ML', 'DEVOPS']),
  communicationTrackEnabled: zod.boolean(),
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

  const { data: roadmap, isLoading: loadingRoadmap, error: roadmapError } = useQuery({
    queryKey: ['studentRoadmap'],
    queryFn: roadmapService.getPersonalizedRoadmap,
    enabled: isProfileConfigured && !editingProfile,
  });

  const { register, handleSubmit, formState: { errors } } = useForm<ProfileSetupValues>({
    resolver: zodResolver(profileSetupSchema),
    values: profile ? {
      semester: profile.semester || 1,
      branch: profile.branch || '',
      college: profile.college || '',
      enrollmentNo: profile.enrollmentNo || '',
      preferredLanguage: profile.preferredLanguage || 'JAVA',
      targetRole: profile.targetRole || 'SDE',
      communicationTrackEnabled: profile.communicationTrackEnabled,
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

  const onFormSubmit = (values: ProfileSetupValues) => {
    // Merge existing user names since backend update profile requires all profile parameters
    const payload = {
      firstName: profile?.firstName || '',
      lastName: profile?.lastName || '',
      ...values
    };
    updateProfileMutation.mutate(payload);
  };

  if (loadingProfile || (isProfileConfigured && loadingRoadmap && !editingProfile)) {
    return (
      <div className="space-y-8 animate-pulse">
        <div className="h-40 bg-slate-200 dark:bg-zinc-800 rounded-2xl w-full" />
        <div className="space-y-4 max-w-xl mx-auto py-10">
          {[...Array(3)].map((_, i) => (
            <div key={i} className="h-28 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          ))}
        </div>
      </div>
    );
  }

  // Render configuration form if not configured or explicitly editing
  if (!isProfileConfigured || editingProfile) {
    return (
      <div className="max-w-2xl mx-auto">
        <Card>
          <CardHeader>
            <CardTitle className="text-xl font-bold font-heading flex items-center gap-2">
              <Compass className="h-5 w-5 text-brand-600" /> Roadmap Configuration
            </CardTitle>
          </CardHeader>
          <CardContent className="p-6">
            <p className="text-sm text-slate-500 dark:text-slate-400 mb-6">
              Configure your current academic status, language preference, and career aspirations. We will tailor your preparation curriculum accordingly.
            </p>

            <form onSubmit={handleSubmit(onFormSubmit)} className="space-y-6">
              <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
                <Input
                  label="Current Semester (1-8)"
                  type="number"
                  placeholder="e.g., 5"
                  error={errors.semester?.message}
                  {...register('semester', { valueAsNumber: true })}
                />
                <Input
                  label="Academic Branch"
                  placeholder="e.g., Computer Science"
                  error={errors.branch?.message}
                  {...register('branch')}
                />
              </div>

              <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
                <Input
                  label="College / Institute Name"
                  placeholder="e.g., State University"
                  error={errors.college?.message}
                  {...register('college')}
                />
                <Input
                  label="Enrollment / Student ID"
                  placeholder="e.g., CS2026101"
                  error={errors.enrollmentNo?.message}
                  {...register('enrollmentNo')}
                />
              </div>

              <div className="grid grid-cols-1 sm:grid-cols-2 gap-6">
                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Preferred Programming Language
                  </label>
                  <select
                    {...register('preferredLanguage')}
                    className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
                  >
                    <option value="JAVA">Java (OOP, Multithreading)</option>
                    <option value="CPP">C++ (STL, OOP)</option>
                    <option value="PYTHON">Python (Scripting, ML)</option>
                  </select>
                </div>

                <div className="space-y-1.5">
                  <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                    Target Role
                  </label>
                  <select
                    {...register('targetRole')}
                    className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
                  >
                    <option value="SDE">Software Development Engineer (SDE)</option>
                    <option value="FULL_STACK">Full Stack Engineer</option>
                    <option value="WEB_DEVELOPER">Frontend / Backend Web Developer</option>
                    <option value="AI_ML">Artificial Intelligence / Machine Learning</option>
                    <option value="DEVOPS">DevOps & Cloud Engineer</option>
                  </select>
                </div>
              </div>

              {/* Soft Skills Track Option */}
              <div className="flex items-start bg-slate-50 dark:bg-zinc-800/10 p-4 rounded-xl border border-slate-100 dark:border-zinc-800/30">
                <input
                  id="comms-track"
                  type="checkbox"
                  className="h-4 w-4 rounded border-slate-300 dark:border-dark-border text-brand-600 focus:ring-brand-500/20 mt-1"
                  {...register('communicationTrackEnabled')}
                />
                <div className="ml-3">
                  <label htmlFor="comms-track" className="text-sm font-semibold text-slate-800 dark:text-slate-200 flex items-center gap-1.5 select-none">
                    <MessageSquare className="h-4 w-4 text-indigo-500" /> Enable Soft-Skills Track
                  </label>
                  <p className="text-xs text-slate-400 mt-1">
                    Adds communication preparation, mock interview prep, resume writing, and verbal aptitude phases to your final roadmap.
                  </p>
                </div>
              </div>

              <div className="flex justify-end gap-3 pt-2">
                {editingProfile && (
                  <button
                    type="button"
                    onClick={() => setEditingProfile(false)}
                    className="px-4 py-2.5 rounded-xl text-sm font-semibold border border-slate-200 dark:border-dark-border hover:bg-slate-50 dark:hover:bg-zinc-800/40"
                  >
                    Cancel
                  </button>
                )}
                <button
                  type="submit"
                  disabled={updateProfileMutation.isPending}
                  className="inline-flex items-center justify-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-5 py-2.5 rounded-xl font-semibold text-sm transition-colors shadow-lg shadow-brand-500/20 disabled:opacity-75 disabled:cursor-not-allowed"
                >
                  {updateProfileMutation.isPending ? (
                    <>
                      <Loader2 className="h-4 w-4 animate-spin" /> Saving...
                    </>
                  ) : (
                    'Generate Roadmap'
                  )}
                </button>
              </div>
            </form>
          </CardContent>
        </Card>
      </div>
    );
  }

  // Handle roadmap matches missing error
  if (roadmapError || !roadmap) {
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

  // Calculate estimated completion
  const totalMonths = roadmap.phases.reduce((sum, phase) => sum + phase.durationMonths, 0);

  return (
    <div className="space-y-10 max-w-4xl mx-auto">
      
      {/* ==================== ROADMAP HEADER CARD ==================== */}
      <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl p-6 md:p-8 flex flex-col md:flex-row justify-between items-start md:items-center gap-6 relative overflow-hidden shadow-sm">
        <div className="space-y-3 relative z-10">
          <div className="flex items-center gap-2">
            <Badge variant="brand">{roadmap.targetRole}</Badge>
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
              <Calendar className="h-4 w-4 text-brand-500" /> Est: {totalMonths} Months
            </span>
            <span className="flex items-center gap-1.5">
              <Award className="h-4 w-4 text-brand-500" /> {roadmap.phases.length} Learning Phases
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

        {roadmap.phases.map((phase, idx) => {
          // Identify soft-skills dynamically
          const isSoftSkills = phase.phaseName.toLowerCase().includes('soft') || phase.phaseName.toLowerCase().includes('communication');

          return (
            <motion.div
              key={phase.id}
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

              {/* Phase card details */}
              <Card hoverEffect>
                <CardContent className="p-6 md:p-8 space-y-4">
                  <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-3 border-b border-slate-200/50 dark:border-dark-border/40 pb-3">
                    <div>
                      <span className="text-[10px] font-bold text-brand-600 dark:text-brand-400 uppercase tracking-wider block">
                        PHASE {phase.orderIndex}
                      </span>
                      <h3 className="text-lg font-bold font-heading text-slate-900 dark:text-white mt-0.5">
                        {phase.phaseName}
                      </h3>
                    </div>
                    <Badge variant={isSoftSkills ? 'success' : 'brand'}>
                      {phase.durationMonths} {phase.durationMonths === 1 ? 'Month' : 'Months'}
                    </Badge>
                  </div>

                  <p className="text-sm text-slate-600 dark:text-slate-400 leading-relaxed whitespace-pre-line">
                    {phase.description}
                  </p>
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
