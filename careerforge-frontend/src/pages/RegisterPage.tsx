import React, { useState, useEffect } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { useAuthStore } from '../store/authStore';
import { authService } from '../services/authService';
import { API_BASE_URL } from '../config/api';
import { Eye, EyeOff, Loader2, Mail, CheckCircle2, RefreshCw, ArrowLeft } from 'lucide-react';

const registerSchema = zod.object({
  firstName: zod.string().min(1, 'First name is required').max(50, 'Max 50 characters'),
  lastName: zod.string().min(1, 'Last name is required').max(50, 'Max 50 characters'),
  email: zod.string().min(1, 'Email is required').email('Invalid email address').max(100, 'Max 100 characters'),
  password: zod.string().min(6, 'Password must be at least 6 characters').max(100),
});

type RegisterFormValues = zod.infer<typeof registerSchema>;

export const RegisterPage: React.FC = () => {
  const navigate = useNavigate();
  const { setCredentials } = useAuthStore();
  const [step, setStep] = useState<'REGISTER' | 'OTP'>('REGISTER');
  const [registeredEmail, setRegisteredEmail] = useState('');
  const [otp, setOtp] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [loading, setLoading] = useState(false);
  const [resendCooldown, setResendCooldown] = useState(0);

  const { register, handleSubmit, formState: { errors } } = useForm<RegisterFormValues>({
    resolver: zodResolver(registerSchema),
    defaultValues: {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
    }
  });

  // Countdown timer for resend OTP
  useEffect(() => {
    if (resendCooldown <= 0) return;
    const timer = setInterval(() => {
      setResendCooldown((prev) => prev - 1);
    }, 1000);
    return () => clearInterval(timer);
  }, [resendCooldown]);

  const onRegisterSubmit = async (data: RegisterFormValues) => {
    setLoading(true);
    try {
      const response: any = await authService.register(data);
      const user = response?.data || response;
      if (user?.previewOtp) {
        setOtp(user.previewOtp);
      }
      setRegisteredEmail(data.email);
      setStep('OTP');
      setResendCooldown(60);
      toast.success('6-digit verification code generated!');
    } catch (error: any) {
      console.error('Registration error detailed:', error);
      const isNetworkError = error.message === 'Network Error' || error.code === 'ERR_NETWORK';
      const errorMessage = error.response?.data?.message
        || (isNetworkError
            ? `Cannot connect to backend (${API_BASE_URL}). If using Render free tier, please wait 30s for it to wake up and try again.`
            : error.message || 'Registration failed. Please check connection.');
      toast.error(errorMessage, { duration: 6000 });
    } finally {
      setLoading(false);
    }
  };

  const onVerifyOtpSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!otp || otp.trim().length !== 6) {
      toast.error('Please enter the complete 6-digit OTP code.');
      return;
    }

    setLoading(true);
    try {
      const response = await authService.verifyOtp({
        email: registeredEmail,
        otp: otp.trim(),
        type: 'EMAIL_VERIFICATION',
      });

      setCredentials(response.accessToken, response.refreshToken, response.user);
      toast.success(`Email verified! Welcome to CareerForge, ${response.user.firstName}!`);
      navigate(response.user.role === 'ADMIN' ? '/admin/dashboard' : '/student/dashboard', { replace: true });
    } catch (error: any) {
      console.error('OTP Verification error:', error);
      const errorMessage = error.response?.data?.message || error.message || 'Invalid or expired verification code.';
      toast.error(errorMessage);
    } finally {
      setLoading(false);
    }
  };

  const handleResendOtp = async () => {
    if (resendCooldown > 0 || !registeredEmail) return;
    setLoading(true);
    try {
      const res: any = await authService.resendOtp({
        email: registeredEmail,
        type: 'EMAIL_VERIFICATION',
      });
      const preview = res?.data?.previewOtp || res?.previewOtp;
      if (preview) {
        setOtp(preview);
      }
      setResendCooldown(60);
      toast.success('A fresh 6-digit code has been dispatched.');
    } catch (error: any) {
      const errorMessage = error.response?.data?.message || error.message || 'Failed to resend code.';
      toast.error(errorMessage);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="space-y-6">
      {step === 'REGISTER' ? (
        <>
          <div className="text-center">
            <h3 className="text-xl font-bold font-heading text-slate-800 dark:text-slate-200">
              Create Account
            </h3>
            <p className="text-xs text-slate-400 mt-1">
              Forge your roadmap and track placement preparation
            </p>
          </div>

          <form onSubmit={handleSubmit(onRegisterSubmit)} className="space-y-4">
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
                'Sign Up & Get OTP'
              )}
            </button>
          </form>

          <div className="text-center text-xs text-slate-500 dark:text-slate-400 mt-6 border-t border-slate-200/50 dark:border-dark-border/50 pt-4">
            Already have an account?{' '}
            <Link to="/login" className="font-semibold text-brand-600 dark:text-brand-400 hover:underline">
              Sign in
            </Link>
          </div>
        </>
      ) : (
        /* STEP 2: 6-DIGIT OTP VERIFICATION VIEW */
        <div className="space-y-6">
          <div className="text-center">
            <div className="inline-flex items-center justify-center h-12 w-12 rounded-2xl bg-indigo-50 dark:bg-indigo-950/40 text-indigo-600 dark:text-indigo-400 mb-3 shadow-inner">
              <Mail className="h-6 w-6" />
            </div>
            <h3 className="text-xl font-bold font-heading text-slate-800 dark:text-slate-200">
              Verify Your Email
            </h3>
            <p className="text-xs text-slate-400 mt-1.5 leading-relaxed">
              We sent a 6-digit verification code to<br />
              <span className="font-semibold text-slate-700 dark:text-slate-200">{registeredEmail}</span>
            </p>
          </div>

          {otp && otp.length === 6 && (
            <div className="p-3 bg-emerald-500/10 border border-emerald-500/20 rounded-xl text-center text-xs text-emerald-400">
              <span className="font-semibold">Verification Code: </span>
              <span className="font-mono font-bold text-sm tracking-widest text-emerald-300 ml-1">{otp}</span>
              <p className="text-[11px] text-emerald-400/80 mt-0.5">
                Auto-detected for demo / cloud free-tier testing.
              </p>
            </div>
          )}

          <form onSubmit={onVerifyOtpSubmit} className="space-y-5">
            <div>
              <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 mb-2 uppercase tracking-wider text-center">
                Enter 6-Digit Code
              </label>
              <input
                type="text"
                maxLength={6}
                value={otp}
                onChange={(e) => setOtp(e.target.value.replace(/\D/g, ''))}
                placeholder="123456"
                autoFocus
                className="w-full text-center text-2xl font-mono font-bold tracking-[0.5em] px-4 py-3.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800/10 text-slate-800 dark:text-white focus:outline-none focus:ring-2 focus:ring-brand-500/20 focus:border-brand-500 transition-all placeholder:text-slate-300 dark:placeholder:text-zinc-600"
              />
            </div>

            <button
              type="submit"
              disabled={loading || otp.length !== 6}
              className="w-full inline-flex items-center justify-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-5 py-3 rounded-xl font-semibold text-sm transition-colors shadow-lg shadow-brand-500/20 disabled:opacity-50 disabled:cursor-not-allowed"
            >
              {loading ? (
                <>
                  <Loader2 className="h-4 w-4 animate-spin" /> Verifying...
                </>
              ) : (
                <>
                  <CheckCircle2 className="h-4 w-4" /> Verify & Start Journey
                </>
              )}
            </button>
          </form>

          <div className="text-center space-y-3 pt-2">
            <div className="text-xs text-slate-500 dark:text-slate-400">
              Didn't receive the code?{' '}
              {resendCooldown > 0 ? (
                <span className="font-semibold text-slate-400">Resend in {resendCooldown}s</span>
              ) : (
                <button
                  type="button"
                  onClick={handleResendOtp}
                  disabled={loading}
                  className="font-semibold text-brand-600 dark:text-brand-400 hover:underline inline-flex items-center gap-1"
                >
                  <RefreshCw className="h-3 w-3" /> Resend Code
                </button>
              )}
            </div>

            <div>
              <button
                type="button"
                onClick={() => setStep('REGISTER')}
                className="inline-flex items-center gap-1 text-xs text-slate-400 hover:text-slate-600 dark:hover:text-slate-200"
              >
                <ArrowLeft className="h-3 w-3" /> Change email address
              </button>
            </div>
          </div>

          <div className="mt-5 p-3.5 bg-amber-500/10 border border-amber-500/20 rounded-xl text-center text-xs text-amber-700 dark:text-amber-400">
            <p className="font-semibold flex items-center justify-center gap-1.5">
              <span>Testing locally or in development?</span>
            </p>
            <p className="mt-1 text-[11px] text-amber-800/80 dark:text-amber-300/80 leading-relaxed">
              If an SMTP mail server is not configured in your <code className="font-mono bg-amber-500/20 px-1 py-0.5 rounded">.env</code>, check your backend console logs for <code className="font-mono bg-amber-500/20 px-1 py-0.5 rounded font-bold">[OTP-DISPATCH]</code> to copy your 6-digit code.
            </p>
          </div>
        </div>
      )}
    </div>
  );
};
export default RegisterPage;
