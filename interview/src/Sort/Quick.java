package Sort;

import java.util.Arrays;

// Worst case is O(n^2)
// Avg case is O(nlog(n))
// Best case is O(nlog(n))
// It is in-place sort
// It is not stable
public class Quick {
	public static void quickSort(int arr[], int lo, int hi) {
		if(arr.length == 0) {
			return;
		}
		// No element in the array list
		if((hi - lo) <= 0) {
			return;
		}
		int p = split(arr, lo, hi);
		quickSort(arr, lo, p - 1);
		quickSort(arr, p + 1, hi);
	}
	private static int split(int[] arr, int lo, int hi) {
		int left = lo;
		int pivot = arr[lo];
		lo++;
		while(true) {
			// Go to the right till lo < = hi
			// Or (hi - lo) >= 0 ... as long as elements in array
			while(lo <= hi) {
				if(arr[lo] < pivot) {
					lo++;
				} else {
					break;
				}
			}
			// = checked in previous while loop
			while(lo < hi) {
				if(arr[hi] > pivot	) {
					hi --;
				} else {
					break;
				}
			}
			// Break on = also beacuse no point swapping same numbers
			if(lo >= hi) {
				break;
			}
			Bubble.swap(arr, lo, hi);
			lo++;
			hi--;
		}
		Bubble.swap(arr, (lo - 1), left);
		return lo - 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8,1,2,6,3,-10,4,9};
		quickSort(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}

}
