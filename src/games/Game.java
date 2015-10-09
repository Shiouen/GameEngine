package games;

import engine.controller.GameController;
import engine.model.logic.GameLogic;
import engine.view.GameView;

public abstract class Game {
    private GameController controller;

    public Game() {
        GameLogic gameLogic = this.initialiseGameLogic();
        controller = new GameController(gameLogic);
    }

    protected abstract GameLogic initialiseGameLogic();

    public final void start(){
        controller.startGameLoop();
    }

    public final GameView getGameView(){
        return controller.getGameView();
    }
}
