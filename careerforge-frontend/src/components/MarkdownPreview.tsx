import React from 'react';

interface MarkdownPreviewProps {
  content: string;
  className?: string;
}

export const renderMarkdown = (markdown: string): string => {
  if (!markdown) return '';
  
  // Escape HTML tags for safety
  let html = markdown
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;');

  // Bold: **text**
  html = html.replace(/\*\*(.*?)\*\*/g, '<strong>$1</strong>');

  // Italic: *text*
  html = html.replace(/\*(.*?)\*/g, '<em>$1</em>');

  // Headers: ###, ##, #
  html = html.replace(/^### (.*?)$/gm, '<h4 class="text-sm font-bold text-slate-850 dark:text-slate-100 mt-4 mb-2">$1</h4>');
  html = html.replace(/^## (.*?)$/gm, '<h3 class="text-base font-extrabold text-slate-900 dark:text-white mt-5 mb-2.5">$1</h3>');
  html = html.replace(/^# (.*?)$/gm, '<h2 class="text-lg font-black text-slate-900 dark:text-white mt-6 mb-3">$1</h2>');

  // Bullet Lists
  html = html.replace(/^\s*-\s+(.*?)$/gm, '<li class="ml-5 list-disc text-xs text-slate-600 dark:text-slate-405 leading-relaxed my-1">$1</li>');
  html = html.replace(/^\s*\*\s+(.*?)$/gm, '<li class="ml-5 list-disc text-xs text-slate-600 dark:text-slate-405 leading-relaxed my-1">$1</li>');

  // Line breaks / paragraphs
  html = html.split('\n').map(line => {
    const trimmed = line.trim();
    if (!trimmed) return '<div class="h-2"></div>';
    if (trimmed.startsWith('<h') || trimmed.startsWith('<li') || trimmed.startsWith('<div')) {
      return line;
    }
    return `<p class="text-xs text-slate-600 dark:text-slate-400 leading-relaxed mb-3">${line}</p>`;
  }).join('\n');

  // External Links: [text](url)
  html = html.replace(/\[(.*?)\]\((.*?)\)/g, '<a href="$2" target="_blank" rel="noopener noreferrer" class="text-brand-650 dark:text-brand-400 hover:underline font-semibold">$1</a>');

  return html;
};

export const MarkdownPreview: React.FC<MarkdownPreviewProps> = ({ content, className = '' }) => {
  const renderedHtml = React.useMemo(() => renderMarkdown(content), [content]);

  return (
    <div 
      className={`prose prose-slate dark:prose-invert max-w-none text-xs ${className}`}
      dangerouslySetInnerHTML={{ __html: renderedHtml }}
    />
  );
};

export default MarkdownPreview;
