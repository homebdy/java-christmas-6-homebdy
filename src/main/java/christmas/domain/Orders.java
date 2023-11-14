package christmas.domain;

import christmas.constant.ExceptionMessage;
import christmas.constant.OutputMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orders {

    private static final int MAX_COUNT = 20;
    private static final int DEFAULT_COUNT = 0;
    private final Date date;
    private final List<Order> elements;

    public Orders(Date date, List<Order> elements) {
        validate(elements);
        this.date = date;
        this.elements = new ArrayList<>(elements);
    }

    private void validate(List<Order> elements) {
        validateIsOnlyBeverage(elements);
        validateMaxOrder(elements);
        validateDuplicateMenu(elements);
    }

    private void validateIsOnlyBeverage(List<Order> elements) {
        int notBeverageMenuCount = elements.stream()
                .filter(Order::isNotBeverage)
                .toList()
                .size();
        if (notBeverageMenuCount == DEFAULT_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage());
        }
    }

    private void validateDuplicateMenu(List<Order> elements) {
        Set<String> notDuplicateElements = new HashSet<>(elements.stream()
                .map(Order::getMenuName)
                .toList());
        if (notDuplicateElements.size() != elements.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage());
        }
    }

    private void validateMaxOrder(List<Order> elements) {
        int totalCount = elements.stream()
                .mapToInt(Order::getQuantity)
                .sum();
        if (totalCount > MAX_COUNT) {
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

    public boolean isBeforeDDay() {
        return date.isBeforeChristmas();
    }

    public int getDifferenceDate() {
        return date.getDifferenceDDay();
    }

    public boolean isWeekDay() {
        return date.isWeekDay();
    }

    public boolean isWeekend() {
        return date.isWeekend();
    }

    public boolean isSpecialDay() {
        return date.isSpecialDay();
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(element -> stringBuilder.append(element.display())
                .append(OutputMessage.NEW_LINE.getMessage()));
        return stringBuilder.toString();
    }
}
