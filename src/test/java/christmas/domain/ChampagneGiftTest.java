package christmas.domain;

import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChampagneGiftTest {

    @Test
    @DisplayName("120000만원 이상 구매한 경우 샴페인 하나의 가격을 할인한다.")
    void getChampagneAmount() {
        String order = "해산물파스타-10";
        Gift gift = new Gift(Menu.CHAMPAGNE, 120000);
        Orders orders = new Orders(new Date(3), new OrderMenus(List.of(new Order(order))));
        GiftPolicy giftPolicy = new ChampagneGift();

        int giftAmount = giftPolicy.getGiftAmount(gift, orders);

        assertThat(giftAmount).isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @Test
    @DisplayName("120000원 이하 구매의 경우 증정품을 받지 못한다.")
    void receiveNothing() {
        String order = "해산물파스타-1";
        Gift gift = new Gift(Menu.CHAMPAGNE, 120000);
        Orders orders = new Orders(new Date(3), new OrderMenus(List.of(new Order(order))));
        GiftPolicy giftPolicy = new ChampagneGift();

        int giftAmount = giftPolicy.getGiftAmount(gift, orders);

        assertThat(giftAmount).isZero();
    }

    @Test
    @DisplayName("증정품을 받은 경우 true를 반환한다.")
    void notApplyGift() {
        String order = "해산물파스타-10";
        Gift gift = new Gift(Menu.CHAMPAGNE, 120000);
        Orders orders = new Orders(new Date(3), new OrderMenus(List.of(new Order(order))));
        GiftPolicy giftPolicy = new ChampagneGift();

        int giftAmount = giftPolicy.getGiftAmount(gift, orders);
        boolean isGift = giftPolicy.isApply();

        assertThat(isGift).isTrue();
    }

    @Test
    @DisplayName("증정품을 받지 못한 경우 false를 반환한다.")
    void applyGift() {
        String order = "해산물파스타-1";
        Gift gift = new Gift(Menu.CHAMPAGNE, 120000);
        Orders orders = new Orders(new Date(3), new OrderMenus(List.of(new Order(order))));
        GiftPolicy giftPolicy = new ChampagneGift();

        int giftAmount = giftPolicy.getGiftAmount(gift, orders);
        boolean isGift = giftPolicy.isApply();

        assertThat(isGift).isFalse();
    }
}
