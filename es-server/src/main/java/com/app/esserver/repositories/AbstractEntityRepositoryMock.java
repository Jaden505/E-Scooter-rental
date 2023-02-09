package com.app.esserver.repositories;

import com.app.esserver.models.Scooter;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityRepositoryMock<E extends Identifable>
        implements EntityRepository<E> {
    private long latestId = 10000;
    private List<E> entities = new ArrayList<>();

    public List<E> findAll() {
        return entities;
    }

    public E findById(long id) {
        return entities.stream().filter(entity -> entity.getId() == id).findFirst().orElse(null);
    }

    public E save(@RequestBody E entity) {
        // Generate id if not set
        if (entity.getId() == 0) {
            entity.setId(latestId++);
            entities.add(entity);
        }
        else {
            E old_entity = entities.stream().filter(s -> s.getId() == (entity.getId())).findFirst().get();

            this.entities.set(entities.indexOf(old_entity), entity);
        }

        return entity;
    }

    public E deleteById(long id) {
        E entity = findById(id);

        if (!entity.equals(null)) {
            entities.remove(entity);
        }

        return entity;
    }
}
