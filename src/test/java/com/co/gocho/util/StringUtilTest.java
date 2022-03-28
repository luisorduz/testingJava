package com.co.gocho.util;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        Assert.assertEquals("hola",StringUtil.repeat("hola",1));
    }
    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("",StringUtil.repeat("hola",0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hola",-1);
    }


    @Test
    public void string_is_not_empty(){
        boolean result = StringUtil.isEmpty("Hola");
        assertFalse(result);
    }

    @Test
    public void string_is_empty(){
        boolean result = StringUtil.isEmpty("");
        assertTrue(result);
    }

    @Test
    public void null_is_string_empty(){
        boolean result = StringUtil.isEmpty(null);
        assertTrue(result);
    }

    @Test
    public void string_with_spaces_is_empty(){
        boolean result = StringUtil.isEmpty(" ");
        assertTrue(result);
    }






}