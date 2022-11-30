package com.app.esserver.rest;

import com.app.esserver.exceptions.PreConditionFailed;
import com.app.esserver.exceptions.UserNotFoundException;
import com.app.esserver.models.Scooter;
import com.app.esserver.repositories.ScooterRepositoryMock;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
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
    private ScooterRepositoryMock scooterRepo = new ScooterRepositoryMock();


    @GetMapping("/")
    public List<Scooter> findAll() {
        return scooterRepo.findAll();
    }

    @GetMapping("/{id}")
    public Scooter findById(@PathVariable long id) {
        Scooter scooter = scooterRepo.findById(id);
        if (scooter == null) {
            throw new UserNotFoundException("User " + id + " not found");
        }
        return scooterRepo.findById(id);
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
    public Scooter saveScooter(@RequestBody String scooter_json) throws JSONException {
        Scooter scooter = new Scooter();

        JSONObject scooter_details = new JSONObject(scooter_json).getJSONObject("scooter");
        scooter.setId(scooter_details.getLong("_id"));
        scooter.setTag(scooter_details.getString("_tag"));
        scooter.setStatus(scooter_details.getString("_status"));
        scooter.setGpsLocation(scooter_details.getString("_gpsLocation"));
        scooter.setMileage(scooter_details.getInt("_mileage"));
        scooter.setBatteryCharge(scooter_details.getInt("_batteryCharge"));

        Scooter saveScooter = scooterRepo.save(scooter);

        return saveScooter;
    }

    @DeleteMapping("/{id}")
    public Scooter deleteById(@PathVariable String id) {
        return scooterRepo.deleteById(Long.parseLong(id));
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
