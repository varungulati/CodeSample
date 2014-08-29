// http://www.geeksforgeeks.org/square-root-of-a-perfect-square/
// Babylonian method for square root
package SquareRoot;

public class SquareRoot {

	public static float squareRoot(float num) {
		float x = num;
		float y = 1;
		float e = 0.00001F;
		
		while(x-y > e) {
			x = (x+y)/2;
			y = num/x;
		}
		return x;
	}
	public static void main(String[] args) {
		System.out.println(SquareRoot.squareRoot(30));
	}

}
