package christmas.domain;

import christmas.domain.order.OrderHistory;

public class Payment {
    private final Integer payment;

    public static Payment create(OrderHistory orderHistory){
        return new Payment(orderHistory);
    }

    private Payment(OrderHistory orderHistory){
        payment = orderHistory.calculateBill();
    }

    public Integer payment(){
        return this.payment;
    }
}
