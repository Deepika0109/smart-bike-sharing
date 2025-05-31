-- 1. (Optional) Insert a test user
INSERT INTO users.users (username, password, role)
VALUES
  -- password must be BCrypt-encoded if you’re using Spring Security
  ('testuser', '$2a$10$YqstVC5wXJp1mfAOEDBfjOf053sKxVJL6Gg3YaZxP9t6TuLetKR6K', 'ROLE_USER');