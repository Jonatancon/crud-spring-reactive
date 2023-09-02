package com.reactive.webflux.person.infraestructure.message;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Message {
    private final MessageSource messageSource;

    public Message(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getCreate() {
        return messageSource.getMessage("description.generic.create", null, Locale.getDefault());
    }

    public String getUpdate() {
        return messageSource.getMessage("description.generic.update", null, Locale.getDefault());
    }
    public String getSuccess() {
        return messageSource.getMessage("description.generic.success", null, Locale.getDefault());
    }
    public String getError() {
        return messageSource.getMessage("description.generic.error", null, Locale.getDefault());
    }
    public String getDelete() {
        return messageSource.getMessage("description.generic.delete", null, Locale.getDefault());
    }
}
