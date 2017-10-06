package com.acme.edu.message;

import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;

public abstract class Message {


    protected static final String LINE_SEPARATOR = System.lineSeparator();

    public abstract String formateForSave();

    public void processPreviousMessage(Message prevMessage, Saver saver) {
        if (prevMessage == null) {
            return;
        }
        if (!this.equalsTypes(prevMessage)) {
            try{
                saver.save(prevMessage.formateForSave());

            } catch (SaverException e) {
                new IllegalArgumentException("There is nowhere to save data");
            }

        } else {
            this.processPrevAndCurrent(prevMessage, saver);
        }
    }

    protected void processPrevAndCurrent(Message prevMessage, Saver saver){
        try{
            saver.save(prevMessage.formateForSave());

        } catch (SaverException e) {
            new IllegalArgumentException("There is nowhere to save data");
        }

    }

    public abstract boolean equalsTypes(Message other);

    public abstract void reset();
}
