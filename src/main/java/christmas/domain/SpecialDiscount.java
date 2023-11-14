package christmas.domain;

import christmas.constant.OutputMessage;

public class SpecialDiscount implements DiscountPolicy {

    private static final int DEFAULT_COUNT = 0;
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
    public boolean isApply() {
        return discountAmount != DEFAULT_COUNT;
    }

    @Override
    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OutputMessage.SPECIAL_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }
}
