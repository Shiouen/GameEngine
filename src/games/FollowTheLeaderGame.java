package games;

import javafx.scene.paint.Color;

import engine.math.Vector3D;
import engine.model.logic.GameLogic;
import engine.model.logic.GameObject;
import engine.model.logic.components.Follower;
import engine.model.logic.components.RandomWalker;
import engine.utility.Constants;
import engine.view.render.components.BallRenderer;

public class FollowTheLeaderGame extends Game {
    public FollowTheLeaderGame() { super(); }

    @Override
    protected GameLogic initialiseGameLogic() {
        GameLogic logic = new GameLogic();
        GameObject leader = new GameObject();

        leader.setRenderComponent(new BallRenderer(Color.BLUE));
        leader.getTransform().translate(new Vector3D(200,200,200));
        leader.getTransform().scale(10);
        leader.addComponent(new RandomWalker());

        logic.addGameObject(leader);

        for (int i = 0; i < 100; ++i) {
            GameObject gameObject = new GameObject();

            gameObject.getTransform().translate(Vector3D.getRandom(Constants.VIEW_SIZE));
            gameObject.getTransform().scale(10);
            gameObject.setRenderComponent(new BallRenderer(Color.RED));

            gameObject.addComponent(new Follower(leader));
            logic.addGameObject(gameObject);
        }

        return logic;
    }
}
