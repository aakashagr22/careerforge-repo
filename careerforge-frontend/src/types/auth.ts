export type Role = 'STUDENT' | 'ADMIN';

export interface User {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
  role: Role;
  active: boolean;
}

export interface StudentProfile {
  id: string;
  userId: string;
  firstName: string;
  lastName: string;
  email: string;
  semester: number | null;
  branch: string | null;
  section: string | null;
  college: string | null;
  enrollmentNo: string | null;
  preferredLanguage: 'JAVA' | 'CPP' | 'PYTHON' | null;
  targetRole: 'SDE' | 'FULL_STACK' | 'WEB_DEVELOPER' | 'AI_ML' | 'DEVOPS' | null;
  communicationTrackEnabled: boolean;
  streak: number;
  profileImage: string | null;
}

export interface JwtAuthResponse {
  accessToken: string;
  refreshToken: string;
  tokenType: string;
  user: User;
}
