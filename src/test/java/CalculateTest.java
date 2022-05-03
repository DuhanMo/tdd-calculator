import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        int firstNumber = 1;
        int secondNumber = 2;
        assertThat(calculator.add(firstNumber, secondNumber)).isEqualTo(3);
    }
}
