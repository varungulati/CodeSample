package Backtracking;

import java.util.Arrays;

//http://www.geeksforgeeks.org/fill-two-instances-numbers-1-n-specific-way/
	
public class ArrangeNumbersInArray {
	public static boolean BT(int[] arr, int n, int count) {
		if(count == arr.length) {
			return true;
		}
		System.out.println(Arrays.toString(arr));
		boolean ret = false;
		for (int i = 0; i < arr.length; i++) {
			if (i + n/2 + 1 < arr.length && arr[i] == -1 && arr[i + n/2 + 1] == -1) {
				arr[i] = n/2;
				arr[i + n/2 + 1] = n/2;
				count += 2;
			ret = BT(arr, n - 2, count);
			if(!ret) {
				arr[i] = -1;
				arr[i + n/2 + 1] = -1;
				count -= 2;
				}
			} else {
				continue;
			}
		}
		return ret;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 7;
		int arr[] = new int[2*n];
		Arrays.fill(arr, -1);
		ArrangeNumbersInArray.BT(arr, 2*n, 0);
		System.out.println(Arrays.toString(arr));
	}

}
