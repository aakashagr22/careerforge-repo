-- Create chatbot_usage table for tracking daily quota and rate limits
CREATE TABLE chatbot_usage (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    usage_date DATE NOT NULL,
    query_count INTEGER NOT NULL DEFAULT 0,
    last_query_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_chatbot_usage_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT uq_chatbot_user_date UNIQUE (user_id, usage_date)
);

CREATE INDEX idx_chatbot_usage_lookup ON chatbot_usage(user_id, usage_date);
