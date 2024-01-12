package com.appsdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();
    static Integer x;
    @BeforeAll
    static void setupX() {
        x = 1;
    }
    @BeforeEach
    void setup() {
        System.out.println("Starting test " + x);
    }
    @AfterEach
    void incrementX() {
        x++;
    }
    @ParameterizedTest
    @CsvSource({
            "4,2,2",
            "50,10,5",
            "100,5,20"
    })
    void integerDivision(int dividend, int divisor, int expectedResult) {
        int actualResult = calculator.integerDivision(dividend, divisor);
        assertEquals(expectedResult, actualResult, dividend + "/" + divisor + " did not produce " + expectedResult);
    }
    @Test
    void integerDivision_divisionByZero() {
        String expectedExceptionMessage = "/ by zero";
        ArithmeticException actualException = assertThrows(ArithmeticException.class, ()->{
            calculator.integerDivision(4,0);
        }, "Division by zero should have thrown ArithmeticException");
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }
    @ParameterizedTest
//    @MethodSource("integerSubtractionInputParameters")
    @CsvSource({
            "33,1,32",
            "24,1,23",
            "54,2,52",
            "254645,10,254635"
    })
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, actualResult, minuend + "-" + subtrahend + " did not produce " + expectedResult);
    }
//    public static Stream<Arguments> integerSubtractionInputParameters() {
//        return Stream.of(
//            Arguments.of(33,1,32),
//            Arguments.of(24,1,23),
//            Arguments.of(54,2,52)
//        );
//    }
}