package Mathematical;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 
 * stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

stairs

Consider the example shown in diagram. The value of n is 3. There are 3 ways to reach the top. The diagram is 
taken from Easier Fibonacci puzzles

*/
public class StaircasePath {

	public static int numPaths(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		int arr[][] = new int[n+1][n+1];
		Arrays.fill(arr[0], 1);
		for (int i = 0; i <= n; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if(i != j) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				} else {
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}
			}
			printer(arr);
			System.out.println();
		}
		return arr[n][n];
	}
	public static void printer(int lst[][]) {
        for (int[] arr : lst) {
            System.out.println(Arrays.toString(arr));
        }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numPaths(4));
	}

}
