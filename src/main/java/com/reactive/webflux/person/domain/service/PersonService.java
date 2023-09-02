package com.reactive.webflux.person.domain.service;

import com.reactive.webflux.commons.GenericRepository;
import com.reactive.webflux.commons.GenerictSeriveImpl;
import com.reactive.webflux.person.domain.model.Person;
import com.reactive.webflux.person.domain.outputport.OutPutPersonRepository;

public class PersonService extends GenerictSeriveImpl<Person> {
    private final OutPutPersonRepository repository;

    public PersonService(OutPutPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Person> getRepository() {
        return this.repository;
    }
}
