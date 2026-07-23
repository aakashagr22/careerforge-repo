import { create } from 'zustand';

export type ChatTab = 'rooms' | 'direct';

interface ChatUIState {
  // Selected targets
  activeTab: ChatTab;
  selectedRoomId: string | null;
  selectedConversationId: string | null;

  // Panel & UI states
  infoPanelOpen: boolean;
  mobileDrawerOpen: boolean;
  searchModalOpen: boolean;
  searchQuery: string;

  // Actions
  setActiveTab: (tab: ChatTab) => void;
  selectRoom: (roomId: string) => void;
  selectConversation: (conversationId: string) => void;
  toggleInfoPanel: () => void;
  setInfoPanelOpen: (open: boolean) => void;
  setMobileDrawerOpen: (open: boolean) => void;
  setSearchModalOpen: (open: boolean) => void;
  setSearchQuery: (query: string) => void;
  resetChatSelection: () => void;
}

export const useChatStore = create<ChatUIState>((set) => ({
  activeTab: 'rooms',
  selectedRoomId: null,
  selectedConversationId: null,

  infoPanelOpen: false,
  mobileDrawerOpen: false,
  searchModalOpen: false,
  searchQuery: '',

  setActiveTab: (activeTab) => set({ activeTab }),
  selectRoom: (selectedRoomId) =>
    set({
      selectedRoomId,
      selectedConversationId: null,
      activeTab: 'rooms',
      mobileDrawerOpen: false,
    }),
  selectConversation: (selectedConversationId) =>
    set({
      selectedConversationId,
      selectedRoomId: null,
      activeTab: 'direct',
      mobileDrawerOpen: false,
    }),
  toggleInfoPanel: () => set((state) => ({ infoPanelOpen: !state.infoPanelOpen })),
  setInfoPanelOpen: (infoPanelOpen) => set({ infoPanelOpen }),
  setMobileDrawerOpen: (mobileDrawerOpen) => set({ mobileDrawerOpen }),
  setSearchModalOpen: (searchModalOpen) => set({ searchModalOpen }),
  setSearchQuery: (searchQuery) => set({ searchQuery }),
  resetChatSelection: () =>
    set({
      selectedRoomId: null,
      selectedConversationId: null,
    }),
}));
