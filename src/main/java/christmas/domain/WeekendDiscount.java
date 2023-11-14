package christmas.domain;

import christmas.constant.OutputMessage;

public class WeekendDiscount implements DiscountPolicy {

    private static final int DISCOUNT_UNIT = 2023;
    private int discountAmount = 0;
    private boolean isApply = false;

    @Override
    public int getDiscountAmount(EventPlanner eventPlanner) {
        if (eventPlanner.isWeekend()) {
            discountAmount = eventPlanner.getMainMenuCount() * DISCOUNT_UNIT;
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
        stringBuilder.append(OutputMessage.WEEKEND_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }
}
