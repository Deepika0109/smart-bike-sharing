package com.example.station.controller;

import com.example.station.model.Station;
import com.example.station.repo.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired private StationRepository repo;

    @GetMapping
    public List<Station> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Station one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Station create(@RequestBody Station s) {
        return repo.save(s);
    }

    @PutMapping("/{id}")
    public Station update(@PathVariable Long id, @RequestBody Station s) {
        Station existing = repo.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setCapacity(s.getCapacity());
        existing.setAvailable(s.getAvailable());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}