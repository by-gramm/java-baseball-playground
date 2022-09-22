package baseballgame;

import baseballgame.view.InputView;
import baseballgame.view.ResultView;
import java.io.IOException;


public class BaseballGame {

    public static void main(String[] args) throws IOException {
        GamePlay gamePlay = new GamePlay();
        String menu = Constants.RESTART_GAME;

        while (menu.equals(Constants.RESTART_GAME)) {
            gamePlay.play();
            ResultView.finishGame();
            menu = InputView.inputMenu();
        }
    }

}
