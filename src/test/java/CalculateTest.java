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
}
