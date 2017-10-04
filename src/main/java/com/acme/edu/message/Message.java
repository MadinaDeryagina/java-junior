package com.acme.edu.message;

import com.acme.edu.saver.Saver;

public abstract class Message {


    protected static final String LINE_SEPARATOR = System.lineSeparator();

    public abstract String formateForSave();

    public void processPreviousMessage(Message prevMessage, Saver saver) {
        if (prevMessage == null) {
            return;
        }
        if (!this.equalsTypes(prevMessage)) {
            saver.save(prevMessage.formateForSave());

        } else {
            this.processPrevAndCurrent(prevMessage, saver);
        }
    }

    abstract protected void processPrevAndCurrent(Message prevMessage, Saver saver);

    public abstract boolean equalsTypes(Message other);

    public abstract void reset();
}
