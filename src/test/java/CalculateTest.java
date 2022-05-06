import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    private int firstNumber;
    private int secondNumber;

    @BeforeEach
    void numberSetup() {
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
        Calculator calculator = new Calculator();
        int expect = firstNumber + secondNumber;
        assertThat(calculator.plus(firstNumber, secondNumber)).isEqualTo(expect);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void minusTest() {
        Calculator calculator = new Calculator();
        int expect = firstNumber - secondNumber;
        assertThat(calculator.minus(firstNumber, secondNumber)).isEqualTo(expect);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplyTest() {
        Calculator calculator = new Calculator();
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
        Calculator calculator = new Calculator();
        int expect = firstNumber / secondNumber;
        assertThat(calculator.division(firstNumber, secondNumber)).isEqualTo(expect);
    }

    @DisplayName("계산기가 분류기에게 단항식 전달 테스트")
    @Test
    void calculatorCallClassifierTest() {
        Calculator calculator = new Calculator();
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
        Calculator calculator = new Calculator();
        int calculateResult = calculator.calculate(singularExpression);
        assertThat(calculateResult).isEqualTo(expected);
    }
}
