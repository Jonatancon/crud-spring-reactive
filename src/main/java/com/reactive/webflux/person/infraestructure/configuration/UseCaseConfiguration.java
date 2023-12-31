package com.reactive.webflux.person.infraestructure.configuration;

import com.reactive.webflux.person.domain.service.PersonService;
import com.reactive.webflux.person.domain.usecase.PersonUseCase;
import com.reactive.webflux.person.infraestructure.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration{

    @Bean
    public PersonUseCase getPersonUseCase(PersonService service, Message message) {
        return new PersonUseCase(service, message);
    }
}
