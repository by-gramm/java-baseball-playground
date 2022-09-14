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
        String randomNumber = game.getRandomNumber(3);
        // 자리수 확인
        assertEquals(randomNumber.length(), 3);

        // 숫자가 모두 다른지 확인
        assertNotEquals(randomNumber.charAt(0), randomNumber.charAt(1));
        assertNotEquals(randomNumber.charAt(0), randomNumber.charAt(2));
        assertNotEquals(randomNumber.charAt(1), randomNumber.charAt(2));
    }

    @Test
    @DisplayName("스트라이크/볼 테스트")
    void strikeAndBallCount() {
        int[] result1 = game.compare("567", "557");
        int[] result2 = game.compare("015", "234");

        assertTrue(result1[0] == 2);
        assertTrue(result1[1] == 1);

        assertTrue(result2[0] == 0);
        assertTrue(result2[1] == 0);
    }

    @Test
    @DisplayName("스트라이크/볼 카운트 결과 나타내기")
    void getCountResult() {
        assertEquals(game.getCountResult(0, 0), "낫싱");
        assertEquals(game.getCountResult(1, 0), "1스트라이크");
        assertEquals(game.getCountResult(0, 2), "2볼");
        assertEquals(game.getCountResult(2, 1), "1볼 2스트라이크");
    }

}