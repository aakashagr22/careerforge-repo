import axios from 'axios';
import { useAuthStore } from '../store/authStore';

const resolveBaseUrl = () => {
  let url = (import.meta.env.VITE_API_BASE_URL || '').trim();
  if (!url) {
    return 'http://localhost:8082';
  }
  if (!url.startsWith('http://') && !url.startsWith('https://')) {
    url = `https://${url}`;
  }
  return url.replace(/\/+$/, '');
};

export const API_BASE_URL = resolveBaseUrl();

export const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request Interceptor: Automatically inject Bearer JWT access token
apiClient.interceptors.request.use(
  (config) => {
    const token = useAuthStore.getState().accessToken;
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response Interceptor: Handle global errors, token expiration and redirects
apiClient.interceptors.response.use(
  (response) => {
    // Guard against SPA returning index.html on 404/fallback
    if (
      typeof response.data === 'string' &&
      (response.data.trim().startsWith('<!doctype html') || response.data.includes('<html'))
    ) {
      return Promise.reject(
        new Error(
          'API endpoint returned HTML instead of JSON. Please check backend connection & VITE_API_BASE_URL.'
        )
      );
    }
    return response;
  },
  (error) => {
    const { status } = error.response || {};

    if (status === 401) {
      // Clear local credentials on token expiration
      useAuthStore.getState().logout();
      window.location.href = '/login?expired=true';
    }

    return Promise.reject(error);
  }
);
