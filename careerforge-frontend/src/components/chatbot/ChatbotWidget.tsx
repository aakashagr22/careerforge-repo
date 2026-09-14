import React, { useState, useEffect, useRef } from 'react';
import { useQuery, useMutation } from '@tanstack/react-query';
import { motion, AnimatePresence } from 'framer-motion';
import {
  Bot, Sparkles, X, Send, RotateCcw, Loader2, ArrowRight,
  ChevronDown, MessageSquare, ExternalLink, Zap, AlertCircle, Clock
} from 'lucide-react';
import { chatbotService, ChatMessage, ChatbotResponse } from '../../services/chatbotService';
import { studentService } from '../../services/studentService';
import toast from 'react-hot-toast';

export const ChatbotWidget: React.FC = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [inputMessage, setInputMessage] = useState('');
  const [messages, setMessages] = useState<ChatMessage[]>([]);
  const [cooldownSeconds, setCooldownSeconds] = useState(0);
  const messagesEndRef = useRef<HTMLDivElement>(null);
  const inputRef = useRef<HTMLInputElement>(null);

  // Fetch student profile for journey badge
  const { data: profile } = useQuery({
    queryKey: ['studentProfile'],
    queryFn: studentService.getMyProfile,
  });

  // Fetch quota
  const { data: quota, refetch: refetchQuota } = useQuery({
    queryKey: ['chatbotQuota'],
    queryFn: chatbotService.getQuota,
    enabled: isOpen,
    refetchInterval: isOpen ? 20000 : false,
  });

  // Fetch suggested prompts
  const { data: suggestedPrompts = [] } = useQuery({
    queryKey: ['chatbotSuggestedPrompts'],
    queryFn: chatbotService.getSuggestedPrompts,
    enabled: isOpen,
  });

  // Cooldown countdown timer
  useEffect(() => {
    if (cooldownSeconds <= 0) return;
    const interval = setInterval(() => {
      setCooldownSeconds((prev) => Math.max(0, prev - 1));
    }, 1000);
    return () => clearInterval(interval);
  }, [cooldownSeconds]);

  // Scroll to bottom on new message
  useEffect(() => {
    messagesEndRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [messages, isOpen]);

  // Focus input when modal opens
  useEffect(() => {
    if (isOpen) {
      setTimeout(() => inputRef.current?.focus(), 150);
    }
  }, [isOpen]);

  // Ask question mutation
  const askMutation = useMutation({
    mutationFn: (msg: string) =>
      chatbotService.askQuestion({
        message: msg,
        history: messages.slice(-4).map((m) => ({ role: m.role, content: m.content })),
        pageContext: window.location.pathname,
      }),
    onSuccess: (data: ChatbotResponse) => {
      setMessages((prev) => [
        ...prev,
        {
          role: 'assistant',
          content: data.answer,
          isOfflineKnowledge: data.isOfflineKnowledge,
        },
      ]);
      setCooldownSeconds(10);
      refetchQuota();
    },
    onError: (error: any) => {
      const errMsg =
        error?.response?.data?.message ||
        error?.response?.data?.errors?.[0] ||
        'Failed to get answer. Please try again.';
      toast.error(errMsg);
    },
  });

  const handleSendMessage = (textToSend?: string) => {
    const text = (textToSend || inputMessage).trim();
    if (!text || askMutation.isPending || cooldownSeconds > 0) return;

    if (quota && quota.queriesRemaining <= 0) {
      toast.error('Daily quota of 20 queries reached. Resets at midnight!');
      return;
    }

    setMessages((prev) => [...prev, { role: 'user', content: text }]);
    setInputMessage('');
    askMutation.mutate(text);
  };

  const handleClearHistory = () => {
    setMessages([]);
    toast.success('Conversation reset');
  };

  const roleBadge = profile?.targetRole ? `${profile.targetRole} • ${profile.framework || 'Spring Boot'}` : 'Tech & Career Mentor';

  return (
    <>
      {/* ================= FLOATING TRIGGER BUTTON ================= */}
      <div className="fixed bottom-6 right-6 z-50">
        <motion.button
          whileHover={{ scale: 1.05 }}
          whileTap={{ scale: 0.95 }}
          onClick={() => setIsOpen(!isOpen)}
          className="relative flex items-center gap-2.5 px-4 py-3 rounded-2xl bg-gradient-to-r from-brand-600 via-indigo-600 to-purple-600 text-white shadow-xl shadow-brand-500/25 hover:shadow-brand-500/40 border border-white/20 transition-all font-medium text-sm"
          title="Open ForgeBot AI Mentor"
        >
          <div className="relative">
            <Bot className="h-5 w-5" />
            <span className="absolute -top-1 -right-1 flex h-2.5 w-2.5">
              <span className="animate-ping absolute inline-flex h-full w-full rounded-full bg-emerald-400 opacity-75"></span>
              <span className="relative inline-flex rounded-full h-2.5 w-2.5 bg-emerald-500"></span>
            </span>
          </div>
          <span className="hidden sm:inline font-semibold">AI Mentor</span>
          {quota && (
            <span className="text-xs bg-white/20 px-1.5 py-0.5 rounded-md font-mono">
              {quota.queriesRemaining} left
            </span>
          )}
        </motion.button>
      </div>

      {/* ================= CHATBOT DRAWER MODAL ================= */}
      <AnimatePresence>
        {isOpen && (
          <motion.div
            initial={{ opacity: 0, y: 20, scale: 0.96 }}
            animate={{ opacity: 1, y: 0, scale: 1 }}
            exit={{ opacity: 0, y: 20, scale: 0.96 }}
            transition={{ type: 'spring', damping: 25, stiffness: 300 }}
            className="fixed bottom-20 right-4 sm:right-6 z-50 w-[94vw] sm:w-[460px] h-[640px] max-h-[85vh] bg-white dark:bg-zinc-900 border border-slate-200 dark:border-zinc-800 rounded-3xl shadow-2xl flex flex-col overflow-hidden"
          >
            {/* ── TOP HEADER ── */}
            <div className="px-5 py-4 border-b border-slate-100 dark:border-zinc-800/80 bg-gradient-to-b from-slate-50/80 to-white dark:from-zinc-900 dark:to-zinc-900/90 flex items-center justify-between shrink-0">
              <div className="flex items-center gap-3">
                <div className="h-10 w-10 rounded-2xl bg-gradient-to-tr from-brand-600 to-indigo-500 flex items-center justify-center text-white shadow-md shadow-brand-500/20">
                  <Sparkles className="h-5 w-5" />
                </div>
                <div>
                  <div className="flex items-center gap-2">
                    <h3 className="font-heading font-bold text-base text-slate-900 dark:text-white leading-tight">
                      ForgeBot
                    </h3>
                    <span className="text-[10px] uppercase font-bold tracking-wider px-2 py-0.5 rounded-full bg-brand-50 dark:bg-brand-950/40 text-brand-600 dark:text-brand-400 border border-brand-200 dark:border-brand-800">
                      Groq Llama
                    </span>
                  </div>
                  <p className="text-xs text-slate-500 dark:text-zinc-400 truncate max-w-[200px]">
                    {roleBadge}
                  </p>
                </div>
              </div>

              <div className="flex items-center gap-1.5">
                {/* Clear chat history */}
                <button
                  onClick={handleClearHistory}
                  disabled={messages.length === 0}
                  className="p-2 rounded-xl text-slate-400 hover:text-slate-600 dark:hover:text-zinc-200 hover:bg-slate-100 dark:hover:bg-zinc-800 disabled:opacity-40 transition-colors"
                  title="Reset conversation"
                >
                  <RotateCcw className="h-4 w-4" />
                </button>
                {/* Close modal */}
                <button
                  onClick={() => setIsOpen(false)}
                  className="p-2 rounded-xl text-slate-400 hover:text-slate-600 dark:hover:text-zinc-200 hover:bg-slate-100 dark:hover:bg-zinc-800 transition-colors"
                  title="Close widget"
                >
                  <X className="h-4 w-4" />
                </button>
              </div>
            </div>

            {/* ── QUOTA & STATUS STRIP ── */}
            <div className="px-4 py-2 bg-slate-50/70 dark:bg-zinc-950/40 border-b border-slate-100 dark:border-zinc-800 text-[11px] flex items-center justify-between text-slate-500 dark:text-zinc-400 shrink-0">
              <div className="flex items-center gap-1.5">
                <Zap className="h-3.5 w-3.5 text-amber-500" />
                <span>
                  Quota: <strong className="text-slate-700 dark:text-zinc-200">{quota?.queriesRemaining ?? 20}</strong> / {quota?.dailyLimit ?? 20} left today
                </span>
              </div>
              {cooldownSeconds > 0 ? (
                <div className="flex items-center gap-1 text-brand-600 dark:text-brand-400 font-medium">
                  <Clock className="h-3 w-3 animate-spin" />
                  <span>Cooldown: {cooldownSeconds}s</span>
                </div>
              ) : (
                <span className="text-emerald-600 dark:text-emerald-400 font-medium flex items-center gap-1">
                  <span className="h-1.5 w-1.5 rounded-full bg-emerald-500"></span> Ready
                </span>
              )}
            </div>

            {/* ── MESSAGES CONTAINER ── */}
            <div className="flex-1 overflow-y-auto p-4 space-y-4 text-sm scroll-smooth">
              {/* Welcoming Card when chat is empty */}
              {messages.length === 0 && (
                <div className="space-y-4 my-2">
                  <div className="p-4 rounded-2xl bg-gradient-to-br from-brand-50/70 to-indigo-50/40 dark:from-zinc-800/50 dark:to-zinc-800/30 border border-brand-100/60 dark:border-zinc-700/60 text-slate-700 dark:text-zinc-200 space-y-2">
                    <div className="flex items-center gap-2 text-brand-600 dark:text-brand-400 font-semibold text-xs">
                      <Sparkles className="h-4 w-4" />
                      <span>Welcome to your AI Career Assistant</span>
                    </div>
                    <p className="text-xs leading-relaxed text-slate-600 dark:text-zinc-300">
                      I'm customized for your <strong>{roleBadge}</strong> track. Ask me technical questions (DSA, code snippets, debugging), interview prep, or how to pace your semester milestones!
                    </p>
                  </div>

                  {/* Suggested starter pills */}
                  <div className="space-y-2">
                    <p className="text-[11px] font-semibold tracking-wider text-slate-400 dark:text-zinc-500 uppercase px-1">
                      Quick Questions to Start:
                    </p>
                    <div className="flex flex-col gap-1.5">
                      {suggestedPrompts.slice(0, 4).map((prompt, idx) => (
                        <button
                          key={idx}
                          onClick={() => handleSendMessage(prompt)}
                          disabled={askMutation.isPending || cooldownSeconds > 0}
                          className="text-left px-3 py-2 rounded-xl text-xs bg-slate-50 dark:bg-zinc-800/60 hover:bg-brand-50 dark:hover:bg-brand-950/30 hover:text-brand-600 dark:hover:text-brand-300 border border-slate-200/70 dark:border-zinc-700/50 transition-all flex items-center justify-between group disabled:opacity-50"
                        >
                          <span className="truncate pr-2">{prompt}</span>
                          <ArrowRight className="h-3 w-3 opacity-40 group-hover:opacity-100 group-hover:translate-x-0.5 transition-all shrink-0" />
                        </button>
                      ))}
                    </div>
                  </div>
                </div>
              )}

              {/* Message bubbles */}
              {messages.map((msg, index) => {
                const isUser = msg.role === 'user';
                return (
                  <div
                    key={index}
                    className={`flex flex-col ${isUser ? 'items-end' : 'items-start'}`}
                  >
                    <div
                      className={`max-w-[86%] rounded-2xl px-4 py-3 leading-relaxed whitespace-pre-wrap ${
                        isUser
                          ? 'bg-brand-600 text-white rounded-br-none shadow-md shadow-brand-600/15'
                          : 'bg-slate-100 dark:bg-zinc-800 text-slate-800 dark:text-zinc-100 rounded-bl-none border border-slate-200/60 dark:border-zinc-700/50'
                      }`}
                    >
                      {msg.content}
                    </div>

                    {!isUser && msg.isOfflineKnowledge && (
                      <span className="text-[10px] text-slate-400 dark:text-zinc-500 mt-1 pl-1 flex items-center gap-1">
                        <AlertCircle className="h-3 w-3 text-amber-500" /> Platform Knowledge
                      </span>
                    )}
                  </div>
                );
              })}

              {/* Pending loading bubble */}
              {askMutation.isPending && (
                <div className="flex items-start gap-2">
                  <div className="h-8 w-8 rounded-xl bg-brand-50 dark:bg-zinc-800 flex items-center justify-center text-brand-600 dark:text-brand-400 border border-brand-100 dark:border-zinc-700 shrink-0">
                    <Loader2 className="h-4 w-4 animate-spin" />
                  </div>
                  <div className="bg-slate-100 dark:bg-zinc-800 text-slate-500 dark:text-zinc-400 px-4 py-2.5 rounded-2xl rounded-bl-none text-xs flex items-center gap-2">
                    <span>Thinking & formulating guidance...</span>
                  </div>
                </div>
              )}

              <div ref={messagesEndRef} />
            </div>

            {/* ── INPUT BOX ── */}
            <div className="p-3 border-t border-slate-100 dark:border-zinc-800/80 bg-white dark:bg-zinc-900 shrink-0">
              <form
                onSubmit={(e) => {
                  e.preventDefault();
                  handleSendMessage();
                }}
                className="flex items-center gap-2"
              >
                <input
                  ref={inputRef}
                  type="text"
                  value={inputMessage}
                  onChange={(e) => setInputMessage(e.target.value)}
                  placeholder={
                    cooldownSeconds > 0
                      ? `Please wait ${cooldownSeconds}s before next query...`
                      : quota && quota.queriesRemaining <= 0
                      ? 'Daily quota reached for today'
                      : 'Ask a tech question or journey advice...'
                  }
                  disabled={askMutation.isPending || (quota !== undefined && quota.queriesRemaining <= 0)}
                  className="flex-1 bg-slate-50 dark:bg-zinc-800/70 border border-slate-200 dark:border-zinc-700 rounded-xl px-4 py-2.5 text-xs text-slate-900 dark:text-white placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-brand-500/30 transition-all disabled:opacity-50"
                />
                <button
                  type="submit"
                  disabled={
                    !inputMessage.trim() ||
                    askMutation.isPending ||
                    cooldownSeconds > 0 ||
                    (quota !== undefined && quota.queriesRemaining <= 0)
                  }
                  className="h-10 w-10 rounded-xl bg-brand-600 hover:bg-brand-700 text-white flex items-center justify-center disabled:opacity-40 disabled:cursor-not-allowed transition-all shadow-md shadow-brand-500/20 shrink-0"
                >
                  <Send className="h-4 w-4" />
                </button>
              </form>
              <div className="mt-1.5 flex items-center justify-between text-[10px] text-slate-400 dark:text-zinc-500 px-1">
                <span>Powered by Groq High-Speed Inference</span>
                <span>Fair-share: 20/day</span>
              </div>
            </div>
          </motion.div>
        )}
      </AnimatePresence>
    </>
  );
};
