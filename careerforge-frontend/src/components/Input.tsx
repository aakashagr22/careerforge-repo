import React, { forwardRef } from 'react';

interface InputProps extends React.InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  error?: string;
  helperText?: string;
}

export const Input = forwardRef<HTMLInputElement, InputProps>(
  ({ label, error, helperText, className = '', type = 'text', ...props }, ref) => {
    return (
      <div className="w-full space-y-1.5">
        {label && (
          <label className="block text-xs font-semibold text-slate-600 dark:text-slate-400 uppercase tracking-wide">
            {label}
          </label>
        )}
        <input
          type={type}
          ref={ref}
          className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800/10 text-sm transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 disabled:opacity-50 disabled:cursor-not-allowed ${
            error
              ? 'border-red-500 focus:border-red-500 focus:ring-red-500/10'
              : 'border-slate-200 dark:border-dark-border focus:border-brand-500 dark:focus:border-brand-500'
          } ${className}`}
          {...props}
        />
        {error && (
          <p className="text-xs text-red-500 font-medium mt-1">{error}</p>
        )}
        {helperText && !error && (
          <p className="text-xs text-slate-400 mt-1">{helperText}</p>
        )}
      </div>
    );
  }
);

Input.displayName = 'Input';
export default Input;
