package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DateTest {

    @Test
    @DisplayName("1~31 사이의 숫자를 입력하지 않을 경우 예외 발생")
    void getChristmasDDayDiscount() {
        int day = 32;

        assertThatThrownBy(() -> new Date(day))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("날짜가 크리스마스 이전일 경우 true를 반환한다.")
    void returnTrueBeforeChristmas() {
        Date date = new Date(1);

        boolean isBeforeChristmas = date.isBeforeChristmas();

        assertThat(isBeforeChristmas).isTrue();
    }

    @Test
    @DisplayName("날짜가 크리스마스 이후일 경우 false를 반환한다.")
    void returnFalseAfterChristmas() {
        Date date = new Date(26);

        boolean isBeforeChristmas = date.isBeforeChristmas();

        assertThat(isBeforeChristmas).isFalse();
    }

    @Test
    @DisplayName("평일일 경우 true를 반환한다.")
    void returnTrueAtWeekday() {
        Date date = new Date(4);

        boolean isWeekday = date.isWeekDay();

        assertThat(isWeekday).isTrue();
    }

    @Test
    @DisplayName("평일이 아닐 경우 flase를 반환한다.")
    void returnFalseAtWeekend() {
        Date date = new Date(1);

        boolean isWeekday = date.isWeekDay();

        assertThat(isWeekday).isFalse();
    }

    @Test
    @DisplayName("주말일 경우 true를 반환한다.")
    void returnTrueAtWeekend() {
        Date date = new Date(1);

        boolean isWeekend = date.isWeekend();

        assertThat(isWeekend).isTrue();
    }

    @Test
    @DisplayName("주말이 아닐 경우 false를 반환한다.")
    void returnFalseAtWeekday() {
        Date date = new Date(4);

        boolean isWeekend = date.isWeekend();

        assertThat(isWeekend).isFalse();
    }

    @Test
    @DisplayName("이벤트 날짜에 포함될 경우 true를 반환한다.")
    void returnTrueAtSpecialDay() {
        Date date = new Date(25);

        boolean isSpecial = date.isSpecialDay();

        assertThat(isSpecial).isTrue();
    }

    @Test
    @DisplayName("이벤트 날짜에 포함되지 않을 경우 false를 반환한다.")
    void returnFalseAtNotSpecialDay() {
        Date date = new Date(1);

        boolean isSpecial = date.isSpecialDay();

        assertThat(isSpecial).isFalse();
    }
}
