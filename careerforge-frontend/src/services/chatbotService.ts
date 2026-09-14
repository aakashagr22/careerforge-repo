import { apiClient } from '../config/api';

export interface ChatMessage {
  role: 'user' | 'assistant';
  content: string;
  isOfflineKnowledge?: boolean;
}

export interface ChatbotResourceLink {
  title: string;
  url: string;
  type: 'ROADMAP' | 'SHEET' | 'RESOURCE' | 'EXTERNAL';
}

export interface ChatbotResponse {
  answer: string;
  queriesRemaining: number;
  dailyLimit: number;
  isOfflineKnowledge: boolean;
  suggestedFollowUps?: string[];
  relevantLinks?: ChatbotResourceLink[];
}

export interface ChatbotQuota {
  dailyLimit: number;
  queriesUsedToday: number;
  queriesRemaining: number;
  cooldownSecondsRemaining: number;
  resetsAt: string;
}

export interface ChatbotRequest {
  message: string;
  history?: { role: string; content: string }[];
  pageContext?: string;
}

export const chatbotService = {
  async askQuestion(request: ChatbotRequest): Promise<ChatbotResponse> {
    const response = await apiClient.post('/api/student/chatbot/ask', request);
    return response.data.data;
  },

  async getQuota(): Promise<ChatbotQuota> {
    const response = await apiClient.get('/api/student/chatbot/quota');
    return response.data.data;
  },

  async getSuggestedPrompts(): Promise<string[]> {
    const response = await apiClient.get('/api/student/chatbot/suggested-prompts');
    return response.data.data;
  }
};
