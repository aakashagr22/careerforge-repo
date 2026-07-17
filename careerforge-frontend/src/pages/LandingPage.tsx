import React from 'react';
import { useNavigate } from 'react-router-dom';
import { motion } from 'framer-motion';
import { Flame, ArrowRight, Milestone, CheckSquare, Library, Award } from 'lucide-react';
import { useAuthStore } from '../store/authStore';

export const LandingPage: React.FC = () => {
  const navigate = useNavigate();
  const { accessToken, user } = useAuthStore();

  const handleCTA = () => {
    if (accessToken && user) {
      navigate(user.role === 'ADMIN' ? '/admin/dashboard' : '/student/dashboard');
    } else {
      navigate('/register');
    }
  };

  const features = [
    {
      title: 'Personalized Roadmaps',
      description: 'Get month-wise curriculum recommendations matching your Target Role, Language, and Semester.',
      icon: Milestone,
      color: 'bg-indigo-500/10 text-indigo-500',
    },
    {
      title: 'Structured Sheets',
      description: 'Practice checklists curated for DSA, Web Dev, System Design, and Machine Learning.',
      icon: CheckSquare,
      color: 'bg-emerald-500/10 text-emerald-500',
    },
    {
      title: 'Curated Resources',
      description: 'Find top books, articles, videos, and documentation categorised by difficulty.',
      icon: Library,
      color: 'bg-violet-500/10 text-violet-500',
    },
  ];

  return (
    <div className="min-h-screen bg-slate-50 dark:bg-dark-bg text-slate-900 dark:text-slate-100 transition-colors duration-200">
      {/* Navbar */}
      <header className="h-16 border-b border-slate-200/50 dark:border-dark-border/50 bg-white/70 dark:bg-dark-card/70 backdrop-blur-md sticky top-0 z-50">
        <div className="max-w-7xl mx-auto h-full flex items-center justify-between px-6">
          <div className="flex items-center gap-3">
            <div className="h-9 w-9 rounded-lg bg-brand-600 flex items-center justify-center text-white">
              <Flame className="h-5 w-5" />
            </div>
            <span className="font-heading font-bold text-lg text-slate-900 dark:text-white">
              CareerForge
            </span>
          </div>

          <div className="flex items-center gap-4">
            {accessToken && user ? (
              <button 
                onClick={() => navigate(user.role === 'ADMIN' ? '/admin/dashboard' : '/student/dashboard')}
                className="bg-brand-600 hover:bg-brand-700 text-white px-4 py-2 rounded-xl text-sm font-semibold transition-colors shadow-lg shadow-brand-500/20"
              >
                Go to Dashboard
              </button>
            ) : (
              <>
                <button 
                  onClick={() => navigate('/login')}
                  className="text-slate-600 dark:text-slate-400 hover:text-slate-900 dark:hover:text-slate-200 text-sm font-semibold transition-colors"
                >
                  Sign In
                </button>
                <button 
                  onClick={() => navigate('/register')}
                  className="bg-slate-900 hover:bg-slate-800 dark:bg-white dark:hover:bg-slate-100 text-white dark:text-slate-950 px-4 py-2 rounded-xl text-sm font-semibold transition-colors"
                >
                  Get Started
                </button>
              </>
            )}
          </div>
        </div>
      </header>

      {/* Hero Section */}
      <section className="relative pt-24 pb-20 px-6 overflow-hidden">
        {/* Background blobs */}
        <div className="absolute top-[10%] left-[20%] w-[40%] h-[40%] rounded-full bg-brand-500/10 blur-[150px] pointer-events-none" />
        <div className="absolute bottom-[10%] right-[20%] w-[45%] h-[45%] rounded-full bg-brand-500/10 blur-[150px] pointer-events-none" />

        <div className="max-w-4xl mx-auto text-center relative z-10">
          <motion.div
            initial={{ opacity: 0, y: 15 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5 }}
          >
            <span className="inline-flex items-center gap-1.5 px-3 py-1 rounded-full text-xs font-semibold bg-brand-500/10 text-brand-600 dark:text-brand-300 border border-brand-500/20 mb-6">
              <Award className="h-3.5 w-3.5" /> Placement preparation, engineered.
            </span>
          </motion.div>

          <motion.h1
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5, delay: 0.1 }}
            className="text-5xl md:text-7xl font-extrabold text-slate-900 dark:text-white font-heading tracking-tight leading-[1.08] mb-6"
          >
            Forge Your Way to a <span className="bg-gradient-to-r from-brand-500 to-indigo-500 bg-clip-text text-transparent">Dream Offer</span>
          </motion.h1>

          <motion.p
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5, delay: 0.2 }}
            className="text-lg md:text-xl text-slate-500 dark:text-slate-400 max-w-2xl mx-auto mb-10 leading-relaxed"
          >
            CareerForge guides you through personalized learning roadmaps, curated sheets, and progress logs to build a standout portfolio for top tech recruitments.
          </motion.p>

          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5, delay: 0.3 }}
            className="flex flex-col sm:flex-row items-center justify-center gap-4"
          >
            <button
              onClick={handleCTA}
              className="w-full sm:w-auto inline-flex items-center justify-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-8 py-4 rounded-xl font-semibold text-base transition-colors shadow-xl shadow-brand-500/25"
            >
              Start Preparing Free <ArrowRight className="h-5 w-5" />
            </button>
            <button
              onClick={() => navigate('/login')}
              className="w-full sm:w-auto inline-flex items-center justify-center bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800/80 text-slate-800 dark:text-slate-200 border border-slate-200 dark:border-dark-border px-8 py-4 rounded-xl font-semibold text-base transition-colors"
            >
              Sign In to Resume
            </button>
          </motion.div>
        </div>
      </section>

      {/* Features Grid */}
      <section className="py-20 max-w-7xl mx-auto px-6 border-t border-slate-200/50 dark:border-dark-border/50">
        <h2 className="text-3xl font-bold font-heading text-center text-slate-900 dark:text-white mb-16">
          Everything you need to land the offer
        </h2>
        <div className="grid md:grid-cols-3 gap-8">
          {features.map((feature, i) => {
            const Icon = feature.icon;
            return (
              <motion.div
                key={feature.title}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ duration: 0.4, delay: i * 0.1 }}
                className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl p-8 hover:shadow-lg dark:hover:shadow-2xl/20 transition-all group"
              >
                <div className={`h-12 w-12 rounded-xl flex items-center justify-center mb-6 ${feature.color}`}>
                  <Icon className="h-6 w-6" />
                </div>
                <h3 className="text-xl font-bold font-heading text-slate-900 dark:text-white mb-3">
                  {feature.title}
                </h3>
                <p className="text-slate-500 dark:text-slate-400 text-sm leading-relaxed">
                  {feature.description}
                </p>
              </motion.div>
            );
          })}
        </div>
      </section>

      {/* Footer */}
      <footer className="border-t border-slate-200/50 dark:border-dark-border/50 py-12 px-6 bg-white dark:bg-dark-card">
        <div className="max-w-7xl mx-auto flex flex-col md:flex-row items-center justify-between gap-6 text-sm text-slate-500">
          <div className="flex items-center gap-2">
            <Flame className="h-4 w-4 text-brand-600" />
            <span className="font-semibold text-slate-800 dark:text-slate-200">CareerForge</span>
            <span>&copy; {new Date().getFullYear()}. All rights reserved.</span>
          </div>
          <div className="flex items-center gap-6">
            <a href="#" className="hover:text-brand-600">Privacy Policy</a>
            <a href="#" className="hover:text-brand-600">Terms of Service</a>
          </div>
        </div>
      </footer>

    </div>
  );
};
export default LandingPage;
