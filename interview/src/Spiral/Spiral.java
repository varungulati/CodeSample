package Spiral;

public class Spiral {

		public static void printSpiral(int[][] arr, int lr, int lc, int hr, int hc) {
			if(lr > hr || lc > hc) {
				return;
			}
			for(int i=lc; i <= hc; i++) {
				System.out.println(arr[lr][i]);
			}
			for(int i=lr + 1; i <= hr; i++) {
				System.out.println(arr[i][hc]);
			}
			for(int i=hc - 1; i >= lc && lr != hr; i--){
				System.out.println(arr[hr][i]);
			}
			for(int i=hr - 1; i > lr && hc != lc; i--){
				System.out.println(arr[i][lc]);
			}
			printSpiral(arr, lr + 1, lc + 1, hr - 1, hc - 1);
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    int arr[][] = {{1,  2,  3,  4,  5,  6}, {7, 8,  9,  10, 11, 12}, {13, 14, 15, 16, 17, 18}};
		printSpiral(arr, 0, 0, 2, 5);
	}

}
