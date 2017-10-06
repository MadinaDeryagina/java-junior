package com.acme.edu;

public class LoggerException extends Exception {
    public LoggerException(String message, Exception e){
        super(message,e);
    }
}

