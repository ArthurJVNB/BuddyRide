package com.faculdade.buddyride.Entities;

import java.util.Date;

public class User {
    private String name;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;

    public User(String name, String lastName, Date birthDate, String email, String password) {
        setName(name);
        setLastName(lastName);
        setBirthDate(birthDate);
        setEmail(email);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
