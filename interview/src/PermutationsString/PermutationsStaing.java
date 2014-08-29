package PermutationsString;

public class PermutationsStaing {
	public static void permutations(String res, String end) {
		if(res.length() == 0) {
			System.out.println(end);
		}
		for(int i = 0; i < res.length(); i++) {
			try {
				String newString = res.substring(0, i) + res.substring(i+1);
				permutations(newString, end + res.charAt(i));
			} catch(IndexOutOfBoundsException e){
				permutations("", end + res.charAt(i));
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		permutations("abcd", "");
	}

}
