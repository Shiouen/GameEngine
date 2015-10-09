package games;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

import engine.math.Vector3D;
import engine.model.logic.GameLogic;
import engine.model.logic.GameObject;
import engine.utility.Constants;
import engine.view.render.components.MeshRenderer;
import engine.view.render.meshes.TetrahedronMesh;

public class FullMeshGame extends Game {
    public FullMeshGame() { super(); }

    @Override
    protected GameLogic initialiseGameLogic() {
        List<GameObject> gameObjects = new ArrayList<>();
        GameLogic gameLogic = new GameLogic();

        for (int i = 0; i < 100; ++i){
            GameObject gameObject = new GameObject();

            gameObject.getTransform().translate(Vector3D.getRandom(Constants.VIEW_SIZE));
            gameObject.getTransform().scale(50);
            gameObject.getTransform().rotate(Vector3D.getRandom(2 * Math.PI));

            gameObject.setRenderComponent(new MeshRenderer(Color.BLACK, new TetrahedronMesh()));

            // keep near and far clipping in mind
            double z = gameObject.getTransform().getPosition().getZ();
            if (z >= 50 && z <= 250) { gameObjects.add(gameObject); }

            // painters algo
            gameObjects.sort(new GameObject.ZCoordinateComparator());
        }

        gameObjects.forEach(gameObject -> gameLogic.addGameObject(gameObject));

        return gameLogic;
    }
}
