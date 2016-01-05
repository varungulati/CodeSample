package CountSameNumbers;

import java.util.HashMap;

public class CountSameNumbers {
	public static HashMap<Integer, Integer> countSameNumbers(int[] arr) {
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(res.containsKey(arr[i])) {
				res.put(arr[i], res.get(arr[i]) + 1);
			} else {
				res.put(arr[i], 1);
			}
		}
		return res;
	}
	public static int countNumber(int[] arr, int foo) {
		int lo = 0, hi = arr.length - 1, pos = -1, mid;
		while(true) {
			mid = (hi + lo)/2;
			if(hi == lo) break;
			if(arr[mid] > foo) {
				hi = mid - 1;
			} else if(arr[mid] < foo) {
				lo = mid + 1;
			} else {
				pos = mid;
				break;
			}
		}
		if(pos == -1) {
			return -1;
		}
		int count = 1;
		for(int i = pos + 1; i < arr.length; i++) {
			if(arr[i] == foo) count++;
		}
		for(int i = pos - 1; i >= 0; i--) {
			if(arr[i] == foo) count++;
		}
		return count;
	}
	public static int countNumberImproved(int[] arr, int lo, int hi, int num, int flag, boolean found) {
		if(lo > hi) {
			if(flag == 0) {
				return -1;
			} else if(flag == 1){
				if(found) {
					return lo - 1;
				} else {
					return -1;
				}
			} else if(flag == 2){
				if(found) {
					return hi;
				} else {
					return -1;
				}
			}
		} 
		int mid = lo + (hi-lo)/2;
		if(arr[mid] == num) {
			if(flag == 0) {
				return mid;
			} else if(flag == 1) {
				return countNumberImproved(arr, lo, mid-1, num, flag, true);
			} else if(flag == 2) {
				return countNumberImproved(arr, mid+1, hi, num, flag, true);
			}
		}
		if(arr[mid] > num) {
			return countNumberImproved(arr, lo, mid-1, num, flag, found);
		} else {
			return countNumberImproved(arr, mid+1, hi, num, flag, found);
		}
	}
	public static int GetOccurance(int[] inputs, int k, int start, int end)
	{
	    if(start<end) return 0;
	    if(inputs[end]<k||inputs[start]>k) return 0;
	    if(inputs[start]==k&&inputs[end]==k) return end-start+1;
	    int mid = (start+end)/2;
	    if(inputs[mid]<k)
	        return GetOccurance(inputs, k, mid+1, end);
	    else if(inputs[mid]>k)
	        return GetOccurance(inputs, k, start, mid-1);
	    else
	        return GetOccurance(inputs, k, start, mid-1)+1+GetOccurance(inputs, k, mid+1, end);
	}
	public static int binarySearch(int[] arr, int lo, int hi, int num) {
		if(lo > hi) {
			return -1;
		}
		int mid = lo + (hi-lo)/2;
		if(arr[mid] == num) {
			return mid;
		}
		if(arr[mid] > num) {
			return binarySearch(arr, lo, mid - 1, num);
		} else {
			return binarySearch(arr, mid + 1, hi, num);
		}
	}
	public static int binarySearchlower(int[] arr, int lo, int hi, int num, boolean found) {
		if(lo > hi) {
			if(found) {
				return lo;
			} else {
				return -1;
			}
		} 
		int mid = lo + (hi-lo)/2;
		if(arr[mid] == num) {
			return binarySearchlower(arr, lo, mid - 1, num, true);
		}
		return binarySearchlower(arr, mid + 1, hi, num, found);
	}
	public static int binarySearchupper(int[] arr, int lo, int hi, int num, boolean found) {
		if(lo > hi) {
			if(found) {
				return lo - 1;
			} else {
				return -1;
			}
		} 
		int mid = lo + (hi-lo)/2;
		if(arr[mid] == num) {
			return binarySearchupper(arr, mid + 1, hi, num, true);
		}
		return binarySearchupper(arr, lo, mid - 1, num, found);
	}
	public static void main(String[] args) {
		int arr[] = {5,5,5,5,5,5,5,5,5};
		//15 when start from 1
//		HashMap<Integer, Integer> result = countSameNumbers(arr);
//		System.out.println(result);
//		System.out.println(countNumber(arr, 5));
//		int num = 1;
//		int found = countNumberImproved(arr, 0, arr.length - 1, num, 0, false);
//		int lo = countNumberImproved(arr, 0, found - 1, num, 1, true);
//		int hi = countNumberImproved(arr, found + 1, arr.length -1, num, 2, true);
//		System.out.println(hi - lo);
		System.out.println(GetOccurance(arr, 4, 0, arr.length - 1));
		System.out.println(binarySearch(arr, 0, arr.length - 1, 5));
		int at = binarySearch(arr, 0, arr.length - 1, 5);
		System.out.println(binarySearchlower(arr, 0, at - 1, 5, false));
		System.out.println(binarySearchupper(arr, at + 1, arr.length - 1, 5, false));
	}

}
