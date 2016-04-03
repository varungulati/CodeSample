package geeksforgeeks.array;

public class MaxMinner {
	public static void maxMinner(int arr[]) {
		if(arr.length == 0) return;
		int i;
		for (i = 0; i < arr.length/2; i++) {
			System.out.print(arr[arr.length - i - 1] + " ");
			System.out.print(arr[i] + " ");
		}
		if (arr.length % 2 != 0) {
			System.out.println(arr[i]);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7};
		maxMinner(arr);
	}

}
