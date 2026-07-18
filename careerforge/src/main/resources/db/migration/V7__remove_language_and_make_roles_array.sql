-- Drop unique constraint and index that reference language/target_role
ALTER TABLE roadmaps DROP CONSTRAINT uq_semester_lang_role;
DROP INDEX IF EXISTS idx_roadmaps_lookup;

-- Drop the language column and target_role column from roadmaps table
ALTER TABLE roadmaps DROP COLUMN language;
ALTER TABLE roadmaps DROP COLUMN target_role;

-- Add target_roles array column to roadmaps table
ALTER TABLE roadmaps ADD COLUMN target_roles varchar(50)[] NOT NULL DEFAULT '{}';

-- Re-create index for lookup performance on semester
CREATE INDEX idx_roadmaps_semester ON roadmaps(semester);
