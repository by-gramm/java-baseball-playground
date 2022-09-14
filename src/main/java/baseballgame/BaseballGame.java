package baseballgame;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class BaseballGame {

    public static void main(String[] args) throws IOException {
        BaseballGame game = new BaseballGame();
        String targetNum = game.getRandomNumber(3);

        InputView inputView = new InputView();
        int[] counts = new int[]{0, 0};

        while (counts[0] < 3) {
            String inputNum = inputView.inputNumber();
            counts = game.compare(targetNum, inputNum);
            String result = game.getCountResult(counts[0], counts[1]);
        }

    }

    /**
     * 서로 다른 숫자로 이루어진 임의의 n자리 수를 리턴한다.
     */
    public String getRandomNumber(int n) {
        StringBuffer randomNumber = new StringBuffer();

        while (randomNumber.length() < 3) {
            int digit = getRandomDigit(10);
            addDigit(randomNumber, digit);
        }

        return String.valueOf(randomNumber);
    }

    /**
     * 3자리 숫자로 이루어진 2개의 문자열을 비교한다.
     * @return
     */
    public int[] compare(String targetNum, String inputNum) {
        String[] result = {"", "", ""};

        for (int idx = 0; idx < 3; idx++) {
            String s = compareDigit(targetNum, idx, inputNum.substring(idx, idx + 1));
            result[idx] = s;
        }

        int strikeCount = Collections.frequency(Arrays.asList(result), "STRIKE");
        int ballCount = Collections.frequency(Arrays.asList(result), "BALL");

        return new int[]{strikeCount, ballCount};
    }

    /**
     * 특정 위치의 숫자를 비교한 결과(STRIKE/BALL/EMPTY)를 구한다.
     */
    private String compareDigit(String targetNum, int idx, String inputDigit) {
        if (targetNum.substring(idx, idx + 1).equals(inputDigit)) {
            return "STRIKE";
        }
        if (targetNum.contains(inputDigit)) {
            return "BALL";
        }
        return "EMPTY";
    }

    /**
     * 스트라이크/볼 카운트 결과를 문자열로 나타낸다.
     */
    public String getCountResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        if (strikeCount == 0) {
            return ballCount + "볼";
        }
        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }

        return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
    }

    /**
     * 0 ~ maxNum 사이의 임의의 수를 리턴한다.
     */
    private int getRandomDigit(int maxNum) {
        return (int) (Math.random() * (maxNum));
    }

    /**
     * 새로운 숫자가 randomNumber에 없는 경우, 새로 더한다.
     */
    private void addDigit(StringBuffer randomNumber, int digit) {
        if (randomNumber.indexOf(Integer.toString(digit)) == -1) {
            randomNumber.append(digit);
        }
    }
}
