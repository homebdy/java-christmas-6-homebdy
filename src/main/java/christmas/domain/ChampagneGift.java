package christmas.domain;

import christmas.constant.OutputMessage;

public class ChampagneGift implements GiftPolicy {

    private static final int DEFAULT_COUNT = 0;
    private int discountAmount = 0;

    @Override
    public int getGiftAmount(Gift gift, Orders orders) {
        if (gift.isGift(orders.getTotalPrice())) {
            gift.addGift();
            discountAmount = gift.getGiftPrice();
        }
        return discountAmount;
    }

    @Override
    public boolean isApply() {
        return discountAmount != DEFAULT_COUNT;
    }

    @Override
    public String display() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OutputMessage.PRESENT_DISCOUNT.getMessage())
                .append(String.format(OutputMessage.AMOUNT.getMessage(), discountAmount));
        return stringBuilder.toString();
    }
}
