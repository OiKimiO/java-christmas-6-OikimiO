package christmas.domain.benefit;

import static java.lang.String.format;

import christmas.domain.order.Payment;
import christmas.domain.order.ReservationDay;
import christmas.view.output.DomainMessage;
import java.time.DayOfWeek;

public class WeekDayPolicy extends DayOfWeekPolicy {
    private static final String DESSERT = "Dessert";
    private final int weekDayDiscount;

    public static WeekDayPolicy create(Payment payment, ReservationDay reservationDay){
        return new WeekDayPolicy(payment, reservationDay);
    }

    private WeekDayPolicy(Payment payment, ReservationDay reservationDay){
        this.weekDayDiscount = super.discount(this.DESSERT, payment, reservationDay);
    }

    @Override
    public boolean dayOfWeekRange(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    @Override
    public int discountAmount() {
        return this.weekDayDiscount;
    }

    @Override
    public String printFormat() {
        if(this.weekDayDiscount == super.NOT_DISCOUNT){
            return "";
        }
        return format(DomainMessage.WEEKDAY_DISCOUNT.getValue(),weekDayDiscount);
    }
}
