package DynamicProgramming;

public class CoinChange {
	public static int coinChange(int total, int count, int coins[]) {
		if (total < 0) {
			return Integer.MAX_VALUE;
		}
		if (total == 0) {
			return count;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int temp = coinChange(total - coins[i], count + 1, coins);
			if (temp < min) {
				min = temp;
			}
		}
		return min;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 16;
		int coins[] = {1,3,5};
		System.out.println(coinChange(total, 0, coins));
	}

}
