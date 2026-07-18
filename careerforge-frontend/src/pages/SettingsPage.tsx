import React, { useEffect } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { useAuthStore } from '../store/authStore';
import { useTheme } from '../contexts/ThemeContext';
import { studentService } from '../services/studentService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { 
  Settings, Sun, Moon, Laptop, User, Loader2, Save 
} from 'lucide-react';

const profileSchema = zod.object({
  firstName: zod.string().min(1, 'First name is required').max(50),
  lastName: zod.string().min(1, 'Last name is required').max(50),
  semester: zod.number().min(1, 'Semester must be 1-8').max(8),
  branch: zod.string().min(1, 'Branch is required'),
  section: zod.string().optional(),
  enrollmentNo: zod.string().min(1, 'Enrollment number is required'),
  preferredLanguage: zod.enum(['JAVA', 'CPP', 'PYTHON']),
  targetRole: zod.enum(['SDE', 'FULL_STACK', 'WEB_DEVELOPER', 'AI_ML', 'DEVOPS']),
});

type ProfileFormValues = zod.infer<typeof profileSchema>;

export const SettingsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const { user, updateUser } = useAuthStore();
  const { theme, setTheme } = useTheme();

  // Query latest backend profile
  const { data: profile, isLoading } = useQuery({
    queryKey: ['studentProfile'],
    queryFn: studentService.getMyProfile,
  });

  const { register, handleSubmit, reset, formState: { errors } } = useForm<ProfileFormValues>({
    resolver: zodResolver(profileSchema) as any,
    defaultValues: {
      firstName: '',
      lastName: '',
      semester: 5,
      branch: '',
      section: '',
      enrollmentNo: '',
      preferredLanguage: 'JAVA',
      targetRole: 'SDE',
    }
  });

  // Load profile values into form once fetched
  useEffect(() => {
    if (profile) {
      reset({
        firstName: profile.firstName || '',
        lastName: profile.lastName || '',
        semester: profile.semester || 5,
        branch: profile.branch || '',
        section: profile.section || '',
        enrollmentNo: profile.enrollmentNo || '',
        preferredLanguage: profile.preferredLanguage as any || 'JAVA',
        targetRole: profile.targetRole as any || 'SDE',
      });
    }
  }, [profile, reset]);

  // Update profile mutation
  const updateMutation = useMutation({
    mutationFn: studentService.updateMyProfile,
    onSuccess: (updatedData) => {
      // Invalidate queries to reload dashboard roadmap changes
      queryClient.invalidateQueries({ queryKey: ['studentProfile'] });
      queryClient.invalidateQueries({ queryKey: ['studentDashboard'] });
      queryClient.invalidateQueries({ queryKey: ['personalizedRoadmap'] });

      // Update global auth store user info
      if (user) {
        updateUser({
          ...user,
          firstName: updatedData.firstName,
          lastName: updatedData.lastName,
        });
      }

      toast.success('Settings and profile updated successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to update settings.');
    }
  });

  const onSubmit = (values: ProfileFormValues) => {
    updateMutation.mutate(values);
  };

  if (isLoading) {
    return (
      <div className="space-y-6 animate-pulse max-w-4xl mx-auto">
        <div className="h-10 bg-slate-200 dark:bg-zinc-800 rounded-xl w-64" />
        <div className="h-32 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
        <div className="h-96 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
      </div>
    );
  }

  return (
    <div className="space-y-8 max-w-3xl mx-auto">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <Settings className="h-7 w-7 text-brand-600" /> Platform Settings
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Adjust theme appearance preferences or configure target placements.
        </p>
      </div>

      {/* ==================== THEME APPEARANCE CARD ==================== */}
      <Card>
        <CardHeader>
          <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
            <Sun className="h-4.5 w-4.5 text-brand-650" /> Theme Customization
          </CardTitle>
        </CardHeader>
        <CardContent className="p-5">
          <p className="text-xs text-slate-500 dark:text-slate-400 mb-4">
            Select how CareerForge layout fits your work environment.
          </p>

          <div className="grid grid-cols-3 gap-4">
            {[
              { id: 'light', name: 'Light', icon: Sun, desc: 'Classic bright look' },
              { id: 'dark', name: 'Dark', icon: Moon, desc: 'Easy on the eyes' },
              { id: 'system', name: 'System', icon: Laptop, desc: 'Match your OS' },
            ].map((item) => {
              const Icon = item.icon;
              const isActive = theme === item.id;
              return (
                <button
                  key={item.id}
                  onClick={() => setTheme(item.id as any)}
                  className={`p-4 rounded-2xl border text-left flex flex-col justify-between h-28 transition-all relative ${
                    isActive
                      ? 'bg-brand-50/10 border-brand-600 dark:bg-brand-900/5'
                      : 'bg-white dark:bg-dark-card border-slate-200 dark:border-dark-border hover:bg-slate-50 dark:hover:bg-zinc-800/30'
                  }`}
                >
                  <Icon className={`h-6 w-6 ${isActive ? 'text-brand-600' : 'text-slate-455'}`} />
                  <div>
                    <span className="block font-bold text-xs text-slate-850 dark:text-slate-200">
                      {item.name}
                    </span>
                    <span className="block text-[10px] text-slate-450 mt-0.5">
                      {item.desc}
                    </span>
                  </div>
                  {isActive && (
                    <span className="absolute top-3 right-3 h-2 w-2 rounded-full bg-brand-600" />
                  )}
                </button>
              );
            })}
          </div>
        </CardContent>
      </Card>

      {/* ==================== STUDENT PROFILE CONFIG FORM ==================== */}
      <Card>
        <CardHeader>
          <CardTitle className="text-sm font-bold uppercase tracking-wider flex items-center gap-2">
            <User className="h-4.5 w-4.5 text-brand-650" /> Academic & Target Configuration
          </CardTitle>
        </CardHeader>
        <CardContent className="p-5">
          <form onSubmit={handleSubmit(onSubmit)} className="space-y-6">
            
            {/* First & Last name */}
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <Input
                label="First Name"
                placeholder="First name"
                error={errors.firstName?.message}
                {...register('firstName')}
              />
              <Input
                label="Last Name"
                placeholder="Last name"
                error={errors.lastName?.message}
                {...register('lastName')}
              />
            </div>

            {/* Academic details */}
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <div className="space-y-2">
                <label className="block text-sm font-semibold text-slate-700 dark:text-zinc-300">Branch / Major</label>
                <select
                  {...register('branch')}
                  className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
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
              <Input
                label="Section"
                placeholder="e.g., A"
                error={errors.section?.message}
                {...register('section')}
              />
            </div>

            {/* Enrollment & semester */}
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <Input
                label="Enrollment / Roll Number"
                placeholder="e.g., EN20CS301"
                error={errors.enrollmentNo?.message}
                {...register('enrollmentNo')}
              />
              <Input
                label="Current Semester (1-8)"
                type="number"
                error={errors.semester?.message}
                {...register('semester', { valueAsNumber: true })}
              />
            </div>

            {/* Language & Placement target paths */}
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6 border-t border-slate-200/50 dark:border-dark-border/40 pt-6">
              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                  Preferred Language
                </label>
                <select
                  {...register('preferredLanguage')}
                  className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
                >
                  <option value="JAVA">Java (Core & OOPs)</option>
                  <option value="CPP">C++ (STL & Core)</option>
                  <option value="PYTHON">Python (Scripts & ML)</option>
                </select>
              </div>

              <div className="space-y-1.5">
                <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
                  Placement Role Target
                </label>
                <select
                  {...register('targetRole')}
                  className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
                >
                  <option value="SDE">Software Development Engineer (SDE)</option>
                  <option value="FULL_STACK">Full Stack Developer</option>
                  <option value="WEB_DEVELOPER">Frontend Developer</option>
                  <option value="AI_ML">Machine Learning Engineer</option>
                  <option value="DEVOPS">DevOps & Cloud Engineer</option>
                </select>
              </div>
            </div>


            {/* Save trigger */}
            <div className="flex justify-end pt-4 border-t border-slate-200/50 dark:border-dark-border/40">
              <button
                type="submit"
                disabled={updateMutation.isPending}
                className="inline-flex items-center gap-2 bg-brand-650 hover:bg-brand-700 text-white px-5 py-2.5 rounded-xl font-semibold text-sm transition-colors disabled:opacity-70 shadow-lg shadow-brand-500/10"
              >
                {updateMutation.isPending ? (
                  <>
                    <Loader2 className="h-4 w-4 animate-spin" /> Saving...
                  </>
                ) : (
                  <>
                    <Save className="h-4.5 w-4.5" /> Save Changes
                  </>
                )}
              </button>
            </div>

          </form>
        </CardContent>
      </Card>

    </div>
  );
};
export default SettingsPage;
