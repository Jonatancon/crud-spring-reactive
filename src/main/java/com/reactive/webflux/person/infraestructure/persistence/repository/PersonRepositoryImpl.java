package com.reactive.webflux.person.infraestructure.persistence.repository;

import com.reactive.webflux.person.domain.model.Person;
import com.reactive.webflux.person.domain.outputport.OutPutPersonRepository;
import com.reactive.webflux.person.infraestructure.persistence.dao.PersonDao;
import com.reactive.webflux.person.infraestructure.persistence.mapper.PersonMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonRepositoryImpl implements OutPutPersonRepository {
    private final PersonMapper mapper;
    private final PersonDao dao;

    public PersonRepositoryImpl(PersonMapper mapper, PersonDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }

    @Override
    public Mono<Person> save(Person t) {
        return dao.save(mapper.personToPersonEntity(t))
                .map(mapper::personEntityToPerson);
    }

    @Override
    public Mono<Person> update(Person t) {
        return dao.save(mapper.personToPersonEntity(t))
                .map(mapper::personEntityToPerson);
    }

    @Override
    public Mono<Boolean> delete(Integer id) {
        return dao.deleteById(id)
                .then(Mono.just(true))
                .onErrorReturn(false);
    }

    @Override
    public Mono<Person> get(Integer id) {
        return dao.findById(id)
                .map(mapper::personEntityToPerson);
    }

    @Override
    public Flux<Person> getAll() {
        return dao.findAll().map(mapper::personEntityToPerson);
    }

    @Override
    public Mono<Boolean> exitsPerson(Integer id) {
        return dao.existsPersonEntityById(id);
    }
}
