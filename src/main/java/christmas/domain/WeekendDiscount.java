package christmas.domain;

public class WeekendDiscount implements DiscountPolicy {

    private static final int DISCOUNT_UNIT = 2023;
    private int discountAmount = 0;


    @Override
    public int getDiscountAmount(EventPlanner eventPlanner) {
        if (eventPlanner.isWeekend()) {
            discountAmount = eventPlanner.getMainMenuCount() * DISCOUNT_UNIT;
        }
        return discountAmount;
    }

    @Override
    public int display() {
        return 0;
    }
}
