package com.faculdade.buddyride.Entities;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String lastname;
    private Date birthDate;
    private String email;
    private String profileName;
    private String password;

    public User(int id, String name, String lastname, Date birthDate, String email, String profileName, String password) {
        setId(id);
        setName(name);
        setLastname(lastname);
        setBirthDate(birthDate);
        setEmail(email);
        setProfileName(profileName);
        setPassword(password);
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
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
