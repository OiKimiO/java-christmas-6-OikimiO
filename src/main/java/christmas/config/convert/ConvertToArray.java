package christmas.config.convert;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;

public class ConvertToArray {
    String[] values;

    public static ConvertToArray from(String value){
        return new ConvertToArray(value);
    }

    private ConvertToArray(String value){
        try{
            values = value.split(",");
        }catch (NumberFormatException e){
            throw new InputException(ExceptionType.NOT_SEPERATE_STRING);
        }
    }

    public String[] get(){
        return values;
    }
}
