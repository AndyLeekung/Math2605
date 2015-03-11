import java.util.Scanner;


public class MatrixTester {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.print("Number of rows in matrix: ");
		int m = reader.nextInt();
		System.out.print("Number of columns in matrix: ");
		int n = reader.nextInt();
		double[][] matArray = new double[m][n];
		for (int i = 0; i < m; i++) {
			System.out.print("Enter row " + i + ": ");
			for (int j = 0; j < n; j++) {
				matArray[i][j] = reader.nextDouble();
			}
		}
		Matrix mat = new Matrix(matArray);
		mat.print(5, 2);
		double[] col0 = mat.getColumnVector(0);
		double[] col1 = mat.getColumnVector(1);
		for (int i = 0; i < col0.length; i++) {
			System.out.println(col0[i]);
		}
		System.out.println(mat.dotProduct(col0, col1));
	}

}
