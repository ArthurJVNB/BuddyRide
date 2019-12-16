package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Enums.EnumControllerException;
import com.faculdade.buddyride.Exceptions.ControllerException;
import com.faculdade.buddyride.Interfaces.IRepository;
import com.faculdade.buddyride.Interfaces.IUserController;
import com.faculdade.buddyride.Repositories.UserRepositoryArrayList;

import java.util.Date;

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

    public void createNewUser(String name, String surname, Date birthDate, String email, String profileName, String password) {
        int id = 0;
        do {
            id = (int) (Math.random() * Integer.MAX_VALUE);
        } while (mUserRepository.exists(id));

        User user = mUserController.create(id, name, surname, birthDate, email, profileName, password);
        mUserRepository.add(user);
    }

    public User getUser(int id) throws ControllerException {
        User result = mUserRepository.search(id);

        if (result == null) {
            throw new ControllerException(EnumControllerException.USER_NOT_FOUND);
        }

        return result;
    }

    // TODO talvez tirar esse aqui, pois creio que deveria trocar uma coisa por vez
    public void updateUser(User user, String password) throws ControllerException {
        if (user.checkPassword(password)) {
            mUserRepository.update(user);
        } else {
            throw new ControllerException(EnumControllerException.INVALID_PASSWORD);
        }
    }

    // TODO vou fazer aqui no padrão builder, onde possui a flexibilidade de fazer o update de quantas coisas a UI quiser
    public class UpdateUser {
        // ---------- Very simple SINGLETON ------------
        private UpdateUser instance = new UpdateUser();
        private UpdateUser() {}
        // ---------------------------------------------

        public UpdateUser changePassword(User user, String oldPassword, String newPassword) throws ControllerException {
            if(user.checkPassword(oldPassword)) {
                mUserController.setPassword(user, newPassword);
            } else {
                throw new ControllerException(EnumControllerException.INVALID_PASSWORD);
            }

            return this;
        }

        public UpdateUser setProfileName(User user, String name) {
            mUserController.setProfileName(user, name);
            return this;
        }

        public UpdateUser setBirthDate(User user, Date birthDate) {
            mUserController.setBirthDate(user, birthDate);
            return this;
        }
    }

    public void removeUser(int id, String password) throws ControllerException {
        User user = mUserRepository.search(id);

        if (user == null) {
            throw new ControllerException(EnumControllerException.USER_NOT_FOUND);
        }

        if (user.checkPassword(password)) {
            mUserRepository.remove(id);
        } else {
            throw new ControllerException(EnumControllerException.INVALID_PASSWORD);
        }
    }
}
