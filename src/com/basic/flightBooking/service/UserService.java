package com.basic.flightBooking.service;

import com.basic.flightBooking.dao.UserDaoImpl;
import com.basic.flightBooking.entities.User;

public class UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    public User create(String name, String surname) {
        User user = findByData(name, surname);

        if (user == null) {
            User.sequenceId++;
            user = new User(User.sequenceId, name, surname);
            userDao.save(user);
        }

        return user;
    }

    public User findByData(String name, String surname) {
        User user = null;

        for (User userCur : userDao.getAll()) {
            if (userCur.getName().equals(name) && userCur.getSurname().equals(surname)) {
                user = userCur;
                break;
            }
        }

        return user;
    }
}
