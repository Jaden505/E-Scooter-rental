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
public class ScootersRepositoryJpa extends AbstractEntityRepositoryJpa<Scooter> {
    public ScootersRepositoryJpa() {
        super(Scooter.class);
    }
}
