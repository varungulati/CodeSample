package Kadane;
public class Kadane {
	public int maxSubArray(int[] arr) {
		int maxSofar = 0, maxEndingHere = 0;
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if(maxSofar < maxEndingHere) {
				maxSofar = maxEndingHere;
			}
		}
		return maxSofar;
	}
	// Takes care of all negative numbers.
	public int maxSubArrayModified(int[] a) {
		int currMax = a[0];
		int maxSoFar = a[0];
		for(int i = 0; i < a.length; i++) {
			if(currMax + a[i] > a[i]) {
				currMax += a[i];
			} else {
				currMax = a[i];
			}
			if(maxSoFar < currMax) {
				maxSoFar = currMax;
			}
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] arr = {-2, -3, -4, -1, -2, -1, -5, -3};
		System.out.println(new Kadane().maxSubArrayModified(arr));
	}

}
