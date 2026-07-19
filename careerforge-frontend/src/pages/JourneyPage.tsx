import React from 'react';
import { useQuery } from '@tanstack/react-query';
import { Link, useNavigate } from 'react-router-dom';
import {
  ArrowRight, Compass, Loader2, Rocket, Code, Brain,
  Layout, Database, Server, Terminal, BookOpen, BarChart3,
  Clock, GitBranch
} from 'lucide-react';
import { studentService } from '../services/studentService';
import { getJourneyConfig, JourneyTrack } from '../data/journeyConfig';
import { Card, CardContent } from '../components/Card';

const iconMap: Record<JourneyTrack['icon'], React.ElementType> = {
  code: Code,
  brain: Brain,
  layout: Layout,
  database: Database,
  server: Server,
  terminal: Terminal,
  book: BookOpen,
  chart: BarChart3,
};

export const JourneyPage: React.FC = () => {
  const navigate = useNavigate();

  const { data: profile, isLoading } = useQuery({
    queryKey: ['studentProfile'],
    queryFn: studentService.getMyProfile,
  });

  if (isLoading) {
    return (
      <div className="flex flex-col items-center justify-center py-32 gap-3 text-slate-500 font-semibold text-xs">
        <Loader2 className="h-5 w-5 animate-spin text-brand-650" />
        Loading your journey...
      </div>
    );
  }

  const journey = getJourneyConfig(
    profile?.targetRole,
    profile?.framework,
    profile?.startingSemester,
  );

  // ── No journey configured ──
  if (!journey) {
    return (
      <div className="max-w-xl mx-auto text-center py-20 space-y-5">
        <div className="mx-auto h-16 w-16 rounded-2xl bg-gradient-to-br from-brand-100 to-indigo-100 dark:from-brand-900/30 dark:to-indigo-900/30 grid place-items-center">
          <Compass className="h-8 w-8 text-brand-600" />
        </div>
        <h1 className="text-2xl font-extrabold font-heading text-slate-800 dark:text-white">
          Set Up Your Journey
        </h1>
        <p className="text-sm text-slate-500 max-w-md mx-auto leading-relaxed">
          Choose a <strong>starting semester</strong>, <strong>target role</strong>, and <strong>framework</strong> in
          Settings to unlock your personalised preparation plan.
        </p>
        <button
          onClick={() => navigate('/student/settings')}
          className="inline-flex items-center gap-2 bg-brand-600 hover:bg-brand-700 text-white px-6 py-2.5 rounded-xl text-sm font-semibold transition-colors"
        >
          Open Settings <ArrowRight className="h-4 w-4" />
        </button>
      </div>
    );
  }

  const milestones = journey.milestones;

  return (
    <div className="max-w-4xl mx-auto space-y-8 pb-16">

      {/* ── Hero banner ── */}
      <div className="rounded-3xl p-7 md:p-9 text-white bg-gradient-to-br from-brand-700 via-brand-650 to-indigo-800 shadow-xl relative overflow-hidden">
        {/* Decorative circles */}
        <div className="absolute -right-12 -top-12 h-40 w-40 rounded-full bg-white/5" />
        <div className="absolute -right-4 -bottom-8 h-24 w-24 rounded-full bg-white/5" />

        <div className="relative z-10">
          <div className="flex items-center gap-2 text-brand-100 text-[10px] font-bold uppercase tracking-[0.15em]">
            <Rocket className="h-4 w-4" /> Your Preparation Plan
          </div>
          <h1 className="text-3xl font-extrabold font-heading mt-3">
            {journey.title}
          </h1>
          <p className="text-brand-100 mt-2 text-sm leading-relaxed">
            Journey {profile!.startingSemester}: A focused path from
            semester {milestones[0]?.semester} to semester {milestones[milestones.length - 1]?.semester}.
          </p>

          <div className="flex flex-wrap gap-3 mt-5">
            <span className="inline-flex items-center gap-1.5 text-[10px] font-bold bg-white/10 backdrop-blur px-3 py-1.5 rounded-full">
              <Clock className="h-3 w-3" />
              {milestones.length} semesters
            </span>
            <span className="inline-flex items-center gap-1.5 text-[10px] font-bold bg-white/10 backdrop-blur px-3 py-1.5 rounded-full">
              {milestones.reduce((sum, m) => sum + m.tracks.length, 0)} tracks total
            </span>
          </div>
        </div>
      </div>

      {/* ── Timeline ── */}
      <div className="relative space-y-0">
        {milestones.map((milestone, index) => {
          const isLast = index === milestones.length - 1;

          return (
            <div key={milestone.semester} className="relative pl-14 pb-8 last:pb-0">

              {/* Timeline connector line */}
              {!isLast && (
                <div className="absolute left-[19px] top-10 bottom-0 w-px bg-gradient-to-b from-brand-300 to-brand-100 dark:from-brand-700 dark:to-brand-900/30" />
              )}

              {/* Semester badge */}
              <div className="absolute left-0 top-0 h-10 w-10 rounded-full bg-gradient-to-br from-brand-600 to-brand-700 text-white grid place-items-center text-xs font-black shadow-lg shadow-brand-600/25">
                {milestone.semester}
              </div>

              <Card className="overflow-hidden hover:shadow-lg transition-shadow duration-300">
                <CardContent className="p-6">

                  {/* Header */}
                  <div className="flex items-start gap-3">
                    <GitBranch className="h-5 w-5 text-brand-600 shrink-0 mt-0.5" />
                    <div className="flex-1 min-w-0">
                      <div className="flex items-center gap-2 flex-wrap">
                        <p className="text-[10px] uppercase tracking-wider font-bold text-brand-600">
                          Semester {milestone.semester}
                        </p>
                        <span className="text-[10px] text-slate-400 font-medium">
                          {milestone.monthsHint}
                        </span>
                      </div>
                      <h2 className="font-bold text-lg mt-1 text-slate-800 dark:text-white">
                        {milestone.title}
                      </h2>
                      <p className="text-sm text-slate-500 mt-1 leading-relaxed">
                        {milestone.description}
                      </p>
                    </div>
                  </div>

                  {/* Track cards */}
                  {milestone.tracks.length > 0 && (
                    <div className="grid sm:grid-cols-2 gap-3 mt-5">
                      {milestone.tracks.map((track) => {
                        const Icon = iconMap[track.icon] || Code;

                        if (track.roadmapId) {
                          return (
                            <Link
                              key={track.name}
                              to={`/student/roadmap?roadmapId=${track.roadmapId}`}
                              className="group border border-brand-200 dark:border-brand-900/50 p-4 rounded-xl hover:bg-brand-50 dark:hover:bg-brand-950/20 transition-colors flex items-center gap-3"
                            >
                              <div className="h-8 w-8 rounded-lg bg-brand-100 dark:bg-brand-900/30 grid place-items-center shrink-0">
                                <Icon className="h-4 w-4 text-brand-600" />
                              </div>
                              <span className="text-sm font-semibold text-slate-700 dark:text-slate-200 flex-1 min-w-0">
                                {track.name}
                              </span>
                              <ArrowRight className="h-4 w-4 text-brand-400 group-hover:text-brand-600 transition-colors shrink-0" />
                            </Link>
                          );
                        }

                        return (
                          <div
                            key={track.name}
                            className="border border-slate-200 dark:border-dark-border p-4 rounded-xl flex items-center gap-3"
                          >
                            <div className="h-8 w-8 rounded-lg bg-slate-100 dark:bg-zinc-800 grid place-items-center shrink-0">
                              <Icon className="h-4 w-4 text-slate-500" />
                            </div>
                            <span className="text-sm font-semibold text-slate-600 dark:text-slate-400">
                              {track.name}
                            </span>
                          </div>
                        );
                      })}
                    </div>
                  )}
                </CardContent>
              </Card>
            </div>
          );
        })}
      </div>
    </div>
  );
};
