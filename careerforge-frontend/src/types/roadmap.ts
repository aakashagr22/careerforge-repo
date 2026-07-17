export interface RoadmapPhase {
  id: string;
  phaseName: string;
  description: string;
  durationMonths: number;
  orderIndex: number;
}

export interface PersonalizedRoadmapResponse {
  id: string;
  targetRole: string;
  preferredLanguage: string;
  semester: number;
  title: string;
  description: string;
  phases: RoadmapPhase[];
  communicationTrackEnabled: boolean;
}
