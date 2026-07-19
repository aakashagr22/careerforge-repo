import React, { useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import { resourceService } from '../services/resourceService';
import { resourceFolderService } from '../services/resourceFolderService';
import { Breadcrumbs } from '../components/Breadcrumbs';
import { FolderCard } from '../components/FolderCard';
import { ResourceCard } from '../components/ResourceCard';
import { YouTubePlayerModal } from '../components/YouTubePlayerModal';
import { Input } from '../components/Input';
import { Select } from '../components/Select';
import { 
  Library, Search, ArrowLeft, ArrowRight, FolderOpen 
} from 'lucide-react';

export const StudyResourcesPage: React.FC = () => {
  const [query, setQuery] = useState('');
  const [activeFolderId, setActiveFolderId] = useState<string | null>(null);
  const [type, setType] = useState<'ALL' | 'VIDEO' | 'ARTICLE'>('ALL');
  const [page, setPage] = useState(0);
  const [activeVideo, setActiveVideo] = useState<{ title: string; url: string } | null>(null);
  const size = 9; // Grid page size

  // If a search query is active, perform a global search. Otherwise, fetch folder directory.
  const isSearching = query.trim().length > 0;

  // Query 1: Directory Mode (no search query)
  const { data: directoryData, isLoading: loadingDirectory } = useQuery({
    queryKey: ['resourceDirectory', activeFolderId, page, size, type],
    queryFn: () => resourceFolderService.getDirectory(false, activeFolderId, page, size, type),
    enabled: !isSearching,
    staleTime: 5 * 60 * 1000, // Cache fresh directory pages for 5 mins
  });

  // Query 2: Search Mode (active search query)
  const { data: searchData, isLoading: loadingSearch } = useQuery({
    queryKey: ['globalSearchResources', query, type, page, size],
    queryFn: () => resourceService.getResources({
      query: query.trim(),
      type: type === 'ALL' ? undefined : type,
      page,
      size,
    }),
    enabled: isSearching,
    staleTime: 5 * 60 * 1000, // Cache fresh search queries for 5 mins
  });

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setQuery(e.target.value);
    setPage(0); // Reset page on query modify
  };

  const handleTypeChange = (t: 'ALL' | 'VIDEO' | 'ARTICLE') => {
    setType(t);
    setPage(0);
  };

  const handleNavigateFolder = (folderId: string | null) => {
    setActiveFolderId(folderId);
    setPage(0);
  };

  const isLoading = isSearching ? loadingSearch : loadingDirectory;

  // Pull elements based on current mode
  const childFolders = !isSearching ? (directoryData?.childFolders || []) : [];
  const resources = isSearching ? (searchData?.content || []) : (directoryData?.resources?.content || []);
  const totalPages = isSearching ? (searchData?.totalPages || 0) : (directoryData?.resources?.totalPages || 0);
  const totalElements = isSearching ? (searchData?.totalElements || 0) : (directoryData?.resources?.totalElements || 0);

  const hasContent = childFolders.length > 0 || resources.length > 0;

  const types = [
    { id: 'ALL', name: 'All Formats' },
    { id: 'VIDEO', name: 'Videos' },
    { id: 'ARTICLE', name: 'Articles' },
  ];

  return (
    <div className="space-y-8 max-w-6xl mx-auto pb-16">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-end gap-6 border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <div className="space-y-3">
          <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2.5">
            <Library className="h-7 w-7 text-brand-650" /> Study Library
          </h1>
          <p className="text-xs text-slate-500 dark:text-slate-400 max-w-lg leading-relaxed">
            Navigate subject folders or search directly for curated YouTube tutorials and editorial guides.
          </p>

          {/* Breadcrumbs (only visible if browsing) */}
          {!isSearching && (
            <div className="pt-2">
              <Breadcrumbs
                breadcrumbs={directoryData?.breadcrumbs || []}
                onNavigate={handleNavigateFolder}
              />
            </div>
          )}
        </div>

        {/* Filters Widget (Search & Formats) */}
        <div className="flex flex-col sm:flex-row gap-4 w-full md:w-auto items-end">
          {/* Format selection filter */}
          <Select
            label="Format"
            options={types.map(t => ({ value: t.id, label: t.name }))}
            value={type}
            onChange={(val) => handleTypeChange(val as any)}
            className="w-full sm:w-40 text-left"
          />

          {/* Search box input */}
          <div className="w-full sm:w-72">
            <label className="block text-[10px] font-bold text-slate-450 uppercase tracking-wider mb-1.5">Search</label>
            <div className="relative">
              <Input
                placeholder="Search globally across library..."
                value={query}
                onChange={handleSearchChange}
                className="pl-10"
              />
              <Search className="h-4.5 w-4.5 absolute left-3.5 top-1/2 -translate-y-1/2 text-slate-400 pointer-events-none" />
            </div>
          </div>
        </div>
      </div>

      {/* ==================== CONTENT DISPLAY ==================== */}
      {isLoading ? (
        <div className="space-y-8 animate-pulse">
          <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
            {[...Array(3)].map((_, i) => (
              <div key={i} className="h-16 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
            ))}
          </div>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {[...Array(6)].map((_, i) => (
              <div key={i} className="h-44 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
            ))}
          </div>
        </div>
      ) : !hasContent ? (
        <div className="text-center py-24 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-3xl space-y-4 shadow-sm max-w-lg mx-auto">
          <div className="h-14 w-14 bg-slate-50 dark:bg-zinc-800/20 text-slate-400 rounded-full flex items-center justify-center mx-auto border border-slate-100 dark:border-zinc-800/10">
            <FolderOpen className="h-6 w-6" />
          </div>
          <h3 className="text-sm font-bold text-slate-800 dark:text-white">This Folder is Empty</h3>
          <p className="text-xs text-slate-500 max-w-xs mx-auto leading-relaxed">
            There are no subfolders or resources uploaded in this directory level yet.
          </p>
          {!isSearching && activeFolderId && (
            <button
              onClick={() => handleNavigateFolder(null)}
              className="inline-flex items-center gap-1.5 text-xs text-brand-650 hover:underline font-bold"
            >
              Return to Root
            </button>
          )}
        </div>
      ) : (
        <div className="space-y-8">
          {/* Subfolders Grid */}
          {childFolders.length > 0 && (
            <div className="space-y-3">
              <h2 className="text-[10px] font-extrabold text-slate-450 uppercase tracking-wider">Subfolders</h2>
              <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-5">
                {childFolders.map((folder) => (
                  <FolderCard
                    key={folder.id}
                    folder={folder}
                    onClick={handleNavigateFolder}
                  />
                ))}
              </div>
            </div>
          )}

          {/* Resources Grid */}
          {resources.length > 0 && (
            <div className="space-y-3">
              <h2 className="text-[10px] font-extrabold text-slate-450 uppercase tracking-wider">
                {isSearching ? 'Search Results' : 'Resources'}
              </h2>
              <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {resources.map((res) => (
                  <ResourceCard
                    key={res.id}
                    resource={res}
                    onPlayVideo={(title, url) => setActiveVideo({ title, url })}
                  />
                ))}
              </div>
            </div>
          )}
        </div>
      )}

      {/* ==================== PAGINATION BOTTOM ==================== */}
      {totalPages > 1 && (
        <div className="flex items-center justify-between text-sm font-bold text-slate-450 pt-6 border-t border-slate-200/50 dark:border-dark-border/40">
          <span>
            Showing page {page + 1} of {totalPages} ({totalElements} resources)
          </span>
          <div className="flex gap-2">
            <button
              onClick={() => setPage(p => Math.max(0, p - 1))}
              disabled={page === 0 || isLoading}
              className="h-9 w-9 rounded-xl border border-slate-200 dark:border-dark-border flex items-center justify-center bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800/40 disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
            >
              <ArrowLeft className="h-4 w-4" />
            </button>
            <button
              onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))}
              disabled={page >= totalPages - 1 || isLoading}
              className="h-9 w-9 rounded-xl border border-slate-200 dark:border-dark-border flex items-center justify-center bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800/40 disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
            >
              <ArrowRight className="h-4 w-4" />
            </button>
          </div>
        </div>
      )}

      {/* ==================== VIDEO MODAL ==================== */}
      {activeVideo && (
        <YouTubePlayerModal
          title={activeVideo.title}
          url={activeVideo.url}
          onClose={() => setActiveVideo(null)}
        />
      )}

    </div>
  );
};

export default StudyResourcesPage;
