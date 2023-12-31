package christmas.domain.order;

public class Payment {
    private static final int TOTAL_AMOUNT = 120000;
    private static final int DISCOUNT_CONDITION = 10000;
    private OrderHistory orderHistory;
    private final Integer payment;

    public static Payment create(OrderHistory orderHistory){
        return new Payment(orderHistory);
    }

    private Payment(OrderHistory orderHistory){
        this.orderHistory = orderHistory;
        this.payment = this.orderHistory.calculateBill();
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

    public boolean isApplyEvent() {
        return this.payment >= this.DISCOUNT_CONDITION;
    }

    public int discount(String cookType, int discountAmount) {
        return this.orderHistory.discount(cookType, discountAmount);
    }

    public int finalPay(int realDiscount){
        return payment + realDiscount;
    }
}
