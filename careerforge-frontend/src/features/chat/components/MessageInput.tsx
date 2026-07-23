import React, { useState, useRef, KeyboardEvent } from 'react';
import { Send, Smile, Paperclip } from 'lucide-react';

interface MessageInputProps {
  onSendMessage: (text: string) => void;
  disabled?: boolean;
  placeholder?: string;
}

const COMMON_EMOJIS = ['👍', '❤️', '🔥', '🎉', '😊', '🚀', '💯', '👏', '💡', '✅'];

export const MessageInput: React.FC<MessageInputProps> = ({
  onSendMessage,
  disabled = false,
  placeholder = 'Type a message...',
}) => {
  const [text, setText] = useState('');
  const [showEmojiPicker, setShowEmojiPicker] = useState(false);
  const textareaRef = useRef<HTMLTextAreaElement>(null);

  const handleSend = () => {
    if (!text.trim() || disabled) return;
    onSendMessage(text.trim());
    setText('');
    setShowEmojiPicker(false);
    if (textareaRef.current) {
      textareaRef.current.focus();
    }
  };

  const handleKeyDown = (e: KeyboardEvent<HTMLTextAreaElement>) => {
    if (e.key === 'Enter' && !e.shiftKey) {
      e.preventDefault();
      handleSend();
    }
  };

  const addEmoji = (emoji: string) => {
    setText((prev) => prev + emoji);
  };

  return (
    <div className="relative p-4 bg-white dark:bg-dark-card border-t border-slate-200/80 dark:border-dark-border">
      {/* Quick Emoji Picker Popup */}
      {showEmojiPicker && (
        <div className="absolute bottom-full mb-2 left-4 p-2 bg-white dark:bg-dark-card border border-slate-200/80 dark:border-dark-border rounded-2xl shadow-xl z-20 flex items-center gap-1.5 flex-wrap max-w-xs">
          {COMMON_EMOJIS.map((emoji) => (
            <button
              key={emoji}
              type="button"
              onClick={() => addEmoji(emoji)}
              className="h-8 w-8 rounded-lg hover:bg-slate-100 dark:hover:bg-zinc-800/60 flex items-center justify-center text-lg transition-transform hover:scale-110"
            >
              {emoji}
            </button>
          ))}
        </div>
      )}

      {/* Input Box Wrapper */}
      <div className="flex items-end gap-2 bg-slate-50 dark:bg-dark-bg/60 border border-slate-200/80 dark:border-dark-border rounded-2xl p-2 focus-within:ring-2 focus-within:ring-brand-500/20 focus-within:border-brand-500 transition-all">
        {/* Attachment Button (Future Ready) */}
        <button
          type="button"
          disabled={disabled}
          className="p-2 text-slate-400 hover:text-slate-600 dark:hover:text-slate-200 disabled:opacity-40 transition-colors rounded-xl hover:bg-slate-200/50 dark:hover:bg-zinc-800/50 shrink-0"
          title="Attach file (Future ready)"
        >
          <Paperclip className="h-5 w-5" />
        </button>

        {/* Text Area */}
        <textarea
          ref={textareaRef}
          rows={1}
          value={text}
          disabled={disabled}
          onChange={(e) => setText(e.target.value)}
          onKeyDown={handleKeyDown}
          placeholder={placeholder}
          className="flex-1 bg-transparent py-2 px-1 text-sm outline-none resize-none max-h-32 text-slate-900 dark:text-white placeholder:text-slate-400 dark:placeholder:text-slate-500"
        />

        {/* Emoji Button */}
        <button
          type="button"
          disabled={disabled}
          onClick={() => setShowEmojiPicker(!showEmojiPicker)}
          className="p-2 text-slate-400 hover:text-slate-600 dark:hover:text-slate-200 disabled:opacity-40 transition-colors rounded-xl hover:bg-slate-200/50 dark:hover:bg-zinc-800/50 shrink-0"
          title="Pick emoji"
        >
          <Smile className="h-5 w-5" />
        </button>

        {/* Send Button */}
        <button
          type="button"
          disabled={disabled || !text.trim()}
          onClick={handleSend}
          className="p-2.5 rounded-xl bg-brand-600 hover:bg-brand-700 text-white disabled:opacity-40 disabled:hover:bg-brand-600 transition-all shadow-md shadow-brand-600/20 shrink-0"
          title="Send message"
        >
          <Send className="h-4 w-4" />
        </button>
      </div>

      <div className="flex items-center justify-between mt-2 px-1 text-[11px] text-slate-400 dark:text-slate-500">
        <span>Press <kbd className="px-1 py-0.5 rounded bg-slate-100 dark:bg-zinc-800 border font-sans">Enter</kbd> to send, <kbd className="px-1 py-0.5 rounded bg-slate-100 dark:bg-zinc-800 border font-sans">Shift + Enter</kbd> for new line</span>
      </div>
    </div>
  );
};
