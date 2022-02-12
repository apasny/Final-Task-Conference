package com.epam.conference.entity;

import java.util.Objects;

public class User {

    public static final String TABLE = "user";

    private final long id;
    private final String name;
    private final String surname;
    private final String login;
    private final boolean isAdmin;

    public User(long id, String name, String surname, String login, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.isAdmin = isAdmin;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return id == user.id && isAdmin == user.isAdmin && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, login, isAdmin);
    }
}
