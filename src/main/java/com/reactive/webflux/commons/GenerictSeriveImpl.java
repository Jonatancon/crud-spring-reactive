package com.reactive.webflux.commons;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class GenerictSeriveImpl<T> implements GenericService<T> {
    protected abstract GenericRepository<T> getRepository();

    public Mono<T> save(T t) {
        return getRepository().save(t);
    }
    public Mono<T> update(T t) {
        return getRepository().update(t);
    }
    public Mono<Boolean> delete(Integer id){
        return getRepository().delete(id);
    }
    public Mono<T> get(Integer id) {
        return getRepository().get(id);
    }
    public Flux<T> getAll() {
        return getRepository().getAll();
    }

}
