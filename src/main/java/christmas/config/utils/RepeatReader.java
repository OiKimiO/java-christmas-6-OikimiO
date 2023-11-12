package christmas.config.utils;

import christmas.config.exception.InputException;
import java.util.function.Supplier;

public class RepeatReader {
    private RepeatReader() {

    }

    public static <T> T read(Supplier<T> supplier) {
        T input = null;

        while(retry()){
            try {
                input = supplier.get();
                break;
            } catch (InputException e) {

            }
        }

        return input;
    }

    private static boolean retry() {
        return true;
    }
}
