public class LuTester {
    public static void main(String[] args) {
        double[][] a = {{1, 0.5, 0.333333, 0.25}, {0.5, 0.333333, 0.25, 0.2}, {0.333333, 0.25, 0.2, 0.166667}, {0.25, 0.2, 0.166667, 0.142857}};
        double[][] b = {{1, 2, -1}, {0, 1, -1}, {2, 4, 0}};
        Matrix am = new Matrix(a);
        Matrix bm = new Matrix(b);
        LuFact j = new LuFact(bm);
    }
}
