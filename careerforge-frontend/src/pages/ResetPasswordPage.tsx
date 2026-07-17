import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { Loader2, ArrowLeft } from 'lucide-react';

const resetSchema = zod.object({
  password: zod.string().min(6, 'Password must be at least 6 characters'),
  confirmPassword: zod.string().min(6, 'Confirmation is required'),
}).refine(data => data.password === data.confirmPassword, {
  message: 'Passwords must match',
  path: ['confirmPassword']
});

type ResetFormValues = zod.infer<typeof resetSchema>;

export const ResetPasswordPage: React.FC = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const { register, handleSubmit, formState: { errors } } = useForm<ResetFormValues>({
    resolver: zodResolver(resetSchema),
  });

  const onSubmit = (_data: ResetFormValues) => {
    setLoading(true);
    // Simulate API request to reset password
    setTimeout(() => {
      setLoading(false);
      toast.success('Password updated successfully! Please login.');
      navigate('/login');
    }, 1500);
  };

  return (
    <div className="space-y-6">
      <div className="text-center">
        <h3 className="text-xl font-bold font-heading text-slate-800 dark:text-slate-200">
          Define New Password
        </h3>
        <p className="text-xs text-slate-400 mt-1">
          Set your new credential credentials below
        </p>
      </div>

      <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
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
              <Loader2 className="h-4 w-4 animate-spin" /> Updating...
            </>
          ) : (
            'Update Password'
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
