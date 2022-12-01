package com.app.esserver.repositories;

import com.app.esserver.models.Scooter;
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
public class ScootersRepositoryJpa implements ScooterRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Scooter> findAll() {
        TypedQuery<Scooter> namedQuery = this.entityManager.createQuery("SELECT s FROM Scooter s", Scooter.class);
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
