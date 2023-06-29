package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String helloMessgae(){
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping(path = "/plus")
    public String addNumbers(@RequestParam(value = "a", required = false) Double a, @RequestParam(value = "b", required = false) Double b) {
        if ( a == null || b == null){
            return "Отсутствует одно или оба числа, проверьте корректность введенных данных";
        }
        return calculatorService.plus(a, b).toString();
    }

    @GetMapping(path = "/minus")
    public String subtractNumbers(@RequestParam(value = "a", required = false) Double a, @RequestParam(value = "b", required = false) Double b) {
        if ( a == null || b == null){
            return "Отсутствует одно или оба числа, проверьте корректность введенных данных";
        }
        return calculatorService.minus(a, b).toString();
    }

    @GetMapping(path = "/multiply")
    public String timesNumbers(@RequestParam(value = "a", required = false) Double a, @RequestParam(value = "b", required = false) Double b) {
        if ( a == null || b == null){
            return "Отсутствует одно или оба числа, проверьте корректность введенных данных";
        }
        return calculatorService.multiply(a, b).toString();
    }

    @GetMapping(path = "/divide")
    public String divideNumbers(@RequestParam(value = "a", required = false) Double a, @RequestParam(value = "b", required = false) Double b) {
        if ( a == null || b == null){
            return "Отсутствует одно или оба числа, проверьте корректность введенных данных";
        }
        try {
            Double result = calculatorService.divide(a, b);
        } catch (IllegalArgumentException e) {
            return "Делить на ноль нельзя!";
        }
        return calculatorService.divide(a, b).toString();
    }
}
