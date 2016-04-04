package Google;

public class WildCard {

	public static boolean contains(String str, String pat) {
		if(str.length() == 0 && pat.length() == 0) {
			return true;
		}
		if(str.length() == 0 || pat.length() == 0) {
			return false;
		}
		if(str.charAt(0) == pat.charAt(0) || pat.charAt(0) == '?') {
			return contains(str.substring(1), pat.substring(1));
		}
		if(pat.charAt(0) == '*') {
			return contains(str.substring(1), pat) || contains(str.substring(1), pat.substring(1)) || contains(str, pat.substring(1));
		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(contains("abxc5", "*c?"));
	}

}
