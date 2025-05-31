-- File: rental-service-db.sql

-- 1. Create “rentals” table to match com.example.rental.model.Rental
--    Note: We reference users.id and stations.id if you want referential integrity.
CREATE TABLE IF NOT EXISTS rental.rentals (
    id          BIGSERIAL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    station_id  BIGINT NOT NULL,
    start_time  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    end_time    TIMESTAMP WITHOUT TIME ZONE,

    CONSTRAINT fk_rental_user
        FOREIGN KEY (user_id) REFERENCES users.users(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_rental_station
        FOREIGN KEY (station_id) REFERENCES station.stations(id)
        ON DELETE SET NULL
);