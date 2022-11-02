package com.app.esserver.rest;

import com.app.esserver.models.Scooter;
import com.app.esserver.repositories.ScooterRepositoryMock;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/scooters")
public class ScooterController {
    private ScooterRepositoryMock scooterRepo = new ScooterRepositoryMock();

    @GetMapping("/")
    public List<Scooter> findAll() {
        return scooterRepo.findAll();
    }

    @GetMapping("/{id}")
    public Scooter findById(@PathVariable long id) {
        return scooterRepo.findById(id);
    }

    @PostMapping("/")
    @PutMapping("/{id}")
    @ResponseBody
    public Scooter save(@RequestBody Scooter scooter) {
        return scooterRepo.save(scooter);
    } 

    @DeleteMapping("/{id}")
    public Scooter deleteById(@PathVariable long id) {
        return scooterRepo.deleteById(id);
    }
}
