package com.basic.flightBooking.utilities;

import com.basic.flightBooking.controller.FlightController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightsTestData {
    private static class FlightTest {
        String date;
        String from;
        String to;
        int seats;

        public FlightTest(String date, String from, String to, int seats) {
            this.date = date;
            this.from = from;
            this.to = to;
            this.seats = seats;
        }
    }

    public static void saveTestDataToFile() {
        FlightController flightController = new FlightController();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        testData.forEach(flight -> {
            LocalDateTime dateTime = LocalDateTime.parse(flight.date, dateFormatter);

            flightController.create(dateTime, flight.from, flight.to, flight.seats);
        });

        flightController.saveDataToFile();
    }

    private static List<FlightTest> testData = new ArrayList<>(List.of(
            new FlightTest("2024-07-26 08:00", "Київ", "Львів", 12)
            , new FlightTest("2024-07-26 10:30", "Харків", "Одеса", 20)
            , new FlightTest("2024-07-26 12:00", "Дніпро", "Київ", 15)
            , new FlightTest("2024-07-26 14:45", "Львів", "Харків", 8)
            , new FlightTest("2024-07-26 17:30", "Одеса", "Дніпро", 25)
            , new FlightTest("2024-07-26 19:00", "Київ", "Одеса", 5)
            , new FlightTest("2024-07-26 21:15", "Харків", "Львів", 18)
            , new FlightTest("2024-07-27 08:00", "Київ", "Харків", 10)
            , new FlightTest("2024-07-27 10:30", "Львів", "Одеса", 22)
            , new FlightTest("2024-07-27 13:00", "Дніпро", "Львів", 9)
            , new FlightTest("2024-07-27 15:30", "Одеса", "Київ", 17)
            , new FlightTest("2024-07-27 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-07-27 20:30", "Львів", "Київ", 7)
            , new FlightTest("2024-07-28 08:00", "Київ", "Одеса", 14)
            , new FlightTest("2024-07-28 10:45", "Харків", "Львів", 19)
            , new FlightTest("2024-07-28 13:15", "Дніпро", "Харків", 11)
            , new FlightTest("2024-07-28 15:45", "Одеса", "Львів", 23)
            , new FlightTest("2024-07-28 18:15", "Київ", "Дніпро", 6)
            , new FlightTest("2024-07-28 20:45", "Львів", "Одеса", 13)
            , new FlightTest("2024-07-29 08:00", "Київ", "Харків", 16)
            , new FlightTest("2024-07-29 10:30", "Львів", "Київ", 10)
            , new FlightTest("2024-07-29 13:00", "Дніпро", "Одеса", 21)
            , new FlightTest("2024-07-29 15:30", "Одеса", "Київ", 8)
            , new FlightTest("2024-07-29 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-07-29 20:30", "Львів", "Харків", 7)
            , new FlightTest("2024-07-30 08:00", "Київ", "Львів", 12)
            , new FlightTest("2024-07-30 10:30", "Харків", "Одеса", 20)
            , new FlightTest("2024-07-30 12:00", "Дніпро", "Київ", 15)
            , new FlightTest("2024-07-30 14:45", "Львів", "Харків", 8)
            , new FlightTest("2024-07-30 17:30", "Одеса", "Дніпро", 25)
            , new FlightTest("2024-07-30 19:00", "Київ", "Одеса", 5)
            , new FlightTest("2024-07-30 21:15", "Харків", "Львів", 18)
            , new FlightTest("2024-07-31 08:00", "Київ", "Харків", 10)
            , new FlightTest("2024-07-31 10:30", "Львів", "Одеса", 22)
            , new FlightTest("2024-07-31 13:00", "Дніпро", "Львів", 9)
            , new FlightTest("2024-07-31 15:30", "Одеса", "Київ", 17)
            , new FlightTest("2024-07-31 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-07-31 20:30", "Львів", "Київ", 7)
            , new FlightTest("2024-08-01 08:00", "Київ", "Одеса", 14)
            , new FlightTest("2024-08-01 10:45", "Харків", "Львів", 19)
            , new FlightTest("2024-08-01 13:15", "Дніпро", "Харків", 11)
            , new FlightTest("2024-08-01 15:45", "Одеса", "Львів", 23)
            , new FlightTest("2024-08-01 18:15", "Київ", "Дніпро", 6)
            , new FlightTest("2024-08-01 20:45", "Львів", "Одеса", 13)
            , new FlightTest("2024-08-02 08:00", "Київ", "Харків", 16)
            , new FlightTest("2024-08-02 10:30", "Львів", "Київ", 10)
            , new FlightTest("2024-08-02 13:00", "Дніпро", "Одеса", 21)
            , new FlightTest("2024-08-02 15:30", "Одеса", "Київ", 8)
            , new FlightTest("2024-08-02 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-08-02 20:30", "Львів", "Харків", 7)
            , new FlightTest("2024-08-03 08:00", "Київ", "Львів", 12)
            , new FlightTest("2024-08-03 10:30", "Харків", "Одеса", 20)
            , new FlightTest("2024-08-03 12:00", "Дніпро", "Київ", 15)
            , new FlightTest("2024-08-03 14:45", "Львів", "Харків", 8)
            , new FlightTest("2024-08-03 17:30", "Одеса", "Дніпро", 25)
            , new FlightTest("2024-08-03 19:00", "Київ", "Одеса", 5)
            , new FlightTest("2024-08-03 21:15", "Харків", "Львів", 18)
            , new FlightTest("2024-08-04 08:00", "Київ", "Харків", 10)
            , new FlightTest("2024-08-04 10:30", "Львів", "Одеса", 22)
            , new FlightTest("2024-08-04 13:00", "Дніпро", "Львів", 9)
            , new FlightTest("2024-08-04 15:30", "Одеса", "Київ", 17)
            , new FlightTest("2024-08-04 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-08-04 20:30", "Львів", "Київ", 7)
            , new FlightTest("2024-08-05 08:00", "Київ", "Одеса", 14)
            , new FlightTest("2024-08-05 10:45", "Харків", "Львів", 19)
            , new FlightTest("2024-08-05 13:15", "Дніпро", "Харків", 11)
            , new FlightTest("2024-08-05 15:45", "Одеса", "Львів", 23)
            , new FlightTest("2024-08-05 18:15", "Київ", "Дніпро", 6)
            , new FlightTest("2024-08-05 20:45", "Львів", "Одеса", 13)
            , new FlightTest("2024-08-06 08:00", "Київ", "Харків", 16)
            , new FlightTest("2024-08-06 10:30", "Львів", "Київ", 10)
            , new FlightTest("2024-08-06 13:00", "Дніпро", "Одеса", 21)
            , new FlightTest("2024-08-06 15:30", "Одеса", "Київ", 8)
            , new FlightTest("2024-08-06 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-08-06 20:30", "Львів", "Харків", 7)
            , new FlightTest("2024-08-07 21:15", "Харків", "Львів", 18)
            , new FlightTest("2024-08-10 08:00", "Київ", "Харків", 10)
            , new FlightTest("2024-08-12 10:30", "Львів", "Одеса", 22)
            , new FlightTest("2024-08-14 13:00", "Дніпро", "Львів", 9)
            , new FlightTest("2024-08-16 15:30", "Одеса", "Київ", 17)
            , new FlightTest("2024-08-18 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-08-20 20:30", "Львів", "Київ", 7)
            , new FlightTest("2024-08-22 08:00", "Київ", "Одеса", 14)
            , new FlightTest("2024-08-24 10:45", "Харків", "Львів", 19)
            , new FlightTest("2024-08-26 13:15", "Дніпро", "Харків", 11)
            , new FlightTest("2024-08-28 15:45", "Одеса", "Львів", 23)
            , new FlightTest("2024-08-30 18:15", "Київ", "Дніпро", 6)
            , new FlightTest("2024-09-01 20:45", "Львів", "Одеса", 13)
            , new FlightTest("2024-09-03 08:00", "Київ", "Харків", 16)
            , new FlightTest("2024-09-05 10:30", "Львів", "Київ", 10)
            , new FlightTest("2024-09-07 13:00", "Дніпро", "Одеса", 21)
            , new FlightTest("2024-09-09 15:30", "Одеса", "Київ", 8)
            , new FlightTest("2024-09-11 18:00", "Харків", "Дніпро", 12)
            , new FlightTest("2024-09-13 20:30", "Львів", "Харків", 7)
            , new FlightTest("2024-09-15 08:00", "Київ", "Львів", 12)
            , new FlightTest("2024-09-17 10:30", "Харків", "Одеса", 20)
            , new FlightTest("2024-09-19 12:00", "Дніпро", "Київ", 15)
            , new FlightTest("2024-09-21 14:45", "Львів", "Харків", 8)
            , new FlightTest("2024-09-23 17:30", "Одеса", "Дніпро", 25)
            , new FlightTest("2024-09-25 19:00", "Київ", "Одеса", 5)
            , new FlightTest("2024-09-27 21:15", "Харків", "Львів", 48)
            , new FlightTest("2024-09-29 08:00", "Київ", "Харків", 10)
    ));
}
