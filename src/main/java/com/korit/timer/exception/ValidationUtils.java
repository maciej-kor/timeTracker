package com.korit.timer.exception;

public class ValidationUtils {

    public static boolean isNullOrEmpty(String value){
        return value == null || value.isEmpty();
    }

    public static  boolean isNull(Object o){
        return o == null;
    }

}
