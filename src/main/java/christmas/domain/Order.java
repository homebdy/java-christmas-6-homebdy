package christmas.domain;

import christmas.constant.ExceptionMessage;
import christmas.constant.Menu;
import christmas.constant.OutputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Order {

    private static final String DELIMITER = "-";
    private static final int MENU_NAME = 0;
    private static final int MENU_QUANTITY = 1;
    private final Menu menu;
    private final int quantity;

    public Order(String input) {
        List<String> order = splitInput(input);
        this.menu = Menu.getMenu(order.get(MENU_NAME));
        this.quantity = Integer.parseInt(order.get(MENU_QUANTITY));
    }

    private List<String> splitInput(String input) {
        List<String> order = Arrays.stream(input.split(DELIMITER))
                .toList();
        validateNumber(order.get(MENU_QUANTITY));
        return order;
    }

    public void validateNumber(String input) {
        String NUMBER_REGEXP = "^\\d*$";
        if(!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage message = ExceptionMessage.INVALID_MENU;
            throw new IllegalArgumentException(message.getMessage());
        }
    }


    public int getPrice() {
        int price = menu.getPrice();
        return price * quantity;
    }

    public boolean isDessert() {
        return menu.isDessert();
    }

    public boolean isMainMenu() {
        return menu.isMainMenu();
    }

    public boolean isNotBeverage() {
        return !menu.isBeverage();
    }

    public int getQuantity() {
        return quantity;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(menu.getName())
                .append(OutputMessage.SPACE.getMessage())
                .append(quantity)
                .append(OutputMessage.COUNT.getMessage());
        return stringBuilder.toString();
    }
}
