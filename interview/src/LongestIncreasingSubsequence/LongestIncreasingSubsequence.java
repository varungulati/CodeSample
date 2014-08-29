package LongestIncreasingSubsequence;
// http://professorjava.weebly.com/longest-increasing-subsequence.html


public class LongestIncreasingSubsequence {

	// Prints the longest increasing subsequence in an array.
	//	0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
	//	A subsequence is 0,4,2,1,5. An increasing subsequence is 0,4,10,14,15.
	//	The question is to find the length of the longest increasing subsequence,
	// which has size 6 (0, 2, 6, 9, 13, 15). Note that the sequence might not be unique,
	// but you need to find the length of the longest subsequence. 
	public static int longestIncreasingSubsequence(int[] arr) {
		int[] temp = new int[arr.length];
		temp[0] = 1;
		int maxn = 0;
		for(int i = 1; i < arr.length; i++) {
			maxn = 0;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && temp[j] > maxn) {
					maxn = temp[j];
				}
			}
			if(maxn != 0) {
				temp[i] = maxn + 1;
			} else {
				temp[i] = temp[i-1];
			}
		}
		return temp[temp.length - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(longestIncreasingSubsequence(arr));
	}

}
