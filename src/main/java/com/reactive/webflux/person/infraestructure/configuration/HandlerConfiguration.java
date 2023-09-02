package com.reactive.webflux.person.infraestructure.configuration;

import com.reactive.webflux.person.aplication.handler.PersonHandler;
import com.reactive.webflux.person.domain.inputport.InputPerson;
import com.reactive.webflux.person.infraestructure.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfiguration {

    @Bean
    public PersonHandler getPersonHandler(InputPerson inputPerson, Message message) {
        return new PersonHandler(inputPerson, message);
    }
}
