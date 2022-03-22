package com.co.gocho.util;

public class StringUtil {

    public static String repeat(String str, int times){

        String result = "";

        for (int t = 0; t < times; t++) {
            result += str;
        }
        return result;
    }

}
