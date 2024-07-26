package com.basic.flightBooking.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight implements Serializable {
    public static int sequenceId;

    private static final long serialVersionUID = 1;

    private int id;
    private LocalDateTime dateTime;
    private String cityFrom;
    private String cityTo;
    private int freeSeatsCount;

    public Flight(int id, LocalDateTime dateTime, String cityFrom, String cityTo, int freeSeatsCount) {
        this.id = id;
        this.dateTime = dateTime;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.freeSeatsCount = freeSeatsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public int getFreeSeatsCount() {
        return freeSeatsCount;
    }

    public void setFreeSeatsCount(int freeSeatsCount) {
        this.freeSeatsCount = freeSeatsCount;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return "Flight ID: " + id + "\t" +
                "Date: " + dateTime.format(dateFormatter) + "\t" +
                "Time: " + dateTime.format(timeFormatter) + "\t" +
                "From: " + cityFrom + "\t" +
                "To: " + cityTo + "\t" +
                "Seats available: " + freeSeatsCount + "\t";
    }
}
