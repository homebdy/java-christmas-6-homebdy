package christmas.service;

import christmas.domain.Orders;

public class OrderService {

    private final Orders orders;

    public OrderService(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }
}
