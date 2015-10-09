package games;

import javafx.scene.paint.Color;

import engine.math.Vector3D;
import engine.model.logic.GameLogic;
import engine.model.logic.GameObject;
import engine.model.logic.components.Rotator;
import engine.utility.Constants;
import engine.view.render.components.MeshRenderer;
import engine.view.render.meshes.TetrahedronMesh;

public class TetrahederGame extends Game {
    public TetrahederGame() { super(); }

    @Override
    protected GameLogic initialiseGameLogic() {
        GameLogic gameLogic = new GameLogic();

        for (int i = 0; i < 100; ++i){
            GameObject gameObject = new GameObject();

            gameObject.getTransform().translate(Vector3D.getRandom(Constants.VIEW_SIZE));
            gameObject.getTransform().scale(50);
            gameObject.getTransform().rotate(Vector3D.getRandom(2 * Math.PI));

            gameObject.setRenderComponent(new MeshRenderer(Color.BLACK, new TetrahedronMesh()));

            gameLogic.addGameObject(gameObject);
        }

        return gameLogic;
    }
}
