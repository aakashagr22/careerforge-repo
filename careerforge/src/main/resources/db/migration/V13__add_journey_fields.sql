-- Add journey-related fields to student profiles
ALTER TABLE student_profiles ADD COLUMN starting_semester INT;
ALTER TABLE student_profiles ADD COLUMN framework VARCHAR(50);

ALTER TABLE student_profiles
    ADD CONSTRAINT chk_student_profiles_starting_semester
    CHECK (starting_semester IS NULL OR starting_semester BETWEEN 1 AND 5);

-- Migrate any existing WEB_DEVELOPER or DEVOPS target_role values to SDE
UPDATE student_profiles SET target_role = 'SDE' WHERE target_role IN ('WEB_DEVELOPER', 'DEVOPS');

-- Clean up roadmaps target_roles arrays: remove WEB_DEVELOPER and DEVOPS entries
UPDATE roadmaps SET target_roles = array_remove(target_roles, 'WEB_DEVELOPER');
UPDATE roadmaps SET target_roles = array_remove(target_roles, 'DEVOPS');
-- Ensure no roadmap has an empty target_roles array after cleanup
UPDATE roadmaps SET target_roles = ARRAY['SDE'] WHERE target_roles = '{}' OR target_roles IS NULL;
