import React, { useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import { 
  Trophy, Award, Calendar, Clock, ExternalLink, ShieldAlert,
  CheckCircle2, AlertCircle, RefreshCw, X, Users, HelpCircle
} from 'lucide-react';
import { contestService, Contest, LeaderboardEntry, StudentParticipation } from '../services/contestService';
import { Card, CardContent } from '../components/Card';
import Badge from '../components/Badge';

const KERNEL_WEB_URL = (import.meta.env.VITE_KERNEL_WEB_URL || 'http://localhost:3000').replace(/\/+$/, '');

export const ContestsPage: React.FC = () => {
  const [activeTab, setActiveTab] = useState<'all' | 'history'>('all');
  const [statusFilter, setStatusFilter] = useState<'all' | 'live' | 'upcoming' | 'concluded'>('all');
  const [selectedLeaderboardCode, setSelectedLeaderboardCode] = useState<string | null>(null);

  // Query all contests
  const { 
    data: contests = [], 
    isLoading: isLoadingContests, 
    isFetching: isFetchingContests,
    refetch: refetchContests 
  } = useQuery({
    queryKey: ['externalContests', statusFilter],
    queryFn: () => contestService.getContests(statusFilter),
    refetchInterval: 30000,
  });

  // Query logged-in student's contest history
  const { 
    data: historyData, 
    isLoading: isLoadingHistory, 
    refetch: refetchHistory 
  } = useQuery({
    queryKey: ['myContestHistory'],
    queryFn: contestService.getMyContestHistory,
  });

  const participations: StudentParticipation[] = historyData?.participations || [];

  // Query leaderboard for the modal
  const { 
    data: leaderboardData, 
    isLoading: isLoadingLeaderboard 
  } = useQuery({
    queryKey: ['contestLeaderboard', selectedLeaderboardCode],
    queryFn: () => contestService.getLeaderboard(selectedLeaderboardCode!),
    enabled: !!selectedLeaderboardCode,
  });

  const liveCount = contests.filter((c) => c.isLive).length;
  const participatedCount = participations.length;
  const bestRank = participations
    .filter((p) => p.rank !== null && p.rank > 0)
    .reduce<number | null>((min, p) => (min === null || (p.rank! < min) ? p.rank : min), null);

  const formatDate = (dateStr: string) => {
    try {
      const d = new Date(dateStr);
      return d.toLocaleDateString(undefined, {
        month: 'short',
        day: 'numeric',
        year: 'numeric',
        hour: '2-digit',
        minute: '2-digit',
      });
    } catch {
      return dateStr;
    }
  };

  return (
    <div className="space-y-8 max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-6">
      {/* ==================== HERO HEADER ==================== */}
      <div className="relative overflow-hidden rounded-3xl bg-linear-to-r from-brand-600 via-brand-700 to-indigo-800 text-white p-8 md:p-10 shadow-lg">
        <div className="relative z-10 flex flex-col md:flex-row md:items-center justify-between gap-6">
          <div className="space-y-3 max-w-2xl">
            <div className="inline-flex items-center gap-2 px-3 py-1 rounded-full text-xs font-semibold bg-white/10 backdrop-blur-md border border-white/20 text-brand-100">
              <Trophy className="h-3.5 w-3.5 text-amber-300" />
              Integrated with Kernel Contest Engine
            </div>
            <h1 className="text-3xl sm:text-4xl font-extrabold font-heading tracking-tight text-white">
              Coding Contests & Leaderboards
            </h1>
            <p className="text-brand-100 text-sm sm:text-base leading-relaxed">
              Take part in competitive coding challenges, review detailed test case diagnostics, and benchmark your rank across the entire campus.
            </p>
          </div>

          <div className="grid grid-cols-3 gap-3 shrink-0 bg-white/10 backdrop-blur-md border border-white/20 rounded-2xl p-4">
            <div className="text-center px-3">
              <div className="text-2xl font-extrabold text-white">{contests.length}</div>
              <div className="text-xs text-brand-200 font-medium">Contests</div>
            </div>
            <div className="text-center px-3 border-x border-white/20">
              <div className="text-2xl font-extrabold text-emerald-300">{liveCount}</div>
              <div className="text-xs text-brand-200 font-medium">Live Now</div>
            </div>
            <div className="text-center px-3">
              <div className="text-2xl font-extrabold text-amber-300">
                {bestRank ? `#${bestRank}` : participatedCount > 0 ? 'Ranked' : '—'}
              </div>
              <div className="text-xs text-brand-200 font-medium">Best Rank</div>
            </div>
          </div>
        </div>
      </div>

      {/* ==================== TAB SWITCHER ==================== */}
      <div className="flex items-center justify-between border-b border-slate-200 dark:border-dark-border pb-2">
        <div className="flex gap-2">
          <button
            onClick={() => setActiveTab('all')}
            className={`px-5 py-2.5 rounded-xl text-sm font-semibold transition-all duration-200 flex items-center gap-2 ${
              activeTab === 'all'
                ? 'bg-brand-600 text-white shadow-sm'
                : 'text-slate-600 dark:text-zinc-400 hover:bg-slate-100 dark:hover:bg-zinc-800'
            }`}
          >
            <Trophy className="h-4 w-4" />
            Explore Contests
            {liveCount > 0 && (
              <span className="h-2 w-2 rounded-full bg-emerald-400 animate-pulse" />
            )}
          </button>

          <button
            onClick={() => setActiveTab('history')}
            className={`px-5 py-2.5 rounded-xl text-sm font-semibold transition-all duration-200 flex items-center gap-2 ${
              activeTab === 'history'
                ? 'bg-brand-600 text-white shadow-sm'
                : 'text-slate-600 dark:text-zinc-400 hover:bg-slate-100 dark:hover:bg-zinc-800'
            }`}
          >
            <Award className="h-4 w-4" />
            My Scorecards & History
            {participatedCount > 0 && (
              <span className="px-2 py-0.5 rounded-full text-xs font-bold bg-white/20 dark:bg-zinc-700">
                {participatedCount}
              </span>
            )}
          </button>
        </div>

        <button
          onClick={() => {
            refetchContests();
            refetchHistory();
          }}
          disabled={isFetchingContests}
          className="p-2 text-slate-500 hover:text-slate-900 dark:text-zinc-400 dark:hover:text-white rounded-lg hover:bg-slate-100 dark:hover:bg-zinc-800 transition-colors"
          title="Refresh contests"
        >
          <RefreshCw className={`h-4 w-4 ${isFetchingContests ? 'animate-spin' : ''}`} />
        </button>
      </div>

      {/* ==================== TAB 1: ALL CONTESTS ==================== */}
      {activeTab === 'all' && (
        <div className="space-y-6">
          {/* Status Filter Chips */}
          <div className="flex flex-wrap gap-2">
            {(['all', 'live', 'upcoming', 'concluded'] as const).map((filter) => (
              <button
                key={filter}
                onClick={() => setStatusFilter(filter)}
                className={`px-3.5 py-1.5 rounded-lg text-xs font-semibold capitalize transition-all ${
                  statusFilter === filter
                    ? 'bg-slate-900 text-white dark:bg-white dark:text-slate-900'
                    : 'bg-white dark:bg-dark-card border border-slate-200 dark:border-dark-border text-slate-600 dark:text-zinc-400 hover:border-slate-300 dark:hover:border-zinc-700'
                }`}
              >
                {filter === 'all' ? 'All Contests' : filter}
              </button>
            ))}
          </div>

          {/* Loading Skeletons */}
          {isLoadingContests ? (
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 animate-pulse">
              {[...Array(6)].map((_, i) => (
                <div key={i} className="h-64 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
              ))}
            </div>
          ) : contests.length === 0 ? (
            <div className="text-center py-16 bg-white dark:bg-dark-card rounded-2xl border border-slate-200 dark:border-dark-border p-8 space-y-3">
              <Trophy className="h-10 w-10 text-slate-400 mx-auto" />
              <h3 className="text-base font-bold text-slate-800 dark:text-white">No contests found</h3>
              <p className="text-xs text-slate-500 dark:text-zinc-400 max-w-sm mx-auto">
                No contests match the selected filter. Try switching to "All Contests" to explore past and scheduled sprint exams.
              </p>
            </div>
          ) : (
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
              {contests.map((contest: Contest) => {
                const isLive = contest.status === 'LIVE' || contest.isLive;
                const isConcluded = contest.status === 'CONCLUDED' || contest.isEnded;

                return (
                  <Card
                    key={contest.id}
                    hoverEffect
                    className={`flex flex-col justify-between overflow-hidden transition-all duration-200 ${
                      isLive
                        ? 'border-emerald-500/50 shadow-md shadow-emerald-500/5 ring-1 ring-emerald-500/30'
                        : ''
                    }`}
                  >
                    <CardContent className="p-6 space-y-4 flex-1 flex flex-col justify-between">
                      <div className="space-y-3">
                        {/* Status & Code Header */}
                        <div className="flex items-center justify-between gap-2">
                          <span className="font-mono text-xs font-bold px-2 py-0.5 rounded-md bg-slate-100 dark:bg-zinc-800 text-slate-700 dark:text-zinc-300 border border-slate-200 dark:border-zinc-700">
                            {contest.code}
                          </span>

                          {isLive ? (
                            <Badge variant="success" className="animate-pulse">
                              <span className="h-1.5 w-1.5 rounded-full bg-emerald-500 mr-1.5 inline-block" />
                              LIVE NOW
                            </Badge>
                          ) : isConcluded ? (
                            <Badge variant="slate">Concluded</Badge>
                          ) : (
                            <Badge variant="brand">Upcoming</Badge>
                          )}
                        </div>

                        {/* Title & Description */}
                        <div>
                          <h3 className="text-lg font-bold text-slate-900 dark:text-white line-clamp-1">
                            {contest.title}
                          </h3>
                          <p className="text-xs text-slate-500 dark:text-zinc-400 line-clamp-2 mt-1">
                            {contest.description || 'Algorithmic problem-solving and technical sprint contest.'}
                          </p>
                        </div>

                        {/* Metadata Pills */}
                        <div className="grid grid-cols-2 gap-2 pt-2 border-t border-slate-100 dark:border-dark-border text-xs text-slate-600 dark:text-zinc-400">
                          <div className="flex items-center gap-1.5">
                            <HelpCircle className="h-3.5 w-3.5 text-slate-400" />
                            <span>{contest.totalQuestions} Questions</span>
                          </div>
                          <div className="flex items-center gap-1.5">
                            <Award className="h-3.5 w-3.5 text-slate-400" />
                            <span>{contest.totalScore} Total Marks</span>
                          </div>
                          <div className="flex items-center gap-1.5">
                            <Clock className="h-3.5 w-3.5 text-slate-400" />
                            <span>{contest.duration || contest.totalTime} mins</span>
                          </div>
                          <div className="flex items-center gap-1.5">
                            <Calendar className="h-3.5 w-3.5 text-slate-400" />
                            <span>{formatDate(contest.startTime).split(',')[0]}</span>
                          </div>
                        </div>
                      </div>

                      {/* Action Buttons */}
                      <div className="pt-4 mt-2 border-t border-slate-100 dark:border-dark-border flex items-center justify-between gap-3">
                        <button
                          onClick={() => setSelectedLeaderboardCode(contest.code)}
                          className="flex-1 text-xs font-semibold py-2 px-3 rounded-xl border border-slate-200 dark:border-dark-border text-slate-700 dark:text-zinc-300 hover:bg-slate-50 dark:hover:bg-zinc-800 transition-colors flex items-center justify-center gap-1.5"
                        >
                          <Trophy className="h-3.5 w-3.5 text-amber-500" />
                          Leaderboard
                        </button>

                        <a
                          href={`${KERNEL_WEB_URL}/contest/${contest.code}`}
                          target="_blank"
                          rel="noopener noreferrer"
                          className={`flex-1 text-xs font-semibold py-2 px-3 rounded-xl transition-all flex items-center justify-center gap-1.5 ${
                            isLive
                              ? 'bg-emerald-600 hover:bg-emerald-700 text-white shadow-sm shadow-emerald-600/20'
                              : 'bg-brand-600 hover:bg-brand-700 text-white'
                          }`}
                        >
                          <span>{isLive ? 'Enter Contest' : 'View Page'}</span>
                          <ExternalLink className="h-3 w-3" />
                        </a>
                      </div>
                    </CardContent>
                  </Card>
                );
              })}
            </div>
          )}
        </div>
      )}

      {/* ==================== TAB 2: MY SCORECARDS & HISTORY ==================== */}
      {activeTab === 'history' && (
        <div className="space-y-6">
          {isLoadingHistory ? (
            <div className="space-y-4 animate-pulse">
              {[...Array(3)].map((_, i) => (
                <div key={i} className="h-28 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
              ))}
            </div>
          ) : participations.length === 0 ? (
            <div className="text-center py-20 bg-white dark:bg-dark-card rounded-2xl border border-slate-200 dark:border-dark-border p-8 space-y-4">
              <div className="h-16 w-16 bg-brand-50 dark:bg-brand-950/20 text-brand-600 rounded-full flex items-center justify-center mx-auto">
                <Trophy className="h-8 w-8" />
              </div>
              <h3 className="text-lg font-bold text-slate-900 dark:text-white">
                No Contest Participations Yet
              </h3>
              <p className="text-sm text-slate-500 dark:text-zinc-400 max-w-md mx-auto">
                You haven't participated in any coding sprint contests yet. Enter an active contest above to record your scorecard, verify code diagnostics, and establish your campus leaderboard rank!
              </p>
              <button
                onClick={() => setActiveTab('all')}
                className="bg-brand-600 hover:bg-brand-700 text-white px-5 py-2.5 rounded-xl text-xs font-semibold transition-colors"
              >
                Browse Active Contests
              </button>
            </div>
          ) : (
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              {participations.map((part: StudentParticipation) => {
                const isConcluded = part.status === 'CONCLUDED';
                const isPending = part.status === 'RESULTS_PENDING';

                return (
                  <Card key={part.participationId} hoverEffect className="overflow-hidden">
                    <CardContent className="p-6 space-y-4">
                      {/* Contest Header */}
                      <div className="flex items-start justify-between gap-3">
                        <div>
                          <div className="flex items-center gap-2 mb-1">
                            <span className="font-mono text-xs font-bold px-2 py-0.5 rounded-md bg-slate-100 dark:bg-zinc-800 text-slate-700 dark:text-zinc-300 border border-slate-200 dark:border-zinc-700">
                              {part.contestCode}
                            </span>
                            {isConcluded ? (
                              <Badge variant="success">Concluded</Badge>
                            ) : isPending ? (
                              <Badge variant="warning">Results Pending</Badge>
                            ) : (
                              <Badge variant="brand">{part.status}</Badge>
                            )}
                          </div>
                          <h3 className="text-base font-bold text-slate-900 dark:text-white line-clamp-1">
                            {part.contestTitle}
                          </h3>
                        </div>

                        {/* Rank Badge */}
                        {isConcluded && part.rank ? (
                          <div className={`px-3 py-1.5 rounded-xl text-center shrink-0 border ${
                            part.rank === 1
                              ? 'bg-amber-500/10 border-amber-500/30 text-amber-700 dark:text-amber-300'
                              : part.rank === 2
                              ? 'bg-slate-200 border-slate-300 text-slate-800 dark:bg-zinc-800 dark:text-zinc-200'
                              : part.rank === 3
                              ? 'bg-amber-700/10 border-amber-700/30 text-amber-800 dark:text-amber-400'
                              : 'bg-brand-50 border-brand-200 text-brand-700 dark:bg-brand-950/20 dark:border-brand-900'
                          }`}>
                            <div className="text-xs font-bold">Rank</div>
                            <div className="text-lg font-extrabold leading-tight">#{part.rank}</div>
                          </div>
                        ) : null}
                      </div>

                      {/* Performance Breakdown */}
                      <div className="bg-slate-50 dark:bg-zinc-900/40 rounded-xl p-4 border border-slate-100 dark:border-zinc-800 space-y-3">
                        <div className="flex items-center justify-between text-xs font-semibold">
                          <span className="text-slate-500 dark:text-zinc-400">Score Achieved</span>
                          <span className="text-slate-900 dark:text-white font-mono">
                            {isConcluded ? `${part.score} / ${part.maxScore} pts` : 'Locked (Contest Active)'}
                          </span>
                        </div>

                        {isConcluded && part.percentage !== null && (
                          <div className="w-full bg-slate-200 dark:bg-zinc-800 h-2 rounded-full overflow-hidden">
                            <div
                              className="bg-brand-600 h-full rounded-full transition-all duration-500"
                              style={{ width: `${Math.min(100, Math.max(0, part.percentage))}%` }}
                            />
                          </div>
                        )}

                        <div className="grid grid-cols-2 gap-2 pt-2 border-t border-slate-200/60 dark:border-zinc-800 text-xs text-slate-600 dark:text-zinc-400">
                          <div>
                            <span className="text-slate-400 block text-[10px]">Time Taken</span>
                            <span className="font-semibold">{part.timeTakenMinutes !== null ? `${part.timeTakenMinutes} mins` : '—'}</span>
                          </div>
                          <div>
                            <span className="text-slate-400 block text-[10px]">Participants</span>
                            <span className="font-semibold">{part.totalParticipants} students</span>
                          </div>
                        </div>
                      </div>

                      {/* Action Links */}
                      <div className="flex items-center justify-between gap-3 pt-2">
                        <button
                          onClick={() => setSelectedLeaderboardCode(part.contestCode)}
                          className="text-xs font-semibold text-slate-700 dark:text-zinc-300 hover:text-brand-600 flex items-center gap-1.5 transition-colors"
                        >
                          <Trophy className="h-3.5 w-3.5 text-amber-500" />
                          View Leaderboard
                        </button>

                        <a
                          href={`${KERNEL_WEB_URL}/contest/${part.contestCode}/results`}
                          target="_blank"
                          rel="noopener noreferrer"
                          className="text-xs font-semibold text-brand-600 hover:text-brand-700 flex items-center gap-1"
                        >
                          <span>Full Scorecard</span>
                          <ExternalLink className="h-3 w-3" />
                        </a>
                      </div>
                    </CardContent>
                  </Card>
                );
              })}
            </div>
          )}
        </div>
      )}

      {/* ==================== LEADERBOARD MODAL ==================== */}
      {selectedLeaderboardCode && (
        <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-black/60 backdrop-blur-xs animate-in fade-in duration-200">
          <div className="bg-white dark:bg-dark-card border border-slate-200 dark:border-dark-border rounded-3xl shadow-2xl w-full max-w-2xl max-h-[85vh] flex flex-col overflow-hidden">
            {/* Modal Header */}
            <div className="px-6 py-5 border-b border-slate-100 dark:border-dark-border flex items-center justify-between bg-slate-50/50 dark:bg-zinc-900/30">
              <div className="flex items-center gap-3">
                <div className="h-10 w-10 rounded-xl bg-amber-500/10 text-amber-600 dark:text-amber-400 flex items-center justify-center border border-amber-500/20">
                  <Trophy className="h-5 w-5" />
                </div>
                <div>
                  <h3 className="text-lg font-bold font-heading text-slate-900 dark:text-white flex items-center gap-2">
                    Official Leaderboard
                    <span className="font-mono text-xs px-2 py-0.5 rounded-md bg-slate-200 dark:bg-zinc-800 text-slate-700 dark:text-zinc-300">
                      {selectedLeaderboardCode}
                    </span>
                  </h3>
                  <p className="text-xs text-slate-500 dark:text-zinc-400">
                    Verified rankings for {leaderboardData?.contest?.title || 'Contest'}
                  </p>
                </div>
              </div>

              <button
                onClick={() => setSelectedLeaderboardCode(null)}
                className="h-8 w-8 rounded-lg flex items-center justify-center text-slate-400 hover:text-slate-600 dark:hover:text-zinc-200 hover:bg-slate-100 dark:hover:bg-zinc-800 transition-colors"
              >
                <X className="h-5 w-5" />
              </button>
            </div>

            {/* Modal Body */}
            <div className="p-6 overflow-y-auto flex-1 space-y-6">
              {isLoadingLeaderboard ? (
                <div className="space-y-3 animate-pulse py-8">
                  {[...Array(5)].map((_, i) => (
                    <div key={i} className="h-14 bg-slate-200 dark:bg-zinc-800 rounded-xl" />
                  ))}
                </div>
              ) : leaderboardData?.timeLocked ? (
                /* Time-locked holding screen for live contests */
                <div className="text-center py-12 px-4 space-y-4">
                  <div className="h-16 w-16 bg-amber-500/10 text-amber-600 dark:text-amber-400 rounded-2xl flex items-center justify-center mx-auto border border-amber-500/20">
                    <ShieldAlert className="h-8 w-8" />
                  </div>
                  <h4 className="text-base font-bold text-slate-900 dark:text-white">
                    Leaderboard Time-Locked
                  </h4>
                  <p className="text-xs text-slate-500 dark:text-zinc-400 max-w-sm mx-auto leading-relaxed">
                    {leaderboardData.message ||
                      'This contest is currently running. To protect exam integrity, official standings will unlock once the contest concludes.'}
                  </p>
                </div>
              ) : leaderboardData?.leaderboard?.length === 0 ? (
                <div className="text-center py-12 text-slate-400 text-xs">
                  No submissions recorded for this contest yet.
                </div>
              ) : (
                /* Verified Concluded Leaderboard Table */
                <div className="overflow-x-auto rounded-xl border border-slate-200 dark:border-dark-border">
                  <table className="w-full text-left border-collapse text-xs">
                    <thead>
                      <tr className="bg-slate-50 dark:bg-zinc-900/60 border-b border-slate-200 dark:border-dark-border text-slate-500 dark:text-zinc-400 font-semibold">
                        <th className="py-3 px-4 w-16 text-center">Rank</th>
                        <th className="py-3 px-4">Student</th>
                        <th className="py-3 px-4 text-center">Score</th>
                        <th className="py-3 px-4 text-center">Accuracy</th>
                        <th className="py-3 px-4 text-right">Time Taken</th>
                      </tr>
                    </thead>
                    <tbody className="divide-y divide-slate-100 dark:divide-dark-border">
                      {leaderboardData?.leaderboard?.map((entry: LeaderboardEntry) => (
                        <tr
                          key={entry.studentId}
                          className="hover:bg-slate-50/80 dark:hover:bg-zinc-800/40 transition-colors"
                        >
                          <td className="py-3 px-4 text-center font-bold">
                            {entry.rank === 1 ? (
                              <span className="inline-flex items-center justify-center h-6 w-6 rounded-full bg-amber-100 text-amber-800 dark:bg-amber-950/40 dark:text-amber-300 text-xs">
                                🥇
                              </span>
                            ) : entry.rank === 2 ? (
                              <span className="inline-flex items-center justify-center h-6 w-6 rounded-full bg-slate-200 text-slate-800 dark:bg-zinc-800 dark:text-zinc-300 text-xs">
                                🥈
                              </span>
                            ) : entry.rank === 3 ? (
                              <span className="inline-flex items-center justify-center h-6 w-6 rounded-full bg-amber-700/10 text-amber-900 dark:bg-amber-950/20 dark:text-amber-400 text-xs">
                                🥉
                              </span>
                            ) : (
                              <span className="text-slate-600 dark:text-zinc-400">#{entry.rank}</span>
                            )}
                          </td>
                          <td className="py-3 px-4 font-semibold text-slate-900 dark:text-white">
                            <div>{entry.studentName}</div>
                            <div className="text-[10px] text-slate-400 font-normal">{entry.studentEmail}</div>
                          </td>
                          <td className="py-3 px-4 text-center font-mono font-bold text-slate-900 dark:text-white">
                            {entry.score} / {entry.maxScore}
                          </td>
                          <td className="py-3 px-4 text-center">
                            <span className="px-2 py-0.5 rounded-full text-[10px] font-bold bg-emerald-500/10 text-emerald-600 dark:text-emerald-400">
                              {entry.percentage}%
                            </span>
                          </td>
                          <td className="py-3 px-4 text-right font-medium text-slate-500 dark:text-zinc-400">
                            {entry.durationMinutes !== null ? `${entry.durationMinutes} mins` : '—'}
                          </td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </div>
              )}
            </div>

            {/* Modal Footer */}
            <div className="px-6 py-4 border-t border-slate-100 dark:border-dark-border flex items-center justify-between bg-slate-50/50 dark:bg-zinc-900/30">
              <span className="text-xs text-slate-500 dark:text-zinc-400 flex items-center gap-1.5">
                <Users className="h-3.5 w-3.5" />
                {leaderboardData?.totalParticipants || 0} participants recorded
              </span>
              <button
                onClick={() => setSelectedLeaderboardCode(null)}
                className="px-4 py-2 rounded-xl text-xs font-semibold bg-slate-900 text-white dark:bg-white dark:text-slate-900 hover:opacity-90 transition-opacity"
              >
                Close
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default ContestsPage;
