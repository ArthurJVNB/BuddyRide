package com.faculdade.buddyride.Repositories;

import com.faculdade.buddyride.Entities.FavoriteAddress;
import com.faculdade.buddyride.Interfaces.IRepository;

import java.util.ArrayList;

public class FavoriteAddressRepositoryArrayList implements IRepository<FavoriteAddress> {
    private ArrayList<FavoriteAddress> repository;

    private FavoriteAddressRepositoryArrayList() {
        repository = new ArrayList<>();
    }

    private static class Singleton {
        static final FavoriteAddressRepositoryArrayList INSTANCE = new FavoriteAddressRepositoryArrayList();
    }

    public static FavoriteAddressRepositoryArrayList getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public void add(FavoriteAddress favoriteAddress) {
        repository.add(favoriteAddress);
    }

    @Override
    public void remove(String id) {
        FavoriteAddress address = search(id);
        repository.remove(address);
    }

    @Override
    public void update(FavoriteAddress favoriteAddress) {
        for (FavoriteAddress address : repository) {
            if(address.getId().equals(favoriteAddress.getId())) {
                int index = repository.indexOf(address);
                repository.set(index, favoriteAddress);
            }
        }
    }

    @Override
    public FavoriteAddress search(String id) {
        FavoriteAddress result = null;

        for (FavoriteAddress address : repository) {
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
}
