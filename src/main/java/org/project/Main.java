package org.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        selectorMenu();
    }

    public static void selectorMenu() {
        Scanner scanner = new Scanner(System.in);
        int selectedOption;

        do {
            System.out.println("============================");
            System.out.println("Selecione a operação desejada:");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Sair");

            System.out.print("Digite o número correspondente à operação desejada: ");
            selectedOption = scanner.nextInt();

            switch (selectedOption) {
                case 1:
                    System.out.println("1 - Soma");
                    break;

                case 2:
                    System.out.println("2 - Subtração");
                    break;

                case 3:
                    System.out.println("3 - Multiplicação");
                    break;

                case 4:
                    System.out.println("4 - Divisão");
                    break;

                case 5:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Insira uma opção válida!");
                    break;
            }
        } while (selectedOption != 5);

        scanner.close();
    }
}