-- Create blogs table
CREATE TABLE blogs (
    id UUID PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    status VARCHAR(25) NOT NULL,
    author_id UUID,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    approved_by UUID,
    approved_at TIMESTAMP WITHOUT TIME ZONE,
    rejection_reason TEXT,
    CONSTRAINT fk_blogs_author FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE SET NULL,
    CONSTRAINT fk_blogs_approved_by FOREIGN KEY (approved_by) REFERENCES users(id) ON DELETE SET NULL,
    CONSTRAINT chk_blog_status CHECK (status IN ('DRAFT', 'PENDING_REVIEW', 'PUBLISHED', 'REJECTED'))
);

-- Indexes for status filtering and author feed queries
CREATE INDEX idx_blogs_status ON blogs(status);
CREATE INDEX idx_blogs_author ON blogs(author_id);
