package christmas.domain;

import christmas.constant.OutputMessage;

public class GiftDiscount implements DiscountPolicy {

    private static final int DEFAULT_COUNT = 0;
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
    public boolean isApply() {
        return discountAmount != DEFAULT_COUNT;
    }

    @Override
    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OutputMessage.PRESENT_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }
}
