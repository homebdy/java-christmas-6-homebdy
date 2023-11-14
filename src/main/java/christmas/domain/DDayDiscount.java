package christmas.domain;

import christmas.constant.OutputMessage;

public class DDayDiscount implements DiscountPolicy {

    private static final int BASE_DISCOUNT_AMOUNT = 1000;
    private static final int INCREASE_AMOUNT = 100;
    private int discountAmount = 0;
    private boolean isApply = false;


    @Override
    public int getDiscountAmount(EventPlanner planner) {
        if (planner.isBeforeDDay()) {
            discountAmount = calculateDiscountAmount(planner.getDifferenceDate());
            isApply = true;
        }
        return discountAmount;
    }

    @Override
    public boolean isApply() {
        return isApply;
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
