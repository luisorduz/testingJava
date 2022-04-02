package com.co.gocho.fizzbuzz;

public class FizzBuzz {


    public String divisible(int number) {
        String result = "";
        boolean divisible = false;

        if (number % 3 == 0) {
            result += "Fizz";
            divisible = true;
        }

        if (number % 5 == 0) {
            result +=  "Buzz";
            divisible = true;
        }
        return divisible ? ""+result : ""+number;
    }


    public String arabicToRoman(int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            result += "I";

            result = result.replaceAll("IIII", "IV");
            result = result.replaceAll("IVI", "V");

            result = result.replaceAll("VIV", "IX");
            result = result.replaceAll("IXI", "X");

            result = result.replaceAll("XXXX", "XL");
            result = result.replaceAll("XLX", "L");

            result = result.replaceAll("LXL", "XC");
            result = result.replaceAll("XCX", "C");

            result = result.replaceAll("CCCC", "CD");
            result = result.replaceAll("CDC", "D");

            result = result.replaceAll("DCD", "CM");
            result = result.replaceAll("CMC", "M");
        }
        return result;
    }
}
