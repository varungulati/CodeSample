package Google;

import java.util.Arrays;

public class LoadShare {
	public static int[] summer(int arr[]) {
		int toReturn[] = new int[arr.length];
		toReturn[0] = arr[0];
		for (int i = 1; i < toReturn.length; i++) {
			toReturn[i] = toReturn[i-1] + arr[i];
		}
		return toReturn;
	}
	public static int binSearch(int arr[], int lo, int hi, int num) {
		if(lo > hi) {
			return lo;
		}
		int mid = lo + (hi-lo)/2;
		if(arr[mid] == num) {
			return mid;
		}
		if(arr[mid] > num) {
			return binSearch(arr, lo, mid - 1, num);
		} else {
			return binSearch(arr, mid + 1, hi, num);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100,90,1,1,1};
		int modified[] = summer(arr);
		System.out.println(Arrays.toString(modified));
		System.out.println(binSearch(modified, 0, arr.length - 1, 191));
	}

}
