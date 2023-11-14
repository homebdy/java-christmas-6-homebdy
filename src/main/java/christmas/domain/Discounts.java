package christmas.domain;

import christmas.constant.OutputMessage;

public class Discounts {

    private final DiscountPolicy dDayDiscount = new DDayDiscount();
    private final DiscountPolicy weekdayDiscount = new WeekdayDiscount();
    private final DiscountPolicy weekendDiscount = new WeekendDiscount();
    private final DiscountPolicy specialDiscount = new SpecialDiscount();
    private final DiscountPolicy giftDiscount = new GiftDiscount();

    public DiscountPolicy getDDayDiscount() {
        return dDayDiscount;
    }

    public DiscountPolicy getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public DiscountPolicy getWeekendDiscount() {
        return weekendDiscount;
    }

    public DiscountPolicy getSpecialDiscount() {
        return specialDiscount;
    }

    public DiscountPolicy getGiftDiscount() {
        return giftDiscount;
    }

    public String display() {
        if (!hasApplyDiscount()) {
            return OutputMessage.NOTHING.getMessage();
        }
        StringBuilder stringBuilder = new StringBuilder();
        appendDDayDiscount(stringBuilder);
        appendWeekdayDiscount(stringBuilder);
        appendWeekendDiscount(stringBuilder);
        appendSpecialDiscount(stringBuilder);
        appendGiftDiscount(stringBuilder);
        return stringBuilder.toString();
    }

    private boolean hasApplyDiscount() {
        return dDayDiscount.isApply() || weekdayDiscount.isApply() || weekendDiscount.isApply()
                || specialDiscount.isApply() || giftDiscount.isApply();
    }

    private void appendDDayDiscount(StringBuilder stringBuilder) {
        if (dDayDiscount.isApply()) {
            stringBuilder.append(dDayDiscount.display());
        }
    }

    private void appendWeekdayDiscount(StringBuilder stringBuilder) {
        if (weekdayDiscount.isApply()) {
            stringBuilder.append(weekdayDiscount.display());
        }
    }

    private void appendWeekendDiscount(StringBuilder stringBuilder) {
        if (weekendDiscount.isApply()) {
            stringBuilder.append(weekendDiscount.display());
        }
    }

    private void appendSpecialDiscount(StringBuilder stringBuilder) {
        if (specialDiscount.isApply()) {
            stringBuilder.append(specialDiscount.display());
        }
    }

    private void appendGiftDiscount(StringBuilder stringBuilder) {
        if (giftDiscount.isApply()) {
            stringBuilder.append(giftDiscount.display());
        }
    }
}
