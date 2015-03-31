import java.util.Random;

public class Encoder {

    private int n;

    private Matrix a0Matrix, a1Matrix, y0Matrix, y1Matrix, xMatrix, totalYMatrix;

    private double[][] a0, a1, y0, y1, x, totalY;

    private Random rand;

    public Encoder(int n) {
        rand = new Random();
        this.n = n+3;
        double[][] x3 = {{1}, {0}, {1}, {1}, {1}, {0}, {1}, {1}, {1}, {0}, {0}, {0}, {1}, {0}, {0}, {0}, {0}};
        this.x = x3;
        //createX();
        this.xMatrix = new Matrix(this.x);
        this.a0 = new double[this.n][this.n];
        createA0();
        this.a0Matrix = new Matrix(this.a0);
        this.a1 = new double[this.n][this.n];
        createA1();
        this.a1Matrix = new Matrix(this.a1);
        this.y0Matrix = multiplyBit(this.a0Matrix, this.xMatrix);
        this.y0 = y0Matrix.getArray();
        this.y1Matrix = multiplyBit(this.a1Matrix, this.xMatrix);
        this.y1 = y1Matrix.getArray();
        this.totalY = new double[this.n * 2][1];
        combine();
        this.totalYMatrix = new Matrix(this.totalY);
    }

    private void createX() {
        for (int i = 0; i < n; i++) {
            if (i < (n-3)) {
                int num = rand.nextInt(2);
                x[i][0] = num;
            } else {
                x[i][0] = 0;
            }
        }
    }

    private void createA0() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    a0[i][j] = 1;
                } else if ((i-2) == j) {
                    a0[i][j] = 1;
                } else if ((i-3) == j) {
                    a0[i][j] = 1;
                } else {
                    a0[i][j] = 0;
                }
            }
        }
    }

    private void createA1() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    a1[i][j] = 1;
                } else if ((i-1) == j) {
                    a1[i][j] = 1;
                } else if ((i-3) == j) {
                    a1[i][j] = 1;
                } else {
                    a1[i][j] = 0;
                }
            }
        }
    }

    private Matrix multiplyBit(Matrix A, Matrix B) {
        Matrix X = new Matrix(A.getRowDimension(), B.getColumnDimension());
        double[][] C = X.getArray();
        for (int i = 0; i < A.getRowDimension(); i++) {
            for (int j = 0; j < B.getColumnDimension(); j++) {
                C[i][j] = (Matrix.dotProduct(A.getRowVector(i), B.getColumnVector(j))) % 2;
            }
        }
        return X;
    }

    private void combine() {
        for (int i = 0; i < n*2; i++) {
            if (i%2 == 0) {
                totalY[i][0] = y0[i/2][0];
            } else {
                totalY[i][0] = y1[(i-1)/2][0];
            }
        }
    }

    public Matrix getA0() {
        return a0Matrix;
    }

    public Matrix getA1() {
        return a1Matrix;
    }

    public Matrix getY0() {
        return y0Matrix;
    }

    public Matrix getY1() {
        return y1Matrix;
    }

    public Matrix getY() {
        return totalYMatrix;
    }

    public Matrix getX() {
        return xMatrix;
    }
}
