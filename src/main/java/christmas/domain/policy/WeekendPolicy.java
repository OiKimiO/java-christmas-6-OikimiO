package christmas.domain.policy;

import christmas.domain.Payment;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendPolicy {
    private static final String MAINDISH = "MainDish";
    private static final LocalDate STANDARD_DATE = LocalDate.parse("2023-12-01");
    private static final int NOT_DISCOUNT = 0;
    private final int weekendDiscount;

    public static WeekendPolicy create(Payment payment, int day){
        return new WeekendPolicy(payment, day);
    }

    public WeekendPolicy(Payment payment, int day){
        DayOfWeek dayOfWeek = dayOfWeekAfterDays(day);

        this.weekendDiscount = discountCost(payment, dayOfWeek);
    }

    public DayOfWeek dayOfWeekAfterDays(int day) {
        LocalDate targetDate = this.STANDARD_DATE.plusDays(day);

        DayOfWeek dayOfWeek = targetDate.getDayOfWeek();
        return dayOfWeek;
    }

    private int discountCost(Payment payment, DayOfWeek dayOfWeek) {
        if(ifWeekDay(dayOfWeek)){
            return this.NOT_DISCOUNT;
        }

        return payment.discount(this.MAINDISH);
    }

    private boolean ifWeekDay(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    public int weekendDiscount() {
        return this.weekendDiscount;
    }
}
