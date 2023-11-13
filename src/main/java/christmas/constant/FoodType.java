package christmas.constant;

public enum FoodType {
    APPETIZER,
    MAIN_MENU,
    DESSERT,
    BEVERAGE;

    public boolean isDessert() {
        return this == DESSERT;
    }
}
