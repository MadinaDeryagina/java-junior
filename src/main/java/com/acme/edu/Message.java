package com.acme.edu;

public abstract class Message{

    Message prevMessage;
    Message currMessage;

    protected static final String LINE_SEPARATOR = System.lineSeparator();

    protected abstract String formateForSave();
    public String savePreviousMessageIfNeeded(){
        if( prevMessage != null){
            if( !currMessage.equalsTypes(prevMessage)){

            }
        }
        return null;
    }
    abstract boolean equalsTypes( Message other);
    abstract void reset();
}
