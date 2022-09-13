package stringcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculator {

    public static void main(String[] args) throws IOException {
        StringCalculator stringCalculator = new StringCalculator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = reader.readLine();

        int result = stringCalculator.calculate(value);
        System.out.println("계산 결과 = " + result);

        reader.close();
    }

    public int calculate(String value) {
        String[] values = value.split(" ");

        if (values.length % 2 == 0) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }

        int calCount = (values.length - 1) / 2;
        int cntValue = Integer.parseInt(values[0]);

        for (int i = 0; i < calCount; i++) {
            String operator = values[i * 2 + 1];
            int secondValue = Integer.parseInt(values[i * 2 + 2]);

            switch (operator) {
                case "+":
                    cntValue = plus(cntValue, secondValue);
                    break;
                case "-":
                    cntValue = subtract(cntValue, secondValue);
                    break;
                case "*":
                    cntValue = multiply(cntValue, secondValue);
                    break;
                case "/":
                    cntValue = divide(cntValue, secondValue);
                    break;
                default:
                    throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }
        }
        return cntValue;
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }

}
