package com.faculdade.buddyride.Interfaces;

import java.util.List;

public interface IRepository<T> {
    void add(T t);
    void remove(String id);
    void update(T t);
    T search(String id);
    boolean exists(String id);
    List<T> list();
}