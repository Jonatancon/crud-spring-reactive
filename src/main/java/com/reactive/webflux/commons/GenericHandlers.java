package com.reactive.webflux.commons;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface GenericHandlers{
    Mono<ServerResponse> save(ServerRequest request);
    Mono<ServerResponse> update(ServerRequest request);
    Mono<ServerResponse> delete(ServerRequest request);
    Mono<ServerResponse> get(ServerRequest request);
    Mono<ServerResponse> getAll(ServerRequest request);
}
