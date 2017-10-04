package com.acme.edu.message;

import com.acme.edu.saver.Saver;

public class MessageObject extends Message {

    private static final String PREFIX = "reference: ";
    private Object message;

    public MessageObject(Object message) {
        this.message = message;
    }

    @Override
    public String formateForSave() {
        return PREFIX + message + LINE_SEPARATOR;
    }

    @Override
    protected void processPrevAndCurrent(Message prevMessage, Saver saver) {
        saver.save(prevMessage.formateForSave());
    }

    @Override
    public boolean equalsTypes(Message other) {
        return other instanceof MessageObject;
    }

    @Override
    public void reset() {

    }
}
