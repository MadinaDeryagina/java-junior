package com.acme.edu;

public class MessageObject extends Message {

    private static final String PREFIX="reference: ";
    private Object message;

    public MessageObject(Object message) {
        this.message = message;
    }

    @Override
    protected String formateForSave() {
        return PREFIX + message + LINE_SEPARATOR;
    }

    @Override
    boolean equalsTypes(Message other) {
        return other instanceof  MessageObject;
    }

    @Override
    void reset() {

    }
}
