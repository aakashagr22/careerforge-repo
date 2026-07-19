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
  enrollmentNo: string | null;
  preferredLanguage: 'JAVA' | 'CPP' | 'PYTHON' | null;
  targetRole: 'SDE' | 'FULL_STACK' | 'AI_ML' | 'DATA_SCIENTIST' | null;
  startingSemester: number | null;
  framework: string | null;
  streak: number;
  profileImage: string | null;
}

export interface JwtAuthResponse {
  accessToken: string;
  refreshToken: string;
  tokenType: string;
  user: User;
}
