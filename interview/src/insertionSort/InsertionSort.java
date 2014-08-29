package insertionSort;

public class InsertionSort {
	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int j = i;
			while(j > 0) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				j--;	
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {4,1,2,3,4,5};
		sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
