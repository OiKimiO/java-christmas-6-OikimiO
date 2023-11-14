package christmas.domain.benefit;

import christmas.domain.Payment;
import christmas.domain.ReservationDay;

public abstract class DayPolicy implements DiscountAmount{
    protected final int DISCOUNT_AMOUNT = -1000;
    protected final int NOT_DISCOUNT = 0;

    protected int discount(Payment payment, ReservationDay reservationDay){
        int discountAmount = 0;

        if(payment.isApplyEvent()){
            discountAmount = applyDiscount(reservationDay);
        }

        return discountAmount;
    }

    public abstract int applyDiscount(ReservationDay reservationDay);
}
