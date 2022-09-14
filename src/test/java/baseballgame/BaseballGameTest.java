package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("스트라이크/볼 카운트 테스트")
    @CsvSource(value = {"567:557:2:1", "015:234:0:0", "468:684:0:3"}, delimiter = ':')
    void strikeAndBallCount(String targetNum, String inputNum, int sCount, int bCount) {
        int[] result = game.compare(targetNum, inputNum);
        assertEquals(result[0], sCount);
        assertEquals(result[1], bCount);
    }

    @ParameterizedTest
    @DisplayName("스트라이크/볼 카운트 결과 나타내기")
    @CsvSource(value = {"0:0:낫싱", "1:0:1스트라이크", "0:2:2볼", "2:1:1볼 2스트라이크"}, delimiter = ':')
    void getCountResult(int strikeCount, int ballCount, String result) {
        assertEquals(game.getCountResult(strikeCount, ballCount), result);
    }

}