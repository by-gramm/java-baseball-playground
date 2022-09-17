package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseballgame.BallStatus.*;

public class Balls {

    private final List<Ball> ballList = new ArrayList<Ball>();

    public Balls(Ball ball1, Ball ball2, Ball ball3) {
        ballList.add(ball1);
        ballList.add(ball2);
        ballList.add(ball3);
    }

    public BallStatus compare(Ball userBall) {
        List<BallStatus> statusList = ballList.stream()
                .map(ball -> ball.compare(userBall))
                .collect(Collectors.toList());

        if (statusList.contains(STRIKE)) {
            return STRIKE;
        }

        if (statusList.contains(BALL)) {
            return BALL;
        }

        return NOTHING;
    }
}
