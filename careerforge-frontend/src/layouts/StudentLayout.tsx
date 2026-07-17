import React, { useState } from 'react';
import { Outlet, NavLink, useNavigate } from 'react-router-dom';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useAuthStore } from '../store/authStore';
import { useTheme } from '../contexts/ThemeContext';
import { notificationService } from '../services/notificationService';
import { motion, AnimatePresence } from 'framer-motion';
import { 
  Flame, LayoutDashboard, Milestone, CheckSquare, Library, User, Settings, 
  LogOut, Sun, Moon, Laptop, Bell, Menu, X, Check
} from 'lucide-react';

export const StudentLayout: React.FC = () => {
  const { user, logout } = useAuthStore();
  const { theme, setTheme } = useTheme();
  const navigate = useNavigate();
  const queryClient = useQueryClient();
  const [sidebarOpen, setSidebarOpen] = useState(true);
  const [mobileSidebarOpen, setMobileSidebarOpen] = useState(false);
  const [notifDrawerOpen, setNotifDrawerOpen] = useState(false);
  const [themeMenuOpen, setThemeMenuOpen] = useState(false);

  // Fetch student alerts
  const { data: notifications = [] } = useQuery({
    queryKey: ['studentNotifications'],
    queryFn: notificationService.getNotifications,
    refetchInterval: 15000, // Poll every 15s
  });

  // Mark read mutation
  const markAsReadMutation = useMutation({
    mutationFn: notificationService.markAsRead,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['studentNotifications'] });
    }
  });

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  const navLinks = [
    { to: '/student/dashboard', label: 'Dashboard', icon: LayoutDashboard },
    { to: '/student/roadmap', label: 'My Roadmap', icon: Milestone },
    { to: '/student/sheets', label: 'Practice Sheets', icon: CheckSquare },
    { to: '/student/resources', label: 'Study Resources', icon: Library },
    { to: '/student/profile', label: 'My Profile', icon: User },
    { to: '/student/settings', label: 'Settings', icon: Settings },
  ];

  const unreadCount = notifications.filter(n => !n.read).length;

  const markAllRead = () => {
    notifications.filter(n => !n.read).forEach(n => {
      markAsReadMutation.mutate(n.id);
    });
  };

  return (
    <div className="min-h-screen flex bg-slate-50 dark:bg-dark-bg text-slate-900 dark:text-slate-100 transition-colors duration-200">
      
      {/* ==================== DESKTOP SIDEBAR ==================== */}
      <aside className={`hidden md:flex flex-col border-r border-slate-200/80 dark:border-dark-border bg-white dark:bg-dark-card transition-all duration-300 ${sidebarOpen ? 'w-64' : 'w-20'}`}>
        <div className="h-16 flex items-center justify-between px-6 border-b border-slate-200/80 dark:border-dark-border">
          <div className="flex items-center gap-3 overflow-hidden">
            <div className="h-9 w-9 rounded-lg bg-brand-600 flex items-center justify-center text-white shrink-0">
              <Flame className="h-5 w-5" />
            </div>
            {sidebarOpen && (
              <span className="font-heading font-bold text-lg tracking-tight text-slate-900 dark:text-white">
                CareerForge
              </span>
            )}
          </div>
          <button 
            onClick={() => setSidebarOpen(!sidebarOpen)}
            className="text-slate-400 hover:text-slate-600 dark:hover:text-slate-200 transition-colors"
          >
            {sidebarOpen ? <X className="h-4 w-4" /> : <Menu className="h-4 w-4" />}
          </button>
        </div>

        <nav className="flex-1 px-4 py-6 space-y-1">
          {navLinks.map((link) => {
            const Icon = link.icon;
            return (
              <NavLink
                key={link.to}
                to={link.to}
                className={({ isActive }) => 
                  `flex items-center gap-3 px-3 py-2.5 rounded-xl font-medium text-sm transition-all duration-200 ${
                    isActive 
                      ? 'bg-brand-50 dark:bg-brand-900/20 text-brand-600 dark:text-brand-300' 
                      : 'text-slate-500 dark:text-slate-400 hover:bg-slate-100 dark:hover:bg-zinc-800/50 hover:text-slate-900 dark:hover:text-slate-200'
                  }`
                }
              >
                <Icon className="h-5 w-5 shrink-0" />
                {sidebarOpen && <span>{link.label}</span>}
              </NavLink>
            );
          })}
        </nav>

        <div className="p-4 border-t border-slate-200/80 dark:border-dark-border">
          <button
            onClick={handleLogout}
            className="flex items-center gap-3 w-full px-3 py-2.5 rounded-xl text-sm font-medium text-red-600 hover:bg-red-50 dark:hover:bg-red-950/20 transition-all duration-200"
          >
            <LogOut className="h-5 w-5 shrink-0" />
            {sidebarOpen && <span>Logout</span>}
          </button>
        </div>
      </aside>

      {/* ==================== MOBILE SIDEBAR ==================== */}
      <AnimatePresence>
        {mobileSidebarOpen && (
          <>
            <motion.div 
              initial={{ opacity: 0 }}
              animate={{ opacity: 0.4 }}
              exit={{ opacity: 0 }}
              onClick={() => setMobileSidebarOpen(false)}
              className="fixed inset-0 bg-black z-40 md:hidden"
            />
            <motion.aside 
              initial={{ x: '-100%' }}
              animate={{ x: 0 }}
              exit={{ x: '-100%' }}
              transition={{ type: 'spring', damping: 25 }}
              className="fixed inset-y-0 left-0 w-64 bg-white dark:bg-dark-card border-r border-slate-200/80 dark:border-dark-border z-50 p-6 flex flex-col md:hidden"
            >
              <div className="flex items-center justify-between mb-8">
                <div className="flex items-center gap-3">
                  <div className="h-9 w-9 rounded-lg bg-brand-600 flex items-center justify-center text-white">
                    <Flame className="h-5 w-5" />
                  </div>
                  <span className="font-heading font-bold text-lg text-slate-900 dark:text-white">
                    CareerForge
                  </span>
                </div>
                <button onClick={() => setMobileSidebarOpen(false)}>
                  <X className="h-5 w-5" />
                </button>
              </div>

              <nav className="flex-1 space-y-1">
                {navLinks.map((link) => {
                  const Icon = link.icon;
                  return (
                    <NavLink
                      key={link.to}
                      to={link.to}
                      onClick={() => setMobileSidebarOpen(false)}
                      className={({ isActive }) => 
                        `flex items-center gap-3 px-3 py-3 rounded-xl font-medium text-sm transition-all duration-200 ${
                          isActive 
                            ? 'bg-brand-55 dark:bg-brand-900/20 text-brand-600 dark:text-brand-300' 
                            : 'text-slate-500 dark:text-slate-400 hover:bg-slate-100 dark:hover:bg-zinc-800/50 hover:text-slate-900 dark:hover:text-slate-200'
                        }`
                      }
                    >
                      <Icon className="h-5 w-5" />
                      <span>{link.label}</span>
                    </NavLink>
                  );
                })}
              </nav>

              <button
                onClick={handleLogout}
                className="flex items-center gap-3 w-full px-3 py-3 rounded-xl text-sm font-medium text-red-600 hover:bg-red-50 dark:hover:bg-red-950/20 transition-all duration-200 mt-auto"
              >
                <LogOut className="h-5 w-5" />
                <span>Logout</span>
              </button>
            </motion.aside>
          </>
        )}
      </AnimatePresence>

      {/* ==================== MAIN CONTENT WRAPPER ==================== */}
      <div className="flex-1 flex flex-col min-w-0">
        
        {/* Top Navbar */}
        <header className="h-16 flex items-center justify-between px-6 bg-white dark:bg-dark-card border-b border-slate-200/80 dark:border-dark-border sticky top-0 z-30">
          <button 
            onClick={() => setMobileSidebarOpen(true)}
            className="md:hidden text-slate-500 hover:text-slate-900 dark:hover:text-slate-200"
          >
            <Menu className="h-6 w-6" />
          </button>

          <div className="hidden md:flex items-center gap-2 text-sm text-slate-500 dark:text-slate-400">
            <span>Welcome back,</span>
            <span className="font-semibold text-slate-800 dark:text-slate-200">{user?.firstName}</span>
          </div>

          <div className="flex items-center gap-4 ml-auto">
            {/* Theme Selector */}
            <div className="relative">
              <button 
                onClick={() => setThemeMenuOpen(!themeMenuOpen)}
                className="h-9 w-9 rounded-xl flex items-center justify-center border border-slate-200/80 dark:border-dark-border text-slate-500 dark:text-slate-400 hover:bg-slate-100 dark:hover:bg-zinc-800/50 transition-colors"
              >
                {theme === 'light' && <Sun className="h-4 w-4" />}
                {theme === 'dark' && <Moon className="h-4 w-4" />}
                {theme === 'system' && <Laptop className="h-4 w-4" />}
              </button>
              <AnimatePresence>
                {themeMenuOpen && (
                  <>
                    <div className="fixed inset-0 z-40" onClick={() => setThemeMenuOpen(false)} />
                    <motion.div 
                      initial={{ opacity: 0, y: 10 }}
                      animate={{ opacity: 1, y: 0 }}
                      exit={{ opacity: 0, y: 10 }}
                      className="absolute right-0 mt-2 w-36 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-xl shadow-lg p-1.5 z-50 text-sm font-medium"
                    >
                      {(['light', 'dark', 'system'] as const).map((t) => (
                        <button
                          key={t}
                          onClick={() => {
                            setTheme(t);
                            setThemeMenuOpen(false);
                          }}
                          className={`flex items-center justify-between w-full px-2.5 py-2 rounded-lg text-left capitalize ${
                            theme === t ? 'bg-brand-50 dark:bg-brand-900/10 text-brand-600 dark:text-brand-300' : 'hover:bg-slate-100 dark:hover:bg-zinc-800/40'
                          }`}
                        >
                          <span className="flex items-center gap-2">
                            {t === 'light' && <Sun className="h-4 w-4" />}
                            {t === 'dark' && <Moon className="h-4 w-4" />}
                            {t === 'system' && <Laptop className="h-4 w-4" />}
                            {t}
                          </span>
                          {theme === t && <Check className="h-3.5 w-3.5" />}
                        </button>
                      ))}
                    </motion.div>
                  </>
                )}
              </AnimatePresence>
            </div>

            {/* Notifications Alert Bell */}
            <button 
              onClick={() => setNotifDrawerOpen(true)}
              className="h-9 w-9 rounded-xl flex items-center justify-center border border-slate-200/80 dark:border-dark-border text-slate-500 dark:text-slate-400 hover:bg-slate-100 dark:hover:bg-zinc-800/50 transition-colors relative"
            >
              <Bell className="h-4 w-4" />
              {unreadCount > 0 && (
                <span className="absolute top-1.5 right-1.5 h-2 w-2 rounded-full bg-brand-600 animate-pulse" />
              )}
            </button>

            {/* Profile Avatar Trigger */}
            <div 
              onClick={() => navigate('/student/profile')}
              className="h-9 w-9 rounded-xl bg-slate-200 dark:bg-zinc-800 border border-slate-200/80 dark:border-dark-border flex items-center justify-center text-sm font-semibold text-brand-600 dark:text-brand-300 cursor-pointer hover:opacity-90 shrink-0"
            >
              {user?.firstName?.charAt(0).toUpperCase()}
            </div>
          </div>
        </header>

        {/* Dynamic page contents wrapper */}
        <main className="flex-1 overflow-y-auto p-6 md:p-8">
          <Outlet />
        </main>
      </div>

      {/* ==================== NOTIFICATIONS DRAWER ==================== */}
      <AnimatePresence>
        {notifDrawerOpen && (
          <>
            <motion.div 
              initial={{ opacity: 0 }}
              animate={{ opacity: 0.4 }}
              exit={{ opacity: 0 }}
              onClick={() => setNotifDrawerOpen(false)}
              className="fixed inset-0 bg-black z-40"
            />
            <motion.div 
              initial={{ x: '100%' }}
              animate={{ x: 0 }}
              exit={{ x: '100%' }}
              transition={{ type: 'spring', damping: 25, stiffness: 200 }}
              className="fixed inset-y-0 right-0 w-80 max-w-full bg-white dark:bg-dark-card border-l border-slate-200/80 dark:border-dark-border z-50 p-6 flex flex-col"
            >
              <div className="flex items-center justify-between border-b border-slate-200/80 dark:border-dark-border pb-4 mb-4">
                <h3 className="font-heading font-bold text-lg text-slate-900 dark:text-white flex items-center gap-2">
                  <Bell className="h-5 w-5 text-brand-600" /> Notifications
                </h3>
                <button onClick={() => setNotifDrawerOpen(false)}>
                  <X className="h-5 w-5 text-slate-400 hover:text-slate-600 dark:hover:text-slate-200" />
                </button>
              </div>

              {unreadCount > 0 && (
                <button 
                  onClick={markAllRead}
                  className="text-xs font-semibold text-brand-600 dark:text-brand-400 hover:underline text-right mb-4"
                >
                  Mark all as read
                </button>
              )}

              <div className="flex-1 space-y-4 overflow-y-auto">
                {notifications.length === 0 ? (
                  <div className="text-center py-8 text-slate-500 dark:text-slate-400 text-sm">
                    No notifications yet.
                  </div>
                ) : (
                  notifications.map((notif: any) => (
                    <div 
                      key={notif.id}
                      onClick={() => !notif.read && markAsReadMutation.mutate(notif.id)}
                      className={`p-3 rounded-xl border transition-colors cursor-pointer ${
                        notif.read 
                          ? 'bg-slate-50/50 border-slate-100 dark:bg-zinc-800/10 dark:border-zinc-800/50' 
                          : 'bg-brand-50/10 border-brand-100 dark:bg-brand-900/5 dark:border-brand-950/20 hover:bg-brand-55/15'
                      }`}
                    >
                      <p className="text-sm font-medium text-slate-700 dark:text-slate-300">
                        {notif.message}
                      </p>
                      <span className="text-[10px] text-slate-400 mt-1 block">
                        {new Date(notif.createdAt).toLocaleDateString(undefined, {
                          month: 'short',
                          day: 'numeric',
                          hour: '2-digit',
                          minute: '2-digit'
                        })}
                      </span>
                    </div>
                  ))
                )}
              </div>
            </motion.div>
          </>
        )}
      </AnimatePresence>

    </div>
  );
};
