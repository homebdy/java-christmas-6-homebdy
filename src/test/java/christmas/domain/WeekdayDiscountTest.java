package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WeekdayDiscountTest {

    @Test
    @DisplayName("평일 할인에 포함되는 날짜일 경우 디저트 메뉴 하나당 2023원을 할인한다.")
    void discountAtWeekday() {
        String order = "초코케이크-1";
        Orders orders = new Orders(new Date(6), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy weekdayDiscount = new WeekdayDiscount();

        int discountAmount = weekdayDiscount.getDiscountAmount(orders);

        assertThat(discountAmount).isEqualTo(2023);
    }

    @Test
    @DisplayName("평일 할인에 포함되는 날짜가 아닐 경우 할인을 적용하지 않는다.")
    void notDiscountAtWeekend() {
        String order = "초코케이크-1";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy weekdayDiscount = new WeekdayDiscount();

        int discountAmount = weekdayDiscount.getDiscountAmount(orders);

        assertThat(discountAmount).isZero();
    }
}
