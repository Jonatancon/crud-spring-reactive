package com.reactive.webflux.person.domain.usecase;

import com.reactive.webflux.person.aplication.dto.error.CustomException;
import com.reactive.webflux.person.domain.inputport.InputPerson;
import com.reactive.webflux.person.domain.model.Person;
import com.reactive.webflux.person.domain.service.PersonService;
import com.reactive.webflux.person.infraestructure.message.Message;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonUseCase implements InputPerson {

    private final PersonService service;
    private final Message message;

    public PersonUseCase(PersonService service, Message message) {
        this.service = service;
        this.message = message;
    }

    @Override
    public Mono<Person> save(Person t) {
        return service.exitsPersonById(t.getId()).flatMap(e ->
                e?Mono.error(new CustomException(HttpStatus.CONFLICT, message.getConflict())):
                        service.save(t)
                );
    }

    @Override
    public Mono<Person> update(Person t) {
        return service.exitsPersonById(t.getId())
                .flatMap(response -> response?service.update(t):
                        Mono.error(new CustomException(HttpStatus.NOT_FOUND, message.getNotFound()))
                );
    }

    @Override
    public Mono<Boolean> delete(Integer id) {
        return service.exitsPersonById(id)
                .flatMap(response -> response?service.delete(id):
                                Mono.error(new CustomException(HttpStatus.NOT_FOUND, message.getNotFound()))
                        );
    }

    @Override
    public Mono<Person> get(Integer id) {
        return service.get(id)
                .switchIfEmpty(Mono.error(
                        new CustomException(HttpStatus.NOT_FOUND, message.getNotFound()))
                );
    }

    @Override
    public Flux<Person> getAll() {
        return service.getAll();
    }
}
