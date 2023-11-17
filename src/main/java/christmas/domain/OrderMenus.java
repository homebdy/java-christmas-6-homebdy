package christmas.domain;

import christmas.constant.ExceptionMessage;

import java.util.*;

public class OrderMenus {

    private static final int MAX_COUNT = 20;
    private static final int DEFAULT_COUNT = 0;
    private final List<Order> elements;

    public OrderMenus(List<Order> elements) {
        validate(elements);
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

    private void validateMaxOrder(List<Order> elements) {
        int totalCount = elements.stream()
                .mapToInt(Order::getQuantity)
                .sum();
        if (totalCount > MAX_COUNT) {
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

    public List<Order> getElements() {
        return Collections.unmodifiableList(elements);
    }
}
