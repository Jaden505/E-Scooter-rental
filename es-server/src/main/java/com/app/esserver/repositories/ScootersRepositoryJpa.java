package com.app.esserver.repositories;

import com.app.esserver.models.Scooter;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;



public class ScootersRepositoryJpa implements ScooterRepository{

    private EntityManager entityManager;
    @Override
    public List<Scooter> findAll() {
        TypedQuery<Scooter> namedQuery = entityManager.createNamedQuery("select_all", Scooter.class);
        List<Scooter> results = namedQuery.getResultList();
        return results;
    }

    @Override
    public Scooter findById(long id) {
        return entityManager.find(Scooter.class, id);
    }

    @Override
    public Scooter save(Scooter scooter) {
        return this.entityManager.merge(scooter);
    }

    @Override
    public Scooter deleteById(long id) {

        Scooter scooter = entityManager.find(Scooter.class, id);

        if (!scooter.equals(null)) {
            entityManager.remove(scooter);
        }
        return scooter;
    }
}
