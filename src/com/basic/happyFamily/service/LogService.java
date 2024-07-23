package com.basic.happyFamily.service;

import com.basic.happyFamily.dao.LogMessageDao;
import com.basic.happyFamily.entities.LogMessage;

public class LogService {
    private final LogMessageDao logMessageDao;

    {
        logMessageDao = new LogMessageDao();
    }

    public void logMessage(LogMessage message) {
        try {
            logMessageDao.save(message);
        } catch (RuntimeException e) {
            e.getStackTrace();
        }
    }
}
