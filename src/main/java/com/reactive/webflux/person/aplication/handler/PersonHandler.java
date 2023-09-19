package com.reactive.webflux.person.aplication.handler;

import com.reactive.webflux.commons.GenericHandlers;
import com.reactive.webflux.person.aplication.dto.GenericResponse;
import com.reactive.webflux.person.domain.inputport.InputPerson;
import com.reactive.webflux.person.domain.model.Person;
import com.reactive.webflux.person.infraestructure.message.Message;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class PersonHandler implements GenericHandlers {
    private final InputPerson inputPerson;
    private final Message message;

    public PersonHandler(InputPerson inputPerson, Message message) {
        this.inputPerson = inputPerson;
        this.message = message;
    }


    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<GenericResponse<Person>> responseMono = request.bodyToMono(Person.class)
                .flatMap(person -> inputPerson.save(person)
                        .flatMap(savePerson -> {
                            GenericResponse<Person> response = GenericResponse.success();
                            response.setData(Stream.of(savePerson));
                            response.setDescription(message.getCreate());
                            response.setStatus(201);
                            return Mono.just(response);
                        })
                );

        return ServerResponse.status(201)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMono, GenericResponse.class);
    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<GenericResponse<Person>> responseMono = request.bodyToMono(Person.class)
                .flatMap(person -> inputPerson.update(person)
                        .flatMap(updatePerson -> {
                            GenericResponse<Person> response = GenericResponse.success();
                            response.setData(Stream.of(updatePerson));
                            response.setDescription(message.getUpdate());
                            response.setStatus(200);
                            return Mono.just(response);
                        })
                );

        return ServerResponse.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMono, GenericResponse.class);
    }

    @Override
    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));

        Mono<GenericResponse<Person>> responseMono = inputPerson.delete(id).flatMap(delete -> {
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


        return responseMono.flatMap(respons -> ServerResponse
                .status(respons.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(respons), GenericResponse.class)
        );
    }

    @Override
    public Mono<ServerResponse> get(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));

        Mono<GenericResponse<Person>> responseMono = inputPerson.get(id).flatMap(person -> {
            GenericResponse<Person> response = GenericResponse.success();
            response.setStatus(200);
            response.setDescription(message.getSuccess());
            response.setData(Stream.of(person));
            return Mono.just(response);
        });

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMono, GenericResponse.class);

    }

    @Override
    public Mono<ServerResponse> getAll(ServerRequest request) {

        Mono<GenericResponse<Person>> responseMono = inputPerson.getAll().collectList().flatMap(persons -> {
            GenericResponse<Person> response = GenericResponse.success();
            response.setStatus(200);
            response.setDescription(message.getSuccess());
            response.setData(persons.stream());
            return Mono.just(response);
        });

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseMono, GenericResponse.class);
    }
}
