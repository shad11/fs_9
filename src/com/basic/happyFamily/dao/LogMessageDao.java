package com.basic.happyFamily.dao;

import com.basic.happyFamily.entities.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class LogMessageDao {
    private final String filePath = "files/application.log";

    public void save(LogMessage message) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(message.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
