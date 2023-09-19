package com.reactive.webflux.person.domain.outputport;

import com.reactive.webflux.commons.GenericRepository;
import com.reactive.webflux.person.domain.model.Person;
import reactor.core.publisher.Mono;

public interface OutPutPersonRepository extends GenericRepository<Person> {
    Mono<Boolean> exitsPerson(Integer id);
}
