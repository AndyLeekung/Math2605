public class power_method {
	private Matrix approx, initial;
	private double TOLERANCE = .00000001;
	
	/**
	 * Performs the PowerMethod on a given matrix A for a given amount of iterations
	 * prints out the amount
	 * @param A matrix to perform power method on
	 * @param iterations amount of times to perform power method
	 */
	public power_method(Matrix A, int iterations) {
		initial = A;
		this.approx = new Matrix(A.getRowDimension(), 1, 1);
		powerMethod(iterations);
		printApprox();
		printEigenvalue();
	}
	
	/**
	 * Performs the PowerMethod on a given matrix A until a given
	 * tolerance is reached
	 * @param A matrix to perform power method on
	 */
	public power_method(Matrix A) {
		initial = A;
		this.approx = new Matrix(A.getRowDimension(), 1, 1);
		System.out.println("Iterations: " + powerMethod());
		printApprox();
		printEigenvalue();
	}
	
	/**
	 * Performs the PowerMethod on a given matrix A until a given
	 * tolerance is reached
	 * @param A matrix to perform power method on
	 * @param approx the initial approximation for the power method
	 * @param tol minimum tolerance of error for the method
	 */
	public power_method(Matrix A, Matrix approx, double tol) {
		TOLERANCE = tol;
		initial = A;
		this.approx = approx;
		System.out.println("Iterations: " + powerMethod());
		printApprox();
		printEigenvalue();
	}
	
	/**
	 * Performs the PowerMethod on a given matrix A until a given
	 * tolerance is reached
	 * @param A matrix to perform power method on
	 * @param approx the initial approximation for the power method
	 * @param tol minimum tolerance of error for the method
	 */
	public power_method(Matrix A, Matrix approx, int iterations) {
		initial = A;
		this.approx = approx;
		powerMethod(iterations);
		//printApprox();
		//printEigenvalue();
	}
	
	
	/**
	 * Performs one iteration of power method
	 * @return new approximation 
	 */
	private Matrix powerMethodIteration() {
		Matrix tempApprox = new Matrix(initial.getRowDimension(), 1);
		double rowSum = 0;
		for (int row = 0; row < initial.getRowDimension(); row++) {
			for (int col = 0; col < initial.getColumnDimension(); col++) {
				rowSum += initial.get(row, col) * approx.get(col, 0);
			}
			tempApprox.set(row, 0, rowSum);
			rowSum = 0;
		}
		return tempApprox;
	}
	
	
	/*
	 * runs powerMethodIteration for given amount of iterations
	 * @param iterations to be performed
	 */
	private void powerMethod(int iterations) {
		//Matrix tempApprox = powerMethodIteration();
		for (int i = 0; i < iterations; i++) {
			approx = powerMethodIteration();
		}
		//Normalizing

		double normalizer = approx.get(approx.getRowDimension() - 1, 0);
		for (int i = 0; i < approx.getRowDimension(); i++) {
			approx.set(i, 0, approx.get(i, 0) / normalizer);
		}
	}
	
	/**
	 * Runs the power method with enough iterations to get a tol < TOLERANCE
	 * @return iterations of powerMethod
	 */
	private int powerMethod() {
		//Matrix tempApprox = powerMethodIteration();
		double tol = 100;
		int iterations = 0;
		double eigenvalue = 0;
		while (tol > (TOLERANCE)) {
			
			if (iterations < 6) {
				System.out.print("Age distribution in " + (int) (2000 + ((iterations) * 10)) + ": ");
				printApprox();
				System.out.println("Total population: " + matrixTotal(approx));
				printEigenvalue();
			}
			
			approx = powerMethodIteration();
			double tempEigen = getEigenvalue();
			tol = Math.abs(tempEigen - eigenvalue);
			eigenvalue = tempEigen;
			iterations++;
			if (iterations >= 150) {
				throw new Error("Did not converge within 150 iterations.");
			}
		}
		//Normalizing
		double normalizer = approx.get(approx.getRowDimension() - 1, 0);
		for (int i = 0; i < approx.getRowDimension(); i++) {
			approx.set(i, 0, approx.get(i, 0) / normalizer);
		}
		
		return iterations;
	}
	
	
	
	/**
	 * Calculates and prints an Eigenvalue approximation as an int
	 **/
	private void printEigenvalue() {
		Matrix tempApprox = new Matrix(initial.getRowDimension(), 1);
		double rowSum = 0;
		for (int row = 0; row < initial.getRowDimension(); row++) {
			for (int col = 0; col < initial.getColumnDimension(); col++) {
				rowSum += initial.get(row, col) * approx.get(col, 0);
			}
			tempApprox.set(row, 0, rowSum);
			rowSum = 0;
		}
		//System.out.println("{" + tempApprox.get(0, 0) + "}, {" + tempApprox.get(1, 0) + "}");
		double eigenvalue = 0;
		for (int i = 0; i < tempApprox.getRowDimension(); i++) {
			eigenvalue += tempApprox.get(i, 0) * approx.get(i, 0);
		}
		
		eigenvalue = eigenvalue / (Matrix.dotProduct(approx.getColumnVector(0,0), approx.getColumnVector(0,0)));
		System.out.println("Eigenvalue: " + (eigenvalue));
	}
	
	/**
	 * Calculates and returns an approximate eigenvalue as a double
	 * @return
	 **/
	private double getEigenvalue() {
		//System.out.println("Approx.: {" + approx.get(0, 0) + "}, {" + approx.get(1, 0) + "}");
		//System.out.println("Initial: {" + initial.get(0,0) + ", " + initial.get(0,1) + "}, {" + initial.get(1,0) + ", " + initial.get(1,1) + "}}");
		Matrix tempApprox = new Matrix(initial.getRowDimension(), 1);
		double rowSum = 0;
		for (int row = 0; row < initial.getRowDimension(); row++) {
			for (int col = 0; col < initial.getColumnDimension(); col++) {
				rowSum += initial.get(row, col) * approx.get(col, 0);
				//System.out.println(initial.get(row, col) + " * " + approx.get(col, 0) + " = " + initial.get(row, col) * approx.get(col, 0));
			}
			//System.out.println("rowSum: " + rowSum);
			tempApprox.set(row, 0, rowSum);
			rowSum = 0;
		}
		//System.out.println("{" + tempApprox.get(0, 0) + "}, {" + tempApprox.get(1, 0) + "}");
		double eigenvalue = 0;
		for (int i = 0; i < tempApprox.getRowDimension(); i++) {
			eigenvalue += tempApprox.get(i, 0) * approx.get(i, 0);
		}
		
		eigenvalue = eigenvalue / (Matrix.dotProduct(approx.getColumnVector(0,0), approx.getColumnVector(0,0)));	
		return eigenvalue;
	}
	
	/**
	 * Returns the value of approx
	 * @return approx, the n by 1 matrix used as an approximation
	 */
	public Matrix getApprox() {
        return approx;
    }
	
	/**
	 * Prints the current value of approx
	 */
	public void printApprox() {
		System.out.print("Eigenvector Approximation: {");
		for (int i = 0; i < approx.getRowDimension(); i++) {
			System.out.print("{" + (approx.get(i, 0)) + "}");
			if (i != approx.getRowDimension() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	
	public double matrixTotal(Matrix approx) {
		double total = 0;
		for (int row = 0; row < approx.getRowDimension(); row++) {
			total += approx.get(row, 0);
		}
		return total;
	}
}
