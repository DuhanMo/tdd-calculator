import java.util.List;

public class Calculator {

    private final Classifier classifier = new Classifier();

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
        List<String> operators = classifier.getOperators();
        int tmpResult;
        int result = operands.get(0);
        for (int i = 0; i < operands.size() - 1; i++) {
            int secondOperand = operands.get(i + 1);
            tmpResult = operate(result, operators.get(i), secondOperand);
            result = tmpResult;
        }
        return result;
    }

    private int operate(int firstOperand, String operator, int secondOperand) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
            default:
                throw new IllegalArgumentException();
        }
    }
}
