-- Drop the obsolete roadmap_phases table
DROP TABLE IF EXISTS roadmap_phases CASCADE;

-- Create roadmap_sections table with parent validation constraints
CREATE TABLE roadmap_sections (
  id UUID PRIMARY KEY,
  roadmap_id UUID NOT NULL REFERENCES roadmaps(id) ON DELETE CASCADE,
  parent_id UUID NULL,
  title VARCHAR(255) NOT NULL,
  position INTEGER NOT NULL CHECK (position >= 0),
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,

  -- Unique constraint on composite id + roadmap_id to support parent validation foreign key
  CONSTRAINT uq_section_id_roadmap UNIQUE (id, roadmap_id),
  
  -- Foreign key ensuring the parent section belongs to the exact same roadmap ID
  CONSTRAINT fk_sections_parent FOREIGN KEY (parent_id, roadmap_id) 
    REFERENCES roadmap_sections(id, roadmap_id) ON DELETE CASCADE
);

-- Sibling position uniqueness rules
-- Root sections sibling position constraint (PostgreSQL partial index to handle parent_id IS NULL)
CREATE UNIQUE INDEX uq_sibling_position_root ON roadmap_sections (roadmap_id, position) 
WHERE parent_id IS NULL;

-- Child sections sibling position constraint
CREATE UNIQUE INDEX uq_sibling_position_child ON roadmap_sections (roadmap_id, parent_id, position) 
WHERE parent_id IS NOT NULL;


-- Create questions table for canonical questions
CREATE TABLE questions (
  id UUID PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  difficulty VARCHAR(20) NOT NULL CHECK (difficulty IN ('BEGINNER', 'EASY', 'MEDIUM', 'HARD', 'ADVANCED')),
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- Create roadmap_section_questions to link questions to sections
CREATE TABLE roadmap_section_questions (
  id UUID PRIMARY KEY,
  section_id UUID NOT NULL REFERENCES roadmap_sections(id) ON DELETE CASCADE,
  question_id UUID NOT NULL REFERENCES questions(id) ON DELETE RESTRICT,
  position INTEGER NOT NULL CHECK (position >= 0),
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,

  CONSTRAINT uq_section_question UNIQUE (section_id, question_id),
  CONSTRAINT uq_section_question_position UNIQUE (section_id, position)
);


-- Create question_links table
CREATE TABLE question_links (
  id UUID PRIMARY KEY,
  question_id UUID NOT NULL REFERENCES questions(id) ON DELETE CASCADE,
  link_type VARCHAR(30) NOT NULL CHECK (link_type IN ('SOLVE', 'VIDEO', 'ARTICLE', 'PRACTICE')),
  label VARCHAR(100),
  url TEXT NOT NULL,
  position INTEGER NOT NULL DEFAULT 0 CHECK (position >= 0),
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- Enforce question-link ordering uniqueness
CREATE UNIQUE INDEX uq_question_links_position ON question_links(question_id, position);


-- Create student progress tracking mapped to specific placement IDs
CREATE TABLE student_roadmap_question_progress (
  student_id UUID NOT NULL REFERENCES student_profiles(id) ON DELETE CASCADE,
  roadmap_section_question_id UUID NOT NULL REFERENCES roadmap_section_questions(id) ON DELETE CASCADE,
  completed BOOLEAN NOT NULL DEFAULT FALSE,
  revision_marked BOOLEAN NOT NULL DEFAULT FALSE,
  note TEXT,
  completed_at TIMESTAMP WITHOUT TIME ZONE NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,

  PRIMARY KEY (student_id, roadmap_section_question_id)
);
