package christmas.domain;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;

public class ReservationDay {
    private static final int START_DAY = 1;
    private static final int END_DAY = 31;
    private final int day;

    public ReservationDay(int day){
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
}
