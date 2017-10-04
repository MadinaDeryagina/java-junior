package com.acme.edu.Message;

import com.acme.edu.Saver.Saver;

public class MessageVarargsInt extends Message {
    private static final  String PREFIX="primitives array:";
    private int[] messages;
    public MessageVarargsInt(int... messages) {

        this.messages= messages;

    }

    @Override
    public String formateForSave() {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX+" {");
        for (int i = 0; i < messages.length - 1 ; i++) {
            sb.append(messages[i]).append(", ");
        }
        sb.append(messages[messages.length - 1]).append("}").append(LINE_SEPARATOR);
        sb.trimToSize();
        return sb.toString();
    }

    @Override
    protected void processPrevAndCurrent(Message prevMessage, Saver saver) {
        saver.save(prevMessage.formateForSave());
    }


    @Override
    public boolean equalsTypes(Message other) {
        return other instanceof MessageVarargsInt;
    }

    @Override
    public void reset() {

    }
}
