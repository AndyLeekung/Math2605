import java.util.ArrayList;


public abstract class QRDecomp {
	
	protected Matrix A;
	protected Matrix Q;
	protected Matrix R;
	protected ArrayList<Matrix> qMatrices;
	/**
	 * Row and column dimensions
	 */
	protected static int m;

	protected static int n;
	
	/**
	 * Return Q of the QR decomposition
	 * @return Matrix Q
	 */
	public Matrix getQ() {
		return this.Q;
	}
	
	/**
	 * Return R of the QR decomposition 
	 * @return Matrix R
	 */
	public Matrix getR() {
		return this.R;
	}
	
	public Matrix getA() {
		return this.A;
	}
	
	/**
	 * Solves the linear system given a vector b using QR
	 * @param b The vector to solve with
	 * @return Solution x
	 */
	public double[] solve(double[] b) {
		double[] sol = new double[m];
		//Solve for Qy = B
		//y = Q^tb
		double[] y = Q.transpose().multiplyVector(b);
		//Solve for Rx = y
		//use backwards substitution
		sol[m - 1] = y[m - 1] / R.get(m - 1, m - 1);
		for (int i = m - 2; i >= 0; i--) {
			double[] row = R.getRowVector(i, i);
			double extSum = 0;
			for (int j = 1; j < row.length; j++) {
				extSum += row[j] * sol[i + j];
			}
			sol[i] = (y[i] - extSum) / row[0];
		}
		return sol;
	}
	
	/**
	 * Calculates the error ||QR - A||
	 * @return The error 
	 */
	public double error() {
		double error;
		//QR
		Matrix errorMatrix = Q.multiply(R);
		//QR - A
		errorMatrix.minusEquals(A);
		error = errorMatrix.maxNorm();
		return error;
	}
	
	/**
	 * Prints the solutions to the QR decomposition
	 * @param w Column width.
	 * @param d Number of digits after the decimal
	 */
	public void print(int w, int d) {
		System.out.println("----------Original Matrix----------");
		A.print(w, d);
		System.out.println("----------       Q       ----------");
		Q.print(w, d);
		System.out.println("----------       R       ----------");
		R.print(w, d);
		System.out.println("----------     Error     ----------\n");
		System.out.println("" + error());
		
	}
	
	/**
	 * Checks if vector has zeroes below first term
	 * @param vector Vector to check
	 * @return True if vector has all zeroes below first term, else false
	 */
	protected boolean checkZeroes(double[] vector) {
		boolean hasZeroes = true;
		for (int i = 1; i < vector.length && hasZeroes == true; i++) {
			if (vector[i] != 0) {
				hasZeroes = false;
			}
		}
		return hasZeroes;
	}
	

}
