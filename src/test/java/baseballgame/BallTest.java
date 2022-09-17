package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseballgame.BallStatus.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("2개의 Ball 객체 비교")
public class BallTest {

    private Ball comBall;

    @BeforeEach
    void setup() {
        comBall = new Ball(1, 3);
    }

    @Test
    @DisplayName("숫자와 위치가 같은 경우 스트라이크")
    void strike() {
        Ball userBall = new Ball(1, 3);
        assertEquals(comBall.compare(userBall), STRIKE);
    }

    @Test
    @DisplayName("숫자는 같고 위치는 다른 경우 볼")
    void ball() {
        Ball userBall = new Ball(2, 3);
        assertEquals(comBall.compare(userBall), BALL);
    }

    @Test
    @DisplayName("숫자가 다른 경우 낫싱")
    void nothing() {
        Ball userBall = new Ball(1, 7);
        assertEquals(comBall.compare(userBall), NOTHING);
    }
}
