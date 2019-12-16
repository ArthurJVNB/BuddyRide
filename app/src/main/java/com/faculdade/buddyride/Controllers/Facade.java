package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.FavoriteAddress;
import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Exceptions.FavoritesControllerException;
import com.faculdade.buddyride.Exceptions.UserControllerException;
import com.faculdade.buddyride.Interfaces.IFavoritesController;
import com.faculdade.buddyride.Interfaces.IRepository;
import com.faculdade.buddyride.Interfaces.IUserController;
import com.faculdade.buddyride.Repositories.UserRepositoryArrayList;

import java.util.List;

public class Facade {

    private IUserController mUserController;
    private IFavoritesController mFavoritesController;

    // ---------------------- SINGLETON ----------------------
    private Facade() {
        mUserController = UserController.getInstance();
        mFavoritesController = FavoritesController.getInstance();
    }

    private static class Singleton {
        static final Facade INSTANCE = new Facade();
    }

    public static Facade getInstance() {
        return Singleton.INSTANCE;
    }
    // -------------------------------------------------------

    // CONTROLLER: IUserController
    public void registerUser(User user) throws UserControllerException {
        mUserController.registerUser(user);
    }

    public void removeUser(String email, String password) throws UserControllerException {
        mUserController.removeUser(email, password);
    }

    public void updateUser(User user) throws UserControllerException {
        mUserController.updateUser(user);
    }

    public boolean checkUserPassword(String userId, String password) throws UserControllerException {
        return mUserController.checkPassword(userId, password);
    }

    // CONTROLLER: IFavoritesController
    public void registerFavoriteAddress(FavoriteAddress favorite) throws FavoritesControllerException {
        if (mUserController.exists(favorite.getUserId())) {
            mFavoritesController.registerFavorite(favorite);
        } else {
            throw new FavoritesControllerException(FavoritesControllerException.EnumExceptionType.INVALID_USER);
        }
    }

    public void removeFavoriteAddress(FavoriteAddress favorite) throws FavoritesControllerException {
        mFavoritesController.removeFavorite(favorite);
    }

    public void updateFavoriteAddress (FavoriteAddress favorite) throws FavoritesControllerException {
        mFavoritesController.updateFavorite(favorite);
    }

    public List<FavoriteAddress> listUserFavoriteAddresses (String userId) throws FavoritesControllerException {
        return mFavoritesController.listUserFavorites(userId);
    }
}
