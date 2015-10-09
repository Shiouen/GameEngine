package engine.view;

import java.util.logging.Logger;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import engine.model.logic.GameLogic;
import engine.model.logic.GameObject;
import engine.view.render.components.RenderComponent;
import engine.utility.Constants;

public class GameView extends Canvas {
    private GameLogic gameLogic;
    private static final Logger log = Logger.getLogger(GameView.class.getName());

    public GameView(GameLogic gameLogic) {
        super(Constants.VIEW_SIZE, Constants.VIEW_SIZE);
        this.gameLogic = gameLogic;
    }

    public void render(){
        this.log.info("rendering scene..");
        GraphicsContext context = getGraphicsContext2D();

        context.setFill(Color.LIGHTGREY);
        context.fillRect(0, 0, Constants.VIEW_SIZE, Constants.VIEW_SIZE);

        for (GameObject gameObject : gameLogic.getGameObjects()) {
            RenderComponent renderComponent = gameObject.getRenderComponent();
            if (renderComponent != null) {
                renderComponent.render(context);
            }
        }
    }
}
