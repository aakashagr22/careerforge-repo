import React from 'react';
import { Calendar, User, Eye, Edit2, AlertCircle } from 'lucide-react';
import { Blog } from '../types/blog';
import { Badge } from './Badge';
import { Card, CardContent } from './Card';

interface BlogCardProps {
  blog: Blog;
  isOwner?: boolean;
  onRead: (blog: Blog) => void;
  onEdit?: (blog: Blog) => void;
}

export const BlogCard: React.FC<BlogCardProps> = ({
  blog,
  isOwner = false,
  onRead,
  onEdit
}) => {
  const getStatusBadge = (status: string) => {
    switch (status) {
      case 'DRAFT':
        return <Badge variant="slate">Draft</Badge>;
      case 'PENDING_REVIEW':
        return <Badge variant="warning">Under Review</Badge>;
      case 'PUBLISHED':
        return <Badge variant="success">Published</Badge>;
      case 'REJECTED':
        return <Badge variant="error">Rejected</Badge>;
      default:
        return null;
    }
  };

  // Strip markdown tags to render a clean snippet preview
  const getContentPreview = (markdown: string) => {
    if (!markdown) return '';
    const cleanText = markdown
      .replace(/#+\s+/g, '') // strip headers
      .replace(/\*\*|__/g, '') // strip bold
      .replace(/\*|_/g, '') // strip italics
      .replace(/\[(.*?)\]\(.*?\)/g, '$1') // strip links
      .replace(/-\s+/g, ''); // strip bullet signs
    return cleanText.length > 130 ? cleanText.slice(0, 130) + '...' : cleanText;
  };

  const formattedDate = new Date(blog.createdAt).toLocaleDateString('en-US', {
    month: 'short',
    day: 'numeric',
    year: 'numeric',
  });

  return (
    <Card 
      hoverEffect 
      onClick={() => onRead(blog)}
      className="relative bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border flex flex-col justify-between h-52 p-5 rounded-2xl overflow-hidden cursor-pointer select-none"
    >
      <div className="flex flex-col justify-between h-full space-y-3 relative z-0">
        <div className="space-y-2">
          {/* Header Row: Author details & Status Badge */}
          <div className="flex items-center justify-between text-[10px] text-slate-400 dark:text-slate-500 font-bold uppercase tracking-wider">
            <div className="flex items-center gap-1.5 truncate max-w-[70%]">
              <User className="h-3.5 w-3.5 shrink-0" />
              <span className="truncate">{blog.authorName}</span>
            </div>
            {isOwner && getStatusBadge(blog.status)}
          </div>

          <h3 className="font-extrabold text-sm text-slate-800 dark:text-slate-200 line-clamp-1">
            {blog.title}
          </h3>

          <p className="text-xs text-slate-500 dark:text-slate-400 line-clamp-2 leading-relaxed">
            {getContentPreview(blog.content)}
          </p>
        </div>

        {/* Footer Row: Details & Actions */}
        <div className="border-t border-slate-200/40 dark:border-dark-border/40 pt-3 mt-3 flex items-center justify-between text-xs font-semibold text-slate-450">
          <div className="flex items-center gap-1">
            <Calendar className="h-3.5 w-3.5" />
            <span>{formattedDate}</span>
          </div>

          <div className="flex gap-2">
            {/* Show Edit trigger if isOwner and is editable */}
            {isOwner && onEdit && (blog.status === 'DRAFT' || blog.status === 'REJECTED') && (
              <button
                onClick={(e) => { e.stopPropagation(); onEdit(blog); }}
                className="inline-flex items-center gap-1 text-brand-650 hover:text-brand-700 hover:underline"
                title="Edit / Resubmit"
              >
                Edit <Edit2 className="h-3 w-3" />
              </button>
            )}
            <button
              onClick={(e) => { e.stopPropagation(); onRead(blog); }}
              className="inline-flex items-center gap-1 text-slate-600 dark:text-slate-300 hover:text-brand-650 dark:hover:text-brand-400 hover:underline"
            >
              Read <Eye className="h-3.5 w-3.5" />
            </button>
          </div>
        </div>

        {/* Warning notification for rejected blogs */}
        {isOwner && blog.status === 'REJECTED' && blog.rejectionReason && (
          <div className="absolute top-2 left-2 flex items-center gap-1 text-[9px] text-red-500 bg-red-50 dark:bg-red-950/20 px-2 py-0.5 rounded-md border border-red-200/40 dark:border-red-900/10 pointer-events-none">
            <AlertCircle className="h-3 w-3 shrink-0" />
            <span>Rejection reason provided</span>
          </div>
        )}
      </div>
    </Card>
  );
};

export default BlogCard;
