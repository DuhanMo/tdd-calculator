import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    private Calculator calculator;
    private int firstNumber;
    private int secondNumber;

    @BeforeEach
    void numberSetup() {
        Classifier classifier = new Classifier();
        calculator = new Calculator(classifier);
        firstNumber = 1;
        secondNumber = 2;
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest()
    @CsvSource({
            "1, 2",
            "3, 3",
            "11, 32"
    })
    void plusTest(int firstNumber, int secondNumber) {
        int expect = firstNumber + secondNumber;
        assertThat(calculator.plus(firstNumber, secondNumber)).isEqualTo(expect);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void minusTest() {
        int expect = firstNumber - secondNumber;
        assertThat(calculator.minus(firstNumber, secondNumber)).isEqualTo(expect);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplyTest() {
        int expect = firstNumber * secondNumber;
        assertThat(calculator.multiply(firstNumber, secondNumber)).isEqualTo(expect);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource({
            "3, 1",
            "4, 2",
            "100, 10"
    })
    void divisionTest(int firstNumber, int secondNumber) {
        int expect = firstNumber / secondNumber;
        assertThat(calculator.division(firstNumber, secondNumber)).isEqualTo(expect);
    }

    @DisplayName("계산기가 분류기에게 단항식 전달 테스트")
    @Test
    void calculatorCallClassifierTest() {
        String singularExpression = "3 + 4";
        calculator.calculate(singularExpression);
        assertThat(calculator.getClassifier().getOperands().size()).isEqualTo(2);
    }

    @ParameterizedTest(name = "[{index}] 단항식: {0}, 결과값: {1}")
    @CsvSource({
            "1 + 1 * 2 / 2, 2",
            "2 * 4, 8",
            "4 / 2 * 6, 12",
            "9 - 3 + 206, 212"
    })
    @DisplayName("분류기에 저장된 연산자를 이용한 계산 테스트")
    void calculateWithClassifierOperator(String singularExpression, int expected) {
        int calculateResult = calculator.calculate(singularExpression);
        assertThat(calculateResult).isEqualTo(expected);
    }
}
