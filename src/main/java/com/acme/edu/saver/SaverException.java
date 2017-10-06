package com.acme.edu.saver;

public class SaverException extends Exception {
    public SaverException( String message){
        super(message);
    }

    public SaverException( String message, Exception e){
        super(message,e);
    }
}
