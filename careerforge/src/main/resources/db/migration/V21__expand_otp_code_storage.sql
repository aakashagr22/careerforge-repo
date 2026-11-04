-- OTP values are stored as password hashes rather than plaintext six-digit codes.
ALTER TABLE otps ALTER COLUMN otp_code TYPE VARCHAR(100);
