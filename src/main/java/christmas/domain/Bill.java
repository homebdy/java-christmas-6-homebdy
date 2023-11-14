package christmas.domain;

import christmas.constant.Badge;
import christmas.constant.OutputMessage;

public class Bill {

    private final EventPlanner eventPlanner;
    private int benefitAmount = 0;

    public Bill(EventPlanner eventPlanner) {
        this.eventPlanner = eventPlanner;
    }

    public void applyDiscount(DiscountPolicy discountPolicy) {
        benefitAmount += discountPolicy.getDiscountAmount(eventPlanner);
    }

    public String displayBenefit() {
        StringBuilder sb = new StringBuilder();
        sb.append(OutputMessage.DISCOUNT_DISPLAY.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), benefitAmount));
        return sb.toString();
    }

    public String displayAfterDiscountAmount() {
        return String.format(OutputMessage.AMOUNT.getMessage(), eventPlanner.getTotalPriceIncludeGift() - benefitAmount);
    }

    public String getBadge() {
        Badge badge = Badge.getBadge(benefitAmount);
        return badge.getName();
    }
}
