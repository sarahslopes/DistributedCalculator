package org.project.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;


public class CalculatorService {
    public String menu(int selectedOption, ArrayList<BigDecimal> numbers) {
        CalculatorOperations calculatorOperations = new CalculatorOperations();
        String result = null;

        switch (selectedOption) {
            case 1:
                result = CalculatorUtils.performOperation(numbers, calculatorOperations::sum, "Result of the sum:");
                break;
            case 2:
                result = CalculatorUtils.performOperation(numbers, calculatorOperations::subtract, "Result of subtraction:");
                break;
            case 3:
                result = CalculatorUtils.performOperation(numbers, calculatorOperations::multiply, "Result of multiplication:");
                break;
            case 4:
                result = CalculatorUtils.performOperation(numbers, calculatorOperations::divide, "Result of the division:");
                break;
            case 5:
                System.out.println("Closing the system...");
                break;
            default:
                result = "Insert a valid option!";
                break;
        }

        return result;
    }
}