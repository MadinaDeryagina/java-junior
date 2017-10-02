package com.acme.edu;

public class MessageChar extends Message {
    private static final String PREFIX = "char: ";
    private char message;

    public MessageChar(char message) {
        this.message = message;
    }

    @Override
    protected String formateForSave() {
        return PREFIX + message + LINE_SEPARATOR;
    }

    @Override
    boolean equalsTypes(Message other) {
        return other instanceof MessageChar;
    }

    @Override
    void reset() {

    }
}
