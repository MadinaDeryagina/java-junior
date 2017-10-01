package com.acme.edu;

public class SumTypeLogger {
    //region initialization prefixe's constants
    private final static String FOR_PRIMITIVE ="primitive: ";
    private final static String FOR_CHAR ="char: ";
    private final static String FOR_STRING ="string: ";
    private final static String FOR_OBJECT ="reference: ";
    private static final String FOR_PRIMITIVE_ARRAYS = "primitives array: ";
    //endregion

    private static long sumInt = 0;
    private static long sumByte = 0;
    private static int countRepeatedStrings = 0;
    private static String previousString = null;
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static boolean isPreviousString = false;
    private static boolean isPreviousInt = false;
    private static boolean isPreviousByte = false;

    public static void log(int message) {
        dumpPreviousCallsResults("INT");
        sumInt += message;
        isPreviousInt = true;
    }

    public static void log(byte message) {
        dumpPreviousCallsResults("BYTE");
        sumByte += message;
        isPreviousByte = true;
    }

    public static void log(boolean message){
        dumpPreviousCallsResults("BOOL");
        print(FOR_PRIMITIVE + message);

    }
    public static void log(String message){
        if( message == null) throw new NullPointerException();
        if( previousString == null) {
            dumpPreviousCallsResults("STR");
        }
        else if( ! previousString.equals(message) ){
            dumpString();
        }
        countRepeatedStrings++;
        isPreviousString = true;
        previousString = message;
    }
    public static void log(char message){
        dumpPreviousCallsResults("CHAR");
        print(FOR_CHAR + message);
    }
    public static void log(Object message){

        print(FOR_OBJECT + message.toString());
    }

    public  static void log(int... messages ){
        print(FOR_PRIMITIVE_ARRAYS, messages);
    }
    public static void close(){
        dumpBytes();
        dumpInt();
        dumpString();
    }

    private static void print(String fullMessage){
        System.out.println(fullMessage);
    }

    private static void print( String prefix, int... array ){
        System.out.print(FOR_PRIMITIVE_ARRAYS);
        System.out.print("{");
        for ( int i = 0; i < array.length-1 ; i++ ) {
            System.out.print(array[i]+", ");
        }
        System.out.print( array[ array.length-1 ] +  "}"+LINE_SEPARATOR );

    }

    private static void dumpPreviousCallsResults(String currentFunctionCall){

        if( currentFunctionCall.equals("INT") ) {
            dumpString();
            dumpBytes();

        }else if( currentFunctionCall.equals("STR") ){
            dumpInt();
            dumpBytes();


        } else if(currentFunctionCall.equals("BYTE")){
            dumpString();
            dumpInt();
        }
        else{
            dumpString();
            dumpInt();
            dumpBytes();
        }
    }
    private static void dumpBytes(){
        if( isPreviousByte == false) {
            return;
        }
        dumpByteSumWithOverflow(sumByte);
        sumByte=0;
        isPreviousByte = true;
    }

    private static void dumpInt() {
        if(isPreviousInt == false){
            return;
        }

        dumpIntSumWithOverflow(sumInt);
        sumInt=0;
        isPreviousInt=true;
    }
    private static void dumpString() {
        if( isPreviousString == false){
            return;
        }
        if (countRepeatedStrings == 1) {
            print(FOR_STRING + previousString);
        } else {
            print(FOR_STRING + previousString + " (x" + countRepeatedStrings + ")");
        }
        previousString = null;
        isPreviousString = false;
        countRepeatedStrings=0;
    }

    private static void dumpByteSumWithOverflow(long sum){
        if( sum >= 0 ){
            dumpSumWithOverflow(sum,Byte.MAX_VALUE);
        }else {
            dumpSumWithOverflow(sum, Byte.MIN_VALUE);
        }
    }
    private static void dumpIntSumWithOverflow(long sum){
        if( sum >= 0){
            dumpSumWithOverflow( sum, Integer.MAX_VALUE);
        }else{
            dumpSumWithOverflow( sum, Integer.MIN_VALUE);
        }

    }
    private static void dumpSumWithOverflow(long sum, long border) {
        if( Math.abs(sum) <= Math.abs(border)){
            print(FOR_PRIMITIVE+String.valueOf(sum));
        }else {
            print(FOR_PRIMITIVE+String.valueOf(border));
            dumpSumWithOverflow(sum-border,border);
        }
    }





}
