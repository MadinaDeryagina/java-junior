package com.acme.edu.message;

import com.acme.edu.saver.Saver;

public class MessageChar extends Message {
    private static final String PREFIX = "char: ";
    private char message;

    public MessageChar(char message) {
        this.message = message;
    }

    @Override
    public String formateForSave() {
        return PREFIX + message + LINE_SEPARATOR;
    }

    @Override
    protected void processPrevAndCurrent(Message prevMessage, Saver saver) {

    }

    @Override
    public boolean equalsTypes(Message other) {
        return other instanceof MessageChar;
    }

    @Override
    public void reset() {

    }
}
