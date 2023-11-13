package christmas.domain;

public class Bill {

    private int amount;

    public Bill(int amount) {
        this.amount = amount;
    }

    public void applyDiscount(DiscountPolicy discountPolicy, EventPlanner planner) {
        amount -= discountPolicy.getDiscountAmount(planner);
    }

    public int getAmount() {
        return amount;
    }
}
