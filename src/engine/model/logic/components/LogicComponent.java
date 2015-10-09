package engine.model.logic.components;

import engine.model.logic.GameObject;

public abstract class LogicComponent {
    protected GameObject gameObject;

    public LogicComponent() { }
    public LogicComponent(GameObject gameObject) { this.gameObject = gameObject; }

    public void setGameObject(GameObject gameObject) { this.gameObject = gameObject; }

    public abstract void update();
}
