-- File: user-service-db.sql

-- 1. Create a “users” table to match com.example.user.model.User
CREATE TABLE IF NOT EXISTS users.users (
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    role       VARCHAR(50)  NOT NULL
);