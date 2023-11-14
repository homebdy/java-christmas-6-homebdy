package christmas.domain;

import christmas.constant.OutputMessage;

public class WeekdayDiscount implements DiscountPolicy {

    private static final int DEFAULT_COUNT = 0;
    private static final int DISCOUNT_UNIT = 2023;
    private int discountAmount = DEFAULT_COUNT;

    @Override
    public int getDiscountAmount(Orders orders) {
        if (orders.isWeekDay()) {
            discountAmount = orders.getDessertMenuCount() * DISCOUNT_UNIT;
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
        stringBuilder.append(OutputMessage.WEEKDAY_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }
}
