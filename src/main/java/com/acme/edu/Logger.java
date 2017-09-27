package com.acme.edu;

public class Logger {
    private final static String FOR_PRIMITIVE ="primitive: ";
    private final static String FOR_CHAR ="char: ";
    private final static String FOR_STRING ="string: ";
    private final static String FOR_OBJECT ="reference: ";

    public static void log(int message) {
        print(FOR_PRIMITIVE + message);
    }

    public static void log(byte message) {
        print(FOR_PRIMITIVE + message);
    }
    public static void log(boolean message){
        print(FOR_PRIMITIVE + message);
    }
    public static void log(String message){
        print(FOR_STRING + message);
    }
    public static void log(char message){
        print(FOR_CHAR + message);
    }
    public static void log(Object message){

        print(FOR_OBJECT + message.toString());
    }

    private static void print(String fullMessage){
        System.out.println(fullMessage);
    }
}
