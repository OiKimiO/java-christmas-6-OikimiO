package christmas.domain;

import christmas.domain.menu.Menu;

public class OrderHistory {
    private final Menu menu;
    private final OrderQuantity orderQuantity;

    public OrderHistory(Menu menu, OrderQuantity orderQuantity) {
        this.menu = menu;
        this.orderQuantity = orderQuantity;
    }
}
