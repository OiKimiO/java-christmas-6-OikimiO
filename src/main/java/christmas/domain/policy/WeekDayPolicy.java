package christmas.domain.policy;

import christmas.domain.Payment;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekDayPolicy {
    private static final String DESSERT = "Dessert";
    private static final LocalDate STANDARD_DATE = LocalDate.parse("2023-12-01");
    private static final int NOT_DISCOUNT = 0;
    private final int WeekDayDiscount;

    public static WeekDayPolicy create(Payment payment, int day){
        return new WeekDayPolicy(payment, day);
    }

    private WeekDayPolicy(Payment payment, int day){
        DayOfWeek dayOfWeek = dayOfWeekAfterDays(day);

        this.WeekDayDiscount = discountCost(payment, dayOfWeek);
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

        return payment.discount(this.DESSERT);
    }

    private boolean ifWeekDay(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    public int weekDayDiscount() {
        return this.WeekDayDiscount;
    }
}
