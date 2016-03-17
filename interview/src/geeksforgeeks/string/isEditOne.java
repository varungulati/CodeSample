package geeksforgeeks.string;

public class isEditOne {
	public static boolean tellEditOne(String s1, String s2) {
		int s1_len = s1.length();
		int s2_len = s2.length();
		int count = 0;
		if(s1_len - s2_len >= 2) {
			return false;
		}
		int i;
		for (i = 0; i < Math.min(s1_len, s2_len); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				count++;
				if(count > 1) {
					return false;
				}
			}
		}
		if(s1_len == s2_len && count == 0) {
			return false;
		}
		if(s1_len != s2_len && count == 1 && s1.charAt(s1_len - 1) != s2.charAt(s2_len - 1)) {
		
			return false;
		}
			return true;
	}
	public static void main(String args[]) {
		System.out.println(tellEditOne("gek", "geek"));
	}
}
