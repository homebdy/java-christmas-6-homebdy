package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String MENU_REGEX = ",";

    private final InputValidator validator = new InputValidator();

    public Date readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return new Date(Integer.parseInt(input));
    }

    public List<String> readMenu() {
        String input = Console.readLine();
        return Arrays.stream(input.split(MENU_REGEX))
                .toList();
    }
}
