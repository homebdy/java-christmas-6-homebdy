package christmas.domain;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dDayDiscount.display());
        stringBuilder.append(giftDiscount.display());
        return stringBuilder.toString();
    }
}
