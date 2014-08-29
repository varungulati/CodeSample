import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
//Sort an array according to the order defined by another array
//Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those are in A2. For the elements not present in A2, append them at last in sorted order.
//
//Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
//       A2[] = {2, 1, 8, 3}
//Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
//The code should handle all cases like number of elements in A2[] may be more or less compared to A1[]. A2[] may have some elements which may not be there in A1[] and vice versa is also possible.


public class SortCustom {
	public static ArrayList<Integer> Sort(int[] A1, int[] A2) {
		ArrayList<Integer> A3 = new ArrayList<Integer>();
		HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
		
		// Order m.
		for(int i = 0; i < A1.length; i++) {
			if(numCount.containsKey(A1[i])) {
				numCount.put(numCount.get(A1[i]), numCount.get(A1[i]) + 1);
			} else {
				numCount.put(A1[i], 1);
			}
		}
		
		// Order n.
		for(int i = 0; i < A2.length; i++) {
			if(numCount.containsKey(A2[i])) {
				for(int j = 0; j < numCount.get(A2[i]); j++) {
					A3.add(A2[i]);
				}
				numCount.remove(A2[i]);
			}
		}
		
		// Order klog(k)
		Object[] remainingKeys = numCount.keySet().toArray();
		Arrays.sort(remainingKeys);
		
		for(Object key: remainingKeys) {
			for(int i = 0; i < numCount.get(key); i++) {
				A3.add((Integer)key);
			}
		}
		return A3;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int[] A2 = {2, 1, 8, 3};
		for(Integer val: Sort(A1, A2)) {
			System.out.println(val);
		}
	}

}
