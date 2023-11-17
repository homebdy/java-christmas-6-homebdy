package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventPlannerTest {

    @Test
    @DisplayName("할인 정책을 통해 혜택 금액을 계산한다.")
    void applyDiscount() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy dDayDiscountPolicy = new DDayDiscount();
        EventPlanner planner = new EventPlanner(orders);

        planner.applyDiscount(dDayDiscountPolicy);
        String result = planner.displayBenefit();

        assertThat(result).contains("1,000");
    }

    @Test
    @DisplayName("증정 정책을 통해 혜택 금액을 계산한다.")
    void applyGift() {
        String order = "해산물파스타-10";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        GiftPolicy champagneGift = new ChampagneGift();
        EventPlanner planner = new EventPlanner(orders);

        planner.applyGift(champagneGift);
        String result = planner.displayBenefit();

        assertThat(result).contains("25,000");
    }

    @Test
    @DisplayName("20,000원이상 할인 받은 경우 산타 배지를 받는다.")
    void giveSantaBadge() {
        String order = "해산물파스타-10";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        GiftPolicy champagneGift = new ChampagneGift();
        EventPlanner planner = new EventPlanner(orders);
        planner.applyGift(champagneGift);

        String badge = planner.getBadge();

        assertThat(badge).contains("산타");
    }

    @Test
    @DisplayName("10,000원이상 할인 받은 경우 트리 배지를 받는다.")
    void giveTreeBadge() {
        String order = "해산물파스타-5";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy weekendDiscount = new WeekendDiscount();
        EventPlanner planner = new EventPlanner(orders);
        planner.applyDiscount(weekendDiscount); // 총 10,115원 할인

        String badge = planner.getBadge();

        assertThat(badge).contains("트리");
    }

    @Test
    @DisplayName("5,000원이상 할인 받은 경우 별 배지를 받는다.")
    void giveStartBadge() {
        String order = "해산물파스타-3";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy weekendDiscount = new WeekendDiscount();
        EventPlanner planner = new EventPlanner(orders);
        planner.applyDiscount(weekendDiscount); // 총 6,069원 할인

        String badge = planner.getBadge();

        assertThat(badge).contains("별");
    }
}
