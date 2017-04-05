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
	/**
	 * @param num
	 * @param lo
	 * @param hi
	 * @param precision
	 * @return
	 */
	private static float mySqrtHelper(float num, float lo, float hi, float precision) {
		if(lo > hi) {
			return lo;
		}
		float mid = lo + (hi - lo)/2;
		
		if(mid > num/mid) {
			return mySqrtHelper(num, lo, mid - precision, precision);
		} 
		else if(mid + precision > num/(mid+ precision)) {
			return mid + precision;
		}
		else {
			return mySqrtHelper(num, mid + precision, hi, precision);
		}
	}
    /**
     * @param num
     * @return
     */
    public static float mySqrt(float num) {
    	return mySqrtHelper(num, 0, Float.MAX_VALUE, 0.0001F);
    }
	public static void main(String[] args) {
		System.out.println(SquareRoot.squareRoot(25));
		System.out.println(SquareRoot.mySqrt(25));
	}

}
