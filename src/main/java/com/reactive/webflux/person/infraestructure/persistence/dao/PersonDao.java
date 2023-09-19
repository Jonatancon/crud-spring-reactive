package com.reactive.webflux.person.infraestructure.persistence.dao;

import com.reactive.webflux.person.infraestructure.persistence.entity.PersonEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PersonDao extends ReactiveCrudRepository<PersonEntity, Integer> {
    Mono<Boolean> existsPersonEntityById (Integer id);
}
