package christmas.view.output;

public enum DomainMessage implements MessageType{
    ORDER_MENU("<주문 메뉴>\n"),
    ORDER_MENU_FORMAT("%s %d개 \n"),
    PREV_DISCOUNT_ORDER_AMOUNT("\n<할인 전 총주문 금액>\n"),
    PRESENTATION_MENU("\n<증정 메뉴>\n"),
    BENEFIT_LIST("\n<혜택 내역>\n"),
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인: %d원\n"),
    WEEKDAY_DISCOUNT("평일 할인: %d원\n"),
    WEEKEND_DISCOUNT("주말 할인: %d원\n"),
    SPECIAL_DISCOUNT("특별 할인: %d원\n"),
    PRESENTATION_DISCOUNT("증정 이벤트: %d원\n"),
    TOTAL_BENEFIT_AMOUNT("\n<총혜택 금액>\n"),
    AFTER_DISCOUNT_EXPECTATION_AMOUNT("\n<할인 후 예상 결제 금액>\n"),
    DECEMBER_EVENT_BADGE("\n<12월 이벤트 배지>\n"),
    OUTPUT_FORMAT("%s\n");

    private final String value;

    DomainMessage(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
