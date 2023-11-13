package christmas.view.output;

public enum DomainMessage implements MessageType{
    ORDER_MENU("<주문 메뉴>\n"),
    ORDER_MENU_FORMAT("%s %d개 \n"),
    PREV_DISCOUNT_ORDER_AMOUNT("<할인 전 총주문 금액>\n"),
    PRESENTATION_MENU("<증정 메뉴>\n"),
    BENEFIT_LIST("<혜택 내역>\n"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>\n"),
    AFTER_DISCOUNT_EXPECTION_AMOUNT("<할인 후 예상 결제 금액>\n"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>\n"),
    OUTPUT_FORMAT("%s\n")
    ;

    private final String value;

    DomainMessage(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
