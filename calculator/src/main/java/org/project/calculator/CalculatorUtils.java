package org.project.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculatorUtils {

    private static final Integer MAX_NUMBERS =  20;

    public static boolean isOperationValid(List<BigDecimal> numbersReceived) {
        return numbersReceived.size() < MAX_NUMBERS;
    }

    public static String performOperation(ArrayList<BigDecimal> numbers, OperationFunction operationFunction, String message) {
        if (!isOperationValid(numbers)) {
            return "To perform the operation, enter a maximum of 20 numbers.";
        }

        BigDecimal result = operationFunction.apply(numbers);
        return message + result;
    }
}
