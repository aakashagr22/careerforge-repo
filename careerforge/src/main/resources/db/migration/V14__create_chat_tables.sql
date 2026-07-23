-- =====================================================
-- V14: Create Chat Module Tables
-- =====================================================

-- 1. Chat Rooms
CREATE TABLE chat_rooms (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    room_type VARCHAR(30) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE INDEX idx_chat_rooms_room_type ON chat_rooms(room_type);
CREATE INDEX idx_chat_rooms_active ON chat_rooms(active);

-- 2. Chat Messages
CREATE TABLE chat_messages (
    id UUID PRIMARY KEY,
    chat_room_id UUID,
    conversation_id UUID,
    sender_id UUID NOT NULL,
    message TEXT NOT NULL,
    message_type VARCHAR(20) NOT NULL DEFAULT 'TEXT',
    edited BOOLEAN NOT NULL DEFAULT FALSE,
    edited_at TIMESTAMP WITHOUT TIME ZONE,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_chat_messages_sender FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_chat_messages_room FOREIGN KEY (chat_room_id) REFERENCES chat_rooms(id) ON DELETE CASCADE,
    CONSTRAINT chk_chat_messages_target CHECK (
        (chat_room_id IS NOT NULL AND conversation_id IS NULL) OR
        (chat_room_id IS NULL AND conversation_id IS NOT NULL)
    )
);

CREATE INDEX idx_chat_messages_room_id ON chat_messages(chat_room_id);
CREATE INDEX idx_chat_messages_conversation_id ON chat_messages(conversation_id);
CREATE INDEX idx_chat_messages_sender_id ON chat_messages(sender_id);
CREATE INDEX idx_chat_messages_created_at ON chat_messages(created_at);

-- 3. Private Conversations
CREATE TABLE private_conversations (
    id UUID PRIMARY KEY,
    user_one_id UUID NOT NULL,
    user_two_id UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_private_conversations_user_one FOREIGN KEY (user_one_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_private_conversations_user_two FOREIGN KEY (user_two_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT uq_private_conversations_pair UNIQUE (user_one_id, user_two_id)
);

-- Add FK from chat_messages.conversation_id to private_conversations
ALTER TABLE chat_messages
    ADD CONSTRAINT fk_chat_messages_conversation FOREIGN KEY (conversation_id)
    REFERENCES private_conversations(id) ON DELETE CASCADE;

CREATE INDEX idx_private_conversations_user_one ON private_conversations(user_one_id);
CREATE INDEX idx_private_conversations_user_two ON private_conversations(user_two_id);

-- 4. Room Members
CREATE TABLE room_members (
    id UUID PRIMARY KEY,
    chat_room_id UUID NOT NULL,
    user_id UUID NOT NULL,
    joined_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_room_members_room FOREIGN KEY (chat_room_id) REFERENCES chat_rooms(id) ON DELETE CASCADE,
    CONSTRAINT fk_room_members_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT uq_room_members_room_user UNIQUE (chat_room_id, user_id)
);

CREATE INDEX idx_room_members_room_id ON room_members(chat_room_id);
CREATE INDEX idx_room_members_user_id ON room_members(user_id);

-- 5. Muted Users
CREATE TABLE muted_users (
    id UUID PRIMARY KEY,
    chat_room_id UUID NOT NULL,
    user_id UUID NOT NULL,
    muted_by_id UUID NOT NULL,
    reason VARCHAR(500),
    muted_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    expires_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT fk_muted_users_room FOREIGN KEY (chat_room_id) REFERENCES chat_rooms(id) ON DELETE CASCADE,
    CONSTRAINT fk_muted_users_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_muted_users_muted_by FOREIGN KEY (muted_by_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT uq_muted_users_room_user UNIQUE (chat_room_id, user_id)
);

CREATE INDEX idx_muted_users_room_id ON muted_users(chat_room_id);
CREATE INDEX idx_muted_users_user_id ON muted_users(user_id);
