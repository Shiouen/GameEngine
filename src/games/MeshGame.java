package games;

import javafx.scene.paint.Color;

import engine.model.logic.GameLogic;
import engine.model.logic.GameObject;
import engine.math.Vector3D;
import engine.utility.Constants;
import engine.model.logic.components.Rotator;
import engine.view.render.components.MeshRenderer;
import engine.view.render.meshes.TetrahedronMesh;

public class MeshGame extends Game {
    public MeshGame() { super(); }

    @Override
    protected GameLogic initialiseGameLogic() {
        GameLogic gameLogic = new GameLogic();

        for (int i = 0; i < 10; ++i){
            GameObject gameObject = new GameObject();

            gameObject.getTransform().translate(Vector3D.getRandom(Constants.VIEW_SIZE));
            gameObject.getTransform().scale(Math.random() * 100);
            gameObject.getTransform().rotate(Vector3D.getRandom(2 * Math.PI));

            gameObject.addComponent(new Rotator());
            gameObject.setRenderComponent(new MeshRenderer(Color.RED, new TetrahedronMesh()));

            gameLogic.addGameObject(gameObject);
        }

        return gameLogic;
    }
}
