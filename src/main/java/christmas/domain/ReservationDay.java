package christmas.domain;

import static java.lang.String.format;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;
import christmas.view.output.InputMessage;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ReservationDay {
    private static final LocalDate STANDARD_DATE = LocalDate.parse("2023-12-01");
    private static final int START_DAY = 1;
    private static final int END_DAY = 31;
    private final int day;

    public static ReservationDay create(int day){
        return new ReservationDay(day);
    }

    private ReservationDay(int day){
        validate(day);
        this.day = day;
    }

    private void validate(int day) {
        if(isOverDayRange(day)){
            throw new InputException(ExceptionType.OVER_RANGE_RESERVATION_DAY);
        }
    }

    private boolean isOverDayRange(int day) {
        return isLower(day) && isHigher(day);
    }

    private boolean isLower(int day) {
        return day < START_DAY;
    }

    private boolean isHigher(int day) {
        return day > END_DAY;
    }

    public int reserveDay(){
        return this.day;
    }

    public String printFormat(){
        return format(InputMessage.INPUT_FORMAT.getValue(), this.day);
    }

    public DayOfWeek dayOfWeekAfterDays() {
        LocalDate targetDate = this.STANDARD_DATE.plusDays(day);

        DayOfWeek dayOfWeek = targetDate.getDayOfWeek();
        return dayOfWeek;
    }
}
