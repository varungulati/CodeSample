// http://parlab.eecs.berkeley.edu/wiki/_media/patterns/paraplop_g3_3.pdf
package DynamicProgramming;
import java.util.Arrays;

class Items {
	public int weight;
	public int value;
	public Items(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}
public class DynamicProgramming {
	public static int fibonacci(int n) {
		if(n <= 2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	public static int fibonacciBetterHelper(int n, int[] arr) {
		if(arr[n] != 0) {
			return arr[n];
		}
		if(n <= 2) {
			arr[2] = 1;
			arr[1] = 1;
			return 1;
		}
		return fibonacciBetterHelper(n-1, arr) + fibonacciBetterHelper(n-2, arr);
	}
	public static int fibonacciBetter(int n) {
		int[] arr = new int[n + 1];
		return fibonacciBetterHelper(n, arr);
	}
	public static int fibonacciDP(int n) {
		int[] arr = new int[n];
		// [1,1,2,3,5]
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i < n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n-1];
	}
	// Longest possible subsequence.
	public static int lcs(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if(s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
			return 1 + lcs(s1.substring(0, s1.length() - 1),
					s2.substring(0, s2.length() - 1));
		} else {
			return Math.max(lcs(s1.substring(0, s1.length() - 1), s2),
					lcs(s1, s2.substring(0, s2.length() - 1)));
		}
	}
	// Longest possible subsequence with array helper.
	public static int lcsBetterHelper(String s1, String s2, int[][] arr) {
		// If value not initialized then proceed.
//		if(s1.length() == 8 && s2.length() == 6) {
//			System.out.println("=========");
//			for(int i = 0; i <= s1.length(); i++) {
//				for(int j = 0; j <= s2.length(); j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//		System.out.println("=========");
//		}
		if(arr[s1.length()][s2.length()] == -1) {
			
			if(s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
				arr[s1.length()][s2.length()] = 1 + lcsBetterHelper(s1.substring(0, s1.length() - 1),
						s2.substring(0, s2.length() - 1), arr);
				return arr[s1.length()][s2.length()];
			} else {
				arr[s1.length()][s2.length()] = Math.max(lcsBetterHelper(s1.substring(0, s1.length() - 1), s2, arr),
						lcsBetterHelper(s1, s2.substring(0, s2.length() - 1), arr));
				return arr[s1.length()][s2.length()];
			}
		} else {
			return arr[s1.length()][s2.length()];
		}
	}
	public static int lcsBetter(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		// Initailize array values to -1.
		for(int[] row: arr) {
			Arrays.fill(row, new Integer(-1));
		}
		// All rows should have 0 as default. No match when any one string is 0.
		Arrays.fill(arr[0], new Integer(0));
		// Set first column to 0.
		for(int i = 0; i < s1.length() + 1; i++) {
			arr[i][0] = 0;
		}

		return lcsBetterHelper(s1, s2, arr);
	}
	// abc
	// bcd
	public static int lcsDP(String s1, String s2) {
		int arr[][] = new int[s1.length() + 1][s2.length() + 1];
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		return arr[s1.length()][s2.length()];
	}
	
	// KNAP SACK
	// Pick multiple copies of one item.
	public static int knapsackHelper(Items[] items, int weight) {
		if(weight <= 0) {
			return 0;
		}
		int maxValue = 0;
		for(int i = 0; i < items.length; i++) {
			if(items[i].weight <= weight) {
				int value = items[i].value + knapsackHelper(items, weight - items[i].weight);
				if(value > maxValue) {
					maxValue = value;
				}
			}
		}
		return maxValue;
	}
	public static int knapsack(Items[] items, int weightLimit) {
		int maxValue = 0;
		for(int i = 1; i <= weightLimit; i++) {
			int value = knapsackHelper(items, i);
			if(value > maxValue) {
				maxValue = value;
			}
		}
		return maxValue;
	}
	public static int knapsackBetterHelper(Items[] items, int weight, int[] arr) {
		if(arr[weight] == -1) {
			int maxValue = 0;
			for(int i = 0; i < items.length; i++) {
				if(items[i].weight <= weight){
					int value = items[i].value + knapsackBetterHelper(items, weight - items[i].weight, arr);
					if(value > maxValue) {
						maxValue = value;
					}
				}
			}
			arr[weight] = maxValue;
			return maxValue;
		} else {
			return arr[weight];
		}
	}
	public static int knapsackBetter(Items[] items, int weightLimit) {
		int maxValue = 0;
		int arr[] = new int[weightLimit + 1];
		Arrays.fill(arr, new Integer(-1));
		arr[0] = 0;
		for(int i = 1; i <= weightLimit; i++) {
			int value = knapsackBetterHelper(items, i, arr);
			if(value > maxValue) {
				maxValue = value;
			}
		}
		return arr[weightLimit];
	}
	// TODO
	// Knapsack - one item of each weight.
	// https://www.youtube.com/watch?v=EH6h7WA7sDw
	
	// Cutting a Rod (Dynamic Programming)
	// https://www.youtube.com/watch?v=U-09Gs6cbsQ&list=PL962BEE1A26238CA3
	public static int maxValueRodPieces(int[] arrValues) {
		int[] temp = new int[arrValues.length];
		temp[0] = arrValues[0];
		for(int i = 1; i < arrValues.length; i++) {
			int max = 0, value = 0;
			for(int j = 0; j <= i; j++) {
				if(i != j){
					value = arrValues[j] + temp[i - j - 1];
				} else {
					value = arrValues[i];
				}
				if(value > max) {
					max = value;
				}
			}
			temp[i] = max;
		}
		return temp[temp.length - 1];
	}

	public static void main(String[] args) {
//		System.out.println(fibonacciBetter(6));
//		System.out.println(lcs("abcdefghi", "afdhaaa"));
//		System.out.println(lcsBetter("abcdefghi", "afdhaaa"));
//		System.out.println(lcsDP("abcdefghi", "afdhaaa"));
		Items[] items = new Items[5];
		items[3] = new Items(1, 1);
		items[1] = new Items(2, 2);
		items[2] = new Items(10, 4);
		items[0] = new Items(2, 3);
		items[4] = new Items(4, 12);
//		items[5] = new Items(1, 1);
//		items[6] = new Items(2, 2);
//		items[7] = new Items(10, 4);
//		items[8] = new Items(2, 3);
//		items[9] = new Items(10, 4);
//		System.out.println(knapsack(items, 15));
//		System.out.println(knapsackBetter(items, 15));
		int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(maxValueRodPieces(arr));
		System.out.println(lcsDP("apbcadcqer", "rasbtaucve"));
	}
}
