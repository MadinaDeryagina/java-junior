package com.acme.edu.message;

import com.acme.edu.saver.Saver;

public class MessageVarargsInt extends Message {
    private static final String PREFIX = "primitives array:";
    private int[] messages;

    public MessageVarargsInt(int... messages) throws  MessageException{
        if( messages == null ) throw new MessageException("Null message");
         this.messages = messages;

    }

    @Override
    public String formateForSave() {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX + " {");
        for (int i = 0; i < messages.length - 1; i++) {
            sb.append(messages[i]).append(", ");
        }
        sb.append(messages[messages.length - 1]).append("}").append(LINE_SEPARATOR);
        sb.trimToSize();
        return sb.toString();
    }



    @Override
    public boolean equalsTypes(Message other) {
        return other instanceof MessageVarargsInt;
    }

    @Override
    public void reset() {

    }
}
