package engine.model.logic;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private boolean gameFinished;
    private List<GameObject> gameObjects;

    public GameLogic() {
        this.gameFinished = false;
        this.gameObjects = new ArrayList<>();
    }

    public List<GameObject> getGameObjects() { return gameObjects; }

    public void setGameFinished(boolean gameFinished) { this.gameFinished = gameFinished; }

    public boolean isGameFinished() { return this.gameFinished; }

    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void update() {
        // same as this.gameObjects.forEach(gameObject -> gameObject.update());
        this.gameObjects.forEach(GameObject::update);
    }
}
