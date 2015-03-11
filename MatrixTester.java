//import java.util.Scanner;


public class MatrixTester {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
//		Scanner reader = new Scanner(System.in);
//		System.out.print("Number of rows in matrix: ");
//		int m = reader.nextInt();
//		System.out.print("Number of columns in matrix: ");
//		int n = reader.nextInt();
//		double[][] matArray = new double[m][n];
//		for (int i = 0; i < m; i++) {
//			System.out.print("Enter row " + i + ": ");
//			for (int j = 0; j < n; j++) {
//				matArray[i][j] = reader.nextDouble();
//			}
//		}
		double[][] matArray = {{1, 2}, {3, 4}, {5, 6}};
		Matrix mat = new Matrix(matArray);
		double[][] matArray2 = {{1,  2, 3}, {4, 5, 6}};
		Matrix mat2 = new Matrix(matArray2);
		mat2.multiplyEquals(mat);
		mat2.print(5, 2);
//		mat2.print(5, 2);
//		
//		Matrix mat3 = mat2.multiply(mat);
//		mat3.print(5, 2);
//		Matrix exc = mat.multiply(mat2);
//		exc.print(5, 2);
//		double[] col0 = mat.getColumnVector(0);
//		double[] col1 = mat.getColumnVector(1);
//		for (int i = 0; i < col0.length; i++) {
//			System.out.println(col0[i]);
//		}
//		System.out.println(mat.dotProduct(col0, col1));
	}

}
