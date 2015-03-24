public class GaussTester {
    public static void main(String[] args) {
        double[][] a = {{4, 1, -1}, {2, 7, 1}, {1, -3, 12}};
        Matrix am = new Matrix(a);
        double[][] b = {{3}, {19}, {31}};
        Matrix bm = new Matrix(b);
        double[][] x = {{0}, {0}, {0}};
        Matrix xm = new Matrix(x);
        double[][] a2 = {{16, 3}, {7, -11}};
        Matrix am2 = new Matrix(a2);
        double[][] b2 = {{11}, {13}};
        Matrix bm2 = new Matrix(b2);
        double[][] x2 = {{1}, {1}};
        Matrix xm2 = new Matrix(x2);
        double[][] a3 = {{7, -2, 1, 2}, {2, 8, 3, 1}, {-1, 0, 5, 2}, {0, 2, -1, 4}};
        Matrix am3 = new Matrix(a3);
        double[][] b3 = {{3}, {-2}, {5}, {4}};
        Matrix bm3 = new Matrix(b3);
        double[][] x3 = {{0}, {0}, {0}, {0}};
        Matrix xm3 = new Matrix(x3);
        GaussSeidel g = new GaussSeidel(am3, bm3, xm3, 0.0000000001);
    }
}
