-- Add email_verified to users table if not already present
ALTER TABLE users ADD COLUMN IF NOT EXISTS email_verified BOOLEAN NOT NULL DEFAULT FALSE;

-- Ensure all existing users and admins are marked as verified so they are not locked out
UPDATE users SET email_verified = TRUE;

-- Create otps table for email verification and password resets
CREATE TABLE IF NOT EXISTS otps (
    id UUID PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    otp_code VARCHAR(10) NOT NULL,
    otp_type VARCHAR(30) NOT NULL,
    expires_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    verified BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- Index for fast lookup by email and type
CREATE INDEX IF NOT EXISTS idx_otps_email_type ON otps (email, otp_type);
