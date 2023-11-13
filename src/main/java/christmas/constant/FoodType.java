package christmas.constant;

public enum FoodType {
    APPETIZER,
    MAIN_MENU,
    DESSERT,
    BEVERAGE;

    public boolean isDessert() {
        return this == DESSERT;
    }

    public boolean isMainMenu() {
        return this == MAIN_MENU;
    }
}
