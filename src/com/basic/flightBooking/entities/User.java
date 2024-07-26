package com.basic.flightBooking.entities;

import java.util.Objects;

public class User {
    public static int sequenceId;

    private int id;
    private String name;
    private String surname;

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof User user))
            return false;

        return user.getName().equals(name) && user.getSurname().equals(surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

}
