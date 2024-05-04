package org.project.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorOperations {

    public BigDecimal sum(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal subtract(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce(BigDecimal::subtract)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal multiply(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce(BigDecimal.ONE, BigDecimal::multiply);
    }

    public BigDecimal divide(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a.divide(b, BigDecimal.ROUND_HALF_UP))
                .orElse(BigDecimal.ONE);
    }

    public static ArrayList<BigDecimal> parseInputToBigDecimalList(String receivedLine) {
        Scanner scannerString = new Scanner(receivedLine);
        ArrayList<BigDecimal> numbers = new ArrayList<>();

        while (scannerString.hasNextBigDecimal()) {
            BigDecimal number = scannerString.nextBigDecimal();
            numbers.add(number);
        }

        scannerString.close();
        return numbers;
    }
}
