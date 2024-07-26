package com.basic.flightBooking.dao;

import com.basic.flightBooking.entities.Flight;
import com.basic.flightBooking.exception.NotFoundData;

public interface FlightDao extends Dao<Flight> {
    void update(Flight flight) throws NotFoundData;
}
