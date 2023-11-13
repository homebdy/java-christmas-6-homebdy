package christmas.domain;

public class WeekdayDiscount implements DiscountPolicy {

    private static final int DISCOUNT_UNIT = 2023;
    private int discountAmount = 0;

    @Override
    public int getDiscountAmount(EventPlanner eventPlanner) {
        if (eventPlanner.isWeekDay()) {
            discountAmount = eventPlanner.getDissertCount() * DISCOUNT_UNIT;
        }
        return discountAmount;
    }

    @Override
    public int display() {
        return 0;
    }
}
