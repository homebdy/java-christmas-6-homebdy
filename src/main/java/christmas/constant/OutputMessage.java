package christmas.constant;

public enum OutputMessage {

    START_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    READ_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    READ_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIFT_MENU("<증정 메뉴>"),
    AMOUNT("%,d원\n"),
    ORDER_MENU("<주문 메뉴>"),
    BENEFIT_AMOUNT("<총혜택 금액>"),
    BENEFIT_CONTENT("<혜택 내역>"),
    D_DAY_DISCOUNT("크리스마스 디데이 할인: -"),
    PRESENT_DISCOUNT("증정 이벤트: -"),
    SPECIAL_DISCOUNT("특별 할인: -"),
    WEEKDAY_DISCOUNT("평일 할인: -"),
    WEEKEND_DISCOUNT("주말 할인: -"),
    NOTHING("없음\n"),
    AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>"),
    COUNT("개"),
    SPACE(" "),
    NEW_LINE("\n"),
    DISCOUNT_DISPLAY("-");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
