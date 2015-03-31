public class SolveLuTester {
    public static void main(String[] args) {
        double[][] a = {{1, 0.5, 0.333333333, 0.25}, {0.5, 0.333333333, 0.25, 0.2}, {0.33333333, 0.25, 0.2, 0.166666666}, {0.25, 0.2, 0.1666666666, 0.142857}};
        Matrix aMatrix = new Matrix(a);
        double[][] b = {{0.0464159}, {0.0464159}, {0.0464159}, {0.0464159}};
        Matrix bMatrix = new Matrix(b);
        SolveLuB solve = new SolveLuB(aMatrix, bMatrix);
    }
}
