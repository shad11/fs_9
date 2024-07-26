package com.basic.flightBooking.service;

import com.basic.flightBooking.dao.FlightDao;
import com.basic.flightBooking.dao.FlightDaoImpl;
import com.basic.flightBooking.entities.Flight;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FlightService {
    private FlightDao flightDao = FlightDaoImpl.getInstance();

    public Flight getById(int id) {
        return flightDao.get(id);
    }

    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    public void save(Flight flight) {
        flightDao.save(flight);
    }

    public List<Flight> findFlightsByHours(int hours) {
        LocalDateTime now = LocalDateTime.now();

        return flightDao.getAll()
                .stream()
                .filter(flight -> Duration.between(now, flight.getDateTime()).toHours() < hours)
                .toList();
    }

    public List<Flight> findFlightsByData(String cityFrom, String cityTo, LocalDate date, int seatsCount) {
        return flightDao.getAll()
                .stream()
                .filter(flight ->
                    flight.getCityFrom().equals(cityFrom) &&
                    flight.getCityTo().equals(cityTo) &&
                    flight.getDateTime().toLocalDate().equals(date) &&
                    flight.getFreeSeatsCount() >= seatsCount
                )
                .toList();
    }
}
