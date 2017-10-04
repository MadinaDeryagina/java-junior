package com.acme.edu;

import com.acme.edu.Message.Message;
import com.acme.edu.Saver.Saver;

class LoggerController {

    private Message prevMessage;
    private Saver saver;

    LoggerController(Saver saver){
        this.saver = saver;
        prevMessage = null;
    }

    void setCurrentMessage(Message current) {
        if( prevMessage == null){
            prevMessage = current;
            return;
        }

        current.processPreviousMessage(prevMessage, saver);
         prevMessage = current;
    }
    void close(){
        saver.save(prevMessage.formateForSave());
    }
}
