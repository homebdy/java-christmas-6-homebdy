package christmas.domain;

public class GiftDiscount implements DiscountPolicy {

    private int discountAmount = 0;

    @Override
    public int getDiscountAmount(EventPlanner eventPlanner) {
        if (eventPlanner.isGift()) {
            eventPlanner.addGift();
            discountAmount = eventPlanner.getGiftPrice();
        }
        return discountAmount;
    }

    @Override
    public int display() {
        return 0;
    }
}
