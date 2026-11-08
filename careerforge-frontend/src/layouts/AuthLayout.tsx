import React from 'react';
import { Outlet, Navigate } from 'react-router-dom';
import { motion } from 'framer-motion';
import { useAuthStore } from '../store/authStore';
import { Compass, Flame, Network } from 'lucide-react';

export const AuthLayout: React.FC = () => {
  const { accessToken, user } = useAuthStore();

  // If user is already logged in, redirect them to their respective dashboard
  if (accessToken && user) {
    const targetDashboard = user.role === 'ADMIN' ? '/admin/dashboard' : '/student/dashboard';
    return <Navigate to={targetDashboard} replace />;
  }

  return (
    <div className="min-h-screen w-full bg-slate-50 dark:bg-dark-bg lg:grid lg:grid-cols-[1.08fr_.92fr] transition-colors duration-200">
      <section className="auth-discovery-panel relative hidden overflow-hidden p-10 text-white lg:flex lg:flex-col lg:justify-between xl:p-16">
        <div className="auth-network-grid absolute inset-0 opacity-70" />
        <div className="absolute -bottom-48 -right-36 h-[34rem] w-[34rem] rounded-full border border-white/30" />
        <div className="absolute -bottom-32 -right-20 h-[26rem] w-[26rem] rounded-full border border-white/25" />

        <div className="relative flex items-center gap-3">
          <div className="grid h-11 w-11 place-items-center rounded-2xl bg-slate-950/85 shadow-lg shadow-blue-950/20">
            <Flame className="h-5 w-5" />
          </div>
          <span className="font-heading text-xl font-bold tracking-tight">CareerForge</span>
        </div>

        <div className="relative max-w-xl pb-10">
          <div className="mb-6 inline-flex items-center gap-2 rounded-full border border-white/30 bg-white/10 px-3 py-1.5 text-xs font-semibold backdrop-blur-sm">
            <Network className="h-3.5 w-3.5" /> Your learning network
          </div>
          <h1 className="font-heading text-5xl font-extrabold leading-[1.05] tracking-tight xl:text-6xl">
            Discover your path. Build your future.
          </h1>
          <p className="mt-6 max-w-md text-lg leading-relaxed text-blue-50/90">
            Organize your preparation, practise consistently, and turn each semester into progress.
          </p>
        </div>

        <div className="relative flex items-center gap-2 text-sm text-blue-50/80">
          <Compass className="h-4 w-4" /> One focused step at a time.
        </div>
      </section>

      <section className="flex min-h-screen items-center justify-center px-5 py-10 sm:px-8 lg:px-12">
        <motion.div
          initial={{ opacity: 0, y: 16 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.35 }}
          className="w-full max-w-md"
        >
          <div className="mb-9 flex items-center gap-3 lg:hidden">
            <div className="grid h-10 w-10 place-items-center rounded-xl bg-brand-600 text-white shadow-lg shadow-brand-500/25">
              <Flame className="h-5 w-5" />
            </div>
            <span className="font-heading text-xl font-bold text-slate-900 dark:text-white">CareerForge</span>
          </div>
          <div className="rounded-[28px] border border-slate-200/80 bg-white p-7 shadow-[0_20px_60px_-28px_rgba(30,64,175,.28)] dark:border-dark-border dark:bg-dark-card sm:p-9">
            <Outlet />
          </div>
        </motion.div>
      </section>
    </div>
  );
};
