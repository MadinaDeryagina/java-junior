package com.acme.edu;

public class MessageByte extends CountingPrimitiveMessage {
    public MessageByte( int message){
        super(message);
    }
    protected String formateForSave(){
        if( this.getSum() >= 0){
            return PREFIX + dumpSumWithOverflow( this.getSum(), Byte.MAX_VALUE) + LINE_SEPARATOR;
        }else{
            return  PREFIX + dumpSumWithOverflow( this.getSum(), Byte.MIN_VALUE) + LINE_SEPARATOR;
        }
    }

    @Override
    boolean equalsTypes(Message other) {
        return other instanceof MessageByte;
    }
}
