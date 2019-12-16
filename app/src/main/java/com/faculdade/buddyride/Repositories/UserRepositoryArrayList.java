package com.faculdade.buddyride.Repositories;

import androidx.annotation.NonNull;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Interfaces.IRepository;

import java.util.ArrayList;

public class UserRepositoryArrayList implements IRepository<User> {

    private ArrayList<User> repository;

    private UserRepositoryArrayList() {
        repository = new ArrayList<>();
    }

    private static class Singleton {
        private static final UserRepositoryArrayList INSTANCE = new UserRepositoryArrayList();
    }

    public static UserRepositoryArrayList getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public void add(User user) {
        repository.add(user);
    }

    @Override
    public void remove(int id) {
        repository.remove(search(id));
    }

    @Override
    public void update(User user) {
        for (User currentUser : repository) {
            if (currentUser.getId() == user.getId()) {
                int index = repository.indexOf(currentUser);
                repository.set(index, user);
                break;
            }
        }
    }

    @NonNull
    @Override
    public User search(int id) {
        User result = null;

        for (User currentUser : repository) {
            if (currentUser.getId() == id) {
                result = currentUser;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean exists(int id) {
        boolean result = false;

        if (search(id) != null) {
            result = true;
        }

        return false;
    }
}
