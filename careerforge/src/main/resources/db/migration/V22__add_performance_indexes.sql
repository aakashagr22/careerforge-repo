-- Supports the dashboard completed-sheet aggregate query.
CREATE INDEX IF NOT EXISTS idx_ssp_student_completed_topic
    ON student_sheet_progress (student_id, completed, sheet_topic_id);

-- Supports traversing roadmap questions when calculating student progress.
CREATE INDEX IF NOT EXISTS idx_rsq_section
    ON roadmap_section_questions (section_id);
