package christmas.service;

import christmas.domain.Orders;

public class ChristmasService {

    private final Orders orders;

    public ChristmasService(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }
}
