export interface WeeklyProgress {
  dayOfWeek: string;
  completedCount: number;
}

export interface DashboardData {
  currentStreak: number;
  completedTopics: number;
  completedSheets: number;
  roadmapProgress: number;
  weeklyProgress: WeeklyProgress[];
}
