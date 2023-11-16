package christmas.config.exception;

import christmas.view.output.OutputView;

public class InputException extends IllegalArgumentException{
    public InputException(ExceptionType exceptionType) {
        super(exceptionType.getValue());
    }


}
