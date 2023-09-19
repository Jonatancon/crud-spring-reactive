package com.reactive.webflux.person.infraestructure.router;

import com.reactive.webflux.person.aplication.handler.PersonHandler;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PersonRouter {
    private static final String PATH = "person";

    @Bean
    public WebProperties.Resources resources() {
        return new WebProperties.Resources();
    }

    @Bean
    RouterFunction<ServerResponse> routerFunction(PersonHandler handler) {
        return RouterFunctions.route()
                .GET(PATH, handler::getAll)
                .GET(PATH + "/{id}", handler::get)
                .POST(PATH, handler::save)
                .PUT(PATH, handler::update)
                .DELETE(PATH + "/{id}", handler::delete)
                .build();
    }
}
