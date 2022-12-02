package com.app.esserver.repositories;

public abstract class AbstractEntityRepositoryMock<E extends Identifable>
        implements EntityRepository<E> {

    private long latestId = 10000;
    private E[] entities;
}
