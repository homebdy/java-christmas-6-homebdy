package christmas.domain;

import christmas.constant.Calender;
import christmas.constant.ExceptionMessage;

public class Date {

    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int D_DAY = 25;
    private final int value;

    public Date(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (!(START_DATE <= value && value <= END_DATE)) {
            ExceptionMessage message = ExceptionMessage.INVALID_DATE;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public boolean isBeforeChristmas() {
        return START_DATE <= value && value <= D_DAY;
    }

    public int getDifferenceDDay() {
        return value - START_DATE;
    }

    public boolean isWeekDay() {
        return Calender.isWeekDay(value);
    }

    public boolean isWeekend() {
        return Calender.isWeekend(value);
    }
}
