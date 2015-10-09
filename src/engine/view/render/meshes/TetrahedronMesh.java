package engine.view.render.meshes;

import engine.math.Vector3D;

public class TetrahedronMesh extends Mesh {
    public TetrahedronMesh() {
        super();

        Vector3D p1 = new Vector3D(1, 0, -1.0 / Math.sqrt(2));
        Vector3D p2 = new Vector3D(-1, 0, -1.0 / Math.sqrt(2));
        Vector3D p3 = new Vector3D(0, 1, 1.0 / Math.sqrt(2));
        Vector3D p4 = new Vector3D(0, -1, 1.0 / Math.sqrt(2));

        this.addFace(new Face(p1, p3, p2));
        this.addFace(new Face(p1, p4, p3));
        this.addFace(new Face(p2, p4, p3));
        this.addFace(new Face(p2, p1, p4));
    }
}
