package CountSort;

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
	public static void main(String[] args) {
		int arr[] = {6, 3, 4, 3, 3, 3, 3, 2};
		int sorted[] = countSort(arr, 2, 6);
		System.out.println();
		for(int i = 0; i < 8; i++) {
			System.out.print(sorted[i] + " ");
		}
	}

}
