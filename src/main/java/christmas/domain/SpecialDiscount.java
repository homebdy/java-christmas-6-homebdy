package christmas.domain;

public class SpecialDiscount implements DiscountPolicy {

    private static final int DISCOUNT_PRICE = 1000;
    private int discountAmount = 0;

    @Override
    public int getDiscountAmount(EventPlanner eventPlanner) {
        if (eventPlanner.isSpecialDay()) {
            discountAmount = DISCOUNT_PRICE;
        }
        return discountAmount;
    }

    @Override
    public int display() {
        return 0;
    }
}
