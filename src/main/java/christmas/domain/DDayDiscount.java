package christmas.domain;

import christmas.constant.OutputMessage;

public class DDayDiscount implements DiscountPolicy {

    private static final int DEFAULT_COUNT = 0;
    private static final int BASE_DISCOUNT_AMOUNT = 1000;
    private static final int INCREASE_AMOUNT = 100;
    private int discountAmount = 0;

    @Override
    public int getDiscountAmount(Orders orders) {
        if (orders.isBeforeDDay()) {
            discountAmount = calculateDiscountAmount(orders.getDifferenceDate());
        }
        return discountAmount;
    }

    @Override
    public boolean isApply() {
        return discountAmount != DEFAULT_COUNT;
    }

    private int calculateDiscountAmount(int day) {
        return BASE_DISCOUNT_AMOUNT + day * INCREASE_AMOUNT;
    }

    @Override
    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OutputMessage.D_DAY_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }

}
