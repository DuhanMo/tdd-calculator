import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ClassifierTest {

    @ParameterizedTest(name = "{index} singularExpression: {0}, operands count: {1}, operators count: {2}")
    @CsvSource({
            "3 + 4, 2, 1",
            "3 * 4 / 2, 3, 2",
            "3 + 4 - 3 / 2, 4, 3"
    })
    @DisplayName("단항식 분류기 동작 테스트")
    void splitInputStringTest(String singularExpression, int operandsCount, int operatorsCount) {
        Classifier classifier = new Classifier();
        classifier.classify(singularExpression);

        assertAll(
                () -> assertThat(classifier.getOperands().size()).isEqualTo(operandsCount),
                () -> assertThat(classifier.getOperators().size()).isEqualTo(operatorsCount)
        );
    }
}
