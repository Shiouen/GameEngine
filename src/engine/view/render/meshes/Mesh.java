package engine.view.render.meshes;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

import engine.model.logic.components.Transform;

public class Mesh {
    private List<Face> faces;

    public Mesh() {
        this.faces = new ArrayList<>();
    }

    protected void addFace(Face face){
        this.faces.add(face);
    }

    public void render(GraphicsContext context, Transform transform){
        this.faces.forEach(face -> face.render(context, transform));
    }
}
