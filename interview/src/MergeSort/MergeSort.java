package MergeSort;

public class MergeSort {

	public static int[] mergeSort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		int length = arr.length;
		int[] A = new int[length/2];
		int[] B = new int[length - length/2];
		
		for(int i = 0; i < length; i++) {
			if(i < length/2) {
				A[i] = arr[i];
			} else {
				B[i - length/2] = arr[i];
			}
		}
		return merge(mergeSort(A), mergeSort(B));
	}
	public static int[] merge(int[] A, int[] B) {
		int a = 0, b = 0, i = 0;
		int[] temp = new int[A.length + B.length];
		while(a < A.length || b < B.length) {
			if(b == B.length) {
				temp[i++] = A[a++];
			} else if(a == A.length) {
				temp[i++] = B[b++];
			} else if(A[a] < B[b]) {
				temp[i++] = A[a++];
			} else {
				temp[i++] = B[b++];
			}
		}
		return temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {18, 8, 90, 98, 9, 0, 100, -1, 999, 43, 18, -89};
		arr = mergeSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}

}
