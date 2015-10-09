package engine.view.render.components;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import engine.model.logic.GameObject;

public abstract class RenderComponent {
    protected GameObject gameObject;
    protected Paint paint;

    public RenderComponent() { }
    public RenderComponent(GameObject gameObject) { this.gameObject = gameObject; }
    public RenderComponent(Paint paint) { this.paint = paint; }
    public RenderComponent(GameObject gameObject, Paint paint) {
        this.gameObject = gameObject;
        this.paint = paint;
    }

    public void setGameObject(GameObject gameObject) { this.gameObject = gameObject; }
    public void setPaint(Paint paint) { this.paint = paint; }

    public abstract void render(GraphicsContext context);
}
