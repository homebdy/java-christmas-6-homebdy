package christmas.view;

import christmas.constant.OutputMessage;
import christmas.domain.Discounts;
import christmas.domain.EventPlanner;
import christmas.domain.Gift;
import christmas.domain.Orders;

public class OutputView {

    public void printStartPlanner() {
        System.out.println(OutputMessage.START_PLANNER.getMessage());
    }

    public void printVisitDate() {
        System.out.println(OutputMessage.READ_VISIT_DATE.getMessage());
    }

    public void printOrderMenu() {
        System.out.println(OutputMessage.READ_MENU.getMessage());
    }

    public void printEventPreview() {
        System.out.println(OutputMessage.EVENT_PREVIEW.getMessage());
        System.out.println();
    }

    public void printOrderMenus(Orders orders) {
        System.out.println(OutputMessage.ORDER_MENU.getMessage());
        System.out.println(orders.display());
    }

    public void printTotalPrice(Orders orders) {
        System.out.println(OutputMessage.AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.printf(OutputMessage.AMOUNT.getMessage(), orders.getTotalPrice());
        System.out.println();
    }

    public void printBenefitContent(Discounts discounts) {
        System.out.println(OutputMessage.BENEFIT_CONTENT.getMessage());
        System.out.println(discounts.display());
    }

    public void printBenefit(EventPlanner planner) {
        System.out.println(OutputMessage.BENEFIT_AMOUNT.getMessage());
        System.out.println(planner.displayBenefit());
    }

    public void printAfterDiscount(EventPlanner planner) {
        System.out.println(OutputMessage.AFTER_DISCOUNT.getMessage());
        System.out.println(planner.displayAfterDiscountAmount());
    }

    public void printBadge(EventPlanner planner) {
        System.out.println(OutputMessage.EVENT_BADGE.getMessage());
        System.out.println(planner.getBadge());
    }

    public void printGift(Gift gift) {
        System.out.println(OutputMessage.GIFT_MENU.getMessage());
        System.out.println(gift.display());
        System.out.println();
    }

    public void printExceptionMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }
}
