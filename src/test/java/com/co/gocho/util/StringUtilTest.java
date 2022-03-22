package com.co.gocho.util;


public class StringUtilTest {

    public static void main(String[] args) {

        assertEquals( StringUtil.repeat("hola",3),"holaholahola");

        String result2 = StringUtil.repeat("hola",2);
        assertEquals(result2,"holahola");



    }

    private static void assertEquals(String actual, String expected) {

        if (!actual.equals(expected)) {
            throw new RuntimeException(actual+" in not equal to expected :"+ expected);
        }
    }
}