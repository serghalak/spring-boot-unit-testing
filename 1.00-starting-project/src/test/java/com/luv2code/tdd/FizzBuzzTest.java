package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    @DisplayName("Divisible by Three")
    @Test
    @Order(1)
    void testDivisibleByThree() {
        //fail("fail");
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.computer(3), "Should return Fizz");
    }

    @DisplayName("Divisible by Five")
    @Test
    @Order(2)
    void testDivisibleByFive() {
        //fail("fail");
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.computer(5), "Should return Buzz");
    }

    @DisplayName("Divisible by Fifteen")
    @Test
    @Order(2)
    void testDivisibleByFifteen() {
        //fail("fail");
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.computer(15), "Should return FizzBuzz");
    }

    @DisplayName("Not Divisible by Three or five")
    @Test
    @Order(3)
    void testNotDivisibleByThreeOrFive() {
        //fail("fail");
        String expected = "7";

        assertEquals(expected, FizzBuzz.computer(7), "Should return 7");
    }

    @DisplayName("Testing with cvs data")
    @ParameterizedTest
    @Order(6)
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "7,7"
    })
    void testCvsData(int value, String expected) {

        assertEquals(expected, FizzBuzz.computer(value));
    }

    @DisplayName("Testing with cvs file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @Order(6)
    @CsvFileSource(resources="/small-test-data.csv")
    void testCvsFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.computer(value));
    }
}
