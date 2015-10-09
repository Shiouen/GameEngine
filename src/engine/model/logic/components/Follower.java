package engine.model.logic.components;

import engine.math.Vector3D;
import engine.model.logic.GameObject;

public class Follower extends LogicComponent {
    private GameObject leader;

    public Follower(GameObject leader) {
        this.leader = leader;
    }

    @Override
    public void update() {
        // find direction to leader
        Vector3D leaderPosition = this.leader.getTransform().getPosition();
        Vector3D objectPosition = this.gameObject.getTransform().getPosition();

        Vector3D toLeader = leaderPosition.subtract(objectPosition);

        if (toLeader.getMagnitude() < 50) { return; }

        this.gameObject.getTransform().translate(toLeader.normalize());
    }
}
