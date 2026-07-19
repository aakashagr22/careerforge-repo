import React from 'react';
import { ChevronRight, Home } from 'lucide-react';
import { FolderBreadcrumb } from '../types/resources';

interface BreadcrumbsProps {
  breadcrumbs: FolderBreadcrumb[];
  onNavigate: (id: string | null) => void;
}

export const Breadcrumbs: React.FC<BreadcrumbsProps> = ({ breadcrumbs, onNavigate }) => {
  return (
    <nav className="flex items-center space-x-1 text-xs font-semibold text-slate-500 dark:text-slate-400 bg-slate-50 dark:bg-zinc-800/10 px-4 py-2.5 rounded-xl border border-slate-200/50 dark:border-zinc-800/20 max-w-fit shadow-sm">
      <button
        onClick={() => onNavigate(null)}
        className="flex items-center gap-1.5 hover:text-brand-600 dark:hover:text-brand-400 transition-colors"
        title="Root Library"
      >
        <Home className="h-4 w-4" />
        <span>Root</span>
      </button>

      {breadcrumbs.map((crumb, idx) => {
        const isLast = idx === breadcrumbs.length - 1;
        return (
          <React.Fragment key={crumb.id}>
            <ChevronRight className="h-3.5 w-3.5 text-slate-350 shrink-0" />
            <button
              onClick={() => !isLast && onNavigate(crumb.id)}
              disabled={isLast}
              className={`transition-colors text-ellipsis overflow-hidden max-w-[120px] whitespace-nowrap ${
                isLast
                  ? 'text-slate-800 dark:text-slate-200 font-extrabold cursor-default'
                  : 'hover:text-brand-600 dark:hover:text-brand-400'
              }`}
            >
              {crumb.name}
            </button>
          </React.Fragment>
        );
      })}
    </nav>
  );
};
