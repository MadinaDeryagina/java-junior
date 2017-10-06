package com.acme.edu;

import com.acme.edu.saver.SaverException;

public class LoggerControllerException extends Throwable {
    public LoggerControllerException(String message, SaverException e) {
        super(message,e);
    }
}
