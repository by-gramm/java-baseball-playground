package baseballgame;

import baseballgame.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlay {

    private final InputView inputView = new InputView();

    public void play() throws IOException {
        Balls comBalls = setRandomBalls();
        Balls userBalls = null;

        do {
            userBalls = setUserBalls();
            GameResult gameResult = comBalls.compareAll(userBalls);
            System.out.println(gameResult);
        } while (!comBalls.equals(userBalls));
    }

    private Balls setUserBalls() throws IOException {
        String userInput = inputView.inputNumber();

        List<Integer> userNumbers = Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Balls(userNumbers);
    }

    private static Balls setRandomBalls() {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < Constants.BALL_COUNT) {
            int newNumber = getRandomNumber();
            addUniqueNumber(numbers, newNumber);
        }

        return new Balls(numbers);
    }

    private static void addUniqueNumber(ArrayList<Integer> numbers, int newNumber) {
        if (!numbers.contains(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
