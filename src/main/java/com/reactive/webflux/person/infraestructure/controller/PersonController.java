package com.reactive.webflux.person.infraestructure.controller;

import com.reactive.webflux.person.aplication.dto.GenericResponse;
import com.reactive.webflux.person.aplication.handler.PersonHandler;
import com.reactive.webflux.person.domain.model.Person;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonHandler handler;

    public PersonController(PersonHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<GenericResponse<Person>>> getPerson(@PathVariable Integer id) {
        Mono<GenericResponse<Person>> response = handler.get(id);

        return response.flatMap(object ->
                Mono.just(
                        new ResponseEntity<>(object, HttpStatusCode.valueOf(object.getStatus()))
                )
        );
    }

    @GetMapping()
    public Mono<ResponseEntity<GenericResponse<Person>>> getAllPerson() {
        Mono<GenericResponse<Person>> response = handler.getAll();

        return response.flatMap(object ->
                Mono.just(
                        new ResponseEntity<>(object, HttpStatusCode.valueOf(object.getStatus()))
                )
        );
    }


}
