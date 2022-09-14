package baseballgame;

import java.io.IOException;

public class BaseballGame {

    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        String inputNum = inputView.inputNumber();
    }

    /**
     * 서로 다른 숫자로 이루어진 임의의 n자리 수를 리턴한다.
     */
    public StringBuffer getRandomNumber(int n) {
        StringBuffer randomNumber = new StringBuffer();

        while (randomNumber.length() < 3) {
            int digit = getRandomDigit(10);
            addDigit(randomNumber, digit);
        }

        return randomNumber;
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
