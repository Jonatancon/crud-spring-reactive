package com.reactive.webflux.person.domain.usecase;

import com.reactive.webflux.person.domain.inputport.InputPerson;
import com.reactive.webflux.person.domain.model.Person;
import com.reactive.webflux.person.domain.service.PersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonUseCase implements InputPerson {

    private final PersonService service;

    public PersonUseCase(PersonService service) {
        this.service = service;
    }

    @Override
    public Mono<Person> save(Person t) {
        return service.save(t);
    }

    @Override
    public Mono<Person> update(Person t) {
        return service.update(t);
    }

    @Override
    public Mono<Boolean> delete(Integer id) {
        return service.delete(id);
    }

    @Override
    public Mono<Person> get(Integer id) {
        return service.get(id);
    }

    @Override
    public Flux<Person> getAll() {
        return service.getAll();
    }
}
