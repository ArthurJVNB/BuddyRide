package com.faculdade.buddyride.Repositories;

import androidx.annotation.NonNull;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Exceptions.EnumRepositoryException;
import com.faculdade.buddyride.Exceptions.RepositoryException;
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
    public void add(User user) throws RepositoryException {
        try {
            // if search() find something, we can't add the new user
            search(user.getId());
        } catch (RepositoryException e) {
            // if search() throws an NOT_FOUND message, we can add the new user
            if (e.getMessage().equals(EnumRepositoryException.NOT_FOUND.toString())) {
                repository.add(user);
            }

        }
        throw new RepositoryException(EnumRepositoryException.USER_ALREADY_EXISTS);
    }

    @Override
    public void remove(int id) throws RepositoryException{
        try {
            repository.remove(search(id));
        } catch (RepositoryException e) {
            throw e;
        }
    }

    @Override
    public void update(User user) throws RepositoryException {
        for (User currentUser : repository) {
            if (currentUser.getId() == user.getId()) {
                int index = repository.indexOf(currentUser);
                repository.set(index, user);
                return;
            }
        }

        throw new RepositoryException(EnumRepositoryException.NOT_FOUND);
    }

    @NonNull
    @Override
    public User search(int id) throws RepositoryException {
        User result = null;

        for (User currentUser : repository) {
            if (currentUser.getId() == id) {
                result = currentUser;
                break;
            }
        }

        if (result == null) {
            throw new RepositoryException(EnumRepositoryException.NOT_FOUND);
        }

        return result;
    }
}
