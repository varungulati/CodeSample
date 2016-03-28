package PermutationOf0and1;

public class Permute0and1 {

	public static void permuter(String str, int i, String res) {
		if(res.length() == str.length()) {
			System.out.println(res);
			return;
		}
		if(str.charAt(i++) == '?') {
			permuter(str, i, res + "0");
			permuter(str, i, res + "1");
		} else {
			permuter(str, i, res + str.charAt(i - 1));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permuter("10?1?", 0, "");
	}

}
