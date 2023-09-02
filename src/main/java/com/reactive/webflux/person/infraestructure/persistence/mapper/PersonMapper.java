package com.reactive.webflux.person.infraestructure.persistence.mapper;

import com.reactive.webflux.person.domain.model.Person;
import com.reactive.webflux.person.infraestructure.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person personEntityToPerson(PersonEntity entity);

    PersonEntity personToPersonEntity(Person person);

}
