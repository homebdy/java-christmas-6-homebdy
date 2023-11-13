package christmas.constant;

import java.util.Arrays;

public enum Badge {

    SANTA(20000, "산타"),
    TREE(10000, "트리"),
    START(5000, "별"),
    NONE(0, "없음");

    private final int start;
    private final String name;

    Badge(int start, String name) {
        this.start = start;
        this.name = name;
    }

    public static Badge getBadge(int price) {
        return Arrays.stream(Badge.values())
                .filter(value -> value.start <= price)
                .findFirst()
                .orElse(Badge.NONE);
    }

    public String getName() {
        return name;
    }
}
