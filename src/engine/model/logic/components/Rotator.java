package engine.model.logic.components;

import engine.math.Vector3D;
import engine.model.Time;

public class Rotator extends LogicComponent {
    private Vector3D rotation = Vector3D.getRandom(Math.PI);

    @Override
    public void update() {
        this.gameObject.getTransform().rotate(this.rotation.multiply(Time.deltaTime));
    }
}
