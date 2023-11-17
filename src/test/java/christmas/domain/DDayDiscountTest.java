package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DDayDiscountTest {
    
    @Test
    @DisplayName("12월 1일부터 디데이 할인 이벤트를 1000원부터 시작한다.")
    void getDiscountAmount() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(1), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy dDayDiscountPolicy = new DDayDiscount();

        int discountAmount = dDayDiscountPolicy.getDiscountAmount(orders);

        assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("1000원부터 매일 100원씩 증가해 25일에는 3400원을 할인한다.")
    void getChristmasDDayDiscount() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(25), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy dDayDiscountPolicy = new DDayDiscount();

        int discountAmount = dDayDiscountPolicy.getDiscountAmount(orders);

        assertThat(discountAmount).isEqualTo(3400);
    }

    @Test
    @DisplayName("크리스마스 이후에는 디데이 할인을 진행하지 않는다.")
    void notApplyDiscount() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(26), new OrderMenus(List.of(new Order(order))));
        DiscountPolicy dDayDiscountPolicy = new DDayDiscount();

        int discountAmount = dDayDiscountPolicy.getDiscountAmount(orders);

        assertThat(discountAmount).isZero();
    }
}
