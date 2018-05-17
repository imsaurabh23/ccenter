package com.saurabh.ccenter.util;

public class LoggerMessage {
    public static String logAndReturn(String message,String param1){
        System.out.println(message+param1);
        return message;
    }
    public static String logAndReturn(String message){
        System.out.println(message);
        return message;
    }
}
