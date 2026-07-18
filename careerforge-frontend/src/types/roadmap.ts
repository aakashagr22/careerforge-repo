export interface QuestionLink {
  id: string;
  linkType: 'SOLVE' | 'VIDEO' | 'ARTICLE' | 'PRACTICE';
  label: string;
  url: string;
  position: number;
}

export interface RoadmapSectionQuestion {
  sectionQuestionId: string;
  questionId: string;
  title: string;
  description: string;
  difficulty: 'BEGINNER' | 'EASY' | 'MEDIUM' | 'HARD' | 'ADVANCED';
  position: number;
  links: QuestionLink[];
  completed?: boolean;
  revisionMarked?: boolean;
  note?: string;
}

export interface RoadmapSection {
  id: string;
  title: string;
  position: number;
  children: RoadmapSection[];
  questions: RoadmapSectionQuestion[];
}

export interface Roadmap {
  id: string;
  title: string;
  description?: string;
  semester: number;
  monthsRemaining: number;
  targetRoles: string[];
}

export interface PersonalizedRoadmapResponse {
  roadmap: Roadmap;
  sections: RoadmapSection[];
}
