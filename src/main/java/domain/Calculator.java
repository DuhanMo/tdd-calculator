package domain;

import java.util.List;

public class Calculator {

    private final Classifier classifier;

    public Calculator(Classifier classifier) {
        this.classifier = classifier;
    }

    public int plus(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public int division(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    public Classifier getClassifier() {
        return classifier;
    }

    public int calculate(String singularExpression) {
        classifier.classify(singularExpression);
        List<Integer> operands = classifier.getOperands();
        List<Operator> operators = classifier.getOperators();
        int tmpResult;
        int result = operands.get(0);
        for (int i = 0; i < operands.size() - 1; i++) {
            int secondOperand = operands.get(i + 1);
            tmpResult = operate(result, operators.get(i), secondOperand);
            result = tmpResult;
        }
        return result;
    }

    private int operate(int firstOperand, Operator operator, int secondOperand) {
        switch (operator) {
            case PLUS:
                return firstOperand + secondOperand;
            case MINUS:
                return firstOperand - secondOperand;
            case MULTIPLY:
                return firstOperand * secondOperand;
            case DIVISION:
                return firstOperand / secondOperand;
            default:
                throw new IllegalArgumentException();
        }
    }
}