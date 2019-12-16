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
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public String getProfileName() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public Date getBirthDate() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setSurname(String surname) {

    }

    @Override
    public void setProfileName(String profileName) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setBirthDate(Date birthDate) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public boolean checkPassword(String password) {
        return false;
    }
}
