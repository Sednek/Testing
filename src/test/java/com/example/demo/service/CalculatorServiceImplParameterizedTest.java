package com.example.demo.service;

import com.example.demo.exception.DividedByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplParameterizedTest {

    private final CalculatorServiceImpl c = new CalculatorServiceImpl();


    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(3d, 5d, 8d),
                Arguments.of(0d, 0d, 0d),
                Arguments.of(1d, 2d, 3d)
        );
    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(3d, 5d, -2d),
                Arguments.of(0d, 0d, 0d),
                Arguments.of(1d, 2d, -1d),
                Arguments.of(3d, 2d, 1d)
        );
    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(3d, 5d, 15d),
                Arguments.of(0d, 0d, 0d),
                Arguments.of(1d, 2d, 2d),
                Arguments.of(3d, 2d, 6d)
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(15d, 5d, 3d),
                Arguments.of(5d, 2d, 2.5d),
                Arguments.of(1d, 2d, 0.5d)
        );
    }

    public static Stream<Arguments> divideIllegalTestParams() {
        return Stream.of(
                Arguments.of(15d, 0d),
                Arguments.of(5d, 0d),
                Arguments.of(0d, 0d)
        );
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plus(Double a, Double b, Double expected) {
        Assertions.assertEquals(c.plus(a, b), expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minus(Double a, Double b, Double expected) {
        Assertions.assertEquals(c.minus(a, b), expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiply(Double a, Double b, Double expected) {
        Assertions.assertEquals(c.multiply(a, b), expected);
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divide(Double a, Double b, Double expected) {
        Assertions.assertEquals(c.divide(a, b), expected);
    }

    @ParameterizedTest
    @MethodSource("divideIllegalTestParams")
    public void divide3(Double a, Double b) {
        DividedByZeroException thrown = assertThrows(
                DividedByZeroException.class,
                () -> c.divide(a, b),
                "На ноль делить нельзя, исправьте ошибку!"
        );

        assertTrue(thrown.getMessage().contains("На ноль делить нельзя, исправьте ошибку!"));
    }

}
