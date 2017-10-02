package com.acme.edu;

public class MessageString extends Message {
    private final static String prefix ="string: ";
    private int countRepeated = 1;
    private String message;


    public MessageString(String message){
        this.message = message;
    }

    public String getMessage() {

        return message;
    }
    public int getCounter(){

        return countRepeated;
    }
    public void setCountRepeated(int prevCounter){
        countRepeated = prevCounter + 1;
    }
    @Override
    protected String formateForSave() {
        if( countRepeated == 1){
            return prefix + message + LINE_SEPARATOR;
        }
        return prefix + message + " (x"+countRepeated+")" + LINE_SEPARATOR;
    }

    @Override
    boolean equalsTypes(Message other) {
        return other instanceof  MessageString;
    }

    @Override
    void reset() {
        countRepeated=1;
    }

    boolean equalsString(MessageString other){
        return this.getMessage().equals(other.getMessage());
    }
}
