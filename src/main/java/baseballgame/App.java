package baseballgame;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        Balls comBalls = setRandomBalls();
    }

    private static Balls setRandomBalls() {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < Constants.BALL_COUNT) {
            int newNumber = getRandomNumber();

            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }

        return new Balls(numbers);
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
