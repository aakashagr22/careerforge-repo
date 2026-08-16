export interface CommunityAnswer {
  id: string;
  authorId: string;
  authorName: string;
  content: string;
  createdAt: string;
}

export interface CommunityQuestion {
  id: string;
  authorId: string;
  authorName: string;
  title: string;
  content: string;
  tags: string[];
  answerCount: number;
  createdAt: string;
  answers: CommunityAnswer[];
}

export interface CommunityQuestionPage {
  content: CommunityQuestion[];
  totalPages: number;
}

export interface CreateQuestionRequest {
  title: string;
  content: string;
  tags?: string;
}
