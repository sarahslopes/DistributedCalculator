package org.example;

import org.example.operation.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.example.operation.Operation.performOperation;

public class Calculator {

    public void menu(int selectedOption, ArrayList<BigDecimal> numbers) {
        Operation operation = new Operation();

        switch (selectedOption) {
            case 1:
                performOperation(numbers, operation::sum, "Resultado da soma:");
                break;
            case 2:
                performOperation(numbers, operation::subtract, "Resultado da subtração:");
                break;
            case 3:
                performOperation(numbers, operation::multiply, "Resultado da multiplicação:");
                break;
            case 4:
                performOperation(numbers, operation::divide, "Resultado da divisão:");
                break;
            case 5:
                System.out.println("Encerrando sistema...");
                break;
            default:
                System.out.println("Insira uma opção válida!");
                break;
        }
    }
}