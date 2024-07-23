package com.basic.happyFamily.utils;

import com.basic.happyFamily.entities.LogMessage;
import com.basic.happyFamily.service.LogService;

public class Logger {
    private enum Types { DEBUG, ERROR };
    private static final LogService logService = new LogService();

    public static void error(String message) {
        LogMessage logMsg = new LogMessage(Types.ERROR.name(), message);
        logService.logMessage(logMsg);
    }

    public static void info(String message) {
        LogMessage logMsg = new LogMessage(Types.DEBUG.name(), message);
        logService.logMessage(logMsg);
    }
}
