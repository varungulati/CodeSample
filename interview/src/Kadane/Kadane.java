package Kadane;

import java.util.Arrays;

public class Kadane {
	public int maxSubArray(int[] arr) {
		int maxSofar = 0, maxEndingHere = 0;
		for(int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if(maxSofar < maxEndingHere) {
				maxSofar = maxEndingHere;
			}
		}
		return maxSofar;
	}
	// Takes care of all negative numbers.
	public int maxSubArrayModified(int[] a) {
		int currMax = a[0];
		int maxSoFar = a[0];
		for(int i = 0; i < a.length; i++) {
			if(currMax + a[i] > a[i]) {
				currMax += a[i];
			} else {
				currMax = a[i];
			}
			if(maxSoFar < currMax) {
				maxSoFar = currMax;
			}
		}
		return maxSoFar;
	}
	public static int maxSubArrayDP(int[] a) {
		int[] temp = new int[a.length];
		temp[0] = a[0];
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < a.length; i++) {
			temp[i] = Math.max(temp[i-1] + a[i], a[i]);
			if(temp[i] > max) {
				max = temp[i];
			}
		}
		return max;
	}
	public static int maxSubArrayRec(int[] a, int lo, int hi) {
		if(lo == hi) {
			if(a[lo] > 0) {
				return a[lo];
			} else {
				return 0;
			}
		}
		int left_border_sum = 0, right_border_sum = 0, max_left_border_sum = 0, max_right_border_sum = 0;
		int mid = lo + (hi - lo)/2;
		int max_left_sum = maxSubArrayRec(a, lo, mid);
		int max_right_sum = maxSubArrayRec(a, mid + 1, hi);
		for(int i = mid; i >= lo; i--) {
			left_border_sum += a[i];
			if(left_border_sum > max_left_border_sum) {
				max_left_border_sum = left_border_sum;
			}
		}
		for(int i = mid + 1; i <= hi; i++) {
			right_border_sum += a[i];
			if(right_border_sum > max_right_border_sum) {
				max_right_border_sum = right_border_sum;
			}
		}
		return max3(max_left_sum, max_right_sum, max_left_border_sum + max_right_border_sum);
	}
	// abaa
	public static int maxContinuousTwoChar(String s) {
		if(s.length() <= 2) {
			return s.length();
		}
		char curr, prev;
		curr = s.charAt(1);
		prev = s.charAt(0);
		int max = 2, curr_max = 2;
		for(int i = 2; i < s.length(); i++) {
			if(curr == prev || curr == s.charAt(i) || prev == s.charAt(i)) {
				curr_max += 1;
			} else {
				curr_max = 1;
			}
			if(curr_max > max) {
				max = curr_max;
			}
			prev = curr;
			curr = s.charAt(i);
		}
		return max;
	}
	/**
     * Return maximum of three integers.
     */
    private static int max3( int a, int b, int c )
    {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }
	public static void main(String[] args) {
		int[] arr = {-2, -3, -4, -1, 2, -1, 5, -3};
		System.out.println(new Kadane().maxSubArrayModified(arr));
		System.out.println(Kadane.maxSubArrayDP(arr));
		System.out.println(Kadane.maxSubArrayRec(arr, 0, arr.length - 1));
		System.out.println(Kadane.maxContinuousTwoChar("abnaaaaacccccaaa"));
	}

}
