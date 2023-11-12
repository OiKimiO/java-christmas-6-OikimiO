package christmas.config.convert;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;

public class ConvertToInt {
    private final int value;

    public static ConvertToInt from(String value) {
        return new ConvertToInt(value);
    }

    private ConvertToInt(String value) {
        try{
            this.value = Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new InputException(ExceptionType.NOT_SEPERATE_STRING);
        }
    }

    public int get() {
        return this.value;
    }
}
