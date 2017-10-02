package com.acme.edu;

public class MessageVarargsInt extends Message {
    private static final  String PREFIX="primitives array:";
    private int[] messages;
    public MessageVarargsInt(int... messages) {

        this.messages= messages;

    }

    @Override
    protected String formateForSave() {
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
    boolean equalsTypes(Message other) {
        return other instanceof MessageVarargsInt;
    }

    @Override
    void reset() {

    }
}
