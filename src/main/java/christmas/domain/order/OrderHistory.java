package christmas.domain.order;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory {
    private static final String BEVERAGE = "Beverage";
    private final List<Order> orderHistory;

    public static OrderHistory create(String[] orders) {
        return new OrderHistory(orders);
    }

    private OrderHistory(String[] orders) {
        this.orderHistory = Arrays.stream(orders)
                .map(order -> Order.create(order))
                .collect(Collectors.toList());
        validate();
    }

    private void validate() {
        if(isWrongOrder()){
            throw new InputException(ExceptionType.RIGHT_COOKTYPE);
        }

        if(isOverTwenty()){
            throw new InputException(ExceptionType.OVER_COOKTYPE_TWENTY);
        }
    }

    private boolean isOverTwenty() {
        int totalQuantity = orderHistory.stream()
                .mapToInt(Order::quantity)
                .sum();
        return totalQuantity > 20;
    }

    private boolean isWrongOrder() {
        List<String> orderCheck = orderHistory.stream()
                .map(Order::cookType)
                .filter(cookType -> !BEVERAGE.equals(cookType))
                .collect(Collectors.toList());
        return orderCheck.isEmpty();
    }

    public StringBuilder historyFormat() {
        return new StringBuilder(orderHistory.stream()
                .map(Order::orderFormat)
                .collect(Collectors.joining()));
    }

    public Integer calculateBill() {
        return orderHistory.stream()
                .map(Order::calculate)
                .reduce(0, Integer::sum);
    }

    public int discount(String cookType, int discountAmount) {
        return orderHistory.stream()
                .mapToInt(order -> order.discount(cookType, discountAmount))
                .sum();
    }
}
