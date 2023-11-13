package christmas.config.exception;

public enum ExceptionType {
    ERROR("[ERROR] "),
    OVER_RANGE_RESERVATION_DAY(ERROR.getValue() + "유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER(ERROR.getValue() + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    QUANTITY_UNDER_ONE(ERROR.getValue() + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_FORMAT(ERROR.getValue() + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NOT_EMPTY_FORMAT(ERROR.getValue() + "공백은 들어갈 수 없습니다. 다시 입력해주세요."),
    NOT_SEPERATE_STRING(ERROR.getValue() + "입력값은 쉼표(,)로 구분하셔야 합니다. 다시 입력해주세요."),
    RIGHT_COOKTYPE(ERROR.getValue() + "음료만 주문시 주문할 수 없습니다. 다시 입력해주세요."),
    OVER_COOKTYPE_TWENTY(ERROR.getValue() + "음식은 최대 20개까지만 주문할 수 있습니다. 다시 입력해주세요.");

    private final String value;

    ExceptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
