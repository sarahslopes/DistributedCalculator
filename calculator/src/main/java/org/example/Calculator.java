package org.example;

import org.example.operation.Operation;
import org.example.operation.OperationFunction;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.example.operation.BigDecimalUtils.printResult;
import static org.example.operation.BigDecimalUtils.stringToArrayList;
import static org.example.operation.Operation.isOperationValid;

public class Calculator {

    public void selectorMenu(int selectedOption) {
        Operation operation = new Operation();

        do {
            switch (selectedOption) {
                case 1:
                    performOperation(operation::sum, "Resultado da soma:");
                    break;
                case 2:
                    performOperation(operation::subtract, "Resultado da subtração:");
                    break;
                case 3:
                    performOperation(operation::multiply, "Resultado da multiplicação:");
                    break;
                case 4:
                    performOperation(operation::divide, "Resultado da divisão:");
                    break;
                case 5:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
                    break;
            }
        } while (selectedOption != 5);
    }

    public void performOperation(OperationFunction operationFunction, String message) {
        ArrayList<BigDecimal> numbers = stringToArrayList();

        if (isOperationValid(numbers)) {
            BigDecimal result = operationFunction.apply(numbers);
            printResult(message, result);
        } else {
            System.out.println("Número máximo de números excedido. A operação não pode ser realizada.");
        }
    }
}