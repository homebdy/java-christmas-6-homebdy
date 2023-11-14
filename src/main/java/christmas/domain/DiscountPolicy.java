package christmas.domain;

public interface DiscountPolicy {

    int getDiscountAmount(EventPlanner eventPlanner);

    boolean isApply();

    String display();
}
