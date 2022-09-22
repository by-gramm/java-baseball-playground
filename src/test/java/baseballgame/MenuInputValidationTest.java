package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MenuInputValidationTest {

    @ParameterizedTest
    @DisplayName("메뉴 입력값이 유효한지 검증")
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:false"}, delimiter = ':')
    void validate_menu(String menuInput, boolean result) {
        assertEquals(Validations.isValidMenu(menuInput), result);
    }
}
