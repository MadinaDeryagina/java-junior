package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;

import java.io.IOException;

public class SumTypeLogger {

    private static Saver saver =  new ConsoleSaver();
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

    public static void log(String message) throws IllegalArgumentException{
        try {
            Message m = new MessageString(message);
            loggerController.setCurrentMessage(m);

        }catch ( MessageException e){
            throw new IllegalArgumentException("Invalid log's argument",e);
        }

    }

    public static void log(char message)  {
        Message m = new MessageChar(message);
        loggerController.setCurrentMessage(m);

    }

    public static void log(Object message) throws IllegalArgumentException {
        try {
            Message m = new MessageObject(message);
            loggerController.setCurrentMessage(m);

        }catch ( MessageException e){
            throw new IllegalArgumentException("Invalid log's argument",e);
        }

    }

    public static void log(int... messages) throws IllegalArgumentException {
        try {
            Message m = new MessageVarargsInt(messages);
            loggerController.setCurrentMessage(m);

        }catch ( MessageException e){
            throw new IllegalArgumentException("Invalid log's argument",e);
        }


    }

    public static void close() throws IOException {
        try {
            loggerController.close();
        } catch (LoggerControllerException e){
            throw new  IOException("Logger controller problem",e);
        }
    }

}
