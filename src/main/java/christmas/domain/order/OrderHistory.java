package christmas.domain.order;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;
import java.util.ArrayList;
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

        if(isOverTwnety()){
            throw new InputException(ExceptionType.OVER_COOKTYPE_TWENTY);
        }
    }

    private boolean isOverTwnety() {
        int totalQuantity = 0;
        for (Order order : orderHistory) {
            totalQuantity += order.quantity();
        }
        return totalQuantity > 20;
    }

    private boolean isWrongOrder() {
        List<String> orderCheck = new ArrayList<>();
        for (Order order : orderHistory) {
            String cookType = order.cookType();
            if(cookType != BEVERAGE){
                orderCheck.add(cookType);
            }
        }
        return orderCheck.size() == 0;
    }

    public StringBuilder historyFormat(){
        return new StringBuilder(orderHistory.stream()
                .map(Order::orderFormat)
                .collect(Collectors.joining()));
    }

    public Integer calculateBill() {
        int totalBill = 0;
        for (Order order : orderHistory) {
            totalBill += order.calculate();
        }
        return totalBill;
    }

    public int discount(String cookType, int discountAmount) {
        int totalDiscount = 0;
        for (Order order : orderHistory) {
            totalDiscount += order.discount(cookType, discountAmount);
        }
        return totalDiscount;
    }
}
