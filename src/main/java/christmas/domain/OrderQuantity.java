package christmas.domain;

import christmas.domain.menu.Menu;
import java.util.Map;

public class OrderQuantity {
    private final Map<String, Integer> orderHistory;
    private final Menu menu;

    public OrderQuantity(Map<String, Integer> orderHistory, Menu menu) {
        this.orderHistory = orderHistory;
        this.menu = menu;
    }
}
