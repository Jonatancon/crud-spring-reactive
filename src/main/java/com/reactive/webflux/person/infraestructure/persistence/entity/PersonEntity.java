package com.reactive.webflux.person.infraestructure.persistence.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("person")
public class PersonEntity implements Serializable {

    @Id
    private Integer id;
    @Column("fullName")
    private String fullName;
    @Column("isUser")
    private boolean isUser;
    private String interesting;
    private String email;

    public PersonEntity(Integer id, String fullName, boolean isUser, String interesting, String email) {
        this.id = id;
        this.fullName = fullName;
        this.isUser = isUser;
        this.interesting = interesting;
        this.email = email;
    }

    public PersonEntity() {
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
