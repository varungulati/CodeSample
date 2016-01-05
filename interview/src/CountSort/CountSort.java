package CountSort;

import java.util.Arrays;

public class CountSort {
	public static int[] countSort(int[] arr, int min, int max) {
		int temp[] = new int[max - min + 1];
		for(int num: arr) {
			temp[num - min]++; 
		}
		int z = 0;
		for(int i = min; i <= max; i++) {
			while(temp[i - min] > 0) {
				temp[i - min]--;
				arr[z++] = i;
			}
		}
		return arr;
	}
	// practice
	public static void cs(int[] arr, int min, int max) {
		int temp[] = new int[max - min + 1];
		for(int i = 0; i < arr.length; i++) {
			temp[arr[i] - min]++;
		}
		System.out.println(Arrays.toString(temp));
		int count = 0;
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i]; j++) {
				arr[count++] = i + min;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		int arr[] = {6, 3, 4, 3, 3, 3, 3, 2};
		cs(arr, 2, 6);
//		System.out.println(Arrays.toString(sorted));
	}

}
