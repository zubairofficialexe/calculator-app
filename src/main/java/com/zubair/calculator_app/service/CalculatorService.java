package com.zubair.calculator_app.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculate(double num1, double num2, String operation) {

        return switch (operation) {

            case "+" -> num1 + num2;

            case "-" -> num1 - num2;

            case "*" -> num1 * num2;

            case "/" -> {
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                yield num1 / num2;
            }

            default -> throw new IllegalArgumentException("Invalid Operation");
        };
    }
}