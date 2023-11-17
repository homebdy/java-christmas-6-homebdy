package christmas.domain;

public interface DiscountPolicy {

    int getDiscountAmount(Orders orders);

    boolean isApply();

    String display();
}
