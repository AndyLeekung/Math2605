public class PowerMethodTester {
	public static void main (String args[]) {
	
		//double[][] a = {{2, -12}, {1, -5}};
		double[][] a = {{20,2,1},{9,0,2},{4,1,3}};
		double[][] startingApprox = {{2.1 * (Math.pow(10, 5))}, {1.9 * (Math.pow(10, 5))}, {1.8 * (Math.pow(10, 5))}, {2.1 * (Math.pow(10, 5))}, {2.0 * (Math.pow(10, 5))}, {1.7 * Math.pow(10,  5)}, {1.2 * (Math.pow(10, 5))}, {0.9 * (Math.pow(10, 5))}, {0.5 * (Math.pow(10, 5))}};
		
		double[][] leslie = {{0, 1.2, 1.1, .9, .1, 0, 0, 0, 0},
				{.7, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, .85, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, .9, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, .9, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, .88, 0 , 0, 0, 0},
				{0, 0, 0, 0, 0, .8, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, .77, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, .4, 0}};
		
		double[][] difLeslie = {{0, .6, 1.1, .9, .1, 0, 0, 0, 0},
				{.7, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, .85, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, .9, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, .9, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, .88, 0 , 0, 0, 0},
				{0, 0, 0, 0, 0, .8, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, .77, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, .4, 0}};
		
		Matrix am = new Matrix(a);
		Matrix startingApproxMatrix = new Matrix(startingApprox);
		Matrix leslieMatrix = new Matrix(leslie);
		//Matrix bm = new Matrix(b);
		//Matrix difLeslieMatrix = new Matrix(difLeslie);
		//Matrix twentytwentyStart = new power_method(difLeslieMatrix, startingApproxMatrix, 1).getApprox();
		//new power_method(leslieMatrix, twentytwentyStart, Math.pow(10, -8));
		new power_method(leslieMatrix, startingApproxMatrix, .000000001);
	}
}