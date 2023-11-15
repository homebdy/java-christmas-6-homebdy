package christmas.domain;

import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {

    @Test
    @DisplayName("주문한 메뉴의 총 금액을 반환한다.")
    void getTotalPrice() {
        String order = "해산물파스타-1";
        Orders orders = new Orders(new Date(25), new OrderMenus(List.of(new Order(order))));

        int total = orders.getTotalPrice();

        assertThat(total).isEqualTo(Menu.SEAFOOD_PASTA.getPrice());
    }

    @Test
    @DisplayName("주문한 메뉴 중 디저트 메뉴의 개수를 반환한다.")
    void getDessertCount() {
        String order = "해산물파스타-1";
        String dessert = "초코케이크-3";
        Orders orders = new Orders(new Date(25), new OrderMenus(List.of(new Order(order), new Order(dessert))));

        int count = orders.getDessertMenuCount();

        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("주문한 메뉴 중 메인 메뉴의 개수를 반환한다.")
    void getMainMenuCount() {
        String order = "해산물파스타-1";
        String dessert = "초코케이크-3";
        Orders orders = new Orders(new Date(25), new OrderMenus(List.of(new Order(order), new Order(dessert))));

        int count = orders.getMainMenuCount();

        assertThat(count).isEqualTo(1);
    }
}
