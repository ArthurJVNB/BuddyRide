package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Exceptions.UserControllerException;
import com.faculdade.buddyride.Interfaces.IRepository;
import com.faculdade.buddyride.Interfaces.IUserController;
import com.faculdade.buddyride.Repositories.UserRepositoryArrayList;

class UserController implements IUserController {

    private IRepository<User> mRepository;

    // ---------------------- SINGLETON ----------------------
    private UserController() {
        mRepository = UserRepositoryArrayList.getInstance();
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
        if (mRepository.exists(user.getEmail())) {
            throw new UserControllerException(UserControllerException.EnumExceptionType.USER_ALREADY_EXISTS);
        } else {
            mRepository.add(user);
        }
    }

    @Override
    public void updateUser(User user) throws UserControllerException {
        if (mRepository.exists(user.getEmail())) {
            mRepository.update(user);
        } else {
            throw new UserControllerException(UserControllerException.EnumExceptionType.USER_NOT_FOUND);
        }
    }

    @Override
    public void removeUser(String email, String password) throws UserControllerException {
        if(!mRepository.exists(email)) {
            throw new UserControllerException(UserControllerException.EnumExceptionType.USER_NOT_FOUND);
        }

        User user = mRepository.search(email);
        if(user.checkPassword(password)) {
            throw new UserControllerException(UserControllerException.EnumExceptionType.INVALID_PASSWORD);
        }

        mRepository.remove(email);
    }

    @Override
    public boolean exists(String id) {
        return mRepository.exists(id);
    }

    @Override
    public boolean checkPassword(String id, String password) throws UserControllerException {
        boolean result;

        if (mRepository.exists(id)) {
            User user = mRepository.search(id);
            result = user.checkPassword(password);
        } else {
            throw new UserControllerException(UserControllerException.EnumExceptionType.USER_NOT_FOUND);
        }

        return result;
    }

    @Override
    public void setUserStatus(String id, User.Status status) {
        User user = mRepository.search(id);
        user.setStatus(status);
    }
}
