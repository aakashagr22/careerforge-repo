import { apiClient } from '../config/api';

export interface Contest {
  id: string;
  code: string;
  title: string;
  description: string | null;
  coverImageUrl: string | null;
  startTime: string;
  endTime: string;
  totalQuestions: number;
  totalTime: number;
  totalScore: number;
  duration: number | null;
  status: 'UPCOMING' | 'LIVE' | 'CONCLUDED';
  isLive: boolean;
  isEnded: boolean;
  isUpcoming: boolean;
}

export interface LeaderboardEntry {
  rank: number;
  studentId: string;
  studentName: string;
  studentEmail: string;
  studentImage: string | null;
  score: number;
  maxScore: number;
  percentage: number;
  joinedAt: string;
  startedAt: string | null;
  finishedAt: string | null;
  durationMinutes: number | null;
}

export interface LeaderboardResponse {
  contest: {
    id: string;
    code: string;
    title: string;
    description: string | null;
    startTime: string;
    endTime: string;
    totalQuestions: number;
    totalScore: number;
    duration: number | null;
    isEnded: boolean;
    isLive: boolean;
  };
  timeLocked: boolean;
  message?: string;
  totalParticipants: number;
  leaderboard: LeaderboardEntry[];
}

export interface StudentParticipation {
  participationId: string;
  contestId: string;
  contestCode: string;
  contestTitle: string;
  contestDescription: string | null;
  coverImageUrl: string | null;
  startTime: string;
  endTime: string;
  totalQuestions: number;
  totalScore: number;
  durationMinutes: number | null;
  timeTakenMinutes: number | null;
  status: 'CONCLUDED' | 'RESULTS_PENDING' | 'IN_PROGRESS' | 'TIMED_OUT';
  isEnded: boolean;
  isLiveNow: boolean;
  score: number | null;
  maxScore: number;
  percentage: number | null;
  rank: number | null;
  totalParticipants: number;
  joinedAt: string;
  startedAt: string | null;
  finishedAt: string | null;
}

export interface StudentContestsResponse {
  found: boolean;
  student?: {
    id: string;
    name: string;
    email: string;
    image: string | null;
  } | null;
  count: number;
  participations: StudentParticipation[];
}

export const contestService = {
  // Get all contests
  getContests: async (status: string = 'all'): Promise<Contest[]> => {
    const response = await apiClient.get('/api/student/contests', {
      params: { status },
    });
    const payload = response.data?.data;
    return payload?.contests || [];
  },

  // Get leaderboard for a contest
  getLeaderboard: async (code: string): Promise<LeaderboardResponse> => {
    const response = await apiClient.get(`/api/student/contests/${code}/leaderboard`);
    return response.data?.data;
  },

  // Get current student's contest history
  getMyContestHistory: async (): Promise<StudentContestsResponse> => {
    const response = await apiClient.get('/api/student/contests/my-history');
    return response.data?.data;
  },
};
