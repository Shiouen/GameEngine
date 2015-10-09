package engine.controller;

import java.util.logging.Logger;

import javafx.application.Platform;

import engine.model.Time;
import engine.model.logic.GameLogic;
import engine.utility.Constants;
import engine.view.GameView;

public class GameController {
    private GameLogic gameLogic;
    private GameView gameView;

    private static final Logger log = Logger.getLogger(GameController.class.getName());

    private GameController() { }
    public GameController(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.gameView = new GameView(gameLogic);
    }

    public GameView getGameView() {
        return this.gameView;
    }

    public void startGameLoop() {
/*        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!gameLogic.isGameFinished()) {
                    gameLogic.update();
                    gameView.render();
                }
            }
        });
*/
        new Thread(() -> {
            while (!gameLogic.isGameFinished()) {
                long startFrame = System.currentTimeMillis();
                gameLogic.update();
                //let's pretend it takes some time to update the logic...
                try {
                    Thread.sleep(Constants.MACHINE_LAG);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> gameView.render());
                //gameView.render();
                Time.deltaTime = (System.currentTimeMillis() - startFrame) / 1000f;
            }
        }).start();
    }
}
