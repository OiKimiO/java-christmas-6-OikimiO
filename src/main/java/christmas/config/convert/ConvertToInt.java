package christmas.config.convert;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;
import christmas.view.output.OutputView;

public class ConvertToInt {
    private final int value;

    public static ConvertToInt from(String value) {
        return new ConvertToInt(value);
    }

    private ConvertToInt(String value) {
        try{
            this.value = Integer.parseInt(value);
        }catch (NumberFormatException e){
            OutputView.print(ExceptionType.OVER_RANGE_RESERVATION_DAY);
            throw new InputException(ExceptionType.OVER_RANGE_RESERVATION_DAY);
        }
    }

    public int get() {
        return this.value;
    }
}
