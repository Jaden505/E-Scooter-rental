package com.app.esserver.rest;

import com.app.esserver.models.Scooter;
import com.app.esserver.models.Trip;
import com.app.esserver.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.esserver.exceptions.PreConditionFailed;

import java.time.LocalDateTime;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/scooters")
public class TripController {
    @Autowired
    private EntityRepository<Trip> tripRepo;

    @Autowired
    private EntityRepository<Scooter> scooterRepo;

    @GetMapping("/{scooterId}/trips")
    public Set<Trip> getTripsOfScooter(@PathVariable long scooterId, @RequestParam(required = false) String from, @RequestParam(required = false) String to) {
        Scooter scooter = scooterRepo.findById(scooterId);

        if (scooter == null) return null;

        else if (from != null && to != null)
            return tripRepo.findByQuery("select_all_trips", scooterId).stream().collect(Collectors.toSet());

        return tripRepo.findByQuery("Trip_find_by_scooterId_and_period", scooterId, from, to).stream().collect(Collectors.toSet());
    }

    @PostMapping("/{scooterId}/trips")
    public Trip addTripToScooter(@RequestBody Trip trip, @PathVariable long scooterId) {
        Scooter scooter = scooterRepo.findById(scooterId);

        if (scooter == null) return null;
        if (trip.getStartDate() == null) trip.setStartDate(LocalDateTime.now());
        if (scooter.getBatteryCharge() < 10 || scooter.getStatus() != "IDLE") {
            String error_message = "Scooter with status " + scooter.getStatus() + " and battery charge " +
                    Integer.toString(scooter.getBatteryCharge()) + "% cannot be claimed for another trip";

            throw new PreConditionFailed(error_message);
        }

        trip.setScooter(scooter);
        Trip savedTrip = tripRepo.save(trip);

        scooter.addTrip(tripRepo.findById(savedTrip.getId()));
        scooter.setCurrentTripId(savedTrip.getId());
        scooterRepo.save(scooter);

        return trip;
    }
}
