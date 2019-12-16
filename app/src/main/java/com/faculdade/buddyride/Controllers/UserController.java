package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Exceptions.UserControllerException;
import com.faculdade.buddyride.Interfaces.IRepository;
import com.faculdade.buddyride.Interfaces.IUserController;
import com.faculdade.buddyride.Repositories.UserRepositoryArrayList;

public class UserController implements IUserController {

    private IRepository<User> mUserRepository;

    // ---------------------- SINGLETON ----------------------
    private UserController() {
        mUserRepository = UserRepositoryArrayList.getInstance();
    }

    private static class Singleton {
        static final UserController INSTANCE = new UserController();
    }

    // Protegido para apenas o pacote ler. Isso garante que apenas o Facade irah chama-lo
    static UserController getInstance() {
        return Singleton.INSTANCE;
    }
    // -------------------------------------------------------

    @Override
    public void registerUser(User user) throws UserControllerException {
        if (mUserRepository.exists(user.getEmail())) {
            throw new UserControllerException(UserControllerException.EnumExceptionType.USER_ALREADY_EXISTS);
        }
    }

    @Override
    public void updateUser(User user) throws UserControllerException {
        if (mUserRepository.exists(user.getEmail())) {
            mUserRepository.update(user);
        } else {
            throw new UserControllerException(UserControllerException.EnumExceptionType.USER_NOT_FOUND);
        }
    }

    @Override
    public void removeUser(String email, String password) throws UserControllerException {
        if(!mUserRepository.exists(email)) {
            throw new UserControllerException(UserControllerException.EnumExceptionType.USER_NOT_FOUND);
        }

        User user = mUserRepository.search(email);
        if(user.checkPassword(password)) {
            throw new UserControllerException(UserControllerException.EnumExceptionType.INVALID_PASSWORD);
        }

        mUserRepository.remove(email);
    }
}
