import React from 'react';
import { Folder, Edit, Trash2 } from 'lucide-react';
import { ResourceFolder } from '../types/resources';

interface FolderCardProps {
  folder: ResourceFolder;
  onClick: (id: string) => void;
  isAdmin?: boolean;
  onRename?: (folder: ResourceFolder) => void;
  onDelete?: (id: string) => void;
}

export const FolderCard: React.FC<FolderCardProps> = ({
  folder,
  onClick,
  isAdmin = false,
  onRename,
  onDelete
}) => {
  return (
    <div
      onClick={() => onClick(folder.id)}
      className="group relative bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl p-5 flex items-center gap-4 hover:shadow-md hover:border-brand-300 dark:hover:border-brand-500/30 transition-all duration-300 cursor-pointer select-none overflow-hidden"
    >
      {/* Folder Icon Overlay background */}
      <div className="absolute inset-0 bg-gradient-to-tr from-brand-500/5 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-300 pointer-events-none" />

      <div className="h-12 w-12 bg-amber-50 dark:bg-amber-950/20 text-amber-500 rounded-xl flex items-center justify-center shrink-0 group-hover:scale-105 transition-transform duration-300">
        <Folder className="h-6.5 w-6.5 fill-amber-500/20" />
      </div>

      <div className="flex-1 min-w-0 pr-8">
        <h3 className="font-extrabold text-sm text-slate-800 dark:text-slate-100 truncate group-hover:text-brand-650 dark:group-hover:text-brand-400 transition-colors">
          {folder.name}
        </h3>
        <p className="text-xs text-slate-400 dark:text-slate-500 mt-0.5 font-semibold">
          Directory Folder
        </p>
      </div>

      {isAdmin && (
        <div className="absolute right-3 top-1/2 -translate-y-1/2 flex items-center gap-1.5 opacity-0 group-hover:opacity-100 transition-opacity duration-200" onClick={(e) => e.stopPropagation()}>
          {onRename && (
            <button
              onClick={() => onRename(folder)}
              className="p-1.5 text-slate-400 hover:text-brand-650 hover:bg-slate-100 dark:hover:bg-zinc-800 rounded-lg transition-colors"
              title="Rename Folder"
            >
              <Edit className="h-3.5 w-3.5" />
            </button>
          )}
          {onDelete && (
            <button
              onClick={() => onDelete(folder.id)}
              className="p-1.5 text-slate-400 hover:text-red-600 hover:bg-red-50 dark:hover:bg-red-950/20 rounded-lg transition-colors"
              title="Delete Folder"
            >
              <Trash2 className="h-3.5 w-3.5" />
            </button>
          )}
        </div>
      )}
    </div>
  );
};
