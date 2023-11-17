package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpeacialDiscountTest {

    @Test
    @DisplayName("특별 할인에 포함되는 날짜일 경우 1,000원을 할인한다.")
    void discountAtSpecialDay() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(25), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy specialDiscount = new SpecialDiscount();

        int discountAmount = specialDiscount.getDiscountAmount(orders);

        assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("특별 할인에 포함되는 날짜가 아닐 경우 0원을 할인한다.")
    void notDiscountAtNotSpecialDay() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy specialDiscount = new SpecialDiscount();

        int discountAmount = specialDiscount.getDiscountAmount(orders);

        assertThat(discountAmount).isZero();
    }
}
