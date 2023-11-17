package christmas.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("입력받은 문자가 숫자가 아닐 경우 예외를 발생시킨다.")
    void validateNumber() {
        String input = "a";

        assertThatThrownBy(() -> validator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("형식에 맞지 않는 입력이 들어온 경우 예외를 발생시킨다.")
    void validatorDelimeter() {
        String input = "해산물파스타-3,콜라,2";

        assertThatThrownBy(() -> validator.validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
