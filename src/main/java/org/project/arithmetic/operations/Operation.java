package org.project.arithmetic.operations;

import java.math.BigDecimal;
import java.util.List;

public class Operation {

    private static final Integer MAX_NUMBERS =  20;

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

    public static boolean isOperationValid(List<BigDecimal> numbersReceived) {
        return numbersReceived.size() < MAX_NUMBERS;
    }
}
