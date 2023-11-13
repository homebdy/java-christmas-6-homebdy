package christmas.constant;

import java.util.Arrays;

public enum Menu {

    SOUP(FoodType.APPETIZER, "양송이수프", 6000),
    TAPAS(FoodType.APPETIZER, "타파스", 5500),
    SALAD(FoodType.APPETIZER, "시저샐러드", 8000),
    STEAK(FoodType.MAIN_MENU, "티본스테이크", 55000),
    RIBS(FoodType.MAIN_MENU, "바비큐립", 54000),
    SEAFOOD_PASTA(FoodType.MAIN_MENU, "해산물파스타", 35000),
    CHRISTMAS_PASTA(FoodType.MAIN_MENU, "크리스마스파스타", 25000),
    CAKE(FoodType.DESSERT, "초코케이크", 15000),
    ICE_CREAM(FoodType.DESSERT, "아이스크림", 5000),
    COLA(FoodType.BEVERAGE, "제로콜라", 3000),
    WINE(FoodType.BEVERAGE, "레드와인", 60000),
    CHAMPAGNE(FoodType.BEVERAGE, "샴페인", 25000);

    private final FoodType foodType;
    private final String name;
    private final int price;

    Menu(FoodType foodType, String name, int price) {
        this.foodType = foodType;
        this.name = name;
        this.price = price;
    }

    public static Menu getMenu(String input) {
        return Arrays.stream(Menu.values())
                .filter(value -> value.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_MENU.getMessage()));
    }

    public String getName() {
        return this.name;
    }

    public boolean isDessert() {
        return foodType.isDessert();
    }

    public boolean isMainMenu() {
        return foodType.isMainMenu();
    }

    public int getPrice() {
        return price;
    }
}
