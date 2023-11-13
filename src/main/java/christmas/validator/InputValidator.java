package christmas.validator;

import christmas.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REGEXP = "^\\d*$";

    public void validateNumber(String input) {
        if(!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage message = ExceptionMessage.INVALID_DATE;
            throw new IllegalArgumentException(message.getMessage());
        }
    }
}
