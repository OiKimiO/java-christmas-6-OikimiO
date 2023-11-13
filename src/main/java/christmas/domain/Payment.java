package christmas.domain;

import christmas.domain.order.OrderHistory;

public class Payment {
    private static final int TOTAL_AMOUNT = 120000;
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

    public boolean isPresentation(){
        return this.payment >= TOTAL_AMOUNT;
    }

    public boolean isBadge(int badgeStandard){
        return this.payment >= badgeStandard;
    }
}
