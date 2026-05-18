package com.zubair.calculator_app.controller;

import com.zubair.calculator_app.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculate")
    public double calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {

        return calculatorService.calculate(num1, num2, operation);
    }
}