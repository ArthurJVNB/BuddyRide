package com.faculdade.buddyride.Interfaces;

import com.faculdade.buddyride.Entities.User;

import java.util.Date;

public interface IUserController {
    User create(int id, String name, String surname, Date birthDate, String email, String profileName, String password);
    int getId(User user);
    String getName(User user);
    String getSurname(User user);
    String getProfileName(User user);
    String getEmail(User user);
    Date getBirthDate(User user);
    void setName(User user, String name);
    void setSurname(User user, String surname);
    void setProfileName(User user, String profileName);
    void setEmail(User user, String email);
    void setBirthDate(User user, Date birthDate);
    void setPassword(User user, String password);
    boolean checkPassword(User user, String password);
}
