package christmas.view.output;

import static java.lang.String.format;

import christmas.view.output.MessageType;

public class OutputView {
    private OutputView() {
    }

    public static void print(final MessageType messageType) {
        printMessage(messageType.getValue());
    }

    public static void printf(final MessageType messageType, final Object... inputNames) {
        printMessage(format(messageType.getValue(), inputNames));
    }

    private static void printMessage(String message) {
        System.out.print(message);
    }
}
