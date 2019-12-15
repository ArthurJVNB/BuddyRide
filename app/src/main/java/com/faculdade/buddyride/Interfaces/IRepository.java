package com.faculdade.buddyride.Interfaces;

public interface IRepository<T> {
    void add(T t);
    void remove(int id);
    void update(T t);
    T search(int id);
    boolean exists(int id);
}