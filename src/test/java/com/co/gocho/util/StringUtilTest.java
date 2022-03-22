package com.co.gocho.util;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    @Test
    public void testRepeat() {

        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3));

        String result2 = StringUtil.repeat("hola",2);
        Assert.assertEquals("holahola",result2);
    }

}