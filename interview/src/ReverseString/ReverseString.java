package ReverseString;

public class ReverseString {
	public static void reverseString(String s) {
		for(int i = 0; i < s.length()/2; i++) {
			String before = Character.toString(s.charAt(i));
			String after = Character.toString(s.charAt(s.length() -1 -i));
			s = s.substring(0, i) + after + s.substring(i+1, s.length() -1 -i) + before + s.substring(s.length() - i, s.length());
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		String s = "abcdef";
		reverseString(s);
	}
}
