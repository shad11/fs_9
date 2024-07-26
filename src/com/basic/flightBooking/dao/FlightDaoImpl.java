package com.basic.flightBooking.dao;

import com.basic.flightBooking.entities.Flight;
import com.basic.flightBooking.exception.NotFoundData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightDaoImpl implements FlightDao {
    private static FlightDao flightDao = null;
    private Map<Integer, Flight> flights = new HashMap<>();

    private FlightDaoImpl() {}

    public static FlightDao getInstance() {
        if (flightDao == null) {
            flightDao = new FlightDaoImpl();
        }

        return flightDao;
    }

    @Override
    public Flight get(int id) {
        return flights.get(id);
    }

    @Override
    public List<Flight> getAll() {
        return flights.values().stream().toList();
    }

    @Override
    public void save(Flight flight) {
        flights.put(flight.getId(), flight);
    }

    @Override
    public void update(Flight flight) throws NotFoundData {
        if (flights.containsKey(flight.getId())) {
            flights.put(flight.getId(), flight);
        } else {
            throw new NotFoundData("Flight " + flight.getId() + " not found!");
        }
    }

    @Override
    public Flight delete(int id) {
        return flights.remove(id);
    }
}
