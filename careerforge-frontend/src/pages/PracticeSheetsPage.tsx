import React, { useState } from 'react';
import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { motion, AnimatePresence } from 'framer-motion';
import toast from 'react-hot-toast';
import { sheetService } from '../services/sheetService';
import { Card } from '../components/Card';
import { Badge } from '../components/Badge';
import { 
  CheckSquare, Layers, ChevronDown, 
  ChevronUp, Loader2
} from 'lucide-react';

export const PracticeSheetsPage: React.FC = () => {
  const queryClient = useQueryClient();
  const [selectedCategory, setSelectedCategory] = useState<'ALL' | 'DSA' | 'WEB_DEVELOPER' | 'SYSTEM_DESIGN' | 'MACHINE_LEARNING'>('ALL');
  const [expandedSheetId, setExpandedSheetId] = useState<string | null>(null);

  // Fetch all sheets
  const { data: sheets, isLoading: loadingSheets } = useQuery({
    queryKey: ['practiceSheets'],
    queryFn: sheetService.getPracticeSheets,
  });

  // Fetch completed topic IDs for the current student
  const { data: completedTopicIds = [], isLoading: loadingCompletions } = useQuery({
    queryKey: ['completedTopicIds'],
    queryFn: sheetService.getCompletedTopicIds,
  });

  // Fetch topics for the currently expanded sheet
  const { data: expandedTopics = [], isLoading: loadingTopics } = useQuery({
    queryKey: ['sheetTopics', expandedSheetId],
    queryFn: () => sheetService.getSheetTopics(expandedSheetId!),
    enabled: !!expandedSheetId,
  });

  // Mutation to toggle topic completion status
  const toggleCompletionMutation = useMutation({
    mutationFn: ({ topicId, completed }: { topicId: string; completed: boolean }) =>
      sheetService.toggleTopicCompletion(topicId, completed),
    onMutate: async ({ topicId, completed }) => {
      // Cancel outgoing refetches
      await queryClient.cancelQueries({ queryKey: ['completedTopicIds'] });

      // Snapshot previous value
      const previousCompletions = queryClient.getQueryData<string[]>(['completedTopicIds']) || [];

      // Optimistically update
      const updatedCompletions = completed
        ? [...previousCompletions, topicId]
        : previousCompletions.filter(id => id !== topicId);
      
      queryClient.setQueryData(['completedTopicIds'], updatedCompletions);

      return { previousCompletions };
    },
    onError: (_, __, context) => {
      if (context?.previousCompletions) {
        queryClient.setQueryData(['completedTopicIds'], context.previousCompletions);
      }
      toast.error('Failed to update completion status.');
    },
    onSuccess: (_, variables) => {
      // Invalidate queries to sync with backend progress calculations
      queryClient.invalidateQueries({ queryKey: ['studentDashboard'] });
      queryClient.invalidateQueries({ queryKey: ['completedTopicIds'] });
      toast.success(variables.completed ? 'Topic completed! Keep going.' : 'Progress updated.');
    },
  });

  const handleToggleTopic = (topicId: string) => {
    const isCompleted = completedTopicIds.includes(topicId);
    toggleCompletionMutation.mutate({ topicId, completed: !isCompleted });
  };

  const handleSheetExpand = (sheetId: string) => {
    if (expandedSheetId === sheetId) {
      setExpandedSheetId(null);
    } else {
      setExpandedSheetId(sheetId);
    }
  };

  // Filter sheets by category
  const filteredSheets = sheets?.filter(sheet => 
    selectedCategory === 'ALL' || sheet.category === selectedCategory
  ) || [];

  const categories = [
    { id: 'ALL', name: 'All Practice Sheets' },
    { id: 'DSA', name: 'Data Structures & Algorithms' },
    { id: 'WEB_DEVELOPER', name: 'Web Development' },
    { id: 'SYSTEM_DESIGN', name: 'System Design' },
    { id: 'MACHINE_LEARNING', name: 'Machine Learning' },
  ];

  if (loadingSheets || loadingCompletions) {
    return (
      <div className="space-y-6 animate-pulse">
        <div className="h-10 bg-slate-200 dark:bg-zinc-800 rounded-xl w-72" />
        <div className="flex gap-2 overflow-x-auto pb-2">
          {[...Array(4)].map((_, i) => (
            <div key={i} className="h-9 w-32 bg-slate-200 dark:bg-zinc-800 rounded-xl shrink-0" />
          ))}
        </div>
        <div className="space-y-4">
          {[...Array(3)].map((_, i) => (
            <div key={i} className="h-28 bg-slate-200 dark:bg-zinc-800 rounded-2xl" />
          ))}
        </div>
      </div>
    );
  }

  return (
    <div className="space-y-8 max-w-4xl mx-auto">
      
      {/* ==================== PAGE HEADER ==================== */}
      <div>
        <h1 className="text-3xl font-bold font-heading text-slate-800 dark:text-white flex items-center gap-2">
          <CheckSquare className="h-7 w-7 text-brand-600" /> Practice Sheets
        </h1>
        <p className="text-sm text-slate-500 dark:text-slate-400 mt-1">
          Complete curated preparation sheets to track topics finished and unlock badges.
        </p>
      </div>

      {/* ==================== CATEGORIES SCROLL BAR ==================== */}
      <div className="flex gap-2 overflow-x-auto pb-1.5 scrollbar-thin">
        {categories.map((cat) => (
          <button
            key={cat.id}
            onClick={() => {
              setSelectedCategory(cat.id as any);
              setExpandedSheetId(null); // Reset expand on tab switch
            }}
            className={`px-4 py-2 rounded-xl text-xs font-bold transition-all shrink-0 border ${
              selectedCategory === cat.id
                ? 'bg-brand-600 border-brand-600 text-white shadow-lg shadow-brand-500/10'
                : 'bg-white dark:bg-dark-card border-slate-200 dark:border-dark-border text-slate-500 dark:text-slate-400 hover:text-slate-800 dark:hover:text-slate-200 hover:bg-slate-50 dark:hover:bg-zinc-800/40'
            }`}
          >
            {cat.name}
          </button>
        ))}
      </div>

      {/* ==================== PRACTICE SHEETS CONTAINER ==================== */}
      {filteredSheets.length === 0 ? (
        <div className="text-center py-20 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl space-y-4">
          <Layers className="h-10 w-10 text-slate-400 mx-auto" />
          <h3 className="text-lg font-bold font-heading text-slate-800 dark:text-white">No Sheets Available</h3>
          <p className="text-sm text-slate-500 max-w-xs mx-auto">
            Admins haven't added coding checklists to this category yet.
          </p>
        </div>
      ) : (
        <div className="space-y-4">
          {filteredSheets.map((sheet) => {
            const isExpanded = expandedSheetId === sheet.id;

            return (
              <Card key={sheet.id} hoverEffect className="overflow-hidden">
                {/* Accordion header toggler */}
                <div
                  onClick={() => handleSheetExpand(sheet.id)}
                  className="px-6 py-5 flex flex-col sm:flex-row justify-between items-start sm:items-center gap-4 cursor-pointer select-none"
                >
                  <div className="space-y-1">
                    <div className="flex items-center gap-2">
                      <Badge variant="brand">{sheet.category}</Badge>
                      <h3 className="text-lg font-bold font-heading text-slate-900 dark:text-white">
                        {sheet.title}
                      </h3>
                    </div>
                    <p className="text-xs text-slate-500 dark:text-slate-400">
                      {sheet.description}
                    </p>
                  </div>

                  <div className="flex items-center gap-4 shrink-0 self-end sm:self-auto">
                    {isExpanded ? (
                      <ChevronUp className="h-5 w-5 text-slate-400" />
                    ) : (
                      <ChevronDown className="h-5 w-5 text-slate-400" />
                    )}
                  </div>
                </div>

                {/* Accordion expanded content */}
                <AnimatePresence>
                  {isExpanded && (
                    <motion.div
                      initial={{ height: 0 }}
                      animate={{ height: 'auto' }}
                      exit={{ height: 0 }}
                      className="overflow-hidden border-t border-slate-200/50 dark:border-dark-border/40 bg-slate-50/20 dark:bg-zinc-900/10"
                    >
                      <div className="p-6 space-y-6">
                        {loadingTopics ? (
                          <div className="flex items-center justify-center py-10 gap-2 text-slate-500 text-sm">
                            <Loader2 className="h-5 w-5 animate-spin text-brand-600" /> Loading topic checklist...
                          </div>
                        ) : expandedTopics.length === 0 ? (
                          <div className="text-center py-6 text-slate-500 text-sm">
                            No topics have been added to this practice sheet yet.
                          </div>
                        ) : (
                          <div className="space-y-3.5">
                            {/* Topics List Checkbox Group */}
                            {expandedTopics.map((topic) => {
                              const isCompleted = completedTopicIds.includes(topic.id);

                              return (
                                <div
                                  key={topic.id}
                                  onClick={() => handleToggleTopic(topic.id)}
                                  className={`flex items-start p-4 rounded-xl border transition-all cursor-pointer group ${
                                    isCompleted
                                      ? 'bg-emerald-500/5 border-emerald-500/25 dark:bg-emerald-950/5 dark:border-emerald-500/15'
                                      : 'bg-white dark:bg-dark-card border-slate-200 dark:border-dark-border hover:border-slate-300 dark:hover:border-zinc-700'
                                  }`}
                                >
                                  {/* Custom Checkbox */}
                                  <div className="mt-0.5 shrink-0">
                                    <div className={`h-5 w-5 rounded-lg border-2 flex items-center justify-center transition-all ${
                                      isCompleted
                                        ? 'bg-emerald-500 border-emerald-500 text-white'
                                        : 'border-slate-300 dark:border-zinc-700 group-hover:border-brand-500'
                                    }`}>
                                      {isCompleted && (
                                        <svg className="h-3 w-3 fill-current font-bold" viewBox="0 0 20 20">
                                          <path d="M0 11l2-2 5 5L18 3l2 2L7 18z" />
                                        </svg>
                                      )}
                                    </div>
                                  </div>

                                  <div className="ml-4 flex-1">
                                    <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-1.5">
                                      <span className={`font-semibold text-sm transition-all ${
                                        isCompleted ? 'line-through text-slate-400 dark:text-zinc-500' : 'text-slate-800 dark:text-slate-200'
                                      }`}>
                                        {topic.title}
                                      </span>
                                      
                                      <Badge
                                        variant={
                                          topic.difficulty === 'EASY'
                                            ? 'success'
                                            : topic.difficulty === 'MEDIUM'
                                            ? 'warning'
                                            : 'error'
                                        }
                                        className="self-start sm:self-auto uppercase text-[9px] tracking-wider py-0 px-2.5"
                                      >
                                        {topic.difficulty}
                                      </Badge>
                                    </div>
                                    <p className="text-xs text-slate-500 dark:text-slate-400 mt-1">
                                      {topic.description}
                                    </p>
                                  </div>
                                </div>
                              );
                            })}
                          </div>
                        )}
                      </div>
                    </motion.div>
                  )}
                </AnimatePresence>
              </Card>
            );
          })}
        </div>
      )}

    </div>
  );
};
export default PracticeSheetsPage;
