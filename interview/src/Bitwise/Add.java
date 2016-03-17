package Bitwise;

public class Add {
	public static int adder(int x, int y) {
		int carry = 1;
		while(carry != 0) {
			carry = x & y;
			x = x ^ y;
			y = carry << 1;
		}
		return x;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(adder(18,12));
	}

}
