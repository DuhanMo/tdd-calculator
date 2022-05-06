package domain;

import java.util.ArrayList;
import java.util.List;

public class Classifier {

    public static final String WHITE_SPACE_DELIMITER = " ";
    private final List<Integer> operands;
    private final List<Operator> operators;

    public Classifier() {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void classify(String singularExpression) {
        String[] split = singularExpression.split(WHITE_SPACE_DELIMITER);
        for (String element : split) {
            insertSingularExpression(element);
        }
    }

    private void insertSingularExpression(String element) {
        if (element.equals("+") ||
                element.equals("-") ||
                element.equals("*") ||
                element.equals("/")
        ) {
            operators.add(Operator.toOperator(element));
            return;
        }
        operands.add(Integer.parseInt(element));
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<Operator> getOperators() {
        return operators;
    }
}
