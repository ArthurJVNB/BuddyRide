package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Interfaces.IUserController;

import java.util.Date;

public class UserController implements IUserController {

    // -------------------- SINGLETON ----------------------
    private UserController() {}

    private static class Singleton {
        static final UserController INSTANCE = new UserController();
    }

    public static UserController getInstance() {
        return Singleton.INSTANCE;
    }
    // ------------------------------------------------------

    @Override
    public User create(int id, String name, String surname, Date birthDate, String email, String profileName, String password) {
        User user = new User(id, name, surname, birthDate, email, profileName, password);
        return user;
    }

    @Override
    public int getId(User user) {
        return 0;
    }

    @Override
    public String getName(User user) {
        return null;
    }

    @Override
    public String getSurname(User user) {
        return null;
    }

    @Override
    public String getProfileName(User user) {
        return null;
    }

    @Override
    public String getEmail(User user) {
        return null;
    }

    @Override
    public Date getBirthDate(User user) {
        return null;
    }

    @Override
    public void setName(User user, String name) {

    }

    @Override
    public void setSurname(User user, String surname) {

    }

    @Override
    public void setProfileName(User user, String profileName) {

    }

    @Override
    public void setEmail(User user, String email) {

    }

    @Override
    public void setBirthDate(User user, Date birthDate) {

    }

    @Override
    public void setPassword(User user, String password) {

    }

    @Override
    public boolean checkPassword(User user, String password) {
        return false;
    }
}
