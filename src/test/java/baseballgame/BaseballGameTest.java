package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    private BaseballGame game;

    @BeforeEach
    void setup() {
        game = new BaseballGame();
    }

    @Test
    @DisplayName("서로 다른 3자리 숫자로 이루어진 수 만들기")
    void getRandomNumber() {
        StringBuffer randomNumber = game.getRandomNumber(3);
        // 자리수 확인
        assertEquals(randomNumber.length(), 3);

        // 숫자가 모두 다른지 확인
        assertNotEquals(randomNumber.charAt(0), randomNumber.charAt(1));
        assertNotEquals(randomNumber.charAt(0), randomNumber.charAt(2));
        assertNotEquals(randomNumber.charAt(1), randomNumber.charAt(2));
    }
}