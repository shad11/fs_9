package com.basic.flightBooking.dao;

import com.basic.flightBooking.entities.Booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingDaoImpl implements Dao<Booking> {
    private static Dao<Booking> bookingDao = null;
    private Map<Integer, Booking> bookings = new HashMap<>();

    private BookingDaoImpl() {}

    public static Dao<Booking> getInstance() {
        if (bookingDao == null) {
            bookingDao = new BookingDaoImpl();
        }

        return bookingDao;
    }

    @Override
    public Booking get(int id) {
        return bookings.get(id);
    }

    @Override
    public List<Booking> getAll() {
        return bookings.values().stream().toList();
    }

    @Override
    public void save(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    @Override
    public Booking delete(int id) {
        return bookings.remove(id);
    }
}
