-- Create sheets table
CREATE TABLE sheets (
    id UUID PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT,
    category VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- Create sheet_topics table
CREATE TABLE sheet_topics (
    id UUID PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT,
    difficulty VARCHAR(20) NOT NULL,
    order_index INTEGER NOT NULL,
    sheet_id UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_sheet_topics_sheet FOREIGN KEY (sheet_id) REFERENCES sheets(id) ON DELETE CASCADE
);

-- Create student_sheet_progress table
CREATE TABLE student_sheet_progress (
    id UUID PRIMARY KEY,
    student_id UUID NOT NULL,
    sheet_topic_id UUID NOT NULL,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    completed_at TIMESTAMP WITHOUT TIME ZONE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_ssp_student FOREIGN KEY (student_id) REFERENCES student_profiles(id) ON DELETE CASCADE,
    CONSTRAINT fk_ssp_sheet_topic FOREIGN KEY (sheet_topic_id) REFERENCES sheet_topics(id) ON DELETE CASCADE,
    CONSTRAINT uq_student_topic UNIQUE (student_id, sheet_topic_id)
);

-- Indexing for performance
CREATE INDEX idx_sheet_topics_sheet ON sheet_topics(sheet_id);
CREATE INDEX idx_ssp_student ON student_sheet_progress(student_id);
CREATE INDEX idx_ssp_student_topic ON student_sheet_progress(student_id, sheet_topic_id);
