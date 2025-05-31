-- 1. (Optional) Example: a ride that started but not yet ended
INSERT INTO rental.rentals (user_id, station_id, start_time, end_time)
VALUES
  (1, 2, NOW() - INTERVAL '15 minutes', NULL);