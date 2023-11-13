package christmas.domain;

public interface DiscountPolicy {

    int getDiscountAmount(EventPlanner eventPlanner);

    int display();
}
