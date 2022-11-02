package com.app.esserver.repositories;

import java.util.List;
import com.app.esserver.models.Scooter;
import java.util.ArrayList;

public class ScooterRepositoryMock implements ScooterRepository {
    public List<Scooter> findAll() {
        ArrayList<Scooter> scootersSamples = new ArrayList<>();

        for (int i=3000; i< 3007; i++) {
            scootersSamples.add(Scooter.creatSampleScooter(i));
        }

        return scootersSamples;
    }
}
