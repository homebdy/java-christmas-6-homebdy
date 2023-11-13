package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.validator.InputValidator;

public class InputView {

    private final InputValidator validator = new InputValidator();
    public Date readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return new Date(Integer.parseInt(input));
    }
}
