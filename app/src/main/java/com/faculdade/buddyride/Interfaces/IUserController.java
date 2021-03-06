package com.faculdade.buddyride.Interfaces;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Exceptions.UserControllerException;

public interface IUserController {
    void registerUser(User user) throws UserControllerException;
    void updateUser(User user) throws UserControllerException;
    void removeUser(String email, String password) throws UserControllerException;
    User getUser(String id);
    boolean exists(String id);
    boolean checkPassword(String id, String password) throws UserControllerException;
    boolean checkSecretAnswer(String id, String secretQuestion, String secretAnswer) throws UserControllerException;
    void setUserStatus(String id, User.Status status);
}
