package com.basic.flightBooking.dao;

import com.basic.flightBooking.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements Dao<User> {
    private Map<Integer, User> users = new HashMap<>();

    @Override
    public User get(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return users.values().stream().toList();
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User delete(int id) {
        return users.remove(id);
    }
}
