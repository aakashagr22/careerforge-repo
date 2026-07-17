import React from 'react';
import { useNavigate } from 'react-router-dom';
import { motion } from 'framer-motion';
import { FileQuestion, ArrowLeft } from 'lucide-react';

export const NotFoundPage: React.FC = () => {
  const navigate = useNavigate();

  return (
    <div className="min-h-screen w-full flex flex-col items-center justify-center bg-slate-50 dark:bg-dark-bg p-4 transition-colors">
      <motion.div
        initial={{ opacity: 0, scale: 0.95 }}
        animate={{ opacity: 1, scale: 1 }}
        className="text-center max-w-md bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border p-8 rounded-2xl shadow-xl"
      >
        <div className="h-16 w-16 bg-brand-100 dark:bg-brand-950/20 text-brand-600 rounded-full flex items-center justify-center mx-auto mb-6">
          <FileQuestion className="h-10 w-10" />
        </div>
        <h1 className="text-4xl font-extrabold text-slate-900 dark:text-white font-heading tracking-tight mb-2">
          404
        </h1>
        <h2 className="text-xl font-bold text-slate-800 dark:text-slate-200 mb-4 font-heading">
          Page Not Found
        </h2>
        <p className="text-slate-500 dark:text-slate-400 text-sm mb-8">
          The page you are looking for does not exist or has been moved.
        </p>
        <button
          onClick={() => navigate(-1)}
          className="inline-flex items-center gap-2 bg-slate-900 hover:bg-slate-800 dark:bg-white dark:hover:bg-slate-100 text-white dark:text-slate-950 px-5 py-2.5 rounded-xl font-semibold text-sm transition-all"
        >
          <ArrowLeft className="h-4 w-4" /> Go Back
        </button>
      </motion.div>
    </div>
  );
};
export default NotFoundPage;
