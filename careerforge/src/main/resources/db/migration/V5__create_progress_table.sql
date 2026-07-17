-- Create student_progress table
CREATE TABLE student_progress (
    id UUID PRIMARY KEY,
    student_id UUID NOT NULL UNIQUE,
    completed_sheets INTEGER NOT NULL DEFAULT 0,
    completed_topics INTEGER NOT NULL DEFAULT 0,
    roadmap_progress DOUBLE PRECISION NOT NULL DEFAULT 0.0,
    current_streak INTEGER NOT NULL DEFAULT 0,
    last_active TIMESTAMP WITHOUT TIME ZONE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_student_progress_student FOREIGN KEY (student_id) REFERENCES student_profiles(id) ON DELETE CASCADE
);

-- Indexing for lookup performance
CREATE INDEX idx_student_progress_student ON student_progress(student_id);
