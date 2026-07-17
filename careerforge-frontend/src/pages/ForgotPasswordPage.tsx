import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { Loader2, ArrowLeft } from 'lucide-react';

const forgotSchema = zod.object({
  email: zod.string().min(1, 'Email is required').email('Invalid email address'),
});

type ForgotFormValues = zod.infer<typeof forgotSchema>;

export const ForgotPasswordPage: React.FC = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const { register, handleSubmit, formState: { errors } } = useForm<ForgotFormValues>({
    resolver: zodResolver(forgotSchema),
  });

  const onSubmit = (data: ForgotFormValues) => {
    setLoading(true);
    // Simulate API request to reset password
    setTimeout(() => {
      setLoading(false);
      toast.success(`Password reset link dispatched to ${data.email}`);
      navigate('/login');
    }, 1500);
  };

  return (
    <div className="space-y-6">
      <div className="text-center">
        <h3 className="text-xl font-bold font-heading text-slate-800 dark:text-slate-200">
          Reset Password
        </h3>
        <p className="text-xs text-slate-400 mt-1">
          Enter your email to receive recovery instructions
        </p>
      </div>

      <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
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

        <button
          type="submit"
          disabled={loading}
          className="w-full inline-flex items-center justify-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-5 py-3 rounded-xl font-semibold text-sm transition-colors shadow-lg shadow-brand-500/20 disabled:opacity-75 disabled:cursor-not-allowed mt-2"
        >
          {loading ? (
            <>
              <Loader2 className="h-4 w-4 animate-spin" /> Sending Link...
            </>
          ) : (
            'Send Reset Link'
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
export default ForgotPasswordPage;
