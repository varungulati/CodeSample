// http://www.geeksforgeeks.org/search-almost-sorted-array/
//Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
//
//For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
//
//Example:
//
//Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
//Output: 2 
//Output is index of 40 in given array
//
//Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
//Output: -1
//-1 is returned to indicate element is not present

public class AlmostSortedSearch {

	public static int helper(int[] arr, int lo, int hi, int key) {
		int mid = (lo+hi)/2;
		if(arr[mid] == key) {
			return mid;
		} else {
			if(mid - 1 >= lo && arr[mid-1] >= key) {
				return helper(arr, lo, mid - 1, key);
			} else {
				if(mid + 1 <= hi) {
					return helper(arr, mid + 1, hi, key);
				} else {
					return -1;
				}
			}
		}
	}
	public static int almostSortedSearch(int[] arr, int key) {
		return helper(arr, 0, arr.length, key);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 3, 40, 20, 50, 80, 70};
//		int arr[] = {3, 10, 20, 40, 50, 70, 80};
		int key = 10;
		System.out.println(almostSortedSearch(arr, key));
	}

}
