import React, { useState } from 'react';
import { Outlet, NavLink, useNavigate } from 'react-router-dom';
import { useAuthStore } from '../store/authStore';
import { useTheme } from '../contexts/ThemeContext';
import { motion, AnimatePresence } from 'framer-motion';
import { 
  ShieldAlert, LayoutDashboard, Users, Library, CheckSquare, Milestone, 
  LogOut, Sun, Moon, Laptop, Menu, X, Check
} from 'lucide-react';

export const AdminLayout: React.FC = () => {
  const { user, logout } = useAuthStore();
  const { theme, setTheme } = useTheme();
  const navigate = useNavigate();
  const [sidebarOpen, setSidebarOpen] = useState(true);
  const [mobileSidebarOpen, setMobileSidebarOpen] = useState(false);
  const [themeMenuOpen, setThemeMenuOpen] = useState(false);

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  const navLinks = [
    { to: '/admin/dashboard', label: 'Overview', icon: LayoutDashboard },
    { to: '/admin/students', label: 'Manage Students', icon: Users },
    { to: '/admin/resources', label: 'Manage Resources', icon: Library },
    { to: '/admin/sheets', label: 'Manage Sheets', icon: CheckSquare },
    { to: '/admin/roadmaps', label: 'Configure Roadmaps', icon: Milestone },
  ];

  return (
    <div className="h-screen flex overflow-hidden bg-slate-50 dark:bg-dark-bg text-slate-900 dark:text-slate-100 transition-colors duration-200">
      
      {/* ==================== DESKTOP ADMIN SIDEBAR ==================== */}
      <aside className={`hidden md:flex flex-col border-r border-slate-200/80 dark:border-dark-border bg-white dark:bg-dark-card transition-all duration-300 ${sidebarOpen ? 'w-64' : 'w-20'}`}>
        <div className="h-16 flex items-center justify-between px-6 border-b border-slate-200/80 dark:border-dark-border">
          <div className="flex items-center gap-3 overflow-hidden">
            <div className="h-9 w-9 rounded-lg bg-rose-600 flex items-center justify-center text-white shrink-0">
              <ShieldAlert className="h-5 w-5" />
            </div>
            {sidebarOpen && (
              <span className="font-heading font-bold text-lg tracking-tight text-slate-900 dark:text-white">
                Admin Console
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
                      ? 'bg-rose-50 dark:bg-rose-950/20 text-rose-600 dark:text-rose-400' 
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

      {/* ==================== MOBILE ADMIN SIDEBAR ==================== */}
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
                  <div className="h-9 w-9 rounded-lg bg-rose-600 flex items-center justify-center text-white">
                    <ShieldAlert className="h-5 w-5" />
                  </div>
                  <span className="font-heading font-bold text-lg text-slate-900 dark:text-white">
                    Admin Console
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
                            ? 'bg-rose-55 dark:bg-rose-950/20 text-rose-600 dark:text-rose-45' 
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

      {/* ==================== ADMIN CONTENT WRAPPER ==================== */}
      <div className="flex-1 flex flex-col min-w-0">
        
        {/* Top Header */}
        <header className="h-16 flex items-center justify-between px-6 bg-white dark:bg-dark-card border-b border-slate-200/80 dark:border-dark-border sticky top-0 z-30">
          <button 
            onClick={() => setMobileSidebarOpen(true)}
            className="md:hidden text-slate-500 hover:text-slate-900 dark:hover:text-slate-200"
          >
            <Menu className="h-6 w-6" />
          </button>

          <div className="hidden md:flex items-center gap-2 text-sm text-slate-500 dark:text-slate-400">
            <span className="font-semibold text-rose-600 dark:text-rose-400">ADMIN CONTROL</span>
            <span>-</span>
            <span className="text-slate-800 dark:text-slate-200">{user?.email}</span>
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
                            theme === t ? 'bg-rose-50 dark:bg-rose-950/10 text-rose-600 dark:text-rose-400' : 'hover:bg-slate-100 dark:hover:bg-zinc-800/40'
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
          </div>
        </header>

        {/* Admin Content */}
        <main className="flex-1 overflow-y-auto p-6 md:p-8">
          <Outlet />
        </main>
      </div>

    </div>
  );
};
