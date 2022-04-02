package com.co.gocho.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzShould {

    private String result;
    private  FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void fizz_when_number_is_divisible_by_3(){

        assertThat(fizzBuzz.divisible(3), is("Fizz"));
        assertThat(fizzBuzz.divisible(6), is("Fizz"));

    }

    @Test
    public void buzz_when_number_is_divisible_by_5(){

        assertThat(fizzBuzz.divisible(5), is("Buzz"));
        assertThat(fizzBuzz.divisible(10), is("Buzz"));
    }

    @Test
    public void fizzbuzz_when_number_is_divisible_by_3_and_5(){

        assertThat(fizzBuzz.divisible(15), is("FizzBuzz"));
        assertThat(fizzBuzz.divisible(30), is("FizzBuzz"));
    }

    @Test
    public void other_case_return_number(){
        int number = 2;
        int number2 = 16;
        assertThat(fizzBuzz.divisible(number), is(String.valueOf(number)));
        assertThat(fizzBuzz.divisible(number2), is(String.valueOf(number2)));
    }

    @Test
    public void number_to_roman(){

        assertThat(fizzBuzz.arabicToRoman(1), is("I"));
        assertThat(fizzBuzz.arabicToRoman(2), is("II"));
        assertThat(fizzBuzz.arabicToRoman(3), is("III"));
        assertThat(fizzBuzz.arabicToRoman(4), is("IV"));
        assertThat(fizzBuzz.arabicToRoman(5), is("V"));
        assertThat(fizzBuzz.arabicToRoman(6), is("VI"));
        assertThat(fizzBuzz.arabicToRoman(7), is("VII"));
        assertThat(fizzBuzz.arabicToRoman(10), is("X"));
        assertThat(fizzBuzz.arabicToRoman(11), is("XI"));
        assertThat(fizzBuzz.arabicToRoman(15), is("XV"));
        assertThat(fizzBuzz.arabicToRoman(16), is("XVI"));
        assertThat(fizzBuzz.arabicToRoman(50), is("L"));
        assertThat(fizzBuzz.arabicToRoman(51), is("LI"));
        assertThat(fizzBuzz.arabicToRoman(55), is("LV"));
        assertThat(fizzBuzz.arabicToRoman(56), is("LVI"));
        assertThat(fizzBuzz.arabicToRoman(60), is("LX"));
        assertThat(fizzBuzz.arabicToRoman(70), is("LXX"));
        assertThat(fizzBuzz.arabicToRoman(80), is("LXXX"));
        assertThat(fizzBuzz.arabicToRoman(81), is("LXXXI"));
        assertThat(fizzBuzz.arabicToRoman(85), is("LXXXV"));
        assertThat(fizzBuzz.arabicToRoman(86), is("LXXXVI"));
        assertThat(fizzBuzz.arabicToRoman(126), is("CXXVI"));
        assertThat(fizzBuzz.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void number_to_roman_subtraction(){


        assertThat(fizzBuzz.arabicToRoman(4), is("IV"));
        assertThat(fizzBuzz.arabicToRoman(9), is("IX"));
        assertThat(fizzBuzz.arabicToRoman(14), is("XIV"));
        assertThat(fizzBuzz.arabicToRoman(19), is("XIX"));
        assertThat(fizzBuzz.arabicToRoman(24), is("XXIV"));
        assertThat(fizzBuzz.arabicToRoman(40), is("XL"));
        assertThat(fizzBuzz.arabicToRoman(49), is("XLIX"));
        assertThat(fizzBuzz.arabicToRoman(90), is("XC"));
        assertThat(fizzBuzz.arabicToRoman(99), is("XCIX"));
        assertThat(fizzBuzz.arabicToRoman(400), is("CD"));
        assertThat(fizzBuzz.arabicToRoman(900), is("CM"));

    }

}