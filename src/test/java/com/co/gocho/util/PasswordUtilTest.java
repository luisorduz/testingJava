package com.co.gocho.util;

import org.junit.Test;

import static com.co.gocho.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letter(){
        assertEquals(WEAK, PasswordUtil.assessPassword("abdcdefg"));
    }

    @Test
    public void medium_when_has_only_letter_and_numbers(){
        assertEquals(MEDIUM, PasswordUtil.assessPassword("12123cdefg"));
    }

    @Test
    public void strong_when_has_only_letter_numbers_and_symbols(){
        assertEquals(STRONG, PasswordUtil.assessPassword("12123cd!**"));
    }




}