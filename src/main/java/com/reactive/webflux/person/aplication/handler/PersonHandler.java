package com.reactive.webflux.person.aplication.handler;

import com.reactive.webflux.commons.GenericHandlers;
import com.reactive.webflux.person.aplication.dto.GenericResponse;
import com.reactive.webflux.person.domain.inputport.InputPerson;
import com.reactive.webflux.person.domain.model.Person;
import com.reactive.webflux.person.infraestructure.message.Message;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class PersonHandler implements GenericHandlers<Person> {
    private final InputPerson inputPerson;
    private final Message message;

    public PersonHandler(InputPerson inputPerson, Message message) {
        this.inputPerson = inputPerson;
        this.message = message;
    }


    @Override
    public Mono<GenericResponse<Person>> save(Person person) {
        return inputPerson.save(person).flatMap(updatePerson -> {
            GenericResponse<Person> response = GenericResponse.success();
            response.setData(Stream.of(updatePerson));
            response.setStatus(200);
            response.setDescription(message.getCreate());
            return Mono.just(response);
        });
    }

    @Override
    public Mono<GenericResponse<Person>> update(Person person) {
        return inputPerson.update(person).flatMap(updatePerson -> {
            GenericResponse<Person> response = GenericResponse.success();
            response.setData(Stream.of(updatePerson));
            response.setStatus(200);
            response.setDescription(message.getUpdate());
            return Mono.just(response);
        });
    }

    @Override
    public Mono<GenericResponse<Person>> delete(Integer id) {
        return inputPerson.delete(id).flatMap(delete -> {
            GenericResponse<Person> response = GenericResponse.success();
            if (delete) {
                response.setStatus(200);
                response.setDescription(message.getDelete());
                return Mono.just(response);
            }
            response.setStatus(400);
            response.setDescription(message.getError());
            return Mono.just(response);
        });

    }

    @Override
    public Mono<GenericResponse<Person>> get(Integer id) {
        return inputPerson.get(id).flatMap(person -> {
            GenericResponse<Person> genericResponse = GenericResponse.success();
            genericResponse.setStatus(200);
            genericResponse.setDescription(message.getSuccess());
            genericResponse.setData(Stream.of(person));

            return Mono.just(genericResponse);
        });
    }

    @Override
    public Mono<GenericResponse<Person>> getAll() {

        return inputPerson.getAll().collectList().flatMap(personList -> {
            GenericResponse<Person> genericResponse = GenericResponse.success();

            genericResponse.setData(personList.stream());
            genericResponse.setDescription(message.getSuccess());
            genericResponse.setStatus(200);

            return Mono.just(genericResponse);
        });
    }
}
