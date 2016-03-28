package MaxPlatform;

public class MaxPlatformsAtRailwayStation {
	public static int maxTrains(int arr[], int dep[]) {
		if(arr.length == 0 || dep.length == 0) {
			return 0;
		}
		int currMax = Integer.MIN_VALUE;
		for (int i = 0; i < dep.length; i++) {
			int tempMax = 0;
			for (int j = 0; j < dep.length; j++) {
				if (dep[i] > arr[j] && arr[i] <= arr[j]) {
					tempMax++;
				}
			}
			if (currMax < tempMax) {
				currMax = tempMax;
			}
		}
		return currMax;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {900,940,950, 1100,1500,1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		System.out.println(maxTrains(arr, dep));
	}

}
