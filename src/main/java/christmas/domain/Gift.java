package christmas.domain;

import christmas.constant.Menu;

public class Gift {

    private final Menu menu;
    private int quantity = 0;

    public Gift(Menu menu) {
        this.menu = menu;
    }

    public void addGift() {
        quantity++;
    }

    public int getGiftPrice() {
        return quantity * menu.getPrice();
    }
}
