import React from 'react';

interface CardProps extends React.HTMLAttributes<HTMLDivElement> {
  hoverEffect?: boolean;
}

export const Card: React.FC<CardProps> = ({ 
  children, 
  hoverEffect = false, 
  className = '', 
  ...props 
}) => {
  return (
    <div
      className={`bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl shadow-sm ${
        hoverEffect ? 'hover:shadow-md hover:border-slate-300 dark:hover:border-zinc-700 transition-all duration-200' : ''
      } ${className}`}
      {...props}
    >
      {children}
    </div>
  );
};

export const CardHeader: React.FC<React.HTMLAttributes<HTMLDivElement>> = ({ 
  children, 
  className = '', 
  ...props 
}) => {
  return (
    <div 
      className={`px-6 py-4 border-b border-slate-200/80 dark:border-dark-border flex items-center justify-between ${className}`} 
      {...props}
    >
      {children}
    </div>
  );
};

export const CardTitle: React.FC<React.HTMLAttributes<HTMLHeadingElement>> = ({ 
  children, 
  className = '', 
  ...props 
}) => {
  return (
    <h3 
      className={`text-lg font-bold font-heading text-slate-800 dark:text-white ${className}`} 
      {...props}
    >
      {children}
    </h3>
  );
};

export const CardContent: React.FC<React.HTMLAttributes<HTMLDivElement>> = ({ 
  children, 
  className = '', 
  ...props 
}) => {
  return (
    <div 
      className={`p-6 ${className}`} 
      {...props}
    >
      {children}
    </div>
  );
};

export const CardFooter: React.FC<React.HTMLAttributes<HTMLDivElement>> = ({ 
  children, 
  className = '', 
  ...props 
}) => {
  return (
    <div 
      className={`px-6 py-4 border-t border-slate-200/80 dark:border-dark-border bg-slate-50/50 dark:bg-zinc-800/10 rounded-b-2xl flex items-center justify-between ${className}`} 
      {...props}
    >
      {children}
    </div>
  );
};
export default Card;
