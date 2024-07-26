package com.basic.flightBooking.entities;

import java.util.List;

public class Booking {
    public static int sequenceId;

    private int id;
    private int flightId;
    private int userId; // who booked
    private List<Integer> users;

    public Booking(int id, int flightId, int userId, List<Integer> users) {
        this.id = id;
        this.flightId = flightId;
        this.userId = userId;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }
}
