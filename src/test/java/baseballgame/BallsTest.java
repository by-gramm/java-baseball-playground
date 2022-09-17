package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseballgame.BallStatus.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("3자리 Balls와 하나의 Ball 객체 비교")
public class BallsTest {

    private Balls comBalls;

    @BeforeEach
    void setup() {
        Ball ball1 = new Ball(0, 5);
        Ball ball2 = new Ball(1, 3);
        Ball ball3 = new Ball(2, 8);

        comBalls = new Balls(ball1, ball2, ball3);
    }

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
