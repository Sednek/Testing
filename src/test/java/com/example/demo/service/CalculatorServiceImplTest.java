package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorServiceImplTest {

    private final CalculatorServiceImpl c = new CalculatorServiceImpl();


    @Test
    public void plus1() {
        Double actual = c.plus(3, 5);
        Double expected = 8d;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void plus2() {
        Double actual = c.plus(-3, 5);
        Double expected = 2d;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void minus1() {
        Double actual = c.minus(5, 6);
        Double expected = -1d;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void minus2() {
        Double actual = c.minus(10, 5);
        Double expected = 5d;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void multiply1() {
        Double actual = c.multiply(-3, 5);
        Double expected = -15d;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void multiply2() {
        Double actual = c.multiply(6, 6);
        Double expected = 36d;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void divide1() {
        Double actual = c.divide(5, 5);
        Double expected = 1d;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void divide2() {
        Double actual = c.divide(5, 10);
        Double expected = 0.5;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void divide3() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                ()->c.divide(6, 0),
                "На ноль делить нельзя, исправьте ошибку!"
        );

        assertTrue(thrown.getMessage().contains("На ноль делить нельзя, исправьте ошибку!"));
    }
}