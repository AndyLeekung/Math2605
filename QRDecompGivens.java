/**
 * QR Decomposition using Givens Rotations
 * @author Chingyeu Andy Leekung, Joeseph Lesniak, Jacob Goodpasture
 * @version 1.0
 */
public class QRDecompGivens extends QRDecomp{

	//TODO EVERYTHING

	
	/* ------------------------
	   Constructors
	 * ------------------------ */
	
	/**
	 * Constructor to decompose the Matrix into QR using Givens
	 * rotations
	 * @param A Matrix to decompose
	 */
	public QRDecompGivens(Matrix A) {
		this.R = A;
		m = A.getRowDimension();
		n = A.getRowDimension();
		//TODO Do the QR stuff here
	}
	
	/* ------------------------
	   Public Methods
	 * ------------------------ */
	
	
	/* ------------------------
	   Private Methods
	 * ------------------------ */
	
	private static Matrix givensMatrix(double[] givVec) {
		
	}
	

}