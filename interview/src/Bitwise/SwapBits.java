package Bitwise;

public class SwapBits {
	public static int swapper(int num, int p1, int p2, int n) {
		if(n == 0) return num;
		int n1 = num >> p1;
		int n2 = num >> p2;
		int mask = (int)Math.pow(2, n) - 1;
		n1 = n1 & mask;
		n2 = n2 & mask;
		
		int xor = n1 ^ n2;
		n1 = xor << p2;
		n2 = xor << p1;
		
		num = num ^ (n1 | n2);
		
		return num;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(swapper(47, 1, 5, 3));
		System.out.println(swapper(28, 0, 3, 2));
	}

}
