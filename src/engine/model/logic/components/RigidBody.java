package engine.model.logic.components;

import engine.math.Vector2D;
import engine.model.logic.GameObject;

public class RigidBody extends LogicComponent {
    private Vector2D velocity;

    private RigidBody() { }
    public RigidBody(GameObject gameObject) {
        super(gameObject);
    }

    public Vector2D getVelocity() { return velocity; }
    public void setVelocity(Vector2D velocity) { this.velocity = velocity; }

    @Override
    public void update() {
        Transform transform =  this.gameObject.getTransform();

        System.out.println("Updating RigidBody component...");
//
//        if (transform != null) {
//            Vector2D position = transform.getPosition();
//            position.setX(position.getX() + this.velocity.getX());
//            position.setY(position.getY() + this.velocity.getY());
//        }
    }
}
