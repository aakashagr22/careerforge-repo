-- Create notifications table
CREATE TABLE notifications (
    id UUID PRIMARY KEY,
    student_id UUID NOT NULL,
    message TEXT NOT NULL,
    read_status BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_notifications_student FOREIGN KEY (student_id) REFERENCES student_profiles(id) ON DELETE CASCADE
);

-- Indexing for fast alert feeds queries
CREATE INDEX idx_notifications_student ON notifications(student_id);
CREATE INDEX idx_notifications_student_unread ON notifications(student_id, read_status);
