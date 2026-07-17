export interface WeeklyProgress {
  dayName: string;
  completedCount: number;
}

export interface DashboardData {
  streak: number;
  completedTopics: number;
  completedSheets: number;
  roadmapCompletionPercentage: number;
  weeklyProgress: WeeklyProgress[];
}
