-- Create users table
CREATE TABLE users (
    id UUID PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- Create student_profiles table
CREATE TABLE student_profiles (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL UNIQUE,
    semester INTEGER,
    branch VARCHAR(100),
    section VARCHAR(20),
    college VARCHAR(150),
    enrollment_no VARCHAR(100) UNIQUE,
    preferred_language VARCHAR(20),
    target_role VARCHAR(50),
    communication_track_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    streak INTEGER NOT NULL DEFAULT 0,
    profile_image VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_student_profiles_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
