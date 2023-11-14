package christmas.domain;

import christmas.constant.ExceptionMessage;
import christmas.constant.OutputMessage;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final List<Order> elements;

    public Orders(List<Order> elements) {
        validate(elements);
        this.elements = new ArrayList<>(elements);
    }

    private void validate(List<Order> elements) {
        validateIsOnlyBeverage(elements);
    }

    private void validateIsOnlyBeverage(List<Order> elements) {
        int notBeverageMenuCount = elements.stream()
                .filter(Order::isNotBeverage)
                .toList()
                .size();
        if (notBeverageMenuCount == 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage());
        }
    }

    public int getTotalPrice() {
        return elements.stream()
                .mapToInt(Order::getPrice)
                .sum();
    }

    public int getDessertMenuCount() {
        return elements.stream()
                .filter(Order::isDessert)
                .mapToInt(Order::getQuantity)
                .sum();
    }

    public int getMainMenuCount() {
        return elements.stream()
                .filter(Order::isMainMenu)
                .mapToInt(Order::getQuantity)
                .sum();
    }

    public boolean isOverThan(int amount) {
        return getTotalPrice() >= amount;
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(element -> stringBuilder.append(element.display())
                .append(OutputMessage.NEW_LINE.getMessage()));
        return stringBuilder.toString();
    }
}
