package com.faculdade.buddyride.Interfaces;

import com.faculdade.buddyride.Entities.User;

import java.util.Date;

public interface IUserController {
    User create(int id, String name, String surname, Date birthDate, String email, String profileName, String password);
    int getId();
    String getName();
    String getSurname();
    String getProfileName();
    String getEmail();
    Date getBirthDate();
    void setName(String name);
    void setSurname(String surname);
    void setProfileName(String profileName);
    void setEmail(String email);
    void setBirthDate(Date birthDate);
    void setPassword(String password);
    boolean checkPassword(String password);
}
