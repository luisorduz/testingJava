package com.co.gocho.util;

public class StringUtil {

    public static String repeat(String str, int times){

        if (times < 0){
            throw new IllegalArgumentException("Negative times not all");
        }

        String result = "";

        for (int t = 0; t < times; t++) {
            result += str;
        }
        return result;
    }

}
