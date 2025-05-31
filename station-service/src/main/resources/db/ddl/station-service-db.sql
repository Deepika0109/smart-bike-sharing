-- File: station-service-db.sql

-- 1. Create a “stations” table to match com.example.station.model.Station
CREATE TABLE IF NOT EXISTS station.stations (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(150) NOT NULL,
    capacity   INTEGER         NOT NULL,
    available  INTEGER         NOT NULL
);