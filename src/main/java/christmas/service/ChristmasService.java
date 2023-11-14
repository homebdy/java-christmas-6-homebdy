package christmas.service;

import christmas.constant.Menu;
import christmas.domain.*;

import java.util.List;

public class ChristmasService {

    private final EventPlanner eventPlanner;
    private final Discounts discounts;

    public ChristmasService(Date date, List<Order> orders) {
        this.eventPlanner = new EventPlanner(new Orders(date, orders), new Gift(Menu.CHAMPAGNE));
        this.discounts = new Discounts();
        applyEvent();
    }

    private void applyEvent() {
        eventPlanner.applyDiscount(discounts.getDDayDiscount());
        eventPlanner.applyDiscount(discounts.getWeekdayDiscount());
        eventPlanner.applyDiscount(discounts.getWeekendDiscount());
        eventPlanner.applyDiscount(discounts.getSpecialDiscount());
    }

    public EventPlanner getEventPlanner() {
        return eventPlanner;
    }

    public Orders getOrders() {
        return eventPlanner.getOrders();
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public Gift getGift() {
        return eventPlanner.getGift();
    }
}
