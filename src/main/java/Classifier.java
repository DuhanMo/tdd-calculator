import java.util.ArrayList;
import java.util.List;

public class Classifier {

    public static final String WHITE_SPACE = " ";
    private final List<String> operands = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public void classify(String singularExpression) {
        String[] split = singularExpression.split(WHITE_SPACE);
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
                operands.add(element);
        }
    }

    public List<String> getOperands() {
        return operands;
    }

    public List<String> getOperators() {
        return operators;
    }
}
