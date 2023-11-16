package christmas.view.output;

public enum DomainMessage implements MessageType{
    PREVIEW_BENEFIT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    ORDER_MENU_FORMAT("%s %d개\n"),
    PREV_DISCOUNT_ORDER_AMOUNT("<할인 전 총주문 금액>"),
    PRESENTATION_MENU("<증정 메뉴>"),
    PRESENTATION_FORMAT("샴페인 %,d개"),
    BENEFIT_LIST("<혜택 내역>"),
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인: %,d원"),
    WEEKDAY_DISCOUNT("평일 할인: %,d원"),
    WEEKEND_DISCOUNT("주말 할인: %,d원"),
    SPECIAL_DISCOUNT("특별 할인: %,d원"),
    PRESENTATION_DISCOUNT("증정 이벤트: %,d원"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    OUTPUT_WON("%,d원"),
    AFTER_DISCOUNT_EXPECTATION_AMOUNT("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
    OUTPUT_FORMAT("%s"),
    OUTPUT_NOTHING("없음");


    private final String value;

    DomainMessage(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
