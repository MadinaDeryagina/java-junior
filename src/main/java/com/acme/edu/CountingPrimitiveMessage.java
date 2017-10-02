package com.acme.edu;

public abstract class CountingPrimitiveMessage extends Message{

    public final static String PREFIX ="primitive: ";
    private long sum = 0;



    public CountingPrimitiveMessage(int message){
        this.sum = message;
    }

    public void addPrevSum(long prevSum){
        this.sum += prevSum ;
    }

    public long getSum(){
        return sum;
    }

    protected String dumpSumWithOverflow(long sum, long border) {
        if( Math.abs(sum) <= Math.abs(border)){
            return String.valueOf(sum)+LINE_SEPARATOR;
        }else {
            return String.valueOf(border)+ LINE_SEPARATOR + dumpSumWithOverflow(sum - border,border);
        }
    }
    @Override
    public void reset(){
        sum = 0;
    }
}
