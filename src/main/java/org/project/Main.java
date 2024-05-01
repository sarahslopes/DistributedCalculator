package org.project;

import org.project.arithmetic.operations.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import static org.project.arithmetic.operations.Operation.isOperationValid;
import static org.project.arithmetic.operations.BigDecimalUtils.*;

public class Main {
    public static void main(String[] args) {
        selectorMenu();
    }

    public static void selectorMenu() {
        Operation operation = new Operation();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            printMenu();
            option = scanner.nextInt();

            switch (option) {
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
        } while (option != 5);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Selecione a operação desejada:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Sair");
        System.out.print("Digite o número correspondente à operação desejada: ");
    }


    public static void performOperation(OperationFunction operationFunction, String message) {
        ArrayList<BigDecimal> numbers = stringToArrayList();

        if (isOperationValid(numbers)) {
            BigDecimal result = operationFunction.apply(numbers);
            printResult(message, result);
        } else {
            System.out.println("Número máximo de números excedido. A operação não pode ser realizada.");
        }
    }
}