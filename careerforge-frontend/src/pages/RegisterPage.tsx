import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { authService } from '../services/authService';
import { Eye, EyeOff, Loader2 } from 'lucide-react';

const registerSchema = zod.object({
  firstName: zod.string().min(1, 'First name is required').max(50, 'Max 50 characters'),
  lastName: zod.string().min(1, 'Last name is required').max(50, 'Max 50 characters'),
  email: zod.string().min(1, 'Email is required').email('Invalid email address').max(100, 'Max 100 characters'),
  password: zod.string().min(6, 'Password must be at least 6 characters').max(100),
  role: zod.enum(['STUDENT', 'ADMIN']),
});

type RegisterFormValues = zod.infer<typeof registerSchema>;

export const RegisterPage: React.FC = () => {
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [loading, setLoading] = useState(false);

  const { register, handleSubmit, formState: { errors } } = useForm<RegisterFormValues>({
    resolver: zodResolver(registerSchema),
    defaultValues: {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      role: 'STUDENT',
    }
  });

  const onSubmit = async (data: RegisterFormValues) => {
    setLoading(true);
    try {
      await authService.register(data);
      toast.success('Registration successful! Please sign in.');
      navigate('/login', { replace: true });
    } catch (error: any) {
      console.error('Registration error detailed:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Registration failed. Please check connection.';
      toast.error(errorMessage);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="space-y-6">
      <div className="text-center">
        <h3 className="text-xl font-bold font-heading text-slate-800 dark:text-slate-200">
          Create Account
        </h3>
        <p className="text-xs text-slate-400 mt-1">
          Forge your roadmap and track placement preparation
        </p>
      </div>

      <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
        {/* Name Fields Row */}
        <div className="grid grid-cols-2 gap-4">
          <div>
            <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
              First Name
            </label>
            <input
              type="text"
              placeholder="Akash"
              {...register('firstName')}
              className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-slate-800 dark:text-slate-200 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
                errors.firstName ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
              }`}
            />
            {errors.firstName && (
              <p className="text-xs text-red-500 mt-1">{errors.firstName.message}</p>
            )}
          </div>
          <div>
            <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
              Last Name
            </label>
            <input
              type="text"
              placeholder="Kumar"
              {...register('lastName')}
              className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-slate-800 dark:text-slate-200 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
                errors.lastName ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
              }`}
            />
            {errors.lastName && (
              <p className="text-xs text-red-500 mt-1">{errors.lastName.message}</p>
            )}
          </div>
        </div>

        {/* Email Address */}
        <div>
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
            Email Address
          </label>
          <input
            type="email"
            placeholder="akash@example.com"
            {...register('email')}
            className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-slate-800 dark:text-slate-200 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
              errors.email ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
            }`}
          />
          {errors.email && (
            <p className="text-xs text-red-500 mt-1">{errors.email.message}</p>
          )}
        </div>

        {/* Password */}
        <div>
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
            Password
          </label>
          <div className="relative">
            <input
              type={showPassword ? 'text' : 'password'}
              placeholder="••••••••"
              {...register('password')}
              className={`w-full pl-4 pr-10 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-slate-800 dark:text-slate-200 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
                errors.password ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
              }`}
            />
            <button
              type="button"
              onClick={() => setShowPassword(!showPassword)}
              className="absolute right-3 top-3 text-slate-400 hover:text-slate-600 dark:hover:text-slate-200 transition-colors"
            >
              {showPassword ? <EyeOff className="h-4.5 w-4.5" /> : <Eye className="h-4.5 w-4.5" />}
            </button>
          </div>
          {errors.password && (
            <p className="text-xs text-red-500 mt-1">{errors.password.message}</p>
          )}
        </div>

        {/* Role Choice */}
        <div>
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
            I want to register as a
          </label>
          <select
            {...register('role')}
            className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-card text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-300"
          >
            <option value="STUDENT">Student (Placement Prep)</option>
            <option value="ADMIN">Administrator (Create content/stats)</option>
          </select>
          {errors.role && (
            <p className="text-xs text-red-500 mt-1">{errors.role.message}</p>
          )}
        </div>

        {/* Submit */}
        <button
          type="submit"
          disabled={loading}
          className="w-full inline-flex items-center justify-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-5 py-3 rounded-xl font-semibold text-sm transition-colors shadow-lg shadow-brand-500/20 disabled:opacity-75 disabled:cursor-not-allowed mt-2"
        >
          {loading ? (
            <>
              <Loader2 className="h-4 w-4 animate-spin" /> Creating Account...
            </>
          ) : (
            'Sign Up'
          )}
        </button>
      </form>

      <div className="text-center text-xs text-slate-500 dark:text-slate-400 mt-6 border-t border-slate-200/50 dark:border-dark-border/50 pt-4">
        Already have an account?{' '}
        <Link to="/login" className="font-semibold text-brand-600 dark:text-brand-400 hover:underline">
          Sign in
        </Link>
      </div>
    </div>
  );
};
export default RegisterPage;
