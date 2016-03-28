package Sort;

import java.util.Arrays;

public class Selection {
	public static void selectionSort(int arr[]) {
		if(arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			int currMin = Integer.MAX_VALUE;
			int index = -1;
			for (int j = i; j < arr.length; j++) {
				if(currMin > arr[j]) {
					currMin = arr[j];
					index = j;
				}
			}
			Bubble.swap(arr, i, index);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,9,6,5};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
