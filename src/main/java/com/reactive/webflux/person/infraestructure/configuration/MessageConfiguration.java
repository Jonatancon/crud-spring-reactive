package com.reactive.webflux.person.infraestructure.configuration;

import com.reactive.webflux.person.infraestructure.message.Message;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

    @Bean
    public Message getMessage(MessageSource messageSource) {
        return new Message(messageSource);
    }
}
