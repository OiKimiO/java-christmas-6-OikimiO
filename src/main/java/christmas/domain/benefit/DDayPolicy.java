package christmas.domain.benefit;

import static java.lang.String.format;

import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.view.output.DomainMessage;

public class DDayPolicy extends DayPolicy {
    private static final int START_DAY = 1;
    private static final int END_DAY = 25;
    private static final int DISCOUNT_UNIT = 100;
    private final int dDayDiscount;

    public static DDayPolicy create(Payment payment, ReservationDay reservationDay){
        return new DDayPolicy(payment, reservationDay);
    }

    private DDayPolicy(Payment payment, ReservationDay reservationDay){
        this.dDayDiscount = discount(payment, reservationDay);
    }

    @Override
    public int applyDiscount(ReservationDay reservationDay) {
        if(isOverDiscountDays(reservationDay.reserveDay())){
            return this.NOT_DISCOUNT;
        }

        int addDiscount = -((reservationDay.reserveDay() - this.START_DAY) * this.DISCOUNT_UNIT);

        return this.DISCOUNT_AMOUNT + addDiscount;
    }

    private boolean isOverDiscountDays(int day) {
        return day < START_DAY || day > END_DAY;
    }

    @Override
    public int discountAmount() {
        return this.dDayDiscount;
    }

    @Override
    public String printFormat() {
        if(this.dDayDiscount == super.NOT_DISCOUNT){
            return "";
        }
        return format(DomainMessage.CHRISTMAS_DISCOUNT.getValue(),dDayDiscount);
    }
}
