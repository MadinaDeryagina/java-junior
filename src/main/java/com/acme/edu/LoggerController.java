package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;

public class LoggerController {

    private Message prevMessage;
    private Saver saver;

    public LoggerController(Saver saver) {
        if( saver == null) throw  new IllegalArgumentException("Empty saver");
        this.saver = saver;
        prevMessage = null;
    }

    void setCurrentMessage(Message current) throws IllegalArgumentException{
        if( current == null) throw new IllegalArgumentException("Current message is null");
        if (prevMessage == null) {
            prevMessage = current;
            return;
        }

        current.processPreviousMessage(prevMessage, saver);
        prevMessage = current;
    }

    public void close() throws LoggerControllerException {
        try{
            saver.save(prevMessage.formateForSave());

        } catch (SaverException e) {
            throw new LoggerControllerException("Logger close problem",e);
        }

    }
}
