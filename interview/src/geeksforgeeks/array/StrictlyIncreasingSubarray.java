package geeksforgeeks.array;

public class StrictlyIncreasingSubarray {
	public static int countStrictlyIncreasing(int[] arr) {
		if(arr.length == 0) return 0;
		int count = 0, curr = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i-1]) {
				curr++;
			} else {
				count += curr*(curr - 1)/2;
				curr = 1;
			}
		}
		if (curr!=1) {
			count += curr*(curr - 1)/2;
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {1, 4, 3};
//		int arr[] = {1, 2, 3, 4};
		int arr[] = {1, 2, 2, 4};
		System.out.println(countStrictlyIncreasing(arr));
	}

}
