import React, { useState } from 'react';
import { Search, X, User, MessageSquare } from 'lucide-react';
import { conversationService } from '../services/conversationService';
import { UserSearchResponse } from '../types/chat';
import { motion, AnimatePresence } from 'framer-motion';

interface StudentSearchModalProps {
  isOpen: boolean;
  onClose: () => void;
  onSelectUser: (userId: string) => void;
}

export const StudentSearchModal: React.FC<StudentSearchModalProps> = ({
  isOpen,
  onClose,
  onSelectUser,
}) => {
  const [query, setQuery] = useState('');
  const [results, setResults] = useState<UserSearchResponse[]>([]);
  const [loading, setLoading] = useState(false);
  const [searched, setSearched] = useState(false);

  const handleSearch = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!query.trim() || query.trim().length < 2) return;

    setLoading(true);
    setSearched(true);
    try {
      const data = await conversationService.searchUsers(query.trim());
      setResults(data);
    } catch (err) {
      console.error('Search failed:', err);
      setResults([]);
    } finally {
      setLoading(false);
    }
  };

  if (!isOpen) return null;

  return (
    <AnimatePresence>
      <div className="fixed inset-0 z-50 flex items-center justify-center p-4">
        {/* Backdrop */}
        <motion.div
          initial={{ opacity: 0 }}
          animate={{ opacity: 0.5 }}
          exit={{ opacity: 0 }}
          onClick={onClose}
          className="fixed inset-0 bg-black"
        />

        {/* Modal Container */}
        <motion.div
          initial={{ opacity: 0, scale: 0.95, y: 10 }}
          animate={{ opacity: 1, scale: 1, y: 0 }}
          exit={{ opacity: 0, scale: 0.95, y: 10 }}
          className="relative w-full max-w-md bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl shadow-2xl overflow-hidden z-10"
        >
          {/* Header */}
          <div className="flex items-center justify-between px-6 py-4 border-b border-slate-200/80 dark:border-dark-border">
            <h3 className="font-heading font-bold text-lg text-slate-900 dark:text-white flex items-center gap-2">
              <MessageSquare className="h-5 w-5 text-brand-600" /> Start a Direct Message
            </h3>
            <button
              onClick={onClose}
              className="text-slate-400 hover:text-slate-600 dark:hover:text-slate-200 transition-colors"
            >
              <X className="h-5 w-5" />
            </button>
          </div>

          {/* Search Form */}
          <form onSubmit={handleSearch} className="p-4 border-b border-slate-200/80 dark:border-dark-border">
            <div className="flex items-center gap-2 px-3 py-2 bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border rounded-xl">
              <Search className="h-4 w-4 text-slate-400 shrink-0" />
              <input
                type="text"
                value={query}
                onChange={(e) => setQuery(e.target.value)}
                placeholder="Search students by name or email..."
                className="flex-1 bg-transparent text-sm outline-none text-slate-900 dark:text-white placeholder:text-slate-400"
                autoFocus
              />
              <button
                type="submit"
                disabled={loading || query.trim().length < 2}
                className="px-3 py-1 rounded-lg bg-brand-600 hover:bg-brand-700 text-white text-xs font-semibold disabled:opacity-40 transition-all"
              >
                {loading ? 'Searching...' : 'Search'}
              </button>
            </div>
          </form>

          {/* Results List */}
          <div className="max-h-64 overflow-y-auto p-4 space-y-2">
            {!searched && (
              <p className="text-center text-xs text-slate-400 dark:text-slate-500 py-6">
                Type at least 2 characters and press Search to find students.
              </p>
            )}

            {searched && results.length === 0 && !loading && (
              <p className="text-center text-xs text-slate-400 dark:text-slate-500 py-6">
                No students found matching "{query}".
              </p>
            )}

            {results.map((student) => (
              <button
                key={student.id}
                onClick={() => {
                  onSelectUser(student.id);
                  onClose();
                }}
                className="w-full flex items-center justify-between p-3 rounded-xl hover:bg-slate-100 dark:hover:bg-zinc-800/60 transition-colors text-left group"
              >
                <div className="flex items-center gap-3">
                  <div className="h-9 w-9 rounded-xl bg-slate-200 dark:bg-zinc-800 flex items-center justify-center text-slate-600 dark:text-slate-300 shrink-0">
                    <User className="h-4 w-4" />
                  </div>
                  <div>
                    <div className="text-sm font-semibold text-slate-800 dark:text-slate-200 group-hover:text-brand-600 dark:group-hover:text-brand-400 transition-colors">
                      {student.firstName} {student.lastName}
                    </div>
                    <div className="text-xs text-slate-400">{student.email}</div>
                  </div>
                </div>

                <span className="text-xs font-medium text-brand-600 dark:text-brand-400 group-hover:underline">
                  Chat
                </span>
              </button>
            ))}
          </div>
        </motion.div>
      </div>
    </AnimatePresence>
  );
};
