package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeekendDiscountTest {

    @Test
    @DisplayName("주말 할인에 포함되는 날짜일 경우 메인 메뉴 하나당 2023원을 할인한다.")
    void discountAtWeekday() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy weekendDiscount = new WeekendDiscount();

        int discountAmount = weekendDiscount.getDiscountAmount(orders);

        assertThat(discountAmount).isEqualTo(2023);
    }

    @Test
    @DisplayName("주말 할인에 포함되지 않는 날짜일 경우 할인을 적용하지 않는다.")
    void notDiscountAtWeekday() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(5), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy weekendDiscount = new WeekendDiscount();

        int discountAmount = weekendDiscount.getDiscountAmount(orders);

        assertThat(discountAmount).isZero();
    }
}
