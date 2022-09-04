package com.luv2code.tdd;

public class FizzBuzz {

    private static final String FizzBuzz = "FizzBuzz";
    private static final String Buzz = "Buzz";
    private static final String Fizz = "Fizz";

    public static String computer(int i) {
        if (i % 15 == 0)
            return FizzBuzz;
        else if (i % 5 == 0)
            return Buzz;
        else if (i % 3 == 0)
            return Fizz;
        else
            return String.valueOf(i);

        //return null;
    }
}
