package Median;

public class Median {

	private static int median(int[] arr, int lo, int hi, int k) {
		if(lo > hi) return -1;
		int partition = getPartition(arr, lo, hi);
		if(partition == k) return arr[partition];
		if(partition > k) return median(arr, lo, partition - 1, k);
		else return median(arr, partition + 1, hi, k);
	}
	private static int getPartition(int[] arr, int lo,  int hi) {
		int pivot = arr[lo];
		int left = lo + 1, right = hi;
		while(true) {
			while(left <= right) {
				if(arr[left] <= pivot) left ++;
				if(arr[right] >= pivot) right--;
				break;
			}
			if(left > right) break;
			swap(arr, left, right);
		}
		arr[lo] = arr[left - 1];
		arr[left - 1] = pivot;
		return left - 1;
	}
	private static void swap(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6, 7, 8, 9};
		System.out.println(median(arr, 0, arr.length - 1, 0));
		System.out.println(median(arr, 0, arr.length - 1, 1));
		System.out.println(median(arr, 0, arr.length - 1, 2));
		System.out.println(median(arr, 0, arr.length - 1, 3));
		System.out.println(median(arr, 0, arr.length - 1, 4));
		System.out.println(median(arr, 0, arr.length - 1, 5));
		System.out.println(median(arr, 0, arr.length - 1, 6));
		System.out.println(median(arr, 0, arr.length - 1, arr.length/2));
	}

}
