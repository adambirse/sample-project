package com.birse.person;

import java.io.Serializable;

public class PersonResource implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    public PersonResource() {
    }

    public PersonResource(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person [id= " + id + ", firstName=" + this.firstName + ", lastName=" + this.lastName
                + "]";
    }
}