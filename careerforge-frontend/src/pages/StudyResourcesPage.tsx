import React, { useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import { resourceService } from '../services/resourceService';
import { Card, CardContent } from '../components/Card';
import { Badge } from '../components/Badge';
import { Input } from '../components/Input';
import { 
  Library, Search, Play, FileText, BookOpen, 
  ExternalLink, Code, ArrowLeft, ArrowRight 
} from 'lucide-react';

export const StudyResourcesPage: React.FC = () => {
  const [query, setQuery] = useState('');
  const [category, setCategory] = useState('ALL');
  const [type, setType] = useState('ALL');
  const [difficulty, setDifficulty] = useState<'ALL' | 'EASY' | 'MEDIUM' | 'HARD'>('ALL');
  const [page, setPage] = useState(0);
  const size = 6; // Grid pagination size

  // Fetch paginated resources
  const { data, isLoading } = useQuery({
    queryKey: ['studyResources', query, category, type, difficulty, page],
    queryFn: () => resourceService.getResources({
      query,
      category: category === 'ALL' ? undefined : category,
      type: type === 'ALL' ? undefined : type,
      difficulty: difficulty === 'ALL' ? undefined : difficulty,
      page,
      size,
    }),
  });

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setQuery(e.target.value);
    setPage(0); // Reset page on query modify
  };

  const handleCategoryChange = (cat: string) => {
    setCategory(cat);
    setPage(0);
  };

  const handleTypeChange = (t: string) => {
    setType(t);
    setPage(0);
  };

  const handleDifficultyChange = (diff: 'ALL' | 'EASY' | 'MEDIUM' | 'HARD') => {
    setDifficulty(diff);
    setPage(0);
  };

  // Icon mapping helper
  const getFormatIcon = (format: string) => {
    switch (format) {
      case 'VIDEO':
        return <Play className="h-5 w-5 text-red-500" />;
      case 'ARTICLE':
        return <FileText className="h-5 w-5 text-indigo-500" />;
      case 'BOOK':
        return <BookOpen className="h-5 w-5 text-amber-500" />;
      case 'DOCUMENTATION':
        return <Code className="h-5 w-5 text-emerald-500" />;
      default:
        return <Library className="h-5 w-5 text-slate-500" />;
    }
  };

  const categories = [
    { id: 'ALL', name: 'All Categories' },
    { id: 'DSA', name: 'DSA Curriculum' },
    { id: 'WEB_DEVELOPER', name: 'Web Development' },
    { id: 'SYSTEM_DESIGN', name: 'System Design' },
    { id: 'MACHINE_LEARNING', name: 'Machine Learning' },
  ];

  const types = [
    { id: 'ALL', name: 'All Formats' },
    { id: 'VIDEO', name: 'Videos' },
    { id: 'ARTICLE', name: 'Articles' },
    { id: 'BOOK', name: 'Books / Guides' },
    { id: 'DOCUMENTATION', name: 'Docs' },
  ];

  const difficulties: ('ALL' | 'EASY' | 'MEDIUM' | 'HARD')[] = ['ALL', 'EASY', 'MEDIUM', 'HARD'];

  const resources = data?.content || [];
  const totalElements = data?.totalElements || 0;
  const totalPages = data?.totalPages || 0;

  return (
    <div className="space-y-8 max-w-6xl mx-auto">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4">
        <div>
          <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
            <Library className="h-7 w-7 text-brand-600" /> Study Library
          </h1>
          <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
            Access handpicked tutorials, video playlists, and reference manuals.
          </p>
        </div>

        {/* Search bar widget */}
        <div className="w-full md:w-80 relative">
          <Input
            placeholder="Search topic or title..."
            value={query}
            onChange={handleSearchChange}
            className="pl-10"
          />
          <Search className="h-4.5 w-4.5 absolute left-3 top-3 text-slate-400 pointer-events-none" />
        </div>
      </div>

      {/* ==================== FILTERS ROW ==================== */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border p-5 rounded-2xl shadow-sm">
        
        {/* Category selector */}
        <div className="space-y-1.5">
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
            Subject Category
          </label>
          <select
            value={category}
            onChange={(e) => handleCategoryChange(e.target.value)}
            className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-bg text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
          >
            {categories.map(cat => (
              <option key={cat.id} value={cat.id}>{cat.name}</option>
            ))}
          </select>
        </div>

        {/* Type Format selector */}
        <div className="space-y-1.5">
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
            Resource Type
          </label>
          <select
            value={type}
            onChange={(e) => handleTypeChange(e.target.value)}
            className="w-full px-4 py-2.5 rounded-xl border border-slate-200 dark:border-dark-border bg-slate-50/50 dark:bg-dark-bg text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20 text-slate-700 dark:text-slate-350"
          >
            {types.map(t => (
              <option key={t.id} value={t.id}>{t.name}</option>
            ))}
          </select>
        </div>

        {/* Difficulty Selector */}
        <div className="space-y-1.5">
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
            Target Level
          </label>
          <div className="flex border border-slate-200 dark:border-dark-border rounded-xl p-1 bg-slate-50/50 dark:bg-dark-bg h-[42px] items-center">
            {difficulties.map(diff => (
              <button
                key={diff}
                onClick={() => handleDifficultyChange(diff)}
                className={`flex-1 text-center py-1 rounded-lg text-xs font-bold transition-all capitalize ${
                  difficulty === diff
                    ? 'bg-white dark:bg-zinc-800 text-brand-600 dark:text-white shadow-sm border border-slate-200/50 dark:border-zinc-800'
                    : 'text-slate-500 dark:text-slate-400 hover:text-slate-800 dark:hover:text-slate-200'
                }`}
              >
                {diff.toLowerCase()}
              </button>
            ))}
          </div>
        </div>

      </div>

      {/* ==================== RESOURCES GRID ==================== */}
      {isLoading ? (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6 animate-pulse">
          {[...Array(6)].map((_, i) => (
            <div key={i} className="h-44 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          ))}
        </div>
      ) : resources.length === 0 ? (
        <div className="text-center py-20 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl space-y-4">
          <Library className="h-10 w-10 text-slate-400 mx-auto" />
          <h3 className="text-lg font-bold font-heading text-slate-800 dark:text-white">No Resources Found</h3>
          <p className="text-sm text-slate-500 max-w-xs mx-auto">
            Try adjusting your search query or filters.
          </p>
        </div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {resources.map((res) => (
            <Card key={res.id} hoverEffect className="flex flex-col justify-between h-48">
              <CardContent className="p-5 flex flex-col justify-between h-full">
                
                {/* Header title & icon format */}
                <div className="space-y-2">
                  <div className="flex items-center justify-between">
                    {getFormatIcon(res.type)}
                    <div className="flex gap-1.5">
                      <Badge variant={res.difficulty === 'EASY' ? 'success' : res.difficulty === 'MEDIUM' ? 'warning' : 'error'} className="text-[8px] uppercase tracking-wider py-0">
                        {res.difficulty}
                      </Badge>
                    </div>
                  </div>
                  
                  <h3 className="font-bold text-sm text-slate-900 dark:text-white line-clamp-1">
                    {res.title}
                  </h3>
                  <p className="text-xs text-slate-500 dark:text-slate-400 line-clamp-2 leading-relaxed">
                    {res.description}
                  </p>
                </div>

                {/* Duration/Format badge & CTA anchor */}
                <div className="flex items-center justify-between border-t border-slate-200/50 dark:border-dark-border/40 pt-3 mt-4 text-xs font-semibold text-slate-400">
                  <span>
                    {res.durationMinutes ? `${res.durationMinutes} Min Est.` : 'Free Guide'}
                  </span>
                  
                  <a
                    href={res.url}
                    target="_blank"
                    rel="noreferrer"
                    className="inline-flex items-center gap-1 text-brand-600 dark:text-brand-400 hover:underline"
                  >
                    Open Link <ExternalLink className="h-3.5 w-3.5" />
                  </a>
                </div>

              </CardContent>
            </Card>
          ))}
        </div>
      )}

      {/* ==================== PAGINATION BOTTOM ==================== */}
      {totalPages > 1 && (
        <div className="flex items-center justify-between text-sm font-semibold text-slate-500 dark:text-slate-400 pt-4 border-t border-slate-200/50 dark:border-dark-border/40">
          <span>
            Showing Page {page + 1} of {totalPages} ({totalElements} resources)
          </span>
          <div className="flex gap-2">
            <button
              onClick={() => setPage(p => Math.max(0, p - 1))}
              disabled={page === 0 || isLoading}
              className="h-9 w-9 rounded-xl border border-slate-200 dark:border-dark-border flex items-center justify-center hover:bg-slate-100 dark:hover:bg-zinc-800/50 disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
            >
              <ArrowLeft className="h-4 w-4" />
            </button>
            <button
              onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))}
              disabled={page >= totalPages - 1 || isLoading}
              className="h-9 w-9 rounded-xl border border-slate-200 dark:border-dark-border flex items-center justify-center hover:bg-slate-100 dark:hover:bg-zinc-800/50 disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
            >
              <ArrowRight className="h-4 w-4" />
            </button>
          </div>
        </div>
      )}

    </div>
  );
};
export default StudyResourcesPage;
