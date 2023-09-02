package com.reactive.webflux.person.aplication.dto;

import java.util.stream.Stream;

public class GenericResponse<T> {
    private Integer status;
    private String description;
    private Stream<T> data;

    private GenericResponse() {
    }

    public static <T> GenericResponse<T> success() {
        return new GenericResponse<>();
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Stream<T> getData() {
        return data;
    }

    public void setData(Stream<T> data) {
        this.data = data;
    }
}
