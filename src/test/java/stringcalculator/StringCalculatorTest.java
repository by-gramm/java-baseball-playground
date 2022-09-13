package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Nested
    @DisplayName("사칙연산 테스트")
    class calculateTest {

        @Test
        @DisplayName("덧셈 연산")
        void plus() {
            assertEquals(stringCalculator.calculate("5 + 3"), 8);
        }

        @Test
        @DisplayName("뺄셈 연산")
        void subtract() {
            assertEquals(stringCalculator.calculate("5 - 3"), 2);
        }

        @Test
        @DisplayName("덧셈 연산")
        void multiply() {
            assertEquals(stringCalculator.calculate("5 * 3"), 15);
        }

        @Test
        @DisplayName("나눗셈 연산")
        void divide() {
            assertEquals(stringCalculator.calculate("5 / 3"), 1);
        }

        @Test
        @DisplayName("사칙연산을 모두 사용한 연산")
        void multiCalculate() {
            String sampleInput = "15 + 27 / 5 * 8";
            assertEquals(stringCalculator.calculate(sampleInput), 64);
        }
    }

    @Nested
    @DisplayName("예외처리 테스트")
    class exceptionHandlingTest {

        @Test
        @DisplayName("0으로 나누는 경우 예외처리")
        void dividedByZero() {
            assertThrows(ArithmeticException.class, () -> {
                stringCalculator.calculate("10 / 0");
            });
        }

        @Test
        @DisplayName("연산자, 피연산자 순서가 맞지 않는 경우 예외 처리")
        void invalidInput1() {
            assertThrows(IllegalArgumentException.class, () -> {
                stringCalculator.calculate("10 + + 20 30");
            });
        }

        @Test
        @DisplayName("입력값이 연산자로 끝나는 경우 예외 처리")
        void invalidInput2() {
            assertThrows(IllegalArgumentException.class, () -> {
                stringCalculator.calculate("10 + 20 /");
            });
        }
    }

}