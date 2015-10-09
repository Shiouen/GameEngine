package engine.view.render.components;

import java.util.logging.Logger;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class BallRenderer extends RenderComponent {
    private static final Logger log = Logger.getLogger(BallRenderer.class.getName());

    public BallRenderer(Paint paint) {
        super(paint);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(this.paint);
        gc.fillOval((int) this.gameObject.getTransform().getPosition().getX(),
                (int) this.gameObject.getTransform().getPosition().getY(),
                (int) this.gameObject.getTransform().getScale().getX(),
                (int) this.gameObject.getTransform().getScale().getY());
    }
}
