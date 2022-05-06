import java.util.ArrayList;
import java.util.List;

public class Classifier {

    public static final String WHITE_SPACE_DELIMITER = " ";
    private final List<Integer> operands;
    private final List<String> operators;

    public Classifier() {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public void classify(String singularExpression) {
        String[] split = singularExpression.split(WHITE_SPACE_DELIMITER);
        for (String s : split) {
            insertSingularExpression(s);
        }
    }

    private void insertSingularExpression(String element) {
        switch (element) {
            case "+":
            case "-":
            case "*":
            case "/":
                operators.add(element);
                break;
            default:
                operands.add(Integer.parseInt(element));
        }
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<String> getOperators() {
        return operators;
    }
}
