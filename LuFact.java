public class LuFact {

    private double[][] L, U, lInverse, lStep, e;

    private Matrix lMatrix, uMatrix, lInverseMatrix, lStepMatrix, eMatrix;

    private int m, n;

    /**
     * Factors Matrix A into an upper triangular matrix (U) and a lower
     triangular matrix (L)
     * @param Matrix object A
     */
    public LuFact(Matrix A) {
        this.uMatrix = A;
        this.U = A.getArrayCopy();
        this.m = A.getRowDimension();
        this.n = A.getColumnDimension();
        try {
            checkSquareDimensions(m, n);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        this.e = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    e[i][j] = 1;
                }
            }
        }
        this.eMatrix = new Matrix(this.e);
        this.lInverseMatrix = new Matrix(this.e);
        this.lInverse = eMatrix.getArrayCopy();
        this.L = eMatrix.getArrayCopy();
        luFactor();
        lMatrix.print(5, 6);
        uMatrix.print(5, 6);
    }

    /**
     * Checks to see that the Matrix object passed through the constructor is
     square
     * @param m Number of rows in the matrix
     * @param n Number of columns in the matrix
     */
    private void checkSquareDimensions(int m, int n) {
        if (!(m == n)) {
            throw new IllegalArgumentException("Matrix is not square");
        }
    }

    /**
     * Factors the matrix into U and L
     */
    private void luFactor() {
        int rowStart = 1;
        for (int j = 0; j < n-1; j++) {
            for (int i = rowStart; i < m; i++) {
                if (!(U[i][j] == 0)) {
                    double scale = -1*(U[i][j]/U[rowStart-1][j]);
                    lStep = eMatrix.getArrayCopy();
                    lStep[i][j] = scale;
                    L[i][j] = -1*scale;
                    lStepMatrix = new Matrix(lStep);
                    uMatrix = lStepMatrix.multiply(uMatrix);
                    U = uMatrix.getArrayCopy();
                }
            }
            rowStart = rowStart + 1;
        }
        lMatrix = new Matrix(L);
    }

    /**
     * Gets the lower triangular matrix L
     * @return the lower triangular matrix L
     */
    public Matrix getL() {
        return lMatrix;
    }

    /**
     * Gets the upper triangular matrix U
     * @return the upper triangular matrix U
     */
    public Matrix getU() {
        return uMatrix;
    }
}
