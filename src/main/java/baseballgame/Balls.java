package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static baseballgame.BallStatus.*;

public class Balls {

    private final List<Ball> ballList = new ArrayList<>();

    public Balls(List<Integer> numbers) {
        for (int idx = 0; idx < Constants.BALL_COUNT; idx++) {
            ballList.add(new Ball(idx, numbers.get(idx)));
        }
    }

    public BallStatus compare(Ball userBall) {
        List<BallStatus> statusList = ballList.stream()
                .map(userBall::compare)
                .collect(Collectors.toList());

        if (statusList.contains(STRIKE)) {
            return STRIKE;
        }

        if (statusList.contains(BALL)) {
            return BALL;
        }

        return NOTHING;
    }

    public GameResult compareAll(Balls userBalls) {
        List<BallStatus> result = getStatusList(userBalls);

        int strikeCount = countStatus(result, STRIKE);
        int ballCount = countStatus(result, BALL);

        return new GameResult(strikeCount, ballCount);
    }

    private int countStatus(List<BallStatus> result, BallStatus status) {
        return (int) result.stream()
                .filter(status::equals)
                .count();
    }

    private List<BallStatus> getStatusList(Balls userBalls) {
        return ballList.stream()
                .map(userBalls::compare)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls = (Balls) o;

        return compareAll(balls).equals(new GameResult(3, 0));
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballList);
    }
}
