package baseballgame;

import java.util.Objects;

public class GameResult {

    private final int strikeCount;
    private final int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }

    @Override
    public String toString() {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        if (strikeCount == 0) {
            return String.format("%d볼", ballCount);
        }

        if (ballCount == 0) {
            return String.format("%d스트라이크", strikeCount);
        }

        return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
    }

    public boolean isFinished() {
        return (strikeCount == Constants.BALL_COUNT);
    }
}
