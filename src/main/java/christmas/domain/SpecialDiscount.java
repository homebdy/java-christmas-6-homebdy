package christmas.domain;

import christmas.constant.OutputMessage;

public class SpecialDiscount implements DiscountPolicy {

    private static final int DISCOUNT_PRICE = 1000;
    private int discountAmount = 0;
    private boolean isApply = false;

    @Override
    public int getDiscountAmount(EventPlanner eventPlanner) {
        if (eventPlanner.isSpecialDay()) {
            discountAmount = DISCOUNT_PRICE;
            isApply = true;
        }
        return discountAmount;
    }

    @Override
    public boolean isApply() {
        return isApply;
    }

    @Override
    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OutputMessage.SPECIAL_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }
}
