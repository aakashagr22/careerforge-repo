CREATE TABLE suggestions (
    id UUID PRIMARY KEY,
    student_id UUID REFERENCES users(id) ON DELETE CASCADE,
    content TEXT NOT NULL,
    reply_content TEXT,
    replied_by UUID REFERENCES users(id) ON DELETE SET NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    replied_at TIMESTAMP
);

CREATE INDEX idx_suggestions_student ON suggestions(student_id);
CREATE INDEX idx_suggestions_created ON suggestions(created_at DESC);
