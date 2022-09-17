package baseballgame;


public class Validations {

    public static final int BALL_COUNT = 3;
    private static final String NUMERIC_REGEX = "[0-9]+";

    public static boolean isNumeric(String number) {
        if (number == null) {
            return false;
        }

        return number.matches(NUMERIC_REGEX);
    }

    public static boolean isThreeDigit(String number) {
        if (number == null) {
            return false;
        }

        return (number.length() == BALL_COUNT);
    }
}
