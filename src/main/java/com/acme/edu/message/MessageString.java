package com.acme.edu.message;

import com.acme.edu.saver.Saver;

public class MessageString extends Message {
    private final static String prefix = "string: ";
    private int countRepeated = 1;
    private String message;


    public MessageString(String message) {
        this.message = message;
    }

    public String getMessage() {

        return message;
    }

    private int getCounter() {

        return countRepeated;
    }

    private void setCountRepeated(int prevCounter) {
        countRepeated = prevCounter + 1;
    }

    @Override
    public String formateForSave() {
        if (countRepeated == 1) {
            return prefix + message + LINE_SEPARATOR;
        }
        return prefix + message + " (x" + countRepeated + ")" + LINE_SEPARATOR;
    }

    @Override
    protected void processPrevAndCurrent(Message prevMessage, Saver saver) {
        if (!(this.equalsString((MessageString) prevMessage))) {
            saver.save(prevMessage.formateForSave());
        } else {
            int prevCounter = ((MessageString) prevMessage).getCounter();
            this.setCountRepeated(prevCounter);
        }
    }

    @Override
    public boolean equalsTypes(Message other) {
        return other instanceof MessageString;
    }

    @Override
    public void reset() {
        countRepeated = 1;
    }

    private boolean equalsString(MessageString other) {
        return this.getMessage().equals(other.getMessage());
    }
}
