package engine.math;

import java.util.logging.Logger;

public class Vector3D {
    private final double x;
    private final double y;
    private final double z;
    private static final Logger log = Logger.getLogger(Vector3D.class.getName());

    private Vector3D() { this(Vector3D.getRandom(10)); }
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D(Vector3D other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public double getZ() { return this.z; }

    public double getMagnitude() {
        double powx = this.x * this.x;
        double powy = this.y * this.y;
        double powz = this.z * this.z;
        return Math.sqrt(powx + powy + powz);
    }
    public static Vector3D getRandom(double max) {
        double x = Math.random() * max;
        double y = Math.random() * max;
        double z = Math.random() * max;
        return new Vector3D(x, y, z);
    }

    public Vector3D add(Vector3D other) {
        double x = this.x + other.x;
        double y = this.y + other.y;
        double z = this.z + other.z;
        return new Vector3D(x, y, z);
    }
    public Vector3D cross(Vector3D other){
        double x = (this.y * other.z) - (this.z * other.y);
        double y = (-this.x * other.z) + (other.x * this.z);
        double z = (this.x * other.y) - (other.x * this.y);
        return new Vector3D(x, y, z);
    }
    public double dot(Vector3D other) {
        double x = this.x * other.x;
        double y = this.y * other.y;
        double z = this.z * other.z;
        return x + y + z;
    }
    public Vector3D multiply(double factor) {
        double x = this.x * factor;
        double y = this.y * factor;
        double z = this.z * factor;
        return new Vector3D(x, y, z);
    }
    public Vector3D rotate(Vector3D rotation) {
        Matrix3D matrix = Matrix3D.getZRotation(rotation.getZ());
        Vector3D tmp = matrix.multiply(this);

        matrix = Matrix3D.getYRotation(rotation.getY());
        tmp = matrix.multiply(tmp);

        matrix = Matrix3D.getXRotation(rotation.getX());
        tmp = matrix.multiply(tmp);

        return tmp;
    }
    public Vector3D scale(Vector3D scale) {
        double x = this.x * scale.x;
        double y = this.y * scale.y;
        double z = this.z * scale.z;
        return new Vector3D(x, y, z);
    }
    public Vector3D subtract(Vector3D other) {
        double x = this.x - other.x;
        double y = this.y - other.y;
        double z = this.z - other.z;
        return new Vector3D(x, y, z);
    }

    public Vector3D normalize(){
        double magnitude = this.getMagnitude();
        return this.multiply(1 / magnitude);
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", z=" + this.z +
                '}';
    }
}
