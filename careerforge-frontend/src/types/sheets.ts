export interface Topic {
  id: string;
  title: string;
  description: string;
  difficulty: 'EASY' | 'MEDIUM' | 'HARD';
  orderIndex: number;
  sheetId: string;
  completed?: boolean;
}

export interface PracticeSheet {
  id: string;
  title: string;
  description: string;
  category: 'DSA' | 'WEB_DEVELOPER' | 'SYSTEM_DESIGN' | 'MACHINE_LEARNING';
}
