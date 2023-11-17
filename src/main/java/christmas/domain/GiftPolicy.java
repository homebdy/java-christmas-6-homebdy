package christmas.domain;

public interface GiftPolicy {

    int getGiftAmount(Gift gift, Orders orders);

    boolean isApply();

    String display();
}
