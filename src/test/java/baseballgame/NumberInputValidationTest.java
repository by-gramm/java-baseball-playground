package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberInputValidationTest {

    @ParameterizedTest
    @DisplayName("입력값이 숫자로만 이루어져 있는지 검증")
    @CsvSource(value = {"000:true", "987:true", "A53:false", "3-3:false"}, delimiter = ':')
    void validate_all_numbers(String number, boolean result) {
        assertEquals(Validations.isNumeric(number), result);
    }

    @ParameterizedTest
    @DisplayName("입력값이 3자리인지 검증")
    @CsvSource(value = {"11:false", "111:true", "1111:false"}, delimiter = ':')
    void validate_3_digits(String number, boolean result) {
        assertEquals(Validations.isThreeDigit(number), result);
    }
}
