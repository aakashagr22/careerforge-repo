import React from 'react';
import { FileText, Play, Edit, Trash2, ExternalLink } from 'lucide-react';
import { StudyResource } from '../types/resources';
import { Card, CardContent } from './Card';
import { YoutubeIcon } from './YouTubePlayerModal';

interface ResourceCardProps {
  resource: StudyResource;
  isAdmin?: boolean;
  onPlayVideo?: (title: string, url: string) => void;
  onEdit?: (resource: StudyResource) => void;
  onDelete?: (id: string) => void;
}

export const ResourceCard: React.FC<ResourceCardProps> = ({
  resource,
  isAdmin = false,
  onPlayVideo,
  onEdit,
  onDelete
}) => {
  const isVideo = resource.type === 'VIDEO';

  return (
    <Card hoverEffect className="group relative flex flex-col justify-between h-48 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border overflow-hidden">
      {/* Admin Action Buttons top right corner */}
      {isAdmin && (
        <div className="absolute top-3 right-3 flex items-center gap-1.5 opacity-0 group-hover:opacity-100 transition-opacity duration-200 z-10">
          {onEdit && (
            <button
              onClick={() => onEdit(resource)}
              className="p-1.5 bg-white/90 dark:bg-zinc-800/90 text-slate-500 hover:text-brand-650 hover:bg-slate-100 dark:hover:bg-zinc-700 rounded-lg shadow-sm border border-slate-200/40 dark:border-zinc-700 transition-colors"
              title="Edit Resource"
            >
              <Edit className="h-3.5 w-3.5" />
            </button>
          )}
          {onDelete && (
            <button
              onClick={() => onDelete(resource.id)}
              className="p-1.5 bg-white/90 dark:bg-zinc-800/90 text-slate-500 hover:text-red-650 hover:bg-red-50 dark:hover:bg-red-950/20 rounded-lg shadow-sm border border-slate-200/40 dark:border-zinc-700 transition-colors"
              title="Delete Resource"
            >
              <Trash2 className="h-3.5 w-3.5" />
            </button>
          )}
        </div>
      )}

      <CardContent className="p-5 flex flex-col justify-between h-full relative z-0">
        <div className="space-y-2.5">
          {/* Format Icon Header */}
          <div className="flex items-center justify-between">
            {isVideo ? (
              <div className="flex items-center gap-1.5 text-red-500 font-extrabold text-[10px] uppercase tracking-wide">
                <YoutubeIcon className="h-5.5 w-5.5 fill-red-500" />
                <span>Video Tutorial</span>
              </div>
            ) : (
              <div className="flex items-center gap-1.5 text-blue-500 font-extrabold text-[10px] uppercase tracking-wide">
                <FileText className="h-5 w-5 text-blue-500" />
                <span>Article Tutorial</span>
              </div>
            )}
          </div>

          <h3 className="font-extrabold text-sm text-slate-800 dark:text-slate-200 line-clamp-1 group-hover:text-brand-700 dark:group-hover:text-brand-400 transition-colors pr-12">
            {resource.title}
          </h3>

          <p className="text-xs text-slate-500 dark:text-slate-400 line-clamp-2 leading-relaxed">
            {resource.description || 'No description provided.'}
          </p>
        </div>

        {/* Action Trigger Row */}
        <div className="flex items-center justify-between border-t border-slate-200/50 dark:border-dark-border/40 pt-3 mt-3 text-xs font-semibold text-slate-400">
          <span>
            {resource.durationMinutes ? `${resource.durationMinutes} Min Est.` : 'Study Material'}
          </span>

          {isVideo && onPlayVideo ? (
            <button
              onClick={() => onPlayVideo(resource.title, resource.url)}
              className="inline-flex items-center gap-1 text-red-500 hover:text-red-650 hover:underline focus:outline-none"
            >
              Play Video <Play className="h-3 w-3 fill-current" />
            </button>
          ) : (
            <a
              href={resource.url}
              target="_blank"
              rel="noreferrer"
              className="inline-flex items-center gap-1 text-brand-600 dark:text-brand-400 hover:underline"
            >
              Read Article <ExternalLink className="h-3.5 w-3.5" />
            </a>
          )}
        </div>
      </CardContent>
    </Card>
  );
};
