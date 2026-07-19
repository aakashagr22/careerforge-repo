import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import toast from 'react-hot-toast';
import { suggestionService } from '../services/suggestionService';
import { Card, CardContent } from '../components/Card';
import { Badge } from '../components/Badge';
import {
  MessageSquare, Send, Calendar, User, ArrowLeft, ArrowRight, FileText, CheckCircle2, Clock, Loader2, CornerDownRight
} from 'lucide-react';
import { Suggestion } from '../types/suggestion';

export const ManageSuggestionsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [page, setPage] = useState(0);
  const [filter, setFilter] = useState<'all' | 'pending' | 'replied'>('all');
  const [activeReplyId, setActiveReplyId] = useState<string | null>(null);
  const [replyText, setReplyText] = useState('');
  const size = 10;

  // 1. Fetch suggestions
  const { data: suggestionsPage, isLoading } = useQuery({
    queryKey: ['adminSuggestions', page],
    queryFn: () => suggestionService.getAdminSuggestions(page, size),
    staleTime: 5 * 60 * 1000,
  });

  // 2. Submit reply mutation
  const replyMutation = useMutation({
    mutationFn: ({ id, content }: { id: string; content: string }) => 
      suggestionService.replyToSuggestion(id, { replyContent: content }),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['adminSuggestions'] });
      setActiveReplyId(null);
      setReplyText('');
      toast.success('Reply submitted successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to submit reply.');
    }
  });

  const handleReplySubmit = (e: React.FormEvent, id: string) => {
    e.preventDefault();
    if (!replyText.trim()) return;
    replyMutation.mutate({ id, content: replyText.trim() });
  };

  const rawSuggestions = suggestionsPage?.content || [];
  const totalPages = suggestionsPage?.totalPages || 0;

  // Filter client-side for immediate responsive UX
  const filteredSuggestions = rawSuggestions.filter((item: Suggestion) => {
    if (filter === 'pending') return !item.replyContent;
    if (filter === 'replied') return !!item.replyContent;
    return true;
  });

  return (
    <div className="space-y-8 max-w-4xl mx-auto pb-16">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div className="flex flex-col md:flex-row justify-between items-start md:items-center gap-4 border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <div className="space-y-2">
          <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2.5">
            <MessageSquare className="h-7 w-7 text-rose-650" /> Manage Suggestions
          </h1>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Read suggestions submitted by students and reply to them with feedback or updates.
          </p>
        </div>

        {/* Filter Selection */}
        <div className="flex items-center gap-1.5 bg-slate-100 dark:bg-zinc-800/40 p-1.5 rounded-xl border border-slate-200/40 dark:border-dark-border/10 shrink-0">
          {(['all', 'pending', 'replied'] as const).map((mode) => (
            <button
              key={mode}
              onClick={() => setFilter(mode)}
              className={`px-3.5 py-1.5 text-[10px] font-bold rounded-lg uppercase tracking-wider transition-all ${
                filter === mode
                  ? 'bg-white dark:bg-dark-card text-brand-650 dark:text-white shadow-sm border border-slate-200/20'
                  : 'text-slate-550 hover:text-slate-700 dark:hover:text-slate-350'
              }`}
            >
              {mode === 'all' ? 'All' : mode === 'pending' ? 'Pending' : 'Replied'}
            </button>
          ))}
        </div>
      </div>

      {/* ==================== LIST OF SUGGESTIONS ==================== */}
      {isLoading ? (
        <div className="flex items-center justify-center py-24 gap-3 text-slate-500 font-semibold text-xs">
          <Loader2 className="h-5 w-5 animate-spin text-rose-650" /> Loading student suggestions...
        </div>
      ) : filteredSuggestions.length === 0 ? (
        <div className="text-center py-20 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl space-y-3">
          <FileText className="h-9 w-9 text-slate-350 mx-auto" />
          <h4 className="text-xs font-bold text-slate-750 dark:text-white">No Suggestions Found</h4>
          <p className="text-[10px] text-slate-500">No student suggestions match this filter criteria.</p>
        </div>
      ) : (
        <div className="space-y-6">
          {filteredSuggestions.map((item: Suggestion) => (
            <Card key={item.id} className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border p-6 rounded-2xl relative overflow-hidden">
              <div className="flex flex-col gap-4">
                
                {/* Header info */}
                <div className="flex justify-between items-center text-[10px] text-slate-450 dark:text-slate-500 font-bold uppercase tracking-wider">
                  <div className="flex items-center gap-4">
                    <div className="flex items-center gap-1">
                      <User className="h-3.5 w-3.5" />
                      <span>{item.studentName}</span>
                    </div>
                    <div className="flex items-center gap-1">
                      <Calendar className="h-3.5 w-3.5" />
                      <span>{new Date(item.createdAt).toLocaleDateString()}</span>
                    </div>
                  </div>
                  
                  {item.replyContent ? (
                    <Badge variant="success" className="inline-flex items-center gap-1">
                      <CheckCircle2 className="h-3 w-3" /> Replied
                    </Badge>
                  ) : (
                    <Badge variant="warning" className="inline-flex items-center gap-1">
                      <Clock className="h-3 w-3" /> Awaiting Reply
                    </Badge>
                  )}
                </div>

                {/* Suggestion Text */}
                <p className="text-sm font-semibold text-slate-700 dark:text-slate-300 leading-relaxed break-words">
                  {item.content}
                </p>

                {/* Admin Reply Details or inline form */}
                {item.replyContent ? (
                  <div className="bg-slate-50/50 dark:bg-zinc-800/20 border border-slate-200/50 dark:border-dark-border/30 p-4 rounded-xl space-y-2 mt-1">
                    <div className="flex items-center gap-1.5 text-[9px] text-slate-450 dark:text-slate-550 font-bold uppercase tracking-wider">
                      <CornerDownRight className="h-3.5 w-3.5 text-brand-650" />
                      <span>Replied by: {item.repliedByName}</span>
                      {item.repliedAt && (
                        <>
                          <span className="text-slate-350">•</span>
                          <span>{new Date(item.repliedAt).toLocaleDateString()}</span>
                        </>
                      )}
                    </div>
                    <p className="text-sm font-bold text-slate-800 dark:text-slate-200 leading-relaxed italic break-words">
                      "{item.replyContent}"
                    </p>
                  </div>
                ) : activeReplyId === item.id ? (
                  <form onSubmit={(e) => handleReplySubmit(e, item.id)} className="bg-slate-50/50 dark:bg-zinc-800/10 border border-slate-200/50 dark:border-dark-border/40 p-4 rounded-xl space-y-3 mt-1">
                    <div className="flex justify-between items-center text-[10px] text-slate-450 dark:text-slate-550 font-bold uppercase tracking-wider">
                      <span>Compose Response</span>
                    </div>
                    <textarea
                      required
                      value={replyText}
                      onChange={(e) => setReplyText(e.target.value)}
                      placeholder="Write your feedback response here..."
                      className="w-full px-3 py-2 rounded-lg border border-slate-200 dark:border-dark-border bg-white dark:bg-zinc-800 text-sm font-semibold text-slate-800 dark:text-slate-200 focus:outline-none h-20 resize-none"
                    />
                     <div className="flex justify-end gap-2">
                      <button
                        type="button"
                        onClick={() => { setActiveReplyId(null); setReplyText(''); }}
                        className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl text-sm font-semibold text-slate-700 dark:text-slate-300 hover:bg-slate-100 dark:hover:bg-zinc-800/50"
                      >
                        Cancel
                      </button>
                      <button
                        type="submit"
                        disabled={replyMutation.isPending}
                        className="inline-flex items-center gap-1 bg-brand-650 hover:bg-brand-700 text-white px-4 py-2 rounded-xl text-sm font-bold transition-colors disabled:opacity-75"
                      >
                        {replyMutation.isPending ? (
                          <Loader2 className="h-3.5 w-3.5 animate-spin" />
                        ) : (
                          <Send className="h-3.5 w-3.5" />
                        )}
                        Send Reply
                      </button>
                    </div>
                  </form>
                ) : (
                  <div className="flex justify-end pt-1">
                    <button
                      onClick={() => { setActiveReplyId(item.id); setReplyText(''); }}
                      className="inline-flex items-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4.5 py-2.5 rounded-xl text-sm font-bold transition-colors shadow-sm"
                    >
                      <MessageSquare className="h-4 w-4" /> Reply to Suggestion
                    </button>
                  </div>
                )}

              </div>
            </Card>
          ))}
        </div>
      )}

      {/* Pagination */}
      {totalPages > 1 && (
        <div className="flex items-center justify-between text-sm font-bold text-slate-450 pt-4 border-t border-slate-200/50 dark:border-dark-border/40">
          <span>Page {page + 1} of {totalPages}</span>
          <div className="flex gap-2">
            <button
              onClick={() => setPage(p => Math.max(0, p - 1))}
              disabled={page === 0}
              className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors animate-all"
            >
              Prev
            </button>
            <button
              onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))}
              disabled={page >= totalPages - 1}
              className="px-4 py-2 border border-slate-200 dark:border-dark-border rounded-xl bg-white dark:bg-dark-card hover:bg-slate-50 dark:hover:bg-zinc-800 disabled:opacity-50 transition-colors animate-all"
            >
              Next
            </button>
          </div>
        </div>
      )}

    </div>
  );
};

export default ManageSuggestionsPage;
