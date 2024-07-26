package com.basic.flightBooking.service;

import com.basic.flightBooking.dao.BookingDaoImpl;
import com.basic.flightBooking.dao.Dao;
import com.basic.flightBooking.dao.FlightDao;
import com.basic.flightBooking.dao.FlightDaoImpl;
import com.basic.flightBooking.entities.Booking;
import com.basic.flightBooking.entities.Flight;
import com.basic.flightBooking.exception.NotFoundData;

import java.util.List;

public class BookingService {
    private Dao<Booking> bookingDao = BookingDaoImpl.getInstance();
    private FlightDao flightDao = FlightDaoImpl.getInstance();

    public Booking create(Flight flight, int userId, List<Integer> users) throws NotFoundData {
        Booking.sequenceId++;
        Booking newBooking = new Booking(Booking.sequenceId, flight.getId(), userId, users);

        int curFreeSeats = flight.getFreeSeatsCount();
        int bookSeats = users.size();

        flight.setFreeSeatsCount(curFreeSeats - bookSeats);

        flightDao.update(flight);
        bookingDao.save(newBooking);

        return newBooking;
    }

    public Booking getById(int id) throws NotFoundData {
        Booking booking = bookingDao.get(id);

        if (booking == null) {
            throw new NotFoundData("Booking " + id + " not found!");
        }

        return booking;
    }

    public List<Booking> getBookingByUser(int userId) {
        return bookingDao.getAll()
                .stream()
                .filter(booking -> {
                    List<Integer> users = booking.getUsers();
                    boolean isAmongUsers = false;

                    for (int id : users) {
                        if (id == userId) {
                            isAmongUsers = true;
                            break;
                        }
                    }

                    return booking.getUserId() == userId || isAmongUsers;
                })
                .toList();
    }

    public void deleteBooking(Booking booking) throws NotFoundData {
        Flight flight = flightDao.get(booking.getFlightId());
        int curFreeSeats = flight.getFreeSeatsCount();
        int bookSeats = booking.getUsers().size();

        flight.setFreeSeatsCount(curFreeSeats + bookSeats);

        flightDao.update(flight);
        bookingDao.delete(booking.getId());
    }
}
