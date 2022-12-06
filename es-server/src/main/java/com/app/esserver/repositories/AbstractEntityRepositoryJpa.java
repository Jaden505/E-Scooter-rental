package com.app.esserver.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    @Override
    public List<E> findAll() {
        TypedQuery<E> namedQuery = this.entityManager.createQuery("SELECT s FROM " + theEntityClass.getSimpleName() +" s", theEntityClass);
        List<E> results = namedQuery.getResultList();
        return results;
    }

    @Override
    public E findById(long id) {
        return entityManager.find(theEntityClass, id);
    }

    @Override
    public E save(E entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public E deleteById(long id) {
        E entity = entityManager.find(theEntityClass, id);

        if (!entity.equals(null)) {
            entityManager.remove(entity);
        }
        return entity;
    }

    @Override
    public List<E> findByQuery(String jpqlName, Object... params) {
        Query query = entityManager.createNamedQuery(jpqlName);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }

        return query.getResultList();
    }
}
