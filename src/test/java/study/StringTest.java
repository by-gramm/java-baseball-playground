package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Nested
    @DisplayName("String 클래스 메소드 테스트")
    class stringClassTest {

        @Test
        void replace() {
            String actual = "abc".replace("b", "d");
            assertThat(actual).isEqualTo("adc");
        }

        @Test
        void split() {
            String[] numbers = "1,2".split(",");
            assertThat(numbers).contains("1", "2");
        }

        @Test
        @DisplayName("split() 메소드의 인자가 문자열에 없는 경우 테스트")
        void split_인자가_없는_경우() {
            String[] actual = "1".split(",");
            assertThat(actual).containsExactly("1");
        }

        @Test
        void substring() {
            String s = "(1,2)".substring(1, 4);
            assertThat(s).isEqualTo("1,2");
        }

        @Test
        void charAt() {
            char c = "abc".charAt(1);
            assertThat(c).isEqualTo('b');
        }
    }

    @Nested
    @DisplayName("String 클래스 예외 처리 테스트")
    class stringExceptionTest {

        @Test
        @DisplayName("assertJ의 assertThatThrownBy를 활용한 예외 처리 테스트")
        void charAt_assertj_예외_처리() {
            assertThatThrownBy(() -> "abc".charAt(3))
                    .isInstanceOf(StringIndexOutOfBoundsException.class);
        }

        @Test
        @DisplayName("Junit5의 assertThrows를 활용한 예외 처리 테스트")
        void charAt_junit5_예외_처리() {
            Assertions.assertThrows(StringIndexOutOfBoundsException.class,
                    () -> "abc".charAt(3));
        }
    }

}
