package Atoi;

public class Atoi {
	public static int atoi(String s) {
		if(s.length() == 0) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			Character c = s.charAt(i);
			int digit = c.charValue() - '0';
			result = (int)Math.pow(10, s.length() - i - 1)*digit + result;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Atoi.atoi("123"));
	}

}
