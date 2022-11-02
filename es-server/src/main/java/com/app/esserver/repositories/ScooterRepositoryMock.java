package com.app.esserver.repositories;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.esserver.models.Scooter;
import java.util.ArrayList;
import java.util.Random;
public class ScooterRepositoryMock implements ScooterRepository {
    ArrayList<Scooter> scooters = new ArrayList<>();

    public List<Scooter> findAll() {
        for (int i=3000; i< 3007; i++) {
            scooters.add(Scooter.creatSampleScooter(i));
        }

        return scooters;
    }

    public Scooter findById(long id) {
        return scooters.stream().filter(scooter -> scooter.getId() == id).findFirst().orElse(null);
    }

    public Scooter save(@RequestBody Scooter scooter) {
        // Generate id if not set
        if (scooter.getId() == 0) {
            scooter.setId(new Random().nextInt(99999));
        }

        Scooter scooter_found = findById(scooter.getId());

        if (scooter_found == null) {
            scooters.add(scooter);
        }
        else {
            scooters.set(scooters.indexOf(scooter_found), scooter);
        }

        return scooter;
    }

    public Scooter deleteById(long id) {
        Scooter scooter = findById(id);

        if (!scooter.equals(null)) {
            scooters.remove(scooter);
        }

        return scooter;
    }
}
