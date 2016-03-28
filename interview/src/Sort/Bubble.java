package Sort;

import java.util.Arrays;

public class Bubble {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void bubbleSort(int arr[]) {
		if(arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if(arr[j] < arr[j-1]) {
					swap(arr, j, j - 1);
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,9,6,5};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
