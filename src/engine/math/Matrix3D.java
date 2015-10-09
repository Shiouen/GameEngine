package engine.math;

public class Matrix3D {
    private double values[][];

    private Matrix3D() {
        this.values = new double[][] {
                { 1.0, 0.0, 0.0 },
                { 0.0, 1.0, 0.0 },
                { 0.0, 0.0, 1.0 }
        };
    }

    public static Matrix3D getXRotation(double angle) {
        Matrix3D matrix = new Matrix3D();
        matrix.values[1][1] = Math.cos(angle);
        matrix.values[2][2] = Math.cos(angle);
        matrix.values[1][2] = Math.sin(angle);
        matrix.values[2][1] = -Math.sin(angle);
        return matrix;
    }
    public static Matrix3D getYRotation(double angle) {
        Matrix3D matrix = new Matrix3D();
        matrix.values[0][0] = Math.cos(angle);
        matrix.values[2][0] = Math.sin(angle);
        matrix.values[0][2] = -Math.sin(angle);
        matrix.values[2][2] = Math.cos(angle);
        return matrix;
    }
    public static Matrix3D getZRotation(double angle) {
        Matrix3D matrix = new Matrix3D();
        matrix.values[0][0] = Math.cos(angle);
        matrix.values[0][1] = Math.sin(angle);
        matrix.values[1][0] = -Math.sin(angle);
        matrix.values[1][1] = -Math.cos(angle);
        return matrix;
    }

    public Vector3D multiply(Vector3D v){
        double x = this.values[0][0] * v.getX() + this.values[1][0] * v.getY() + this.values[2][0] * v.getZ();
        double y = this.values[0][1] * v.getX() + this.values[1][1] * v.getY() + this.values[2][1] * v.getZ();
        double z = this.values[0][2] * v.getX() + this.values[1][2] * v.getY() + this.values[2][2] * v.getZ();
        return new Vector3D(x, y, z);
    }
}
