import React from 'react';
import { Outlet, Navigate } from 'react-router-dom';
import { motion } from 'framer-motion';
import { useAuthStore } from '../store/authStore';
import { Flame } from 'lucide-react';

export const AuthLayout: React.FC = () => {
  const { accessToken, user } = useAuthStore();

  // If user is already logged in, redirect them to their respective dashboard
  if (accessToken && user) {
    const targetDashboard = user.role === 'ADMIN' ? '/admin/dashboard' : '/student/dashboard';
    return <Navigate to={targetDashboard} replace />;
  }

  return (
    <div className="min-h-screen w-full flex items-center justify-center bg-slate-50 dark:bg-dark-bg transition-colors duration-200 p-4 relative overflow-hidden">
      {/* SaaS subtle decorative background gradients */}
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] rounded-full bg-brand-500/10 blur-[120px] pointer-events-none" />
      <div className="absolute bottom-[-20%] right-[-10%] w-[50%] h-[50%] rounded-full bg-brand-500/10 blur-[120px] pointer-events-none" />

      <motion.div
        initial={{ opacity: 0, y: 20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.4 }}
        className="w-full max-w-md bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl shadow-xl dark:shadow-2xl/40 p-8 z-10"
      >
        <div className="flex flex-col items-center justify-center mb-8">
          <div className="h-12 w-12 rounded-xl bg-brand-600 flex items-center justify-center text-white mb-3 shadow-lg shadow-brand-500/30">
            <Flame className="h-6 w-6" />
          </div>
          <h2 className="text-3xl font-extrabold text-slate-900 dark:text-white font-heading">
            CareerForge
          </h2>
          <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
            Build your placement ready portfolio
          </p>
        </div>

        <Outlet />
      </motion.div>
    </div>
  );
};
