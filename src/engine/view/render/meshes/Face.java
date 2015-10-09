package engine.view.render.meshes;

import javafx.scene.canvas.GraphicsContext;

import engine.math.Vector3D;
import engine.model.logic.components.Transform;

public class Face {
    private Vector3D[] vertices = new Vector3D[3];

    public Face(Vector3D a, Vector3D b, Vector3D c) {
        this.vertices[0] = a;
        this.vertices[1] = b;
        this.vertices[2] = c;
    }

    public void render(GraphicsContext gc, Transform transform) {
        Vector3D a = vertices[0].rotate(transform.getRotation());
        Vector3D b = vertices[1].rotate(transform.getRotation());
        Vector3D c = vertices[2].rotate(transform.getRotation());

        a = a.scale(transform.getScale());
        b = b.scale(transform.getScale());
        c = c.scale(transform.getScale());

        a = a.add(transform.getPosition());
        b = b.add(transform.getPosition());
        c = c.add(transform.getPosition());

        gc.strokeLine(a.getX(),a.getY(),b.getX(),b.getY());
        gc.strokeLine(b.getX(), b.getY(), c.getX(), c.getY());
        gc.strokeLine(c.getX(), c.getY(), a.getX(), a.getY());
    }
}