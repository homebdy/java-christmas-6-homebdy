package christmas.domain;

import christmas.constant.Badge;
import christmas.constant.OutputMessage;

public class EventPlanner {

    private static final int DEFAULT_COUNT = 0;
    private static final int GIFT_AMOUNT = 120000;
    private final Orders orders;
    private final Gift gift;
    private int benefitAmount = 0;

    public EventPlanner(Orders orders, Gift gift) {
        this.orders = orders;
        this.gift = gift;
    }

    public void applyDiscount(DiscountPolicy discountPolicy) {
        benefitAmount += discountPolicy.getDiscountAmount(orders);
    }

    private int getTotalPriceIncludeGift() {
        return orders.getTotalPrice() + gift.getGiftPrice();
    }

    public Orders getOrders() {
        return orders;
    }

    public Gift getGift() {
        return gift;
    }

    public String displayBenefit() {
        StringBuilder sb = new StringBuilder();
        if (benefitAmount == DEFAULT_COUNT) {
            sb.append(DEFAULT_COUNT);
            return sb.toString();
        }
        sb.append(OutputMessage.DISCOUNT_DISPLAY.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), benefitAmount));
        return sb.toString();
    }

    public String displayAfterDiscountAmount() {
        return String.format(OutputMessage.AMOUNT.getMessage(), getTotalPriceIncludeGift() - benefitAmount);
    }

    public String getBadge() {
        Badge badge = Badge.getBadge(benefitAmount);
        return badge.getName();
    }
}
