public class SolveLuB {

    private Matrix aMatrix, bMatrix, xMatrix, lMatrix, uMatrix;

    private double[][] A, b, x, L, U, y;

    private int m, n;

    public SolveLuB(Matrix A, Matrix b) {
        this.aMatrix = A;
        this.A = A.getArrayCopy();
        this.bMatrix = b;
        this.b = b.getArrayCopy();
        try {
            checkSquareDimensions(m, n);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        this.m = A.getRowDimension();
        this.n = A.getColumnDimension();
        LuFact lu = new LuFact(A);
        this.lMatrix = lu.getL();
        this.L = lMatrix.getArrayCopy();
        this.uMatrix = lu.getU();
        this.U = uMatrix.getArrayCopy();
        this.x = new double[m][1];
        this.y = new double[m][1];
        solveLu();
        this.xMatrix = new Matrix(this.x);
        xMatrix.print(5, 5);
    }

    public void checkSquareDimensions(int m, int n) {
        if (!(m == n)) {
            throw new IllegalArgumentException("Matrix is not square.");
        }
    }

    public void solveLu() {
        for (int i = 0; i < m; i++) {
            double yTemp = b[i][0];
            for (int j = 0; j < i; j++) {
                yTemp = yTemp - L[i][j]*y[j][0];
            }
            y[i][0] = yTemp/L[i][i];
        }
        for (int k = m-1; k > -1; k--) {
            double xTemp = y[k][0];
            for (int l = n-1; l > k; l--) {
                xTemp = xTemp - U[k][l]*x[l][0];
            }
            x[k][0] = xTemp/U[k][k];
        }
    }
}
