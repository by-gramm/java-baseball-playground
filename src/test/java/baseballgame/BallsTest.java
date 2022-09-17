package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;

import static baseballgame.BallStatus.*;
import static org.junit.jupiter.api.Assertions.*;


public class BallsTest {

    private Balls comBalls;

    @BeforeEach
    void setup() {
        comBalls = new Balls(Arrays.asList(5, 3, 8));
    }

    @Nested
    @DisplayName("3자리 Balls와 하나의 Ball 객체 비교")
    class BallToBalls {
        @ParameterizedTest
        @CsvSource(value = {"0:5", "1:3", "2:8"}, delimiter = ':')
        @DisplayName("스트라이크 검증")
        void strike(int position, int number) {
            Ball userBall = new Ball(position, number);
            assertEquals(comBalls.compare(userBall), STRIKE);
        }

        @ParameterizedTest
        @CsvSource(value = {"2:5", "0:3", "1:8"}, delimiter = ':')
        @DisplayName("볼 검증")
        void ball(int position, int number) {
            Ball userBall = new Ball(position, number);
            assertEquals(comBalls.compare(userBall), BALL);
        }

        @ParameterizedTest
        @CsvSource(value = {"1:6", "2:7"}, delimiter = ':')
        @DisplayName("낫싱 검증")
        void nothing(int position, int number) {
            Ball userBall = new Ball(position, number);
            assertEquals(comBalls.compare(userBall), NOTHING);
        }
    }

    @Nested
    @DisplayName("두 개의 3자리 Balls 비교 (ex. 1볼 1스트라이크)")
    class BallsToBalls {

        @Test
        @DisplayName("0볼 0스트라이크(낫싱)")
        void nothing() {
            Balls userBalls = new Balls(Arrays.asList(0, 1, 4));
            assertEquals(comBalls.compareAll(userBalls), new GameResult(0, 0));
        }

        @Test
        @DisplayName("1볼 1스트라이크")
        void one_ball_one_strike() {
            Balls userBalls = new Balls(Arrays.asList(1, 5, 8));
            assertEquals(comBalls.compareAll(userBalls), new GameResult(1, 1));
        }

        @Test
        @DisplayName("3스트라이크")
        void three_strike() {
            Balls userBalls = new Balls(Arrays.asList(5, 3, 8));
            assertEquals(comBalls.compareAll(userBalls), new GameResult(3, 0));
        }
    }
}
