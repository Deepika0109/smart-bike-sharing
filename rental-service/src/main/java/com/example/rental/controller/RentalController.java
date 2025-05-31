package com.example.rental.controller;

import com.example.rental.model.Rental;
import com.example.rental.repo.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalRepository repo;

    @GetMapping
    public List<Rental> all() {
        return repo.findAll();
    }

    @PostMapping("/start")
    public Rental start(@RequestBody Map<String, Long> body) {
        Rental r = new Rental();
        r.setUserId(body.get("userId"));
        r.setStationId(body.get("stationId"));
        r.setStartTime(LocalDateTime.now());
        return repo.save(r);
    }

    @PostMapping("/stop/{id}")
    public Rental stop(@PathVariable Long id) {
        Rental r = repo.findById(id).orElseThrow();
        r.setEndTime(LocalDateTime.now());
        return repo.save(r);
    }
}