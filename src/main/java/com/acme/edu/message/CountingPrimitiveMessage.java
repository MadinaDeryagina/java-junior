package com.acme.edu.message;

import com.acme.edu.saver.Saver;

public abstract class CountingPrimitiveMessage extends Message {

    final static String PREFIX = "primitive: ";
    private long sum = 0;

    CountingPrimitiveMessage(int message) {
        this.sum = message;
    }

    private void addPrevSum(long prevSum) {
        this.sum += prevSum;
    }

    long getSum() {
        return sum;
    }

    String dumpSumWithOverflow(long sum, long border) {
        if (Math.abs(sum) <= Math.abs(border)) {
            return String.valueOf(sum) + LINE_SEPARATOR;
        } else {
            return String.valueOf(border) + LINE_SEPARATOR + dumpSumWithOverflow(sum - border, border);
        }
    }

    @Override
    public void processPrevAndCurrent(Message prevMessage, Saver saver) {
        long prevSum = ((CountingPrimitiveMessage) prevMessage).getSum();
        this.addPrevSum(prevSum);

    }

    @Override
    public void reset() {
        sum = 0;
    }
}
