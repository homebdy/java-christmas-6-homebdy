package christmas.domain;

public class EventPlanner {

    private final Orders orders;
    private final Date date;

    public EventPlanner(Orders orders, Date date) {
        this.orders = orders;
        this.date = date;
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
