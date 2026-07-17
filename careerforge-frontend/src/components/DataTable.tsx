import React, { useState } from 'react';
import { ChevronUp, ChevronDown, Search, ArrowLeft, ArrowRight, Loader2 } from 'lucide-react';

export interface Column<T> {
  header: string;
  key?: string;
  render?: (row: T) => React.ReactNode;
  sortable?: boolean;
}

interface DataTableProps<T> {
  columns: Column<T>[];
  data: T[];
  loading?: boolean;
  page?: number;
  size?: number;
  totalElements?: number;
  onPageChange?: (page: number) => void;
  onSortChange?: (sortField: string, direction: 'asc' | 'desc') => void;
  onSearchChange?: (query: string) => void;
  searchPlaceholder?: string;
  emptyMessage?: string;
}

export function DataTable<T>({
  columns,
  data,
  loading = false,
  page = 0,
  size = 10,
  totalElements = 0,
  onPageChange,
  onSortChange,
  onSearchChange,
  searchPlaceholder = 'Search...',
  emptyMessage = 'No records found.',
}: DataTableProps<T>) {
  const [searchVal, setSearchVal] = useState('');
  const [sortField, setSortField] = useState<string | null>(null);
  const [sortDirection, setSortDirection] = useState<'asc' | 'desc'>('desc');

  const handleSearchSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (onSearchChange) {
      onSearchChange(searchVal);
    }
  };

  const handleSortClick = (colKey?: string) => {
    if (!colKey || !onSortChange) return;

    let nextDir: 'asc' | 'desc' = 'desc';
    if (sortField === colKey) {
      nextDir = sortDirection === 'desc' ? 'asc' : 'desc';
    }
    setSortField(colKey);
    setSortDirection(nextDir);
    onSortChange(colKey, nextDir);
  };

  const totalPages = Math.ceil(totalElements / size);

  return (
    <div className="space-y-4">
      {/* Top Search Controls */}
      {onSearchChange && (
        <form onSubmit={handleSearchSubmit} className="flex max-w-sm relative">
          <input
            type="text"
            placeholder={searchPlaceholder}
            value={searchVal}
            onChange={(e) => setSearchVal(e.target.value)}
            className="w-full pl-10 pr-4 py-2 rounded-xl border border-slate-200 dark:border-dark-border bg-white dark:bg-zinc-800/10 text-sm focus:outline-none focus:ring-2 focus:ring-brand-500/20"
          />
          <button
            type="submit"
            className="absolute left-3 top-2.5 text-slate-400 hover:text-slate-600 dark:hover:text-slate-200"
          >
            <Search className="h-4.5 w-4.5" />
          </button>
        </form>
      )}

      {/* Responsive Table Card */}
      <div className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl overflow-hidden shadow-sm relative">
        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse text-sm">
            <thead>
              <tr className="bg-slate-50/70 dark:bg-zinc-800/20 text-slate-600 dark:text-slate-350 border-b border-slate-200/80 dark:border-dark-border">
                {columns.map((col, idx) => (
                  <th
                    key={idx}
                    onClick={() => col.sortable && col.key && handleSortClick(col.key)}
                    className={`px-6 py-4 font-semibold ${
                      col.sortable && col.key ? 'cursor-pointer select-none hover:text-slate-800 dark:hover:text-slate-100' : ''
                    }`}
                  >
                    <div className="flex items-center gap-1.5">
                      {col.header}
                      {col.sortable && col.key && sortField === col.key && (
                        sortDirection === 'asc' ? <ChevronUp className="h-3.5 w-3.5" /> : <ChevronDown className="h-3.5 w-3.5" />
                      )}
                    </div>
                  </th>
                ))}
              </tr>
            </thead>
            <tbody>
              {loading ? (
                <tr>
                  <td colSpan={columns.length} className="px-6 py-12">
                    <div className="flex flex-col items-center justify-center gap-2 text-slate-500">
                      <Loader2 className="h-7 w-7 animate-spin text-brand-600" />
                      <span className="text-xs font-semibold">Loading data...</span>
                    </div>
                  </td>
                </tr>
              ) : data.length === 0 ? (
                <tr>
                  <td colSpan={columns.length} className="px-6 py-12 text-center text-slate-500 dark:text-slate-400">
                    {emptyMessage}
                  </td>
                </tr>
              ) : (
                data.map((row, rowIdx) => (
                  <tr
                    key={rowIdx}
                    className="border-b last:border-0 border-slate-200/50 dark:border-dark-border/40 hover:bg-slate-50/40 dark:hover:bg-zinc-800/10 transition-colors"
                  >
                    {columns.map((col, colIdx) => (
                      <td key={colIdx} className="px-6 py-4">
                        {col.render
                          ? col.render(row)
                          : col.key
                          ? (row[col.key as keyof T] as unknown as React.ReactNode)
                          : null}
                      </td>
                    ))}
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
      </div>

      {/* Pagination Footer */}
      {totalPages > 1 && onPageChange && (
        <div className="flex items-center justify-between text-sm font-medium text-slate-500 dark:text-slate-400">
          <span>
            Page {page + 1} of {totalPages} ({totalElements} total items)
          </span>
          <div className="flex gap-2">
            <button
              onClick={() => onPageChange(page - 1)}
              disabled={page === 0 || loading}
              className="h-9 w-9 rounded-xl border border-slate-200 dark:border-dark-border flex items-center justify-center hover:bg-slate-100 dark:hover:bg-zinc-800/50 disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
            >
              <ArrowLeft className="h-4 w-4" />
            </button>
            <button
              onClick={() => onPageChange(page + 1)}
              disabled={page >= totalPages - 1 || loading}
              className="h-9 w-9 rounded-xl border border-slate-200 dark:border-dark-border flex items-center justify-center hover:bg-slate-100 dark:hover:bg-zinc-800/50 disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
            >
              <ArrowRight className="h-4 w-4" />
            </button>
          </div>
        </div>
      )}
    </div>
  );
}
