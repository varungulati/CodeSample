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

	public static void main(String[] args) {
		int arr[] = {1,1,1,1,2,2,2,2,4,4,4,5,5,5,5,5,5,5,5,5};
		HashMap<Integer, Integer> result = countSameNumbers(arr);
		System.out.println(result);
		System.out.println(countNumber(arr, 5));
	}

}
