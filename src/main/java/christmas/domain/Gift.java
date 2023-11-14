package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.OutputMessage;

public class Gift {

    private static final int DEFAULT_COUNT = 0;
    private final Menu menu;
    private int quantity;

    public Gift(Menu menu) {
        this.menu = menu;
        this.quantity = DEFAULT_COUNT;
    }

    public void addGift() {
        quantity++;
    }

    public int getGiftPrice() {
        return quantity * menu.getPrice();
    }

    public String display() {
        if (quantity == DEFAULT_COUNT) {
            return OutputMessage.NOTHING.getMessage();
        }
        return menu.getName() +
                OutputMessage.SPACE.getMessage() +
                quantity +
                OutputMessage.COUNT.getMessage();
    }
}
