import React, { useEffect } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm, Controller } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { useAuthStore } from '../store/authStore';
import { useTheme } from '../contexts/ThemeContext';
import { studentService } from '../services/studentService';
import { Card, CardContent, CardHeader, CardTitle } from '../components/Card';
import { Input } from '../components/Input';
import { Select } from '../components/Select';
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
  targetRole: zod.enum(['SDE', 'FULL_STACK', 'AI_ML', 'DATA_SCIENTIST']),
  startingSemester: zod.number().min(1, 'Starting semester must be 1-5').max(5),
  framework: zod.enum(['SPRING_BOOT', 'NODE_JS', 'PYTHON_FASTAPI', 'PYTHON', 'CPP', 'CP']),
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

  const { register, handleSubmit, control, reset, setValue, watch, formState: { errors } } = useForm<ProfileFormValues>({
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
      startingSemester: 1,
      framework: 'SPRING_BOOT',
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
        startingSemester: profile.startingSemester || 1,
        framework: profile.framework as any || 'SPRING_BOOT',
      });
    }
  }, [profile, reset]);

  const selectedRole = watch('targetRole');
  const frameworkOptions = selectedRole === 'AI_ML' || selectedRole === 'DATA_SCIENTIST'
    ? [{ value: 'PYTHON', label: 'Python' }]
    : [
        { value: 'SPRING_BOOT', label: 'Spring Boot' },
        { value: 'NODE_JS', label: 'Node.js' },
        { value: 'PYTHON_FASTAPI', label: 'Python FastAPI' },
        { value: 'CPP', label: 'C++ Basics' },
        { value: 'CP', label: 'Competitive Programming (CP-31)' },
      ];

  useEffect(() => {
    const currentFramework = watch('framework');
    if (!frameworkOptions.some(option => option.value === currentFramework)) {
      setValue('framework', frameworkOptions[0].value as ProfileFormValues['framework']);
    }
  }, [frameworkOptions, setValue, selectedRole, watch]);

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
              <div className="space-y-1.5 w-full text-left">
                <Controller
                  control={control}
                  name="branch"
                  render={({ field }) => (
                    <Select
                      label="Branch / Major"
                      options={[
                        { value: 'Computer Science (CSE)', label: 'Computer Science (CSE)' },
                        { value: 'Information Technology (IT)', label: 'Information Technology (IT)' },
                        { value: 'Electronics and Communication Engineering (ECE)', label: 'Electronics and Communication Engineering (ECE)' },
                        { value: 'Electrical Engineering (EE)', label: 'Electrical Engineering (EE)' }
                      ]}
                      value={field.value || ''}
                      onChange={field.onChange}
                      className="w-full text-left"
                    />
                  )}
                />
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
              <Controller
                control={control}
                name="preferredLanguage"
                render={({ field }) => (
                  <Select
                    label="Preferred Language"
                    options={[
                      { value: 'JAVA', label: 'Java (Core & OOPs)' },
                      { value: 'CPP', label: 'C++ (STL & Core)' },
                      { value: 'PYTHON', label: 'Python (Scripts & ML)' }
                    ]}
                    value={field.value || 'JAVA'}
                    onChange={field.onChange}
                    className="w-full text-left"
                  />
                )}
              />

              <Controller
                control={control}
                name="targetRole"
                render={({ field }) => (
                  <Select
                    label="Placement Role Target"
                    options={[
                      { value: 'SDE', label: 'Software Development Engineer (SDE)' },
                      { value: 'FULL_STACK', label: 'Full Stack Developer' },
                      { value: 'AI_ML', label: 'Machine Learning Engineer' },
                      { value: 'DATA_SCIENTIST', label: 'Data Scientist' }
                    ]}
                    value={field.value || 'SDE'}
                    onChange={field.onChange}
                    className="w-full text-left"
                  />
                )}
              />
            </div>

            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              <Controller
                control={control}
                name="startingSemester"
                render={({ field }) => (
                  <Select
                    label="Starting Semester for Journey"
                    options={[1, 2, 3, 4, 5].map(value => ({ value: String(value), label: `Semester ${value}` }))}
                    value={String(field.value || 1)}
                    onChange={(value) => field.onChange(Number(value))}
                  />
                )}
              />
              <Controller
                control={control}
                name="framework"
                render={({ field }) => (
                  <Select
                    label="Preferred Framework"
                    options={frameworkOptions}
                    value={frameworkOptions.some(option => option.value === field.value) ? field.value : frameworkOptions[0].value}
                    onChange={field.onChange}
                  />
                )}
              />
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
