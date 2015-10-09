package engine.view.render.components;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import engine.view.render.meshes.Mesh;

public class MeshRenderer extends RenderComponent {
    private Mesh mesh;

    public MeshRenderer(Paint paint, Mesh mesh) {
        super(paint);
        this.mesh = mesh;
    }

    @Override
    public void render(GraphicsContext context) {
        context.setStroke(super.paint);
        this.mesh.render(context, super.gameObject.getTransform());
    }
}
