package com.app.esserver.repositories;

import com.app.esserver.models.Scooter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class AbstractEntityRepositoryJpa<E extends Identifable>
        implements EntityRepository<E> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<E> theEntityClass;

    public AbstractEntityRepositoryJpa(Class<E> entityClass) {
        this.theEntityClass = entityClass;
        System.out.println("Created" + this.getClass().getName() +
                "<" + this.theEntityClass.getSimpleName() + ">");
    }
}
