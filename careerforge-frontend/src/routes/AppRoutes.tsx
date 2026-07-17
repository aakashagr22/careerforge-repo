import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import { ProtectedRoute } from './ProtectedRoute';
import { AuthLayout } from '../layouts/AuthLayout';
import { StudentLayout } from '../layouts/StudentLayout';
import { AdminLayout } from '../layouts/AdminLayout';

// Public Pages
import { LandingPage } from '../pages/LandingPage';
import { LoginPage } from '../pages/LoginPage';
import { RegisterPage } from '../pages/RegisterPage';
import { ForgotPasswordPage } from '../pages/ForgotPasswordPage';
import { ResetPasswordPage } from '../pages/ResetPasswordPage';
import { UnauthorizedPage } from '../pages/UnauthorizedPage';
import { NotFoundPage } from '../pages/NotFoundPage';

// Student Pages
import { StudentDashboard } from '../pages/StudentDashboard';
import { RoadmapPage } from '../pages/RoadmapPage';
import { PracticeSheetsPage } from '../pages/PracticeSheetsPage';
import { StudyResourcesPage } from '../pages/StudyResourcesPage';
import { ProfilePage } from '../pages/ProfilePage';
import { SettingsPage } from '../pages/SettingsPage';

// Admin Pages
import { AdminDashboard } from '../pages/AdminDashboard';
import { ManageStudentsPage } from '../pages/ManageStudentsPage';
import { ManageResourcesPage } from '../pages/ManageResourcesPage';
import { ManageSheetsPage } from '../pages/ManageSheetsPage';
import { ManageRoadmapsPage } from '../pages/ManageRoadmapsPage';

export const AppRoutes: React.FC = () => {
  return (
    <Routes>
      {/* Public Pages */}
      <Route path="/" element={<LandingPage />} />
      <Route path="/unauthorized" element={<UnauthorizedPage />} />

      {/* Auth Routes */}
      <Route element={<AuthLayout />}>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/forgot-password" element={<ForgotPasswordPage />} />
        <Route path="/reset-password" element={<ResetPasswordPage />} />
      </Route>

      {/* Protected Student Routes */}
      <Route
        path="/student"
        element={
          <ProtectedRoute allowedRoles={['STUDENT']}>
            <StudentLayout />
          </ProtectedRoute>
        }
      >
        <Route path="dashboard" element={<StudentDashboard />} />
        <Route path="roadmap" element={<RoadmapPage />} />
        <Route path="sheets" element={<PracticeSheetsPage />} />
        <Route path="resources" element={<StudyResourcesPage />} />
        <Route path="profile" element={<ProfilePage />} />
        <Route path="settings" element={<SettingsPage />} />
        <Route path="" element={<Navigate to="dashboard" replace />} />
      </Route>

      {/* Protected Admin Routes */}
      <Route
        path="/admin"
        element={
          <ProtectedRoute allowedRoles={['ADMIN']}>
            <AdminLayout />
          </ProtectedRoute>
        }
      >
        <Route path="dashboard" element={<AdminDashboard />} />
        <Route path="students" element={<ManageStudentsPage />} />
        <Route path="resources" element={<ManageResourcesPage />} />
        <Route path="sheets" element={<ManageSheetsPage />} />
        <Route path="roadmaps" element={<ManageRoadmapsPage />} />
        <Route path="" element={<Navigate to="dashboard" replace />} />
      </Route>

      {/* Fallback Catch-All */}
      <Route path="*" element={<NotFoundPage />} />
    </Routes>
  );
};
