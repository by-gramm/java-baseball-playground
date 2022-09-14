package baseballgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class InputView {

    public String inputNumber() throws IOException {
        System.out.print("3자리 숫자를 입력해 주세요 : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputNum = reader.readLine();

        if (inputNum.length() != 3) {
            throw new InputMismatchException("3자리 수를 입력해 주세요.");
        }

        if (!isAllDigit(inputNum)) {
            throw new InputMismatchException("숫자만 입력 가능합니다.");
        }

        return inputNum;
    }

    private boolean isAllDigit(String numStr) {
        if (!Character.isDigit(numStr.charAt(0))) {   // 1번째 문자가 숫자가 아닌 경우
            return false;
        }
        if (!Character.isDigit(numStr.charAt(1))) {   // 2번째 문자가 숫자가 아닌 경우
            return false;
        }
        if (!Character.isDigit(numStr.charAt(2))) {   // 3번째 문자가 숫자가 아닌 경우
            return false;
        }

        return true;
    }
}
