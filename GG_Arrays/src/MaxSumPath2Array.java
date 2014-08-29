//  http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
//	Given two sorted arrays such the arrays may have some common elements. Find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. We can switch from one array to another array only at common elements.
//	
//	Expected time complexity is O(m+n) where m is the number of elements in ar1[] and n is the number of elements in ar2[].
//	
//	Examples:
//	
//	Input:  ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8}
//	Output: 35
//	35 is sum of 1 + 5 + 7 + 10 + 12.
//	We start from first element of arr2 which is 1, then we
//	move to 5, then 7.  From 7, we switch to ar1 (7 is common)
//	and traverse 10 and 12.
//	
//	Input:  ar1[] = {10, 12}, ar2 = {5, 7, 9}
//	Output: 22
//	22 is sum of 10 and 12.
//	Since there is no common element, we need to take all 
//	elements from the array with more sum.
//	
//	Input:  ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}
//	        ar2[] = {1, 5, 7, 8, 10, 15, 16, 19}
//	Output: 122
//	122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34

public class MaxSumPath2Array {

	public static int MaxSum(int[] arr1, int[] arr2) {
		int i = 0, j = 0, maxSum = 0, arr1_sum = 0, arr2_sum = 0;
		for(; i < arr1.length && j < arr2.length;) {
			if(arr1[i] == arr2[j]) {
				if(arr1_sum > arr2_sum) {
					maxSum += arr1_sum;
				} else {
					maxSum += arr2_sum;
				}
				arr1_sum = 0;
				arr2_sum = 0;
				maxSum += arr1[i];
				i++;
				j++;
			}
			if(arr1[i] > arr2[j]) {
				arr2_sum += arr2[j++];
			} else {
				arr1_sum += arr1[i++];
			}
		}
		while(i < arr1.length) {
			arr1_sum += arr1[i++];
		}
		while(j < arr2.length) {
			arr2_sum += arr2[j++];
		}
			if (arr1_sum > arr2_sum) {
				maxSum += arr1_sum;
			} else {
				maxSum += arr2_sum;
			}
		return maxSum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2, 3, 7, 10, 12, 15, 30, 34};
		int[] arr2 = {1, 5, 7, 8, 10, 15, 16, 19};
		System.out.println(MaxSum(arr1, arr2));

	}

}
