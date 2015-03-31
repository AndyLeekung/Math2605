import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Tester for the first problem The Hilbert Matrix for Math 2605
 * @author Chingyeu Andy Leekung, Joeseph Lesniak, Jacob Goodpasture
 * @version 1.0
 */
public class ProblemOne {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(System.in);
		int choice = 0;
		System.out.println("---Problem 1: The Hilbert Matrix---");
		//-1 to exit
		while (choice != -1) {
			System.out.println("1) Enter a matrix file ");
			System.out.println("2) Use Hilbert Matrix of size n");
			System.out.println("-1) Exit");
			System.out.print("Enter your choice: ");
			choice = reader.nextInt();
			
			switch (choice) {
			case 1:
				enterMatrixFile();
				break;
			case 2:
				useHilbert();
				break;
			case -1:
				//exit
				break;
			default:
				System.out.println("Please enter a valid number.");
				break;
			}
		}

	}
	
	private static void enterMatrixFile() throws IOException {
		Scanner r = new Scanner(System.in);
		System.out.print("Please enter the file name: ");
		String fileName = r.next();
		System.out.println(fileName);
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		Matrix mat = Matrix.read(in);
		System.out.print("Is this matrix already augmented? 1) yes 2) no: ");
		int c = r.nextInt();
		switch (c) {
		case 1: //Already augmented
			Matrix A = mat.getMatrix(0, mat.getRowDimension() - 1, 0, mat.getColumnDimension() - 2);
			double[] b = mat.getColumnVector(mat.getColumnDimension() - 1);
			matrixMenu(A, b);
			break;
		case 2: //Not augmented
			matrixMenu(mat, null);
			break;
		default:
			System.out.println("Please enter 1 or 2");
		}
	}
	
	private static void useHilbert() {
		Scanner r = new Scanner(System.in);
		System.out.print("Enter n, the n x n dimension of the matrix: ");
		int n = r.nextInt();
		if (n <= 0) {
			throw new IllegalArgumentException("n must be greater or equal to 1.");
		}
		Matrix A = Matrix.hilbertMatrix(n);
		double[] b = Matrix.hilbertB(n);
		matrixMenu(A, b);
	}
	
	private static void matrixMenu(Matrix A, double[] b) {
		Scanner r = new Scanner(System.in);
		int c = 0;
		while (c != -1) {
			System.out.println("Matrix A: ");
			A.print(5, 6);
			if (b == null) {
				System.out.println("There is no b yet.\n");
			} else {
				System.out.println("b: \n");
				for (int i = 0; i < b.length; i++) {
					System.out.println(b[i]);
				}
			}
			System.out.println("\n1) LU Decomposition");
			System.out.println("2) QR with Householder Reflections");
			System.out.println("3) QR with Givens Rotations");
			System.out.println("4) Enter a vector b to solve with");
			System.out.println("-1) Exit");
			System.out.print("Enter your choice: ");
			c = r.nextInt();
			switch (c) {
			case 1: //LU
				break;
			case 2: //QR Householder
				QRHouse(A, b);
				break;
			case 3: //QR with Givens
				QRGivens(A, b);
				break;
			case 4: //enter b
					b = enterB(A.getColumnDimension());
				break;
			case -1: //Exit
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}
	
	private static void luMenu(Matrix A, double[] b) {
		//TODO
	}
	
	private static void QRHouse(Matrix A, double[] b) {
		QRDecomp qr = new QRDecompHouseHolder(A);
		qr.print(5, 6);
		if (b != null) {
			double[] x = qr.solve(b);
			System.out.println("----------      Xsol     ----------\n");
			System.out.print("{ ");
			for (int i = 0; i < x.length - 1; i++) {
				System.out.print("" + x[i] + ", ");
			}
			System.out.print(x[x.length - 1] + " }\n");
		}
	
	}
	
	private static void QRGivens(Matrix A, double[] b) {
		QRDecomp qr = new QRDecompGivens(A);
		qr.print(5, 6);
		if (b != null) {
			double[] x = qr.solve(b);
			System.out.println("----------      Xsol     ----------\n");
			System.out.print("{");
			for (int i = 0; i < x.length - 1; i++) {
				System.out.print("" + x[i] + ", ");
			}
			System.out.print(x[x.length - 1] + "}\n");
		}
	}
	 
	private static double[] enterB(int n) {
		Scanner r = new Scanner(System.in);
		double b[] = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter element " + i + ": ");
			b[i] = r.nextDouble();
		}
		return b;
	}

}
