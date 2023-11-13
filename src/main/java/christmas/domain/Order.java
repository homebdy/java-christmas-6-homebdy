package christmas.domain;

import java.util.Arrays;
import java.util.List;

public class Order {

    private static final String DELIMITER = "-";
    private static final int MENU_NAME = 0;
    private static final int MENU_QUANTITY = 1;
    private final String name;
    private final int quantity;

    public Order(String input) {
        List<String> menu = splitInput(input);
        this.name = menu.get(MENU_NAME);
        this.quantity = Integer.parseInt(menu.get(MENU_QUANTITY));
    }

    private List<String> splitInput(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .toList();
    }
}
