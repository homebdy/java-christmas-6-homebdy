package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.OutputMessage;

public class Gift {

    private static final int DEFAULT_COUNT = 0;
    private final Menu menu;
    private final int applicationPrice;
    private int quantity;

    public Gift(Menu menu, int applicationPrice) {
        this.menu = menu;
        this.applicationPrice = applicationPrice;
        this.quantity = DEFAULT_COUNT;
    }

    public void addGift() {
        quantity++;
    }

    public int getGiftPrice() {
        return quantity * menu.getPrice();
    }

    public boolean isGift(int price) {
        return price >= applicationPrice;
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
