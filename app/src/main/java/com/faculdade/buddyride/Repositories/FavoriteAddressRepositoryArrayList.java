package com.faculdade.buddyride.Repositories;

import com.faculdade.buddyride.Entities.FavoriteAddress;
import com.faculdade.buddyride.Interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAddressRepositoryArrayList implements IRepository<FavoriteAddress> {
    private ArrayList<FavoriteAddress> mRepository;

    private FavoriteAddressRepositoryArrayList() {
        mRepository = new ArrayList<>();
    }

    private static class Singleton {
        static final FavoriteAddressRepositoryArrayList INSTANCE = new FavoriteAddressRepositoryArrayList();
    }

    public static FavoriteAddressRepositoryArrayList getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public void add(FavoriteAddress favoriteAddress) {
        mRepository.add(favoriteAddress);
    }

    @Override
    public void remove(String id) {
        FavoriteAddress address = search(id);
        mRepository.remove(address);
    }

    @Override
    public void update(FavoriteAddress favoriteAddress) {
        for (FavoriteAddress address : mRepository) {
            if(address.getId().equals(favoriteAddress.getId())) {
                int index = mRepository.indexOf(address);
                mRepository.set(index, favoriteAddress);
            }
        }
    }

    @Override
    public FavoriteAddress search(String id) {
        FavoriteAddress result = null;

        for (FavoriteAddress address : mRepository) {
            if (address.getId().equals(id)) {
                result = address;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean exists(String id) {
        boolean result = false;

        if (search(id) != null) {
            result = true;
        }

        return result;
    }

    @Override
    public List<FavoriteAddress> list() {
        return mRepository;
    }
}
