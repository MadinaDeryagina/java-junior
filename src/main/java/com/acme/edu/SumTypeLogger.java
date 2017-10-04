package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;

public class SumTypeLogger {

    private static Saver saver = new ConsoleSaver();
    private static LoggerController loggerController = new LoggerController(saver);


    public static void log(int message) {
        Message m = new MessageInt(message);
        loggerController.setCurrentMessage(m);

    }

    public static void log(byte message) {
        Message m = new MessageByte(message);
        loggerController.setCurrentMessage(m);
    }

    public static void log(boolean message) {
        Message m = new MessageBoolean(message);
        loggerController.setCurrentMessage(m);
    }

    public static void log(String message) {
        Message m = new MessageString(message);
        loggerController.setCurrentMessage(m);

    }

    public static void log(char message) {
        Message m = new MessageChar(message);
        loggerController.setCurrentMessage(m);

    }

    public static void log(Object message) {
        Message m = new MessageObject(message);
        loggerController.setCurrentMessage(m);
    }

    public static void log(int... messages) {
        Message m = new MessageVarargsInt(messages);
        loggerController.setCurrentMessage(m);

    }

    public static void close() {
        loggerController.close();
    }

}
