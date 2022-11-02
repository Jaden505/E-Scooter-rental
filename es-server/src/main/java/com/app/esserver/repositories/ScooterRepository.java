package com.app.esserver.repositories;

import com.app.esserver.models.Scooter;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScooterRepository {
    List<Scooter> findAll();

    Scooter findById(long id);

    Scooter save(Scooter scooter);

    Scooter deleteById(long id);
}