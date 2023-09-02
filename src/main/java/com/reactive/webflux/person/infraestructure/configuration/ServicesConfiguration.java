package com.reactive.webflux.person.infraestructure.configuration;

import com.reactive.webflux.person.domain.outputport.OutPutPersonRepository;
import com.reactive.webflux.person.domain.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Bean
    public PersonService getServicePerson(OutPutPersonRepository repository) {
        return new PersonService(repository);
    }
}
