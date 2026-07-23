-- =====================================================
-- V16: Add year_group column to chat_rooms for YEAR_CHAT access control
-- =====================================================

ALTER TABLE chat_rooms ADD COLUMN year_group INTEGER;

-- Update existing seeded year chat rooms with their year groups
UPDATE chat_rooms SET year_group = 1 WHERE id = 'a1000000-0000-0000-0000-000000000001'; -- First Year Chat
UPDATE chat_rooms SET year_group = 2 WHERE id = 'a1000000-0000-0000-0000-000000000002'; -- Second Year Chat
UPDATE chat_rooms SET year_group = 3 WHERE id = 'a1000000-0000-0000-0000-000000000003'; -- Third Year Chat
UPDATE chat_rooms SET year_group = 4 WHERE id = 'a1000000-0000-0000-0000-000000000004'; -- Fourth Year Chat

CREATE INDEX idx_chat_rooms_year_group ON chat_rooms(year_group);
