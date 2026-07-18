import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useQuery } from '@tanstack/react-query';
import { studentService } from '../services/studentService';
import { Card, CardContent } from '../components/Card';
import { Badge } from '../components/Badge';
import { 
  User, Mail, School, BookOpen, Hash, Milestone, 
  Terminal, Flame, CheckCircle, Edit3 
} from 'lucide-react';

export const ProfilePage: React.FC = () => {
  const navigate = useNavigate();

  // Query student profile
  const { data: profile, isLoading, error } = useQuery({
    queryKey: ['studentProfile'],
    queryFn: studentService.getMyProfile,
  });

  if (isLoading) {
    return (
      <div className="space-y-6 animate-pulse max-w-2xl mx-auto">
        <div className="h-44 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
        <div className="h-64 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
      </div>
    );
  }

  if (error || !profile) {
    return (
      <div className="flex flex-col items-center justify-center py-20 text-center space-y-4">
        <h2 className="text-xl font-bold font-heading text-rose-600">Failed to load profile</h2>
        <p className="text-sm text-slate-500 max-w-sm">
          Please make sure the Spring Boot backend is active and database records exist.
        </p>
      </div>
    );
  }

  // Get initial letters for avatar
  const initials = `${profile.firstName?.charAt(0) || ''}${profile.lastName?.charAt(0) || ''}`.toUpperCase();

  return (
    <div className="space-y-8 max-w-3xl mx-auto">
      
      {/* ==================== PREMIUM HEADER CARD ==================== */}
      <Card className="relative overflow-hidden border-none shadow-xl bg-gradient-to-r from-brand-600 to-indigo-650 text-white">
        <div className="absolute -top-10 -right-10 w-40 h-40 bg-white/10 rounded-full blur-2xl pointer-events-none" />
        
        <CardContent className="p-8 flex flex-col sm:flex-row items-center gap-6">
          {/* Avatar Icon */}
          <div className="h-24 w-24 rounded-2xl bg-white/15 border border-white/20 flex items-center justify-center text-3xl font-bold text-white shadow-inner shrink-0">
            {initials || <User className="h-10 w-10 text-white" />}
          </div>

          {/* User Meta */}
          <div className="text-center sm:text-left space-y-1.5 flex-1 min-w-0">
            <div className="flex flex-col sm:flex-row sm:items-center gap-2">
              <h1 className="text-2xl font-bold font-heading leading-tight truncate">
                {profile.firstName} {profile.lastName}
              </h1>
              {profile.targetRole && (
                <Badge variant="warning" className="w-fit self-center sm:self-auto text-[9px] uppercase tracking-wide bg-amber-500/20 text-amber-200 border-amber-500/30">
                  {profile.targetRole} Target
                </Badge>
              )}
            </div>
            
            <p className="text-sm text-brand-100 flex items-center justify-center sm:justify-start gap-1.5 truncate">
              <Mail className="h-4 w-4 shrink-0 opacity-80" /> {profile.email}
            </p>
            
            <div className="flex flex-wrap justify-center sm:justify-start gap-2 pt-1.5">
              <span className="inline-flex items-center gap-1 text-xs bg-white/10 px-2.5 py-1 rounded-lg">
                <Terminal className="h-3.5 w-3.5" /> {profile.preferredLanguage || 'JAVA'}
              </span>
              <span className="inline-flex items-center gap-1 text-xs bg-white/10 px-2.5 py-1 rounded-lg">
                <BookOpen className="h-3.5 w-3.5" /> Semester {profile.semester || 5}
              </span>
            </div>
          </div>

          {/* Edit profile shortcut button */}
          <button
            onClick={() => navigate('/student/settings')}
            className="sm:self-start inline-flex items-center gap-1.5 bg-white text-brand-700 hover:bg-slate-100 px-4 py-2 rounded-xl font-bold text-xs transition-colors shrink-0 shadow"
          >
            <Edit3 className="h-3.5 w-3.5" /> Edit Profile
          </button>
        </CardContent>
      </Card>

      {/* ==================== METRICS SECTION ==================== */}
      <div className="grid grid-cols-1 gap-6">
        
        {/* Streak Counter */}
        <Card hoverEffect>
          <CardContent className="p-6 flex items-center gap-4">
            <div className="h-12 w-12 rounded-2xl bg-amber-500/10 text-amber-500 flex items-center justify-center shrink-0">
              <Flame className="h-6 w-6" />
            </div>
            <div>
              <span className="text-[10px] font-semibold text-slate-500 dark:text-slate-400 uppercase tracking-wide block">
                Active Study Streak
              </span>
              <span className="text-2xl font-bold text-slate-900 dark:text-white block mt-0.5">
                {profile.streak || 0} Days
              </span>
              <span className="text-[10px] text-slate-450 block mt-0.5">
                Practice daily to raise your streak score.
              </span>
            </div>
          </CardContent>
        </Card>
      </div>

      {/* ==================== ACADEMIC DETAILS CARD ==================== */}
      <Card>
        <CardContent className="p-6 space-y-4">
          <h3 className="text-base font-bold font-heading text-slate-800 dark:text-white border-b border-slate-200/50 dark:border-dark-border/40 pb-2">
            Academic Information
          </h3>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-y-4 gap-x-8 text-sm">
            

            <div className="flex items-center gap-3">
              <BookOpen className="h-5 w-5 text-slate-450 shrink-0" />
              <div className="min-w-0">
                <span className="text-[10px] text-slate-450 block">Branch & Section</span>
                <span className="font-semibold text-slate-800 dark:text-slate-200 block truncate">
                  {profile.branch || 'Not specified'} {profile.section ? `(Sec ${profile.section})` : ''}
                </span>
              </div>
            </div>

            <div className="flex items-center gap-3">
              <Hash className="h-5 w-5 text-slate-450 shrink-0" />
              <div className="min-w-0">
                <span className="text-[10px] text-slate-450 block">Enrollment Number</span>
                <span className="font-semibold text-slate-800 dark:text-slate-200 block truncate">
                  {profile.enrollmentNo || 'Not specified'}
                </span>
              </div>
            </div>

            <div className="flex items-center gap-3">
              <Milestone className="h-5 w-5 text-slate-450 shrink-0" />
              <div className="min-w-0">
                <span className="text-[10px] text-slate-450 block">Preferred Curriculum Target</span>
                <span className="font-semibold text-slate-800 dark:text-slate-200 block truncate capitalize">
                  {profile.targetRole?.toLowerCase().replace('_', ' ') || 'SDE'} prep
                </span>
              </div>
            </div>

          </div>
        </CardContent>
      </Card>

    </div>
  );
};
export default ProfilePage;
