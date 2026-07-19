import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as zod from 'zod';
import toast from 'react-hot-toast';
import { suggestionService } from '../services/suggestionService';
import { Card, CardContent } from '../components/Card';
import { Badge } from '../components/Badge';
import {
  MessageSquare, Send, Calendar, User, ArrowLeft, ArrowRight, FileText, CheckCircle2, Clock, Loader2
} from 'lucide-react';
import { Suggestion } from '../types/suggestion';

const suggestionFormSchema = zod.object({
  content: zod.string().min(10, 'Suggestion must be at least 10 characters').max(2000),
});

type SuggestionFormValues = zod.infer<typeof suggestionFormSchema>;

export const StudentSuggestionsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [page, setPage] = useState(0);
  const size = 5;

  // 1. Fetch my suggestions
  const { data: suggestionsPage, isLoading } = useQuery({
    queryKey: ['mySuggestions', page],
    queryFn: () => suggestionService.getMySuggestions(page, size),
    staleTime: 5 * 60 * 1000,
  });

  // 2. Submit form setup
  const { register, handleSubmit, reset, formState: { errors } } = useForm<SuggestionFormValues>({
    resolver: zodResolver(suggestionFormSchema),
    defaultValues: {
      content: '',
    }
  });

  // 3. Submit suggestion mutation
  const submitMutation = useMutation({
    mutationFn: suggestionService.submitSuggestion,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['mySuggestions'] });
      reset();
      toast.success('Suggestion submitted successfully!');
    },
    onError: (error: any) => {
      toast.error(error.response?.data?.message || 'Failed to submit suggestion.');
    }
  });

  const onSubmit = (values: SuggestionFormValues) => {
    submitMutation.mutate(values);
  };

  const suggestions = suggestionsPage?.content || [];
  const totalPages = suggestionsPage?.totalPages || 0;

  return (
    <div className="space-y-8 max-w-6xl mx-auto pb-16">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div className="border-b border-slate-200/50 dark:border-dark-border/40 pb-6">
        <div className="space-y-2">
          <h1 className="text-3xl font-extrabold font-heading text-slate-800 dark:text-white flex items-center gap-2.5">
            <MessageSquare className="h-7 w-7 text-brand-650" /> Student Suggestions
          </h1>
          <p className="text-xs text-slate-500 dark:text-slate-400">
            Help us improve CareerForge. Share feature requests, UI adjustments, or general platform suggestions.
          </p>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-12 gap-8 items-start">
        
        {/* ==================== SUBMIT BOX (LEFT) ==================== */}
        <div className="lg:col-span-5 space-y-4">
          <h3 className="text-xs font-bold text-slate-800 dark:text-white uppercase tracking-wider">
            Submit Suggestion
          </h3>
          <Card className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border">
            <CardContent className="p-6">
              <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
                <div className="space-y-2">
                  <label className="block text-xs font-semibold text-slate-650 dark:text-slate-400">
                    What can we improve?
                  </label>
                  <textarea
                    placeholder="Describe your suggestion in detail (min 10 characters)..."
                    {...register('content')}
                    className={`w-full px-4 py-2.5 rounded-xl border bg-slate-50/50 dark:bg-zinc-800 text-xs font-semibold text-slate-800 dark:text-slate-200 transition-all focus:outline-none focus:ring-2 focus:ring-brand-500/20 h-40 resize-none ${
                      errors.content ? 'border-red-500' : 'border-slate-200 dark:border-dark-border'
                    }`}
                  />
                  {errors.content && (
                    <p className="text-xs text-red-500">{errors.content.message}</p>
                  )}
                </div>

                <button
                  type="submit"
                  disabled={submitMutation.isPending}
                  className="w-full inline-flex items-center justify-center gap-1.5 bg-brand-650 hover:bg-brand-700 text-white px-4.5 py-2.5 rounded-xl text-sm font-bold transition-all shadow-sm disabled:opacity-75"
                >
                  {submitMutation.isPending ? (
                    <Loader2 className="h-4 w-4 animate-spin" />
                  ) : (
                    <Send className="h-4 w-4" />
                  )}
                  Send Suggestion
                </button>
              </form>
            </CardContent>
          </Card>
        </div>

        {/* ==================== HISTORY FEED (RIGHT) ==================== */}
        <div className="lg:col-span-7 space-y-4">
          <h3 className="text-xs font-bold text-slate-800 dark:text-white uppercase tracking-wider">
            Suggestion History
          </h3>
          
          {isLoading ? (
            <div className="space-y-4 animate-pulse">
              {[...Array(3)].map((_, i) => (
                <div key={i} className="h-32 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
              ))}
            </div>
          ) : suggestions.length === 0 ? (
            <div className="text-center py-20 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl space-y-3">
              <FileText className="h-9 w-9 text-slate-350 mx-auto" />
              <h4 className="text-xs font-bold text-slate-750 dark:text-white">No Submissions Yet</h4>
              <p className="text-[10px] text-slate-500">Your suggestion desk is empty. Send us your first idea!</p>
            </div>
          ) : (
            <div className="space-y-4">
              {suggestions.map((item: Suggestion) => (
                <Card key={item.id} className="bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border p-5 rounded-2xl relative overflow-hidden">
                  <div className="flex flex-col gap-4">
                    
                    {/* Header: Date and status badge */}
                    <div className="flex justify-between items-center text-[10px] text-slate-400 dark:text-slate-500 font-bold uppercase tracking-wider">
                      <div className="flex items-center gap-1">
                        <Calendar className="h-3.5 w-3.5" />
                        <span>{new Date(item.createdAt).toLocaleDateString()}</span>
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

                    {/* Content text */}
                    <p className="text-sm font-semibold text-slate-700 dark:text-slate-300 leading-relaxed break-words">
                      {item.content}
                    </p>

                    {/* Admin Response Block */}
                    {item.replyContent && (
                      <div className="bg-brand-50/40 dark:bg-brand-950/10 border border-brand-100 dark:border-brand-950/20 p-4 rounded-xl space-y-2 mt-1">
                        <div className="flex items-center gap-1.5 text-[9px] text-brand-650 dark:text-brand-400 font-bold uppercase tracking-wider">
                          <User className="h-3.5 w-3.5" />
                          <span>Replied by: {item.repliedByName || 'Administrator'}</span>
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

      </div>

    </div>
  );
};

export default StudentSuggestionsPage;
