public class Jacobi extends Iteration {

    private double[][] A, L, D, U, b, x, dInverse, e;

    private Matrix aMatrix, lMatrix, dMatrix, uMatrix, bMatrix, xMatrix, dInverseMatrix, oldMatrix, eMatrix;

    private double tol;

    private int m, n;

    /**
     * Solves a linear system Ax=b using Jacobi iterations
     * @param A a Matrix
     * @param b the solution matrix
     * @param x the initial guess for the solution x
     * @param tol the accuracy to which the answer should be
     */
    public Jacobi(Matrix A, Matrix b, Matrix x, double tol) {
        this.A = A.getArrayCopy();
        this.aMatrix = A;
        this.b = b.getArrayCopy();
        this.bMatrix = b;
        this.m = A.getRowDimension();
        this.n = A.getColumnDimension();
        try {
            checkSquareDimensions(m, n);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        try {
            checkInvertibility(A);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        this.x = x.getArrayCopy();
        this.xMatrix = x;
        this.L = getL();
        lMatrix = new Matrix(this.L);
        this.D = getD();
        dMatrix = new Matrix(this.D);
        this.dInverse = getDInverse();
        dInverseMatrix = new Matrix(this.dInverse);
        this.U = getU();
        uMatrix = new Matrix(this.U);
        this.tol = tol + 1;
        while (this.tol > tol) {
            calcX();
        }
        xMatrix.print(5, 6);
        aMatrix.multiply(xMatrix).print(5, 6);
    }

    /**
     * Gets a 2-D array that represents the matrix L
     * @return L a 2-D array that represents the matrix L
     */
    private double[][] getL() {
        L = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    L[i][j] = A[i][j];
                }
            }
        }
        return L;
    }

    /**
     * Gets a 2-D array that represents the matrix D
     * @return U a 2-D array that represents the matrix D
     */
    private double[][] getD() {
        D = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    D[i][j] = A[i][j];
                }
            }
        }
        return D;
    }

    /**
     * Gets a 2-D array that represents the matrix U
     * @return U a 2-D array that represents the matrix U
     */
    private double[][] getU() {
        U = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    U[i][j] = A[i][j];
                }
            }
        }
        return U;
    }

    /**
     * Gets a 2-D array that represents the inverse of matrix D
     * @return dInverse a 2-D array that represents the inverse of the matrix D
     */
    private double[][] getDInverse() {
        dInverse = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dInverse[i][j] = 1 / D[i][j];
                }
            }
        }
        return dInverse;
    }

    /**
     * Calculates another iteration of the solution matrix x
     */
    private void calcX() {
        oldMatrix = xMatrix.copy();
        xMatrix = dInverseMatrix.multiply(bMatrix.minus(lMatrix.plus(uMatrix).multiply(xMatrix)));
        x = xMatrix.getArray();
        eMatrix = xMatrix.minus(oldMatrix);
        e = eMatrix.getArray();
        double norm = 0;
        for (int i = 0; i < eMatrix.getRowDimension(); i++) {
            for (int j = 0; j < eMatrix.getColumnDimension(); j++) {
                norm += e[i][j] * e[i][j];
            }
        }
        tol = Math.sqrt(norm);
    }

    /**
     * Gets the solution matrix x
     * @return the solution matrix x
     */
    public Matrix getX() {
        return xMatrix;
    }
}
