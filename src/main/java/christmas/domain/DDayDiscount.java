package christmas.domain;

public class DDayDiscount implements DiscountPolicy {

    private static final int BASE_DISCOUNT_AMOUNT = 1000;
    private static final int INCREASE_AMOUNT = 100;
    private int discountAmount = 0;


    @Override
    public int getDiscountAmount(EventPlanner planner) {
        if (planner.isBeforeDDay()) {
            discountAmount = calculateDiscountAmount(planner.getDifferenceDate());
        }
        return discountAmount;
    }

    private int calculateDiscountAmount(int day) {
        return BASE_DISCOUNT_AMOUNT + day * INCREASE_AMOUNT;
    }

    @Override
    public int display() {
        return 0;
    }

}
