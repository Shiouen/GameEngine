package engine.model.logic.components;

import engine.math.Vector3D;
import engine.model.logic.GameObject;

public class Transform extends LogicComponent {
    private Vector3D position;
    private Vector3D rotation;
    private Vector3D scale;

    public Transform() {
        this.position = new Vector3D(0, 0, 0);
        this.rotation = new Vector3D(0, 0, 0);
        this.scale = new Vector3D(1, 1, 1);
    }
    public Transform(GameObject gameObject) {
        super(gameObject);
        this.position = new Vector3D(0, 0, 0);
        this.rotation = new Vector3D(0, 0, 0);
        this.scale = new Vector3D(1, 1, 1);
    }

    public Vector3D getPosition() { return this.position; }
    public Vector3D getRotation() { return this.rotation; }
    public Vector3D getScale() { return this.scale; }

    public void setPosition(Vector3D position) { this.position = position; }
    public void setScale(Vector3D scale) { this.scale = scale; }

    public void rotate(Vector3D rotation) { this.rotation = this.rotation.add(rotation); }
    public void scale(double factor) { this.scale = this.scale.multiply(factor); }
    public void translate(Vector3D translation) { this.position = this.position.add(translation); }

    @Override
    public void update() {
        //transform's update method does nothing...
    }

    @Override
    public String toString() {
        return "Transform{" +
                "position=" + this.position +
                ", scale=" + this.scale +
                ", rotation=" + this.rotation +
                '}';
    }
}
