package Mathematical;

public class BinomialCoefficient {
	public static int coeff(int n, int r) {
		if(r == n || r == 0) return 1;
		if(r == n - 1 || r == 1) return n;
		
		int C = 1;
		for (int i = 1; i <= r; i++) {
			C = C*(n - i + 1)/i;
		}
		return C;
	}	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coeff(8, 2));
	}

}
