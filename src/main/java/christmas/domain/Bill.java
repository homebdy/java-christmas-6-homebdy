package christmas.domain;

import christmas.constant.OutputMessage;

public class Bill {

    private final int totalPrice;
    private int benefitAmount = 0;

    public Bill(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void applyDiscount(DiscountPolicy discountPolicy, EventPlanner planner) {
        benefitAmount += discountPolicy.getDiscountAmount(planner);
    }

    public String displayBenefit() {
        StringBuilder sb = new StringBuilder();
        sb.append(OutputMessage.DISCOUNT_DISPLAY.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), benefitAmount));
        return sb.toString();
    }
}
