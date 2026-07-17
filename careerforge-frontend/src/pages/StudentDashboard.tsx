import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useQuery } from '@tanstack/react-query';
import { useAuthStore } from '../store/authStore';
import { progressService } from '../services/progressService';
import { ProgressBar } from '../components/ProgressBar';
import { Card, CardContent } from '../components/Card';
import { 
  Flame, CheckCircle, Layers, Play, 
  Milestone, Award, Calendar, ChevronRight, BookOpen 
} from 'lucide-react';
import { 
  AreaChart, Area, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer 
} from 'recharts';

export const StudentDashboard: React.FC = () => {
  const navigate = useNavigate();
  const { user } = useAuthStore();

  const { data, isLoading, error } = useQuery({
    queryKey: ['studentDashboard'],
    queryFn: progressService.getDashboardData,
  });

  const handleResume = () => {
    navigate('/student/roadmap');
  };

  if (isLoading) {
    return (
      <div className="space-y-8 animate-pulse">
        {/* Greetings Skeleton */}
        <div className="h-28 bg-slate-200 dark:bg-zinc-800 rounded-2xl w-full" />

        {/* Stats Grid Skeleton */}
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
          {[...Array(4)].map((_, i) => (
            <div key={i} className="h-24 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          ))}
        </div>

        {/* Charts & Actions Skeleton */}
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
          <div className="lg:col-span-2 h-72 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          <div className="h-72 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
        </div>
      </div>
    );
  }

  if (error || !data) {
    return (
      <div className="flex flex-col items-center justify-center py-20 text-center space-y-4">
        <div className="h-14 w-14 bg-rose-100 dark:bg-rose-950/20 text-rose-600 rounded-full flex items-center justify-center">
          <Award className="h-7 w-7" />
        </div>
        <h2 className="text-xl font-bold font-heading">Unable to load dashboard</h2>
        <p className="text-sm text-slate-500 max-w-sm">
          Please make sure your profile details are fully configured in the Profile tab to enable roadmap tracking.
        </p>
        <button
          onClick={() => navigate('/student/profile')}
          className="bg-brand-600 hover:bg-brand-700 text-white px-5 py-2.5 rounded-xl text-sm font-semibold transition-colors"
        >
          Configure Profile
        </button>
      </div>
    );
  }

  // Quick Stats config mapping
  const stats = [
    {
      title: 'Current Streak',
      value: `${data.streak} Days`,
      description: 'Consecutive active days',
      icon: Flame,
      color: 'bg-amber-500/10 text-amber-500',
    },
    {
      title: 'Completed Topics',
      value: data.completedTopics,
      description: 'Tasks marked complete',
      icon: CheckCircle,
      color: 'bg-emerald-500/10 text-emerald-500',
    },
    {
      title: 'Sheets Completed',
      value: data.completedSheets,
      description: 'Checklists fully completed',
      icon: Layers,
      color: 'bg-violet-500/10 text-violet-500',
    },
  ];

  return (
    <div className="space-y-8">
      
      {/* ==================== HEADING & GREETING CARD ==================== */}
      <div className="relative overflow-hidden bg-brand-600 dark:bg-brand-900/30 border border-brand-500/20 rounded-2xl p-6 md:p-8 text-white shadow-xl shadow-brand-500/10 flex flex-col md:flex-row justify-between items-start md:items-center gap-6">
        <div className="space-y-2 relative z-10">
          <span className="text-xs font-bold uppercase tracking-wider bg-white/20 dark:bg-brand-800/50 px-2.5 py-1 rounded-full">
            PLACEMENT PATHWAY ACTIVE
          </span>
          <h1 className="text-3xl md:text-4xl font-extrabold font-heading tracking-tight">
            Hello, {user?.firstName}!
          </h1>
          <p className="text-brand-100 dark:text-slate-350 text-sm md:text-base max-w-lg leading-relaxed">
            Ready for today's coding target? Update your checklists to keep your streak streak alive.
          </p>
        </div>
        <button
          onClick={handleResume}
          className="bg-white text-brand-700 hover:bg-brand-50 px-6 py-3.5 rounded-xl font-bold text-sm shadow-md transition-all shrink-0 flex items-center gap-2 relative z-10"
        >
          <Play className="h-4 w-4 fill-current" /> Resume Learning
        </button>
        {/* Background decorative glowing circles */}
        <div className="absolute right-[-10%] top-[-20%] w-60 h-60 rounded-full bg-white/5 blur-xl pointer-events-none" />
      </div>

      {/* ==================== METRICS GRID ==================== */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
        {stats.map((stat, i) => {
          const Icon = stat.icon;
          return (
            <Card key={i} hoverEffect>
              <CardContent className="flex items-center gap-4 p-6">
                <div className={`h-12 w-12 rounded-xl flex items-center justify-center shrink-0 ${stat.color}`}>
                  <Icon className="h-6 w-6" />
                </div>
                <div className="min-w-0">
                  <span className="text-xs font-semibold text-slate-500 dark:text-slate-400 block truncate">
                    {stat.title}
                  </span>
                  <span className="text-2xl font-bold text-slate-900 dark:text-white block mt-0.5">
                    {stat.value}
                  </span>
                  <span className="text-[10px] text-slate-400 block truncate">
                    {stat.description}
                  </span>
                </div>
              </CardContent>
            </Card>
          );
        })}

        {/* Roadmap Completion Progress Card */}
        <Card hoverEffect className="lg:col-span-1">
          <CardContent className="p-6 flex flex-col justify-between h-full">
            <div className="flex items-center justify-between mb-2">
              <span className="text-xs font-semibold text-slate-500 dark:text-slate-400">
                Roadmap Progress
              </span>
              <span className="text-sm font-bold text-brand-600 dark:text-brand-400">
                {Math.round(data.roadmapCompletionPercentage)}%
              </span>
            </div>
            <ProgressBar value={data.roadmapCompletionPercentage} className="my-2" />
            <span className="text-[10px] text-slate-400 mt-2 block">
              milestones achieved
            </span>
          </CardContent>
        </Card>
      </div>

      {/* ==================== CHARTS & QUICK ACTIONS ==================== */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
        
        {/* Weekly Progress Graph */}
        <Card className="lg:col-span-2">
          <CardContent className="p-6">
            <div className="flex items-center justify-between mb-6">
              <div>
                <h3 className="text-base font-bold font-heading text-slate-800 dark:text-white">
                  Weekly Activity
                </h3>
                <p className="text-xs text-slate-400">
                  Topics completed in the past 7 days
                </p>
              </div>
              <div className="flex items-center gap-1.5 text-xs text-slate-500 dark:text-slate-400 border border-slate-200 dark:border-dark-border px-2.5 py-1 rounded-lg">
                <Calendar className="h-3.5 w-3.5" /> Past 7 Days
              </div>
            </div>

            <div className="h-64 w-full">
              <ResponsiveContainer width="100%" height="100%">
                <AreaChart
                  data={data.weeklyProgress}
                  margin={{ top: 10, right: 10, left: -25, bottom: 0 }}
                >
                  <defs>
                    <linearGradient id="colorCompletions" x1="0" y1="0" x2="0" y2="1">
                      <stop offset="5%" stopColor="#8b5cf6" stopOpacity={0.2}/>
                      <stop offset="95%" stopColor="#8b5cf6" stopOpacity={0}/>
                    </linearGradient>
                  </defs>
                  <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#27272a" strokeOpacity={0.1} />
                  <XAxis 
                    dataKey="dayName" 
                    stroke="#888888" 
                    fontSize={11} 
                    tickLine={false} 
                    axisLine={false} 
                  />
                  <YAxis 
                    stroke="#888888" 
                    fontSize={11} 
                    tickLine={false} 
                    axisLine={false} 
                    allowDecimals={false}
                  />
                  <Tooltip 
                    contentStyle={{ 
                      backgroundColor: '#18181b', 
                      borderColor: '#27272a',
                      borderRadius: '12px',
                      color: '#ffffff',
                      fontSize: '12px'
                    }}
                    labelStyle={{ fontWeight: 'bold', color: '#c084fc' }}
                  />
                  <Area 
                    type="monotone" 
                    dataKey="completedCount" 
                    name="Completed Topics"
                    stroke="#8b5cf6" 
                    strokeWidth={2}
                    fillOpacity={1} 
                    fill="url(#colorCompletions)" 
                  />
                </AreaChart>
              </ResponsiveContainer>
            </div>
          </CardContent>
        </Card>

        {/* Quick Actions & Recommendations */}
        <div className="space-y-6">
          <Card>
            <CardContent className="p-6 space-y-4">
              <h3 className="text-base font-bold font-heading text-slate-800 dark:text-white">
                Quick Navigation
              </h3>
              
              <div className="space-y-2.5">
                <button
                  onClick={() => navigate('/student/roadmap')}
                  className="w-full flex items-center justify-between p-3.5 bg-slate-50 dark:bg-zinc-800/10 border border-slate-100 dark:border-zinc-800/40 rounded-xl hover:bg-slate-100/50 dark:hover:bg-zinc-800/30 transition-all text-left text-sm font-medium group"
                >
                  <span className="flex items-center gap-3">
                    <Milestone className="h-5 w-5 text-indigo-500" /> View Personalized Roadmap
                  </span>
                  <ChevronRight className="h-4 w-4 text-slate-400 group-hover:translate-x-0.5 transition-transform" />
                </button>

                <button
                  onClick={() => navigate('/student/sheets')}
                  className="w-full flex items-center justify-between p-3.5 bg-slate-50 dark:bg-zinc-800/10 border border-slate-100 dark:border-zinc-800/40 rounded-xl hover:bg-slate-100/50 dark:hover:bg-zinc-800/30 transition-all text-left text-sm font-medium group"
                >
                  <span className="flex items-center gap-3">
                    <CheckCircle className="h-5 w-5 text-emerald-500" /> Practice Preparation Sheets
                  </span>
                  <ChevronRight className="h-4 w-4 text-slate-400 group-hover:translate-x-0.5 transition-transform" />
                </button>

                <button
                  onClick={() => navigate('/student/resources')}
                  className="w-full flex items-center justify-between p-3.5 bg-slate-50 dark:bg-zinc-800/10 border border-slate-100 dark:border-zinc-800/40 rounded-xl hover:bg-slate-100/50 dark:hover:bg-zinc-800/30 transition-all text-left text-sm font-medium group"
                >
                  <span className="flex items-center gap-3">
                    <BookOpen className="h-5 w-5 text-violet-500" /> Explore Study Library
                  </span>
                  <ChevronRight className="h-4 w-4 text-slate-400 group-hover:translate-x-0.5 transition-transform" />
                </button>
              </div>
            </CardContent>
          </Card>
        </div>
      </div>

    </div>
  );
};
export default StudentDashboard;
