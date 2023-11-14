package christmas.domain.benefit;

import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import java.time.DayOfWeek;

public abstract class DayOfWeekPolicy implements DiscountAmount{
    public static final int NOT_DISCOUNT = 0;
    private static final int DISCOUNT_AMOUNT = -2023;

    public int discount(String cookType, Payment payment, ReservationDay reservationDay){
        DayOfWeek dayOfWeek = reservationDay.dayOfWeekAfterDays();

        int dayOfWeekDiscount = 0;

        if(payment.isApplyEvent()){
            dayOfWeekDiscount = applyDiscount(cookType, payment, dayOfWeek);
        }

        return dayOfWeekDiscount;
    }

    private int applyDiscount(String cookType, Payment payment, DayOfWeek dayOfWeek) {
        if(dayOfWeekRange(dayOfWeek)){
            return payment.discount(cookType, this.DISCOUNT_AMOUNT);
        }

        return this.NOT_DISCOUNT;
    }


    public abstract boolean dayOfWeekRange(DayOfWeek dayOfWeek);
}
