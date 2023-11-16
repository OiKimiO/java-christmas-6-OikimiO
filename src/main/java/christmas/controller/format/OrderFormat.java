package christmas.controller.format;

import christmas.config.exception.ExceptionType;
import christmas.config.exception.InputException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class OrderFormat {
    private static final Pattern pattern = Pattern.compile("^[가-힣]+-[0-9]+$");

    public static void validate(String[] orderHistory) {
        if (isRetryFormat(orderHistory)) {
            throw new InputException(ExceptionType.INVALID_ORDER_FORMAT);
        }

        if(isEmpty(orderHistory)){
            throw new InputException(ExceptionType.NOT_EMPTY_FORMAT);
        }
    }

    private static boolean isRetryFormat(String[] orderHistory) {
        return Arrays.stream(orderHistory)
                .noneMatch(order -> pattern.matcher(order).matches());
    }

    private static boolean isEmpty(String[] orderHistory) {
        return Arrays.stream(orderHistory)
                .allMatch(order -> order.isEmpty());
    }


}
