package QuickSort;

public class QuickSort {

	public static int splitPoint(int[] arr, int lo, int hi) {
		int left = lo + 1;
		int right = hi;
		int pivot = arr[lo];

		while(true) {
			
			while(left <= right) {
				if(arr[left] <= pivot) {
					left++;
				}
				if(arr[right] >= pivot) {
					right--;
				}
				break;
			}
			if(left > right) {
				break;
			}
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		arr[lo] = arr[left-1];
		arr[left-1] = pivot;
		return left-1;
	}
	public static void sort(int[] arr, int lo, int hi) {
		if (hi - lo <= 0) {
			return;
		}
		int splitPoint = splitPoint(arr, lo, hi);
		sort(arr, lo, splitPoint - 1);
		sort(arr, splitPoint + 1, hi);
	}
	public static void quickSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		} else {
			sort(arr, 0, arr.length -1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {18, 8, 90, 98, 9, 0, 100, -1, 999, 43, 18};
		quickSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}

	}

}
