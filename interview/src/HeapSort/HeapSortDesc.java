package HeapSort;

import java.util.Arrays;

public class HeapSortDesc {

	public static void buildHeap(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			siftUp(arr, i);
		}
	}
	public static void siftUp(int arr[], int c) {
		int p = (c-1)/2;
		while(c > 0) {
			if(arr[p] < arr[c]) {
				int temp = arr[p];
				arr[p] = arr[c];
				arr[c] = temp;
			} else {
				return;
			}
			c = p;
			p = (c-1)/2;
		}
	}
	public static void siftDown(int arr[], int size) {
		int p = 0;
		int c = 1;
		while(c < size) {
			c = (c+1 < size && arr[c+1] > arr[c]? c + 1: c);;
			if(arr[p] < arr[c]) {
				int temp = arr[p];
				arr[p] = arr[c];
				arr[c] = temp;
			} 
			p = c;
			c = 2*p + 1;
		}
	}
	public static void insert(int arr[], int data) {
		
	}
	public static void sort(int arr[]) {
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[0] + " ");
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			siftDown(arr, i);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,4,3,6,7,8};
		HeapSortDesc heap = new HeapSortDesc();
		heap.buildHeap(arr);
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
