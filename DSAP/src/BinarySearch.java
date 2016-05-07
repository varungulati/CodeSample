
public class BinarySearch {

	public static int binarySearchIterative(int[] arr, int num) {
		int lo = 0, hi = arr.length - 1, toReturn = -1;
		while(true) {
			if(lo > hi) {
				break;
			}
			int mid = hi + (lo-hi)/2;
			if(arr[mid] == num) {
				toReturn = mid;
				break;
			}
			if(arr[mid] > num) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return toReturn;
	}
	public static int binarySearchRecursive(int[] arr, int num, int lo, int hi) {
		int mid = hi + (lo-hi)/2;
		if(lo > hi) {
			return -1;
		}
		if(arr[mid] == num) {
			return mid;
		}
		if(arr[mid] > num) {
			return binarySearchRecursive(arr, num, lo, mid - 1);
		} else {
			return binarySearchRecursive(arr, num, mid + 1, hi);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3,4,5,7,7,7,8,9};
		int num = 20;
		System.out.println(BinarySearch.binarySearchIterative(arr, num));
		System.out.println(BinarySearch.binarySearchRecursive(arr, num, 0, arr.length - 1));
	}

}
