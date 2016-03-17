package Pascal;

public class Pascal {
	// 1
	// 1 1
	// 1 2 1
	// 1 3 3 1
	// 1 4 6 4 1
	//
	// func(1,2)
	//
	// row = n
	// col = m

	public static int getNumber(int row, int col) {
		// Check if user enters a valid parameter

		int[][] ar = new int[row + 1][col + 2];

		// fill all 0’s in the first row
		// O(m)
		for (int i = 0; i <= col + 1; i++) {
			ar[0][i] = 0;
		}

		// O(1)
		ar[0][1] = 1;

		// fill all 0’s in the first column
		// O(n)
		for (int i = 1; i <= row; i++) {
			ar[i][0] = 0;
		}

		// Start building with rule ar[i][j] = ar[i-1][j] + ar[i-1][j-1]
		// O(mn)
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col + 1; j++) {
				ar[i][j] = ar[i - 1][j] + ar[i - 1][j - 1];
			}
		}
		// O(1)
		return ar[row][col + 1]; // ar[0][1] = 1
	}

	public static void printPascal(int n) {
		if(n == 0) {
			return;
		}
		int C =1 ;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if(j != 0) {
					C = C*(i-j+1)/j;
				}
				System.out.print(C + " ");
			}
			System.out.println();
			
		}
	}
	public static void main(String[] args) {
//		System.out.println(getNumber(3, 4));
		printPascal(10);
	}

}
