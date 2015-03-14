/**
 * QR Decomposition using Householder reflections
 * @author Chingyeu Andy Leekung, Joeseph Lesniak, Jacob Goodpasture
 * @version 1.0
 */
public class QRDecompHouseHolder {
	
	//TODO EVERYTHING
	
	/**
	 * Storage for the matrices of the QR decomp
	 */
	private double[][] QR, Q, R;
	
	/**
	 * Row and column dimensions
	 */
	private int m, n;
	
	/* ------------------------
	   Constructors
	 * ------------------------ */
	
	/**
	 * Constructor to decompose the Matrix into QR using household
	 * reflections
	 * @param A Matrix to decompose
	 */
	public QRDecompHouseHolder(Matrix A) {
		QR = A.getArrayCopy();
		m = A.getRowDimension();
		n = A.getRowDimension();
		//TODO Do the QR stuff here
	}
	
	/* ------------------------
	   Public Methods
	 * ------------------------ */
	
	/**
	 * Return Q of the QR decomposition
	 * @return Matrix Q
	 */
	public Matrix getQ() {
		return new Matrix(Q);
	}
	
	/**
	 * Return R of the QR decomposition 
	 * @return Matrix R
	 */
	public Matrix getR() {
		return new Matrix(R);
	}

}
