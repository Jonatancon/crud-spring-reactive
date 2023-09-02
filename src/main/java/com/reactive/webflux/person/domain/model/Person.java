package com.reactive.webflux.person.domain.model;

public class Person {
    private Integer id;
    private String fullName;
    private boolean isUser;
    private String interesting;
    private String email;

    public Person() {
    }

    public Person(Integer id, String fullName, boolean isUser, String interesting, String email) {
        this.id = id;
        this.fullName = fullName;
        this.isUser = isUser;
        this.interesting = interesting;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public String getInteresting() {
        return interesting;
    }

    public void setInteresting(String interesting) {
        this.interesting = interesting;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
