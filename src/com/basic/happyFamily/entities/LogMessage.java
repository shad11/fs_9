package com.basic.happyFamily.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogMessage {
    private String type;
    private String message;
    private LocalDateTime dateTime;

    {
        dateTime = LocalDateTime.now();
    }

    public LogMessage(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        return dateTime.format(format) + " [" + type.toUpperCase() + "] " + message;
    }
}
