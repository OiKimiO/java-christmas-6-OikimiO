package christmas.domain.benefit;

import static java.lang.String.format;

import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import christmas.view.output.DomainMessage;
import java.util.Arrays;
import java.util.List;

public class SpecialDayPolicy extends DayPolicy{
    private final List<Integer> specialDay = Arrays.asList(3,10,17,24,25,31);
    private final int specialDiscount;

    public static SpecialDayPolicy create(Payment payment, ReservationDay reservationDay){
        return new SpecialDayPolicy(payment, reservationDay);
    }

    private SpecialDayPolicy(Payment payment, ReservationDay reservationDay){
        this.specialDiscount = super.discount(payment, reservationDay);
    }

    @Override
    public int applyDiscount(ReservationDay reservationDay) {
        if(specialDay.contains(reservationDay.reserveDay())){
            return this.DISCOUNT_AMOUNT;
        }
        return super.NOT_DISCOUNT;
    }

    @Override
    public int discountAmount() {
        return this.specialDiscount;
    }

    @Override
    public String printFormat() {
        if(this.specialDiscount == super.NOT_DISCOUNT){
            return "";
        }
        return format(DomainMessage.SPECIAL_DISCOUNT.getValue(),specialDiscount);
    }
}
