package christmas.domain;

public class EventPlanner {

    private static final int GIFT_AMOUNT = 120000;
    private final Orders orders;
    private final Date date;
    private final Gift gift;

    public EventPlanner(Orders orders, Date date, Gift gift) {
        this.orders = orders;
        this.date = date;
        this.gift = gift;
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

    public boolean isGift() {
        return orders.isOverThan(GIFT_AMOUNT);
    }

    public void addGift() {
        gift.addGift();
    }

    public int getGiftPrice() {
        return gift.getGiftPrice();
    }

    public int getTotalPriceIncludeGift() {
        return orders.getTotalPrice() + gift.getGiftPrice();
    }

    public int getDessertCount() {
        return orders.getDessertMenuCount();
    }

    public int getMainMenuCount() {
        return orders.getMainMenuCount();
    }

    public Orders getOrders() {
        return orders;
    }
}
