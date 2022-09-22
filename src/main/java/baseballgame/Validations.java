package baseballgame;

public class Validations {

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

        return (number.length() == Constants.BALL_COUNT);
    }

    public static boolean isValidMenu(String menuInput) {
        return (Constants.RESTART_GAME.equals(menuInput) || Constants.END_GAME.equals(menuInput));
    }
}
