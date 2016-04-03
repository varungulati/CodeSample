package geeksforgeeks.array;

import java.util.Arrays;

public class MergeTwoSortedArray {
	public static void merger(int arr1[], int arr2[]) {
		if(arr1.length == 0 || arr2.length == 0) return;
		for (int i = arr2.length - 1; i >= 0; i--) {
			int j = arr1.length - 1;
			if(arr2[i] < arr1[j]) {
				int temp = arr2[i];
				arr2[i] = arr1[j];
				arr1[j] = temp;
				while(j > 0 && arr1[j] < arr1[j-1]) {
					temp = arr1[j];
					arr1[j] = arr1[j-1];
					arr1[j-1] = temp;
					j--;
				}
			}
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar1[] = {1, 5, 9, 10, 15, 20};
		int ar2[] = {2, 3, 8, 13};
		merger(ar1, ar2);
	}

}
