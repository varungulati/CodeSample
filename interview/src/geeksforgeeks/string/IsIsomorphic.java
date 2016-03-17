package geeksforgeeks.string;

import java.util.HashMap;

public class IsIsomorphic {
	public static boolean isIsomorphic(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Character> temp = new HashMap<>();
		
		for (int i = 0; i < s1.length(); i++) {
			if(temp.get(s1.charAt(i)) == null) {
				temp.put(s1.charAt(i), s2.charAt(i));
			} else {
				if(temp.get(s1.charAt(i)) != s2.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isIsomorphic("aab", "xyz"));
	}
}
