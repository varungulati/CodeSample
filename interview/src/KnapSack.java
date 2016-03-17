import java.util.Arrays;


public class KnapSack {
	public static int arr[];
	public static void printGrid(int arr[][], int v[], int maxWeight)
	{
	   for(int i = 0; i < v.length + 1; i++)
	   {
	      for(int j = 0; j < maxWeight + 1; j++)
	      {
	         System.out.printf("%5d ", arr[i][j]);
	      }
	      System.out.println();
	   }
	}
	public static int maxValueKnapsack(int maxWeight, int v[], int w[]) {
		int arr[][] = new int[v.length + 1][maxWeight + 1];
		Arrays.fill(arr[0], Integer.MIN_VALUE);
		Arrays.fill(arr[1], Integer.MIN_VALUE);
		Arrays.fill(arr[2], Integer.MIN_VALUE);
		Arrays.fill(arr[3], Integer.MIN_VALUE);
		for (int i = 0; i < v.length + 1; i++) {
			arr[i][0] = 0;
		}
		for (int j = 0; j < maxWeight + 1; j++) {
			arr[0][j] = 0;
		}
		
		for (int i = 1; i < v.length + 1; i++) {
			for (int j = 1; j < maxWeight + 1; j++) {
				if(w[i-1] <= j) {
					if((j - w[i-1]) >= 0) {
						arr[i][j] = Math.max(v[i-1] + arr[i-1][j-w[i-1]], Math.max(arr[i-1][j], arr[i][j-1]));						
					} else {
						arr[i][j] = Math.max(v[i-1], Math.max(arr[i-1][j], arr[i][j-1]));
					}
				} else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
			printGrid(arr, v, maxWeight);
			System.out.println();
		}
		return arr[v.length][maxWeight];
	}
	
	public static int DP(int maxWeight, int v[], int w[]) {
		if(maxWeight <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < v.length; i++) {
			int temp;
			if(arr[maxWeight -1] != -1) {
				temp = v[i] + DP(maxWeight - w[i], v, w);
			} else {
				temp = v[i] + arr[maxWeight - w[i]];
			}
			if(temp > max) {
				max = temp;
			}
		}
		arr[maxWeight-1] = max;
		return arr[maxWeight-1];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int w[] = {5,4,6,3};
//		int v[] = {10, 40, 30, 50};
		int w[] = {3,4,5,6};
		int v[] = {50,40,10,30};
		int maxWeight = 7;
		arr = new int[maxWeight];
		Arrays.fill(arr, -1);
		System.out.println(maxValueKnapsack(maxWeight, v, w));
		System.out.println(DP(maxWeight, v, w));
	}

}
