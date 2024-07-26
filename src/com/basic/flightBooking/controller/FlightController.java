package com.basic.flightBooking.controller;

import com.basic.flightBooking.entities.Flight;
import com.basic.flightBooking.service.FlightService;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class FlightController {
    private FlightService flightService = new FlightService();
    private String FILE_NAME = "files/flightBooking/flights.ser";

    public void onlineSchedule() {
        List<Flight> flights = flightService.findFlightsByHours(24);

        flights.forEach(System.out::println);
    }

    public void flightInfo() {
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть номер рейсу: ");
        int flightNumber = Integer.parseInt(input.nextLine());

        Flight flight = flightService.getById(flightNumber);

        System.out.println(flight == null ? "Рейс не найден!" : flight);
    }

    public Flight create(LocalDateTime dateTime, String cityFrom, String cityTo, int freeSeatsCount) {
        Flight.sequenceId++;

        Flight newFlight = new Flight(Flight.sequenceId, dateTime, cityFrom, cityTo, freeSeatsCount);
        flightService.save(newFlight);

        return newFlight;
    }

    public void readDataFromFile() {
        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Flight flight = null;

            while (true) {
                try {
                    flight = (Flight) ois.readObject();

                    flightService.save(flight);
                } catch (EOFException e) {
                    if (flight != null) {
                        Flight.sequenceId = flight.getId();
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveDataToFile() {
        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            List<Flight> flights = flightService.getAll();

            for (Flight flight : flights) {
                oos.writeObject(flight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
