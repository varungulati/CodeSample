package Combination;
public class Combination {
	public static void combination(String str) {
		int bitCounter = (int) Math.pow(2, str.length()) - 1;
		while(bitCounter > 0) {
			int temp = bitCounter--, count = 0;
			while(temp > 0) {
				if((temp & 1) == 1) {
					System.out.print(str.charAt(count));
				}
				count++;
				temp = temp >> 1;
			}
			System.out.println();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 16;
//		System.out.println(Integer.toString(a, 2));
		combination("abc");
//		System.out.println(3 & 8);
	}

}
