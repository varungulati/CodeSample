package Google;

import java.util.Arrays;

public class LoadShare {
	public static int[] summer(int arr[]) {
		int toReturn[] = new int[arr.length];
		toReturn[0] = arr[0];
		for (int i = 1; i < toReturn.length; i++) {
			toReturn[i] = toReturn[i-1] + arr[i];
		}
		return toReturn;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100,90,1,1,1};
		int modified[] = summer(arr);
		System.out.println(Arrays.toString(modified));
	}

}
