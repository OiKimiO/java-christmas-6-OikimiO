package christmas.domain.policy;

import christmas.domain.order.OrderHistory;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendPolicy {
    private static final String MAINDISH = "MainDish";
    private static final LocalDate STANDARD_DATE = LocalDate.parse("2023-12-01");
    private static final int NOT_DISCOUNT = 0;
    private final int weekendDiscount;

    public WeekendPolicy(OrderHistory orderHistory, int day){
        DayOfWeek dayOfWeek = dayOfWeekAfterDays(day);

        this.weekendDiscount = discountCost(orderHistory, dayOfWeek);
    }

    public DayOfWeek dayOfWeekAfterDays(int day) {
        LocalDate targetDate = this.STANDARD_DATE.plusDays(day);

        DayOfWeek dayOfWeek = targetDate.getDayOfWeek();
        return dayOfWeek;
    }

    private int discountCost(OrderHistory orderHistory, DayOfWeek dayOfWeek) {
        if(ifWeekDay(dayOfWeek)){
            return this.NOT_DISCOUNT;
        }

        return orderHistory.discount(this.MAINDISH);
    }

    private boolean ifWeekDay(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }
}
