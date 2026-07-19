export type BlogStatus = 'DRAFT' | 'PENDING_REVIEW' | 'PUBLISHED' | 'REJECTED';

export interface Blog {
  id: string;
  title: string;
  content: string;
  status: BlogStatus;
  authorId: string | null;
  authorName: string;
  createdAt: string;
  updatedAt: string;
  approvedAt: string | null;
  approvedBy: string | null;
  rejectionReason: string | null;
}

export interface CreateBlogRequest {
  title: string;
  content: string;
  submitForReview: boolean;
}

export interface UpdateBlogRequest {
  title: string;
  content: string;
  submitForReview: boolean;
}

export interface RejectBlogRequest {
  rejectionReason: string;
}
