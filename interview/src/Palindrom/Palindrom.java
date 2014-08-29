package Palindrom;

public class Palindrom {
	public static boolean palindromString(String s) {
		if(s.length() <= 1) {
			return true;
		}
		return s.charAt(0)==s.charAt(s.length()-1) && palindromString(s.substring(1, s.length() - 1));
	}
	// 1. Reverse a number and check if it is equal to the original.
	// 2. Convert to a string and call palindrom String.
	public static boolean palindromInt(int num) {
		int reverse = 0, temp = num;
		while(temp > 0) {
			reverse = reverse*10 + temp%10;
			temp /= 10;
		}
		return reverse == num;
	}
	// Reverses a string.
	public static String isPalindromHelper(String s) {
		if(s.length() == 0) {
			return "";
		}
		return s.charAt(s.length() - 1) + isPalindromHelper(s.substring(0, s.length() - 1));
	}
	public static boolean isPalindrom(String s1, String s2) {
		return s1.equals(isPalindromHelper(s2));
	}
	// Longest palindromic substring.
	public static int longestPalindromHelper(String s) {
		if(s.length() == 0) {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}
		for(int i = 0; i < s.length(); i++) {
			if(palindromString(s.substring(i))) {
				return s.length() - i;
			}
		}
		return 0;
	}
	public static int longestPalindrom(String s) {
		if(s.length() == 0) {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}
		int longestTillNow = 0;
		for(int i = 0; i < s.length(); i++) {
			int temp = longestPalindromHelper(s.substring(0, i + 1));
			if(temp > longestTillNow) {
				longestTillNow = temp;
			}
		}
		return longestTillNow;
	}
	public static void main(String[] args) {
		System.out.println(Palindrom.palindromString("abca"));
		System.out.println(Palindrom.palindromInt(1232));
		System.out.println(Palindrom.isPalindrom("abc", "cb"));
		System.out.println(Palindrom.isPalindromHelper("abcd"));
		System.out.println(Palindrom.longestPalindrom("geeksskeeg"));
		System.out.println(Palindrom.longestPalindrom("geeksskee"));
	}
}
