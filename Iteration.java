public abstract class Iteration {

    /**
     * Checks to see that the Matrix object passed through the constructor is
     square
     * @param m Number of rows in the matrix
     * @param n Number of columns in the matrix
     */
    public void checkSquareDimensions(int m, int n) {
        if (!(m == n)) {
            throw new IllegalArgumentException("Matrix is not square.");
        }
    }

    /**
     * Checks to see if the Matrix is invertible
     * @param A a Matrix
     */
    public void checkInvertibility(Matrix A) {
        if (A.determinant() == 0) {
            throw new IllegalArgumentException("Matrix is not invertible.");
        }
    }

    /**
     * Gets the solution matrix x
     * @return the solution matrix x
     */
    public Matrix getX() {
        return xMatrix;
    }

    public void checkConvergence() {
        
    }
}
