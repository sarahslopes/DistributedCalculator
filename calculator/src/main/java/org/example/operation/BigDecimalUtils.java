package org.example.operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class BigDecimalUtils {

    public static ArrayList<BigDecimal> stringToArrayList() {
        Scanner scanner = new Scanner(System.in);
        String receivedLine = scanner.nextLine();

        Scanner scannerString = new Scanner(receivedLine);
        ArrayList<BigDecimal> numbers = new ArrayList<>();

        while (scannerString.hasNextBigDecimal()) {
            BigDecimal number = scannerString.nextBigDecimal();
            numbers.add(number);
        }

        scannerString.close();
        return numbers;
    }

    public static void printResult(String message, BigDecimal result) {
        System.out.println(message + " " + result);
    }
}
