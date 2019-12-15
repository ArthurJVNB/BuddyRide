package com.faculdade.buddyride.Interfaces;

import com.faculdade.buddyride.Exceptions.RepositoryException;

public interface IRepository<T> {
    void add(T t) throws RepositoryException;
    void remove(int id) throws RepositoryException;
    void update(T t) throws RepositoryException;
    T search(int id) throws RepositoryException;
}