package com.reactive.webflux.commons;

import com.reactive.webflux.person.aplication.dto.GenericResponse;
import reactor.core.publisher.Mono;

public interface GenericHandlers<T>{
    Mono<GenericResponse<T>> save(T t);
    Mono<GenericResponse<T>> update(T t);
    Mono<GenericResponse<T>> delete(Integer id);
    Mono<GenericResponse<T>> get(Integer id);
    Mono<GenericResponse<T>> getAll();
}
