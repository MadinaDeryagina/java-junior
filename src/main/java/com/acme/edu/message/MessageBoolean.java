package com.acme.edu.message;

import com.acme.edu.saver.Saver;

public class MessageBoolean extends Message {
    private boolean message;
    private final static String prefix = "primitive: ";

    public MessageBoolean(boolean message) {
        this.message = message;
    }

    @Override
    public String formateForSave() {
        return prefix + message;
    }

    @Override
    protected void processPrevAndCurrent(Message prevMessage, Saver saver) {
        saver.save(prevMessage.formateForSave());
    }

    @Override
    public boolean equalsTypes(Message other) {
        return other instanceof MessageBoolean;
    }

    @Override
    public void reset() {
    }
}
