-- Create resources table
CREATE TABLE resources (
    id UUID PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT,
    category VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    difficulty VARCHAR(20) NOT NULL,
    url VARCHAR(500) NOT NULL,
    thumbnail VARCHAR(500),
    created_by UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_resources_created_by FOREIGN KEY (created_by) REFERENCES users(id) ON DELETE CASCADE
);

-- Indexes for search and filter performance
CREATE INDEX idx_resources_category ON resources(category);
CREATE INDEX idx_resources_type ON resources(type);
CREATE INDEX idx_resources_difficulty ON resources(difficulty);
CREATE INDEX idx_resources_title ON resources(title);
