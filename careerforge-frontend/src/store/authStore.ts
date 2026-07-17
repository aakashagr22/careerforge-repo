import { create } from 'zustand';
import { persist } from 'zustand/middleware';
import { User } from '../types/auth';

interface AuthState {
  accessToken: string | null;
  refreshToken: string | null;
  user: User | null;
  loading: boolean;
  setCredentials: (accessToken: string, refreshToken: string, user: User) => void;
  logout: () => void;
  setLoading: (loading: boolean) => void;
  updateUser: (user: User) => void;
}

export const useAuthStore = create<AuthState>()(
  persist(
    (set) => ({
      accessToken: null,
      refreshToken: null,
      user: null,
      loading: false,
      setCredentials: (accessToken, refreshToken, user) =>
        set({ accessToken, refreshToken, user, loading: false }),
      logout: () => set({ accessToken: null, refreshToken: null, user: null }),
      setLoading: (loading) => set({ loading }),
      updateUser: (user) => set({ user }),
    }),
    {
      name: 'careerforge-auth-storage',
      partialize: (state) => ({
        accessToken: state.accessToken,
        refreshToken: state.refreshToken,
        user: state.user,
      }),
    }
  )
);
