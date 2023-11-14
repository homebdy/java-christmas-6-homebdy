package christmas.service;

import christmas.constant.Menu;
import christmas.domain.*;

public class ChristmasService {

    private final EventPlanner eventPlanner;
    private final Bill bill;
    private final Discounts discounts;

    public ChristmasService(Date date, Orders orders) {
        this.eventPlanner = new EventPlanner(orders, date, new Gift(Menu.CHAMPAGNE));
        this.bill = new Bill(eventPlanner);
        this.discounts = new Discounts();
        applyEvent();
    }

    private void applyEvent() {
        bill.applyDiscount(discounts.getDDayDiscount());
        bill.applyDiscount(discounts.getWeekdayDiscount());
        bill.applyDiscount(discounts.getWeekendDiscount());
        bill.applyDiscount(discounts.getGiftDiscount());
        bill.applyDiscount(discounts.getSpecialDiscount());
    }

    public Orders getOrders() {
        return eventPlanner.getOrders();
    }

    public Bill getBill() {
        return bill;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public Gift getGift() {
        return eventPlanner.getGift();
    }
}
