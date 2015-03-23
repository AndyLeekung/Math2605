import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MatrixFileTester {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		Matrix mat = Matrix.read(in);
		mat.print(5, 6);
		QRDecompHouseHolder qr1 = new QRDecompHouseHolder(mat);
		Matrix r = qr1.getR();
		//r.print(5, 6);
		Matrix q = qr1.getQ();
		q.print(5, 6);
		r.print(5, 6);
	}
}
