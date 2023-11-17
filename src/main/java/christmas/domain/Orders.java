package christmas.domain;

import christmas.constant.OutputMessage;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final Date date;
    private final List<Order> elements;

    public Orders(Date date, OrderMenus orderMenus) {
        this.date = date;
        this.elements = new ArrayList<>(orderMenus.getElements());
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

    public Date getDate() {
        return date;
    }

    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(element -> stringBuilder.append(element.display())
                .append(OutputMessage.NEW_LINE.getMessage()));
        return stringBuilder.toString();
    }
}
