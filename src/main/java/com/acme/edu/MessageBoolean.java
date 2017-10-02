package com.acme.edu;

public class MessageBoolean extends Message {
    private boolean message;
    private final static String prefix ="primitive: ";
    public MessageBoolean(boolean message){
        this.message = message;
    }
    @Override
    protected String formateForSave() {
        return prefix + message;
    }

    @Override
    boolean equalsTypes(Message other) {
        return other instanceof MessageBoolean;
    }

    @Override
    void reset() {

    }
}
