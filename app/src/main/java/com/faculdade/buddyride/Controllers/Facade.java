package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Exceptions.UserControllerException;
import com.faculdade.buddyride.Interfaces.IRepository;
import com.faculdade.buddyride.Interfaces.IUserController;
import com.faculdade.buddyride.Repositories.UserRepositoryArrayList;

public class Facade {

    private IRepository<User> mUserRepository;
    private IUserController mUserController;

    // ---------------------- SINGLETON ----------------------
    private Facade() {
        mUserRepository = UserRepositoryArrayList.getInstance();
        mUserController = UserController.getInstance();
    }

    private static class Singleton {
        static final Facade INSTANCE = new Facade();
    }

    public static Facade getInstance() {
        return Singleton.INSTANCE;
    }
    // -------------------------------------------------------

    void registerUser(User user) throws UserControllerException {
        mUserController.registerUser(user);
    }

    void removeUser(String email, String password) throws UserControllerException {
        mUserController.removeUser(email, password);
    }

    void updateUser(User user) throws UserControllerException {
        mUserController.updateUser(user);
    }
}
