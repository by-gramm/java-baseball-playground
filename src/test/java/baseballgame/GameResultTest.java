package baseballgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameResultTest {

    @ParameterizedTest
    @DisplayName("제구 결과 문자열로 변경하기 검증")
    @CsvSource(value = {"0:0:낫싱", "1:1:1볼 1스트라이크", "0:2:2볼", "3:0:3스트라이크"}, delimiter = ':')
    void result_to_string(int strikeCount, int ballCount, String stringResult) {
        GameResult result = new GameResult(strikeCount, ballCount);
        assertEquals(result.toString(), stringResult);
    }

    @Test
    @DisplayName("게임 종료 조건 확인 검증")
    void finish_game() {
        GameResult result1 = new GameResult(3, 0);
        GameResult result2 = new GameResult(2, 1);

        assertTrue(result1.isFinished());
        assertFalse(result2.isFinished());
    }
}
