package com.example.demo.service;

import com.example.demo.exception.DividedByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public Double plus(double a, double b) {
        return a + b;
    }

    public Double minus(double a, double b) {
        return a - b;
    }

    public Double multiply(double a, double b) {
        return a * b;
    }

    public Double divide(double a, double b) {
        if ( b == 0 ) {
            throw new DividedByZeroException("На ноль делить нельзя, исправьте ошибку!");
        }
        return a / b;
    }

}
