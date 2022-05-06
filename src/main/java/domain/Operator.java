package domain;

import java.util.Arrays;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVISION("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    static public Operator toOperator(String element) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(element))
                .findFirst()
                .orElseThrow();
    }
}
