package engine.view.render.meshes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import engine.math.Vector3D;
import engine.model.logic.components.Transform;

public class Face {
    private Vector3D[] vertices = new Vector3D[3];

    public Face(Vector3D a, Vector3D b, Vector3D c) {
        this.vertices[0] = a;
        this.vertices[1] = b;
        this.vertices[2] = c;
    }

    public void render(GraphicsContext context, Transform transform) {
        Vector3D a = vertices[0].rotate(transform.getRotation());
        Vector3D b = vertices[1].rotate(transform.getRotation());
        Vector3D c = vertices[2].rotate(transform.getRotation());

        a = a.scale(transform.getScale());
        b = b.scale(transform.getScale());
        c = c.scale(transform.getScale());

        a = a.add(transform.getPosition());
        b = b.add(transform.getPosition());
        c = c.add(transform.getPosition());

        context.strokeLine(a.getX(), a.getY(), b.getX(), b.getY());
        context.strokeLine(b.getX(), b.getY(), c.getX(), c.getY());
        context.strokeLine(c.getX(), c.getY(), a.getX(), a.getY());

        context.setFill(Color.RED);
        context.fillPolygon(
                new double[] { a.getX(), b.getX(), c.getX() },
                new double[] { a.getY(), b.getY(), c.getY() },
                3
        );
    }
}