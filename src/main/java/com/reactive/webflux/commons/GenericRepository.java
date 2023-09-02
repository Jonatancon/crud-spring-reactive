package com.reactive.webflux.commons;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericRepository<T>{
    Mono<T> save(T t);
    Mono<T> update(T t);
    Mono<Boolean> delete(Integer id);
    Mono<T> get(Integer id);
    Flux<T> getAll();
}
