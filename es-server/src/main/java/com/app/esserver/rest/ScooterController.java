package com.app.esserver.rest;

import com.app.esserver.exceptions.PreConditionFailed;
import com.app.esserver.exceptions.UserNotFoundException;
import com.app.esserver.models.Scooter;

import com.app.esserver.models.Trip;
import com.app.esserver.repositories.AbstractEntityRepositoryJpa;
import com.app.esserver.repositories.EntityRepository;
import com.app.esserver.repositories.ScootersRepositoryJpa;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/scooters")

public class ScooterController {
    @Autowired
    private EntityRepository<Scooter> scooterRepo;

    @GetMapping("/")
    public List<Scooter> findAll() {
        return scooterRepo.findAll();
    }

    @GetMapping("/{id}")
    public Scooter findById(@PathVariable long id) {
        Scooter found_scooter = scooterRepo.findById(id);

        if (found_scooter == null) {
            throw new UserNotFoundException("User " + id + " not found");
        }

        return found_scooter;
    }

    @PostMapping("/")
    @ResponseBody
    public Scooter saveScooter() {
        Scooter scooter = new Scooter(0);
        Scooter saveScooter = scooterRepo.save(scooter);

        return saveScooter;
    }

    @PutMapping("/")
    @ResponseBody
    public Scooter saveScooter(@RequestBody Scooter scooter) {
        System.out.println(scooter);
         return scooterRepo.save(scooter);
    }

    @DeleteMapping("/{id}")
    public Scooter deleteById(@PathVariable long id) {
        return scooterRepo.deleteById(id);
    }

    @GetMapping("/summary")
    public MappingJacksonValue getScootersSummary() {
        List<Scooter> scooters = scooterRepo.findAll();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "tag", "status");

        FilterProvider fp = new SimpleFilterProvider().addFilter("ScooterFilter", filter);
        MappingJacksonValue mjv = new MappingJacksonValue(scooters);

        mjv.setFilters(fp);
        return mjv;
    }
}
