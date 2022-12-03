package com.app.esserver.repositories;

import com.app.esserver.models.Trip;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
@Primary
public class TripRepositoryJpa extends AbstractEntityRepositoryJpa<Trip> {
    public TripRepositoryJpa() {
        super(Trip.class);
    }
}
