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
	
	/**
	 * Private method to get the householder vector
	 * @param vector Vector to reflect
	 * @return the householder reflection vector
	 */
	public static double[] houseHolderVector(double[] x) {
		double[] houseHolder = new double[x.length];
		double[] e = new double[x.length];
		double normX = Matrix.norm(x);
		e[0] = normX;
		//check if the vector needs it?
		// v = x + ||x||e
		houseHolder = Matrix.plus(x, e);
		// u = v / ||v||
		double normV = Matrix.norm(houseHolder);
		houseHolder = Matrix.multiply(houseHolder, 1 / normV);
		return houseHolder;
	}
	
	/**
	 * H = I - 2uu^t
	 * Get the householder matrix
	 * @param hhVec The householder vector 
	 * @return The householder matrix
	 */
	public static Matrix houseHolderMatrix(double[] hhVec) {
		//u * u^t
		Matrix X = Matrix.multiplyVectors(hhVec, hhVec);
		//2 * u * u^t
		X.timesEquals(2);
		//I
		Matrix houseHolder = Matrix.identity(X.getRowDimension(), X.getColumnDimension());
		//houseHolder.print(5, 2);
		// I - 2uu^t
		houseHolder.minusEquals(X);
		return houseHolder;
	}

}
