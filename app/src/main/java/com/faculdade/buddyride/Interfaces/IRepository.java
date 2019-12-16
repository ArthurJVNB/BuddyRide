package com.faculdade.buddyride.Interfaces;

public interface IRepository<T> {
    void add(T t);
    void remove(String id);
    void update(T t);
    T search(String id);
    boolean exists(String id);
}