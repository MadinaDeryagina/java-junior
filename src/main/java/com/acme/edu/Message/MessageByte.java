package com.acme.edu.Message;

public class MessageByte extends CountingPrimitiveMessage {
    public MessageByte( int message){
        super(message);
    }
    public String formateForSave(){
        if( this.getSum() >= 0){
            return PREFIX + dumpSumWithOverflow( this.getSum(), Byte.MAX_VALUE) + LINE_SEPARATOR;
        }else{
            return  PREFIX + dumpSumWithOverflow( this.getSum(), Byte.MIN_VALUE) + LINE_SEPARATOR;
        }
    }



    @Override
    public boolean equalsTypes(Message other) {
        return other instanceof MessageByte;
    }
}
