package christmas.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Calender {

    MONDAY(List.of(4, 11, 18, 25)),
    TUESDAY(List.of(5, 12, 19, 26)),
    WEDNESDAY(List.of(6, 13, 20, 27)),
    THURSDAY(List.of(7, 14, 21, 28)),
    FRIDAY(List.of(1, 8, 15, 22, 29)),
    SATURDAY(List.of(2, 9, 16, 23, 30)),
    SUNDAY(List.of(3, 10, 17, 24, 31));

    private final List<Integer> elements;

    Calender(List<Integer> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public static boolean isWeekDay(int number) {
        Calender day = Arrays.stream(Calender.values())
                .filter(value -> value.elements.contains(number))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(ExceptionMessage.INVALID_DATE.getMessage()));
        return day != SATURDAY && day != FRIDAY;
    }
}
