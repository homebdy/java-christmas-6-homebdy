package christmas.constant;

import java.util.Arrays;

public enum SpecialDay {

    THREE(3),
    TEN(10),
    SEVENTEEN(17),
    TWENTY_FOUR(24),
    TWENTY_FIVE(25),
    THIRTY_ONE(31);

    private final int day;

    SpecialDay(int day) {
        this.day = day;
    }

    public static boolean isSpecialDay(int day) {
        return Arrays.stream(SpecialDay.values())
                .anyMatch(value -> value.day == day);
    }
}
