-- =====================================================
-- V15: Seed Default Chat Rooms
-- =====================================================

-- Year Chat Rooms
INSERT INTO chat_rooms (id, name, description, room_type, active, created_at, updated_at)
VALUES
    ('a1000000-0000-0000-0000-000000000001', 'First Year Chat',
     'Chat room for first year students (Semester 1-2)', 'YEAR_CHAT', TRUE, NOW(), NOW()),

    ('a1000000-0000-0000-0000-000000000002', 'Second Year Chat',
     'Chat room for second year students (Semester 3-4)', 'YEAR_CHAT', TRUE, NOW(), NOW()),

    ('a1000000-0000-0000-0000-000000000003', 'Third Year Chat',
     'Chat room for third year students (Semester 5-6)', 'YEAR_CHAT', TRUE, NOW(), NOW()),

    ('a1000000-0000-0000-0000-000000000004', 'Fourth Year Chat',
     'Chat room for fourth year students (Semester 7-8)', 'YEAR_CHAT', TRUE, NOW(), NOW());

-- General Chat Room
INSERT INTO chat_rooms (id, name, description, room_type, active, created_at, updated_at)
VALUES
    ('b1000000-0000-0000-0000-000000000001', 'General Chat',
     'Open chat room for all students and admins', 'GENERAL_CHAT', TRUE, NOW(), NOW());

-- Senior Chat Rooms
INSERT INTO chat_rooms (id, name, description, room_type, active, created_at, updated_at)
VALUES
    ('c1000000-0000-0000-0000-000000000001', 'Third Year Seniors',
     'Senior room - all students can ask doubts to third year seniors', 'SENIOR_CHAT', TRUE, NOW(), NOW()),

    ('c1000000-0000-0000-0000-000000000002', 'Fourth Year Seniors',
     'Senior room - all students can ask doubts to fourth year seniors', 'SENIOR_CHAT', TRUE, NOW(), NOW());
