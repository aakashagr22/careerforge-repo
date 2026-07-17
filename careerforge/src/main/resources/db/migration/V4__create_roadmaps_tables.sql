-- Create roadmaps table
CREATE TABLE roadmaps (
    id UUID PRIMARY KEY,
    semester INTEGER NOT NULL,
    months_remaining INTEGER NOT NULL,
    language VARCHAR(20) NOT NULL,
    target_role VARCHAR(50) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT uq_semester_lang_role UNIQUE (semester, language, target_role)
);

-- Create roadmap_phases table
CREATE TABLE roadmap_phases (
    id UUID PRIMARY KEY,
    roadmap_id UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    start_month INTEGER NOT NULL,
    end_month INTEGER NOT NULL,
    priority INTEGER NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_roadmap_phases_roadmap FOREIGN KEY (roadmap_id) REFERENCES roadmaps(id) ON DELETE CASCADE
);

-- Indexing for lookup performance
CREATE INDEX idx_roadmaps_lookup ON roadmaps(semester, language, target_role);
CREATE INDEX idx_roadmap_phases_roadmap ON roadmap_phases(roadmap_id);
