package christmas.config.exception;

public enum ExceptionType {
    ERROR("[ERROR] "),
    OVER_RANGE_RESERVATION_DAY(ERROR.getValue() + "유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private final String value;

    ExceptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
