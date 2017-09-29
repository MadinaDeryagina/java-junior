package com.acme.edu;

public class SumTypeLogger {
    //region initialization prefixe's constants
    private final static String FOR_PRIMITIVE ="primitive: ";
    private final static String FOR_CHAR ="char: ";
    private final static String FOR_STRING ="string: ";
    private final static String FOR_OBJECT ="reference: ";
    private static final String FOR_PRIMITIVE_ARRAYS = "primitives array: ";
    //endregion

    private static int modMaxSumInt = 0;
    private static int modMaxSumByte = 0;
    private static int numOfMaxOverflowsInSumByte =0;
    private static int numOfMaxOverflowsInSumInt =0;
    private static int countRepeatedStrings = 0;
    private static String previousString = null;
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static boolean isPreviousString = false;
    private static boolean isPreviousInt = false;
    private static boolean isPreviousByte = false;

    private static int maxValueCounter = 0;
    private static int minValueCounter = 0;

    public static void log(int message) {
        dumpPreviuosCallsResults("INT");
        modMaxSumInt = sumModMaxValueInt( modMaxSumInt, message);
        numOfMaxOverflowsInSumInt += maxValueCounter;
        isPreviousInt = true;
    }

    public static void log(byte message) {
        dumpPreviuosCallsResults("BYTE");
        modMaxSumByte = sumModMaxValueByte(modMaxSumByte,message);
        numOfMaxOverflowsInSumByte += maxValueCounter;
        isPreviousByte = true;
    }

    public static void log(boolean message){
        dumpPreviuosCallsResults("BOOL");
        print(FOR_PRIMITIVE + message);

    }
    public static void log(String message){
        if( message == null) throw new NullPointerException();
        if( previousString == null) {
            dumpPreviuosCallsResults("STR");
        }
        else if( ! previousString.equals(message) ){
            dumpString();
        }
        countRepeatedStrings++;
        isPreviousString = true;
        previousString = message;
    }
    public static void log(char message){
        dumpPreviuosCallsResults("CHAR");
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

    private static void dumpPreviuosCallsResults( String currentFunctionCall){

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

    private static void dumpBytes() {
        if( isPreviousByte == false){
            return;
        }
        print(FOR_PRIMITIVE + String.valueOf(modMaxSumByte));
        while ( numOfMaxOverflowsInSumByte >0){
                print( FOR_PRIMITIVE + String.valueOf(Byte.MAX_VALUE));
                numOfMaxOverflowsInSumByte--;
        }
        numOfMaxOverflowsInSumByte = 0;
        modMaxSumByte = 0;
        maxValueCounter = 0;
        isPreviousByte=false;
    }

    private static void dumpInt() {
        if(isPreviousInt == false){
            return;
        }

        print( FOR_PRIMITIVE + String.valueOf(modMaxSumInt));

        while ( numOfMaxOverflowsInSumInt > 0 ){
            print( FOR_PRIMITIVE + String.valueOf(Integer.MAX_VALUE));
            numOfMaxOverflowsInSumInt--;
        }
        modMaxSumInt = 0;
        isPreviousInt = false;
        numOfMaxOverflowsInSumInt = 0;
        maxValueCounter=0;


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

    private static int sumModMaxValueInt(int prevSum,int current) {
        return sumModMaxValue(prevSum, current, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static int sumModMaxValueByte(int prevSum,byte current) {
        return  sumModMaxValue( prevSum, current, Byte.MAX_VALUE, Byte.MIN_VALUE);
    }

    private static int sumModMaxValue(int prevSum, int current, int max_border, int min_border){

        return sumWithMaxOverflow( prevSum, current, max_border);

    }

    private static int sumWithMaxOverflow(int prevSum, int current, int max_border){
            while( current >= max_border - prevSum) {
                maxValueCounter++;
                current = current - max_border;
            }
            return prevSum + current;
    }



}
