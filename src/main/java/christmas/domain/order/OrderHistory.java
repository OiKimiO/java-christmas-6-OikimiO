package christmas.domain.order;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory {
    private final List<Order> orderHistory;

    public static OrderHistory create(String[] orders) {
        return new OrderHistory(orders);
    }

    private OrderHistory(String[] orders) {
        this.orderHistory = Arrays.stream(orders)
                .map(order -> Order.create(order))
                .collect(Collectors.toList());
    }


}
