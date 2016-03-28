package Sort;

import java.util.Arrays;

public class Insertion {
	public static void insertionSort(int arr[]) {
		if(arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			int j = i;
			while(j > 0) {
				if(arr[j] < arr[j - 1]) {
					j--;
				} else {
					break;
				}
			}
			Bubble.swap(arr, i, j);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,9,6,5};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
