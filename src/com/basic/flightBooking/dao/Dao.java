package com.basic.flightBooking.dao;

import java.util.List;

public interface Dao<T> {
    T get(int id);
    List<T> getAll();
    void save(T t);
    T delete(int id);
}
