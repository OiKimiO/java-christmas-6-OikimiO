package christmas.domain.benefit;

import static java.lang.String.format;

import christmas.domain.Payment;
import christmas.domain.ReservationDay;
import christmas.view.output.DomainMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendPolicy extends DayOfWeekPolicy {
    private static final String MAIN_DISH = "MainDish";
    private final int weekendDiscount;

    public static WeekendPolicy create(Payment payment, ReservationDay reservationDay){
        return new WeekendPolicy(payment, reservationDay);
    }

    private WeekendPolicy(Payment payment, ReservationDay reservationDay){
        this.weekendDiscount = super.discount(this.MAIN_DISH, payment, reservationDay);
    }

    @Override
    public boolean dayOfWeekRange(DayOfWeek dayOfWeek) {
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    @Override
    public int discountAmount() {
        return this.weekendDiscount;
    }

    @Override
    public String printFormat() {
        if(this.weekendDiscount == super.NOT_DISCOUNT){
            return "";
        }
        return format(DomainMessage.WEEKEND_DISCOUNT.getValue(),weekendDiscount);
    }
}
