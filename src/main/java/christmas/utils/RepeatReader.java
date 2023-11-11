package christmas.utils;

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
            } catch (IllegalArgumentException e) {

            }
        }

        return input;
    }

    private static boolean retry() {
        return true;
    }
}
