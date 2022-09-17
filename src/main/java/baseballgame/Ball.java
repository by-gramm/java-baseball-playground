package baseballgame;

import static baseballgame.BallStatus.*;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus compare(Ball userBall) {
        if (userBall.number != this.number) {
            return NOTHING;
        }

        if (userBall.position == this.position) {
            return STRIKE;
        }

        return BALL;
    }
}
