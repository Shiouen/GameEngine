package engine.model.logic.components;

import engine.math.Vector3D;

public class RandomWalker extends LogicComponent {
    @Override
    public void update() {
        Vector3D randomTranslation = Vector3D.getRandom(20).subtract(new Vector3D(10, 10, 10));
        this.gameObject.getTransform().translate(randomTranslation);
    }
}
