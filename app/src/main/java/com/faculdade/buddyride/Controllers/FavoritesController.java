package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.FavoriteAddress;
import com.faculdade.buddyride.Exceptions.FavoritesControllerException;
import com.faculdade.buddyride.Interfaces.IFavoritesController;
import com.faculdade.buddyride.Repositories.FavoriteAddressRepositoryArrayList;

import java.util.ArrayList;
import java.util.List;

public class FavoritesController implements IFavoritesController {
    private FavoriteAddressRepositoryArrayList mRepository;

    // ---------------------- SINGLETON ----------------------
    private FavoritesController() {
        mRepository = FavoriteAddressRepositoryArrayList.getInstance();
    }

    private static class Singleton {
        static final FavoritesController INSTANCE = new FavoritesController();
    }

    // Protegido para apenas ser visto no pacote. Assim garante que apenas a Fachada o chame
    static FavoritesController getInstance() {
        return Singleton.INSTANCE;
    }
    // -------------------------------------------------------

    @Override
    public void registerFavorite(FavoriteAddress favorite) {
        // Aqui sera permitido salvar favoritos que sejam iguais
        mRepository.add(favorite);
    }

    @Override
    public void updateFavorite(FavoriteAddress favorite) throws FavoritesControllerException {
        if (mRepository.exists(favorite.getId())) {
            mRepository.update(favorite);
        } else {
            throw new FavoritesControllerException(FavoritesControllerException.EnumExceptionType.FAVORITE_NOT_FOUND);
        }
    }

    @Override
    public void removeFavorite(FavoriteAddress favorite) throws FavoritesControllerException {
        if (mRepository.exists(favorite.getId())) {
            mRepository.remove(favorite.getId());
        } else {
            throw new FavoritesControllerException(FavoritesControllerException.EnumExceptionType.FAVORITE_NOT_FOUND);
        }
    }

    @Override
    public List<FavoriteAddress> listUserFavorites(String userId) throws FavoritesControllerException {
        List<FavoriteAddress> result = new ArrayList<>();

        List<FavoriteAddress> favoriteList = mRepository.list();
        for (FavoriteAddress favorite : favoriteList) {
            if (favorite.getUserId().equals(userId)) {
                result.add(favorite);
            }
        }

        if (result.isEmpty()) {
            // Isso quer dizer que o usuario nao tinha nenhum favorito
            throw new FavoritesControllerException(FavoritesControllerException.EnumExceptionType.FAVORITE_NOT_FOUND);
        }

        return result;
    }
}
