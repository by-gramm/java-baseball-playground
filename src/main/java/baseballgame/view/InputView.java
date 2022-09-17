package baseballgame.view;

import baseballgame.Validations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String inputNumber() throws IOException {
        boolean isInputValid = false;
        String userInput = "";

        while (!isInputValid) {
            System.out.print("3개의 숫자를 입력해 주세요 : ");
            userInput = reader.readLine();
            isInputValid = checkInput(userInput);
        }

        return userInput;
    }

    private boolean checkInput(String userInput) throws IOException {
        if (!Validations.isNumeric(userInput)) {
            System.out.println("숫자만 입력 가능합니다. \n");
            return false;
        }

        if (!Validations.isThreeDigit(userInput)) {
            System.out.println("3자리 수만 입력 가능합니다. \n");
            return false;
        }

        return true;
    }

    public static String inputMenu() throws IOException {
        String menuInput = "";

        while (!Validations.isValidMenu(menuInput)) {
            ResultView.showMenu();
            menuInput = reader.readLine();
        }

        return menuInput;
    }

}
