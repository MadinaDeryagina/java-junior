package com.acme.edu;

public class MessageInt extends CountingPrimitiveMessage {

    public MessageInt( int message){

        super(message);

    }

    protected String formateForSave(){
        if( this.getSum() >= 0){
            return super.PREFIX +dumpSumWithOverflow( this.getSum(), Integer.MAX_VALUE);
        }else{
           return  super.PREFIX +dumpSumWithOverflow( this.getSum(), Integer.MIN_VALUE);
        }
    }
    @Override
    public boolean equalsTypes(Message other){
        return other instanceof MessageInt;
    }
}
