CREATE TABLE resource_folders (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_id UUID REFERENCES resource_folders(id) ON DELETE RESTRICT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Indexes for foreign keys
CREATE INDEX idx_resource_folders_parent ON resource_folders(parent_id);

-- Uniqueness constraints at root and subfolder levels
CREATE UNIQUE INDEX uq_resource_folder_root_name
  ON resource_folders(name)
  WHERE parent_id IS NULL;

CREATE UNIQUE INDEX uq_resource_folder_child_name
  ON resource_folders(parent_id, name)
  WHERE parent_id IS NOT NULL;

-- Alter resources table: remove category, difficulty and link to folder
ALTER TABLE resources DROP COLUMN difficulty;
ALTER TABLE resources DROP COLUMN category;
ALTER TABLE resources ADD COLUMN folder_id UUID REFERENCES resource_folders(id) ON DELETE RESTRICT;

-- Index for FK lookup in resources
CREATE INDEX idx_resources_folder ON resources(folder_id);

-- Enforce strict type enum checking in the database
ALTER TABLE resources ADD CONSTRAINT chk_resource_type CHECK (type IN ('VIDEO', 'ARTICLE'));
