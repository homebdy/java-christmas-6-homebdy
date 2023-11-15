package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderMenusTest {

    @Test
    @DisplayName("음료만 주문한 경우 예외를 발생시킨다.")
    void validateOrderIsOnlyBeverage() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("레드와인-1"));

        assertThatThrownBy(() -> new OrderMenus(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("20개 이상 주문한 경우 예외를 발생시킨다.")
    void validateMaxOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("해산물파스타-21"));

        assertThatThrownBy(() -> new OrderMenus(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("중복 메뉴를 주문한 경우 예외를 발생시킨다.")
    void validateDuplicateMenu() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("해산물파스타-3"));
        orders.add(new Order("해산물파스타-1"));

        assertThatThrownBy(() -> new OrderMenus(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
