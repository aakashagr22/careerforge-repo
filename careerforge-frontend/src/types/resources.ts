export interface StudyResource {
  id: string;
  title: string;
  description: string;
  url: string;
  category: string;
  type: 'VIDEO' | 'ARTICLE' | 'BOOK' | 'DOCUMENTATION';
  difficulty: 'EASY' | 'MEDIUM' | 'HARD';
  durationMinutes?: number;
  createdBy?: string;
  createdAt?: string;
}

export interface ResourceFilters {
  query?: string;
  category?: string;
  type?: string;
  difficulty?: 'EASY' | 'MEDIUM' | 'HARD';
  page: number;
  size: number;
}
