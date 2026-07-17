import React from 'react';

type BadgeVariant = 'brand' | 'slate' | 'success' | 'warning' | 'error';

interface BadgeProps extends React.HTMLAttributes<HTMLSpanElement> {
  variant?: BadgeVariant;
}

export const Badge: React.FC<BadgeProps> = ({ 
  children, 
  variant = 'slate', 
  className = '', 
  ...props 
}) => {
  const baseStyle = 'inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-semibold border transition-colors duration-150';
  
  const variantStyles: Record<BadgeVariant, string> = {
    brand: 'bg-brand-500/10 text-brand-600 border-brand-500/20 dark:text-brand-300 dark:bg-brand-900/10 dark:border-brand-500/30',
    slate: 'bg-slate-100 text-slate-700 border-slate-200 dark:bg-zinc-800/40 dark:text-zinc-300 dark:border-zinc-800',
    success: 'bg-emerald-500/10 text-emerald-600 border-emerald-500/20 dark:text-emerald-400 dark:bg-emerald-950/10 dark:border-emerald-500/30',
    warning: 'bg-amber-500/10 text-amber-600 border-amber-500/20 dark:text-amber-400 dark:bg-amber-950/10 dark:border-amber-500/30',
    error: 'bg-red-500/10 text-red-600 border-red-500/20 dark:text-red-400 dark:bg-red-950/10 dark:border-red-500/30',
  };

  return (
    <span 
      className={`${baseStyle} ${variantStyles[variant]} ${className}`} 
      {...props}
    >
      {children}
    </span>
  );
};
export default Badge;
