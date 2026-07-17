import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useQuery } from '@tanstack/react-query';
import { adminService } from '../services/adminService';
import { Card, CardContent } from '../components/Card';
import { 
  Users, UserCheck, Library, CheckSquare, Flame, 
  ChevronRight, Compass, BarChart2 
} from 'lucide-react';
import { 
  BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, Cell 
} from 'recharts';

export const AdminDashboard: React.FC = () => {
  const navigate = useNavigate();

  const { data: stats, isLoading, error } = useQuery({
    queryKey: ['adminStats'],
    queryFn: adminService.getDashboardStats,
  });

  if (isLoading) {
    return (
      <div className="space-y-8 animate-pulse">
        <div className="h-10 bg-slate-200 dark:bg-zinc-800 rounded-xl w-60" />
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-5 gap-6">
          {[...Array(5)].map((_, i) => (
            <div key={i} className="h-24 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          ))}
        </div>
        <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
          <div className="h-80 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          <div className="h-80 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
        </div>
      </div>
    );
  }

  if (error || !stats) {
    return (
      <div className="flex flex-col items-center justify-center py-20 text-center space-y-4">
        <h2 className="text-xl font-bold font-heading text-rose-600">Failed to load admin stats</h2>
        <p className="text-sm text-slate-500 max-w-sm">
          Please make sure the Spring Boot backend is active at port 8082 and database records exist.
        </p>
      </div>
    );
  }

  // Transform distribution maps to arrays for Recharts
  const branchData = Object.entries(stats.studentDistributionByBranch || {}).map(([key, val]) => ({
    name: key,
    students: val,
  }));

  const collegeData = Object.entries(stats.studentDistributionByCollege || {}).map(([key, val]) => ({
    name: key,
    students: val,
  }));

  const COLORS = ['#8b5cf6', '#3b82f6', '#10b981', '#f59e0b', '#ef4444', '#ec4899'];

  const metrics = [
    {
      title: 'Total Registered',
      value: stats.totalStudents,
      description: 'Total student profiles',
      icon: Users,
      color: 'bg-brand-500/10 text-brand-600 dark:text-brand-400',
    },
    {
      title: 'Active Accounts',
      value: stats.activeStudents,
      description: 'Active student sessions',
      icon: UserCheck,
      color: 'bg-emerald-500/10 text-emerald-650 dark:text-emerald-400',
    },
    {
      title: 'Practice Sheets',
      value: stats.totalSheets,
      description: 'Active coding sheets',
      icon: CheckSquare,
      color: 'bg-amber-500/10 text-amber-600 dark:text-amber-400',
    },
    {
      title: 'Study Resources',
      value: stats.totalResources,
      description: 'Curated references',
      icon: Library,
      color: 'bg-violet-500/10 text-violet-600 dark:text-violet-400',
    },
    {
      title: 'Average Streak',
      value: `${stats.averageStreak?.toFixed(1) || 0} Days`,
      description: 'Active streak logs',
      icon: Flame,
      color: 'bg-rose-500/10 text-rose-600 dark:text-rose-450',
    },
  ];

  return (
    <div className="space-y-8">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <BarChart2 className="h-7 w-7 text-rose-600" /> Platform Overview
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Monitor user signups, engagement metrics, and distribution analytics.
        </p>
      </div>

      {/* ==================== METRICS GRID ==================== */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-5 gap-6">
        {metrics.map((m, i) => {
          const Icon = m.icon;
          return (
            <Card key={i} hoverEffect>
              <CardContent className="p-5 flex items-center gap-4">
                <div className={`h-11 w-11 rounded-xl flex items-center justify-center shrink-0 ${m.color}`}>
                  <Icon className="h-5.5 w-5.5" />
                </div>
                <div className="min-w-0">
                  <span className="text-[10px] font-semibold text-slate-500 dark:text-slate-400 block truncate">
                    {m.title}
                  </span>
                  <span className="text-xl font-bold text-slate-900 dark:text-white block mt-0.5">
                    {m.value}
                  </span>
                  <span className="text-[9px] text-slate-450 block truncate">
                    {m.description}
                  </span>
                </div>
              </CardContent>
            </Card>
          );
        })}
      </div>

      {/* ==================== CHARTS ROW ==================== */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
        
        {/* Branch Distribution Bar Chart */}
        <Card>
          <CardContent className="p-6">
            <h3 className="text-base font-bold font-heading text-slate-800 dark:text-white mb-4">
              Students by Branch
            </h3>
            {branchData.length === 0 ? (
              <div className="h-64 flex items-center justify-center text-slate-500 text-sm">
                No branch distribution metrics available yet.
              </div>
            ) : (
              <div className="h-64 w-full">
                <ResponsiveContainer width="100%" height="100%">
                  <BarChart data={branchData} margin={{ top: 10, right: 10, left: -25, bottom: 0 }}>
                    <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#27272a" strokeOpacity={0.1} />
                    <XAxis dataKey="name" stroke="#888888" fontSize={11} tickLine={false} axisLine={false} />
                    <YAxis stroke="#888888" fontSize={11} tickLine={false} axisLine={false} allowDecimals={false} />
                    <Tooltip 
                      contentStyle={{ 
                        backgroundColor: '#18181b', 
                        borderColor: '#27272a',
                        borderRadius: '12px',
                        color: '#ffffff',
                        fontSize: '12px'
                      }}
                    />
                    <Bar dataKey="students" radius={[6, 6, 0, 0]}>
                      {branchData.map((_, index) => (
                        <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
                      ))}
                    </Bar>
                  </BarChart>
                </ResponsiveContainer>
              </div>
            )}
          </CardContent>
        </Card>

        {/* College Distribution Bar Chart */}
        <Card>
          <CardContent className="p-6">
            <h3 className="text-base font-bold font-heading text-slate-800 dark:text-white mb-4">
              Students by College
            </h3>
            {collegeData.length === 0 ? (
              <div className="h-64 flex items-center justify-center text-slate-500 text-sm">
                No college distribution metrics available yet.
              </div>
            ) : (
              <div className="h-64 w-full">
                <ResponsiveContainer width="100%" height="100%">
                  <BarChart data={collegeData} margin={{ top: 10, right: 10, left: -25, bottom: 0 }}>
                    <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#27272a" strokeOpacity={0.1} />
                    <XAxis dataKey="name" stroke="#888888" fontSize={11} tickLine={false} axisLine={false} />
                    <YAxis stroke="#888888" fontSize={11} tickLine={false} axisLine={false} allowDecimals={false} />
                    <Tooltip 
                      contentStyle={{ 
                        backgroundColor: '#18181b', 
                        borderColor: '#27272a',
                        borderRadius: '12px',
                        color: '#ffffff',
                        fontSize: '12px'
                      }}
                    />
                    <Bar dataKey="students" radius={[6, 6, 0, 0]}>
                      {collegeData.map((_, index) => (
                        <Cell key={`cell-${index}`} fill={COLORS[(index + 2) % COLORS.length]} />
                      ))}
                    </Bar>
                  </BarChart>
                </ResponsiveContainer>
              </div>
            )}
          </CardContent>
        </Card>

      </div>

      {/* ==================== QUICK SHORTCUTS CARD ==================== */}
      <Card>
        <CardContent className="p-6 space-y-4">
          <h3 className="text-base font-bold font-heading text-slate-800 dark:text-white">
            Curriculum Management Panels
          </h3>
          <div className="grid grid-cols-1 sm:grid-cols-4 gap-4">
            
            <button
              onClick={() => navigate('/admin/students')}
              className="flex items-center justify-between p-4 bg-slate-50 dark:bg-zinc-800/10 border border-slate-100 dark:border-zinc-800/40 rounded-2xl hover:bg-slate-150/40 dark:hover:bg-zinc-800/35 transition-all text-left text-sm font-medium group"
            >
              <span className="flex items-center gap-3">
                <Users className="h-5 w-5 text-brand-650" /> Manage Students
              </span>
              <ChevronRight className="h-4 w-4 text-slate-400 group-hover:translate-x-0.5 transition-transform" />
            </button>

            <button
              onClick={() => navigate('/admin/resources')}
              className="flex items-center justify-between p-4 bg-slate-50 dark:bg-zinc-800/10 border border-slate-100 dark:border-zinc-800/40 rounded-2xl hover:bg-slate-150/40 dark:hover:bg-zinc-800/35 transition-all text-left text-sm font-medium group"
            >
              <span className="flex items-center gap-3">
                <Library className="h-5 w-5 text-violet-500" /> Manage Resources
              </span>
              <ChevronRight className="h-4 w-4 text-slate-400 group-hover:translate-x-0.5 transition-transform" />
            </button>

            <button
              onClick={() => navigate('/admin/sheets')}
              className="flex items-center justify-between p-4 bg-slate-50 dark:bg-zinc-800/10 border border-slate-100 dark:border-zinc-800/40 rounded-2xl hover:bg-slate-150/40 dark:hover:bg-zinc-800/35 transition-all text-left text-sm font-medium group"
            >
              <span className="flex items-center gap-3">
                <CheckSquare className="h-5 w-5 text-amber-500" /> Manage Sheets
              </span>
              <ChevronRight className="h-4 w-4 text-slate-400 group-hover:translate-x-0.5 transition-transform" />
            </button>

            <button
              onClick={() => navigate('/admin/roadmaps')}
              className="flex items-center justify-between p-4 bg-slate-50 dark:bg-zinc-800/10 border border-slate-100 dark:border-zinc-800/40 rounded-2xl hover:bg-slate-150/40 dark:hover:bg-zinc-800/35 transition-all text-left text-sm font-medium group"
            >
              <span className="flex items-center gap-3">
                <Compass className="h-5 w-5 text-rose-500" /> Setup Roadmaps
              </span>
              <ChevronRight className="h-4 w-4 text-slate-400 group-hover:translate-x-0.5 transition-transform" />
            </button>

          </div>
        </CardContent>
      </Card>

    </div>
  );
};
export default AdminDashboard;
