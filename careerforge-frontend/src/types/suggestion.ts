export interface Suggestion {
  id: string;
  studentId: string | null;
  studentName: string;
  content: string;
  replyContent: string | null;
  repliedById: string | null;
  repliedByName: string | null;
  createdAt: string;
  repliedAt: string | null;
}

export interface CreateSuggestionRequest {
  content: string;
}

export interface ReplySuggestionRequest {
  replyContent: string;
}
