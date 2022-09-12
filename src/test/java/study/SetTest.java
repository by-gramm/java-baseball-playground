package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 클래스의 size() 메소드 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);  // {1, 2, 3}
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set 클래스의 contains() 메소드 테스트")
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("contains() 메소드가 입력값에 따라 true/false를 잘 리턴하는지 테스트")
    void contains_canReturnTrueOrFalse(int number, boolean result) {
        assertEquals(numbers.contains(number), result);
    }

}
