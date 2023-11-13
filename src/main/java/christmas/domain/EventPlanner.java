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

    public Orders getOrders() {
        return orders;
    }
}
