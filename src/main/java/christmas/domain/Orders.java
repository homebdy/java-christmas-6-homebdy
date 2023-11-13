package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final List<Order> elements;

    public Orders(List<Order> elements) {
        this.elements = new ArrayList<>(elements);
    }
}
