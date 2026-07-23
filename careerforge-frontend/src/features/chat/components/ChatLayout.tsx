import React from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { useChatStore } from '../store/useChatStore';

interface ChatLayoutProps {
  sidebar: React.ReactNode;
  header: React.ReactNode;
  messages: React.ReactNode;
  input: React.ReactNode;
  infoPanel?: React.ReactNode;
  mobileDrawer?: React.ReactNode;
}

export const ChatLayout: React.FC<ChatLayoutProps> = ({
  sidebar,
  header,
  messages,
  input,
  infoPanel,
  mobileDrawer,
}) => {
  const { infoPanelOpen, mobileDrawerOpen, setMobileDrawerOpen } = useChatStore();

  return (
    <div className="h-[calc(100vh-4rem)] flex overflow-hidden bg-slate-50 dark:bg-dark-bg border border-slate-200/80 dark:border-dark-border rounded-2xl shadow-sm">
      {/* Desktop Sidebar */}
      <div className="hidden md:block shrink-0">{sidebar}</div>

      {/* Mobile Drawer Slide-over */}
      <AnimatePresence>
        {mobileDrawerOpen && (
          <>
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 0.4 }}
              exit={{ opacity: 0 }}
              onClick={() => setMobileDrawerOpen(false)}
              className="fixed inset-0 bg-black z-40 md:hidden"
            />
            <motion.div
              initial={{ x: '-100%' }}
              animate={{ x: 0 }}
              exit={{ x: '-100%' }}
              transition={{ type: 'spring', damping: 25 }}
              className="fixed inset-y-0 left-0 w-72 bg-white dark:bg-dark-card z-50 md:hidden flex flex-col"
            >
              {mobileDrawer || sidebar}
            </motion.div>
          </>
        )}
      </AnimatePresence>

      {/* Main Chat Center Column */}
      <div className="flex-1 flex flex-col min-w-0 h-full relative">
        {header}
        <div className="flex-1 flex flex-col min-h-0 bg-slate-50/50 dark:bg-dark-bg/30 relative">
          {messages}
        </div>
        {input}
      </div>

      {/* Desktop Right Details Panel */}
      <AnimatePresence>
        {infoPanelOpen && infoPanel && (
          <motion.div
            initial={{ opacity: 0, width: 0 }}
            animate={{ opacity: 1, width: 'auto' }}
            exit={{ opacity: 0, width: 0 }}
            className="hidden xl:block overflow-hidden"
          >
            {infoPanel}
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  );
};
