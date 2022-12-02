package com.app.esserver.repositories;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EntityRepository<E extends Identifable> {
    List<E> findAll();

    E findById(long id);

    E save(E entity);

    E deleteById(long id);
}