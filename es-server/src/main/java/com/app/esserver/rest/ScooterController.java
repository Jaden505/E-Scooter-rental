package com.app.esserver.rest;

import com.app.esserver.models.Scooter;
import com.app.esserver.repositories.ScooterRepositoryMock;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
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
        return scooterRepo.findById(id);
    }

//    @PostMapping("/")
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

        return scooter;
    }

    @DeleteMapping("/{id}")
    public Scooter deleteById(@PathVariable String id_json) throws JSONException {
        Long id = new JSONObject(id_json).getLong("_id");
        return scooterRepo.deleteById(id);
    }
}
