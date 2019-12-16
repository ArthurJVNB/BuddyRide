package com.faculdade.buddyride.Interfaces;

import com.faculdade.buddyride.Entities.FavoriteAddress;
import com.faculdade.buddyride.Exceptions.FavoritesControllerException;

import java.util.List;

public interface IFavoritesController {
    void registerFavorite(FavoriteAddress favorite);
    void updateFavorite(FavoriteAddress favorite) throws FavoritesControllerException;
    void removeFavorite(FavoriteAddress favorite) throws FavoritesControllerException;
    List<FavoriteAddress> listUserFavorites(String userId) throws FavoritesControllerException;
}
