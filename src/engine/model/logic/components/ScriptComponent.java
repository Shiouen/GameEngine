package engine.model.logic.components;

import engine.math.Vector3D;

public class ScriptComponent extends LogicComponent {
    @Override
    public void update() {
        Vector3D randomVector = Vector3D.getRandom(10).normalize();
        System.out.println(randomVector);
        System.out.println("Magnitude:" + randomVector.getMagnitude());
        this.gameObject.getTransform().translate(randomVector);
    }
}
