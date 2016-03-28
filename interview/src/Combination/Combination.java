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
			System.out.print(" ");
		}
	}
	public static void combinationAndPermuteRec(String str, String res) {
		if(str.length() == 0) {
			System.out.print(res + " ");
			return;
		}
		if(res.length() > 0) {
			System.out.print(res + " ");
		}
		for (int i = 0; i < str.length(); i++) {
			String newStr = null;
			if(i == str.length() - 1) {
				newStr = str.substring(0, i);
			} else {
				newStr = str.substring(0, i) + str.substring(i + 1, str.length());
			}
			String newRes = res + str.charAt(i);
			combinationAndPermuteRec(newStr, newRes);
		}
	}
	public static void permuteRec(String str, String res) {
		if(str.length() == 0) {
			System.out.print(res + " ");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			String newStr = null;
			if(i == str.length() - 1) {
				newStr = str.substring(0, i);
			} else {
				newStr = str.substring(0, i) + str.substring(i + 1, str.length());
			}
			String newRes = res + str.charAt(i);
			permuteRec(newStr, newRes);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 16;
//		System.out.println(Integer.toString(a, 2));
		System.out.println("Combinations: ");
		combination("abc");
		System.out.println();
		System.out.println("Permutation and Combination: ");
		combinationAndPermuteRec("abc", "");
		System.out.println();
		System.out.println("Permutation only on abc: ");
		permuteRec("abc", "");
//		System.out.println(3 & 8);
	}

}
