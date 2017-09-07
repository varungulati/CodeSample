package Solution;

import java.util.Arrays;

public class Solution1 {
	private int BSLow(int[] arr, int lo, int hi, int num, boolean found) {
        if(lo > hi) {
            if(found) return lo;
            else return -1;
        }
        int mid = lo + (hi - lo)/2;
        if(arr[mid] == num) return BSLow(arr, lo, mid - 1, num, true);
        if(arr[mid] >= num) return BSLow(arr, lo, mid - 1, num, found);
        else return BSLow(arr, mid + 1, hi, num, found);
    }
    private int BSHigh(int[] arr, int lo, int hi, int num, boolean found) {
        if(lo > hi) {
            if(found) return hi;
            else return -1;
        }
        int mid = lo + (hi - lo)/2;
        if(arr[mid] == num) BSHigh(arr, mid + 1, hi, num, true);
        if(arr[mid] > num) return BSHigh(arr, lo, mid - 1, num, found);
        else return BSHigh(arr, mid + 1, hi, num, found);
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        boolean found = false;
        int loBound = BSLow(nums, 0, nums.length - 1, target, found);
        int hiBound = BSHigh(nums, 0, nums.length - 1, target, loBound == -1 ? false : true);
        return new int[]{loBound, hiBound};
    }
    public static void main(String args[]) {
    	Solution1 s = new Solution1();
    	System.out.println(Arrays.toString(s.searchRange(new int[]{0}, 8)));
    }
}