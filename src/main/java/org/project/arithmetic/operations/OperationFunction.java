package org.project.arithmetic.operations;

import java.math.BigDecimal;
import java.util.ArrayList;

@FunctionalInterface
public interface OperationFunction {
    BigDecimal apply(ArrayList<BigDecimal> numbers);
}