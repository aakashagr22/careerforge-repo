import React, { useState } from 'react';
import { useNavigate, Link, useSearchParams } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { Loader2, ArrowLeft, KeyRound } from 'lucide-react';
import { authService } from '../services/authService';

const resetSchema = zod.object({
  email: zod.string().min(1, 'Email is required').email('Invalid email address'),
  otp: zod.string().length(6, 'OTP must be exactly 6 digits').regex(/^\d+$/, 'OTP must contain only numbers'),
  password: zod.string().min(6, 'Password must be at least 6 characters').max(100),
  confirmPassword: zod.string().min(6, 'Confirmation is required'),
}).refine(data => data.password === data.confirmPassword, {
  message: 'Passwords must match',
  path: ['confirmPassword']
});

type ResetFormValues = zod.infer<typeof resetSchema>;

export const ResetPasswordPage: React.FC = () => {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();
  const [loading, setLoading] = useState(false);

  const initialEmail = searchParams.get('email') || '';

  const { register, handleSubmit, formState: { errors } } = useForm<ResetFormValues>({
    resolver: zodResolver(resetSchema),
    defaultValues: {
      email: initialEmail,
      otp: '',
      password: '',
      confirmPassword: '',
    }
  });

  const onSubmit = async (data: ResetFormValues) => {
    setLoading(true);
    try {
      await authService.resetPassword({
        email: data.email,
        otp: data.otp,
        newPassword: data.password,
      });
      toast.success('Password updated successfully! Please sign in with your new password.');
      navigate('/login');
    } catch (error: any) {
      console.error('Reset password error:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Failed to reset password. Check your OTP and try again.';
      toast.error(errorMessage);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="space-y-6">
      <div className="text-center">
        <div className="inline-flex items-center justify-center h-12 w-12 rounded-2xl bg-indigo-50 dark:bg-indigo-950/40 text-indigo-600 dark:text-indigo-400 mb-3 shadow-inner">
          <KeyRound className="h-6 w-6" />
        </div>
        <h3 className="text-xl font-bold font-heading text-slate-800 dark:text-slate-200">
          Set New Password
        </h3>
        <p className="text-xs text-slate-400 mt-1">
          Enter the 6-digit code sent to your email and your new password
        </p>
      </div>

      <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
        {/* Email Address */}
        <div>
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
            Email Address
          </label>
          <input
            type="email"
            placeholder="akash@example.com"
            {...register('email')}
            className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
              errors.email ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
            }`}
          />
          {errors.email && (
            <p className="text-xs text-red-500 mt-1">{errors.email.message}</p>
          )}
        </div>

        {/* 6-Digit OTP Code */}
        <div>
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
            6-Digit Reset Code
          </label>
          <input
            type="text"
            maxLength={6}
            placeholder="123456"
            {...register('otp')}
            className={`w-full text-center font-mono font-bold tracking-[0.4em] px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
              errors.otp ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
            }`}
          />
          {errors.otp && (
            <p className="text-xs text-red-500 mt-1">{errors.otp.message}</p>
          )}
        </div>

        {/* New Password */}
        <div>
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
            New Password
          </label>
          <input
            type="password"
            placeholder="••••••••"
            {...register('password')}
            className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
              errors.password ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
            }`}
          />
          {errors.password && (
            <p className="text-xs text-red-500 mt-1">{errors.password.message}</p>
          )}
        </div>

        {/* Confirm Password */}
        <div>
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-1.5 uppercase tracking-wide">
            Confirm Password
          </label>
          <input
            type="password"
            placeholder="••••••••"
            {...register('confirmPassword')}
            className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 ${
              errors.confirmPassword ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
            }`}
          />
          {errors.confirmPassword && (
            <p className="text-xs text-red-500 mt-1">{errors.confirmPassword.message}</p>
          )}
        </div>

        <button
          type="submit"
          disabled={loading}
          className="w-full inline-flex items-center justify-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-5 py-3 rounded-xl font-semibold text-sm transition-colors shadow-lg shadow-brand-500/20 disabled:opacity-75 disabled:cursor-not-allowed mt-2"
        >
          {loading ? (
            <>
              <Loader2 className="h-4 w-4 animate-spin" /> Resetting Password...
            </>
          ) : (
            'Update Password & Sign In'
          )}
        </button>
      </form>

      <div className="text-center text-xs mt-6 border-t border-slate-200/50 dark:border-dark-border/50 pt-4">
        <Link to="/login" className="inline-flex items-center gap-1.5 font-semibold text-slate-500 dark:text-slate-400 hover:text-slate-800 dark:hover:text-slate-200">
          <ArrowLeft className="h-3.5 w-3.5" /> Back to Login
        </Link>
      </div>
    </div>
  );
};
export default ResetPasswordPage;
