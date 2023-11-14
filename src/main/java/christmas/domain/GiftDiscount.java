package christmas.domain;

import christmas.constant.OutputMessage;

public class GiftDiscount implements DiscountPolicy {

    private int discountAmount = 0;
    private boolean isApply = false;

    @Override
    public int getDiscountAmount(EventPlanner eventPlanner) {
        if (eventPlanner.isGift()) {
            eventPlanner.addGift();
            discountAmount = eventPlanner.getGiftPrice();
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
        stringBuilder.append(OutputMessage.PRESENT_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }
}
