package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.OrderMenus;
import christmas.validator.InputValidator;

import java.util.Arrays;

public class InputView {

    private static final String MENU_REGEX = ",";

    private final InputValidator validator = new InputValidator();

    public Date readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return new Date(Integer.parseInt(input));
    }

    public OrderMenus readMenu() {
        String input = Console.readLine();
        validator.validateDelimiter(input);
        return new OrderMenus(Arrays.stream(input.split(MENU_REGEX))
                .map(Order::new)
                .toList());
    }
}
