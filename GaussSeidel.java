public class GaussSeidel extends Iteration {

    private double[][] A, b, x, e, old;

    private double tempL, tempU;

    private Matrix aMatrix, bMatrix, xMatrix, eMatrix, oldMatrix;

    private double tol;

    private int m, n;

    /**
     * Solves a linear system Ax=b using Gauss-Seidel iterations
     * @param A a Matrix
     * @param b the solution matrix
     * @param x the initial guess for the solution x
     * @param tol the accuracy to which the answer should be
     */
    public GaussSeidel(Matrix A, Matrix b, Matrix x, double tol) {
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
        this.tol = tol + 1;
        this.tempL = 0;
        this.tempU = 0;
        while (this.tol > tol) {
            calcX();
        }
        xMatrix.print(5, 6);
        aMatrix.multiply(xMatrix).print(5, 6);
    }

    /**
     * Calculates another iteration of the solution matrix x
     */
    private void calcX() {
        oldMatrix = xMatrix.copy();
        old = oldMatrix.getArrayCopy();
        for (int d = 0; d < m; d++) {
            for (int z = 0; z < n; z++) {
                if (d < z) {
                    tempU = tempU + (A[d][z] * old[z][0]);
                }
            }
            for (int z = 0; z < d; z++) {
                if (d > z) {
                    tempL = tempL + (A[d][z] * x[z][0]);
                }
            }
            x[d][0] = (1/A[d][d]) * (b[d][0] - tempL - tempU);
            tempU = 0;
            tempL = 0;
        }
        xMatrix = new Matrix(x);
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
}
