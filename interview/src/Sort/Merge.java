package Sort;

import java.util.Arrays;

public class Merge {
	public static void mergeSort(int[] arr, int lo, int hi) {
		if(hi - lo <= 0) {
			return;
		}
		int mid = lo + (hi - lo)/2;
		mergeSort(arr, lo, mid);
		mergeSort(arr, mid + 1, hi);
		mergeHelper(arr, lo, mid, hi);
	}
	private static void mergeHelper(int[] arr, int lo, int mid, int hi) {
		int i = 0, j = 0, index = lo;
		int sizeLeft = mid - lo + 1;
		int sizeRight = hi - mid;
		int arrLeft[] = new int[sizeLeft];
		int arrRight[] = new int[sizeRight];
		arrLeft = Arrays.copyOfRange(arr, lo, mid + 1);
		arrRight = Arrays.copyOfRange(arr, mid + 1, hi + 1);
		while(i < arrLeft.length && j < arrRight.length) {
			if(arrLeft[i] < arrRight[j]) {
				arr[index++] = arrLeft[i++];
			} else {
				arr[index++] = arrRight[j++];
			}
		}
		while(i < arrLeft.length) 
			arr[index++] = arrLeft[i++];
		while(j < arrRight.length)
			arr[index++] = arrRight[j++];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8,1,2,6,3,-10,4,9};
		mergeSort(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}

}
