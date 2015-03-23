import java.util.ArrayList;


public abstract class QRDecomp {
	
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
