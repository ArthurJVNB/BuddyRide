package com.faculdade.buddyride.Repositories;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryArrayList implements IRepository<User> {

    private ArrayList<User> mRepository;

    // ---------------------- SINGLETON ----------------------
    private UserRepositoryArrayList() {
        mRepository = new ArrayList<>();
    }

    private static class Singleton {
        private static final UserRepositoryArrayList INSTANCE = new UserRepositoryArrayList();
    }

    public static UserRepositoryArrayList getInstance() {
        return Singleton.INSTANCE;
    }
    // -------------------------------------------------------

    @Override
    public void add(User user) {
        mRepository.add(user);
    }

    @Override
    public void remove(String id) {
        mRepository.remove(search(id));
    }

    @Override
    public void update(User user) {
        for (User currentUser : mRepository) {
            if (currentUser.getId().equals(user.getId())) {
                int index = mRepository.indexOf(currentUser);
                mRepository.set(index, user);
                break;
            }
        }
    }

    @Override
    public User search(String id) {
        User result = null;

        for (User currentUser : mRepository) {
            if (currentUser.getId().equals(id)) {
                result = currentUser;
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
    public List<User> list() {
        return mRepository;
    }
}
